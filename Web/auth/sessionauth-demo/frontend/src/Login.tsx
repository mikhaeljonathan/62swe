import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

export default function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [errorText, setErrorText] = useState("");
  
  const navigate = useNavigate();

  useEffect(() => {
    fetch(`${import.meta.env.VITE_BACKEND_SERVER}/cookie/validation`, {
      credentials: "include"
    })
    .then((res) => { 
      if (res.status === 200) {
        navigate("/content");
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
      navigate("/content");
      return;
    }

    setErrorText(await response.text())
  }

  function goToSignupPage() {
    navigate("/signup");
  }

  return (
    <div style={{ "display": "grid", "placeItems": "center", "height": "100vh", }}>
      <button onClick={goToSignupPage} style={{ "position" : "fixed", "top" : 16, "right" : 16}}>Sign up</button>
      <form onSubmit={logIn} >
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
        <button type="submit">log in</button>
      </form>
    </div>
  )
}
