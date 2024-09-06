import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Cookies from "js-cookie";

export default function Signup() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [errorText, setErrorText] = useState("");

    const navigate = useNavigate();

    useEffect(() => {
        const jwtToken = Cookies.get("token");

        if (!jwtToken) {
          return;
        }
    
        fetch(`${import.meta.env.VITE_BACKEND_SERVER}/cookie/validation`, {
          credentials: "include",
          headers: {
            'Authorization': `Bearer ${jwtToken}`
        }
        })
        .then((res) => { 
          if (res.status === 200) {
            navigate("/content");
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
            navigate("/content");
        }

        setErrorText(await response.text());
    }

    return (
        <div style={{ "display": "grid", "placeItems": "center", "height": "100vh", }}>
            <form onSubmit={signUp} >
                <label htmlFor="username">Username</label>
                <br/>
                <input type="text" name="username" id="username" value={username} onChange={e => setUsername(e.target.value)} required/>
                <br/>
                <br/>
                <label htmlFor="password">Password</label>
                <br/>
                <input type="password" name="password" id="password" value={password} onChange={e => setPassword(e.target.value)} required/>
                <br/>
                <p style={{ "color" : "red" }}>{errorText}</p>
                <button type="submit">sign up</button>
            </form>
        </div>
    )
}