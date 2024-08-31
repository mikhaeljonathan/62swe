import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Cookies from 'js-cookie';

export default function Signup() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [errorText, setErrorText] = useState("");

    const navigate = useNavigate();

    useEffect(() => {
        const jwtToken = Cookies.get("token");
    
        fetch(`${import.meta.env.VITE_BACKEND_SERVER}/cookie/validation`, {
          credentials: "include",
          headers: {
            'Authorization': `Bearer ${jwtToken}`
        }
        })
        .then((res) => { 
          if (res.status === 200) {
            navigate("/feeds");
          }
        })
      }, [])

    async function signUp(e: any) {
        e.preventDefault();

        const response = await fetch(`${import.meta.env.VITE_BACKEND_SERVER}/signup`, {
            method: "POST",
            headers: {
              "Content-Type": "application/json"
            },
            body: JSON.stringify({
              "username": username,
              "password": password
            }),
            credentials: "include"
        });
      
        if (response.status === 201) {
            navigate("/feeds");
        }

        setErrorText(await response.text());
    }

    return (
        <div style={{ "display": "grid", "placeItems": "center", "height": "100vh", }}>
            <form onSubmit={signUp} >
                <label 
                    htmlFor="username" 
                    className="block text-gray-700 font-semibold mb-2">Username</label>
                <input 
                    type="text" 
                    name="username" 
                    id="username" 
                    value={username} 
                    onChange={e => setUsername(e.target.value)} 
                    required
                    className="w-full px-3 py-2 mb-4 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"/>
                <br/>
                <label 
                    htmlFor="password"
                    className="block text-gray-700 font-semibold mb-2">Password</label>
                <input 
                    type="password" 
                    name="password" 
                    id="password" 
                    value={password} 
                    onChange={e => setPassword(e.target.value)} 
                    required 
                    className="w-full px-3 py-2 mb-4 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500" />
                <br/>
                <p className="text-red-500 mb-4">{errorText}</p>
                <button 
                    type="submit"
                    className="w-full py-2 bg-blue-500 text-white font-semibold rounded-lg hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-500">sign up</button>
            </form>
        </div>
    )
}