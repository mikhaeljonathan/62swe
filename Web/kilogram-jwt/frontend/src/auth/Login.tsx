import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Cookies from 'js-cookie';

export default function Login() {
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
        navigate("/feeds");
      }
    })
  }, [])

  async function logIn(e: any) {
    e.preventDefault();

    const response = await fetch(`${import.meta.env.VITE_BACKEND_SERVER}/login`, {
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

    if (response.status === 200) {
      navigate("/feeds");
      return;
    }

    setErrorText(await response.text())
  }

  function goToSignupPage() {
    navigate("/signup");
  }

  return (
    <div style={{ "display": "grid", "placeItems": "center", "height": "100vh", }}>
      <button onClick={goToSignupPage} className="fixed top-4 right-4 bg-blue-700 hover:bg-blue-900 text-white p-4 rounded-md">Sign up</button>
      <h1 className="fixed top-10 text-3xl">Kilogram - share your moments</h1>
      <form onSubmit={logIn} >
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
            className="w-full py-2 bg-blue-500 text-white font-semibold rounded-lg hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-500">log in</button>
      </form>
    </div>
  )
}

