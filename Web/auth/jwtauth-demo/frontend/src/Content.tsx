import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom"
import Cookies from "js-cookie";

export default function Content() {
    const [content, setContent] = useState('rahasia');
    const navigate = useNavigate();

    useEffect(() => {
        const jwtToken = Cookies.get("token");

        if (jwtToken === undefined) {
            navigate("/login")
            return;
        }

        fetch(`${import.meta.env.VITE_BACKEND_SERVER}/content`, {
            credentials: "include",
            headers: {
                'Authorization': `Bearer ${jwtToken}`
            }
        })
        .then((res) => { 
            if (res.status === 200) {
                return res.text()
            }

            if (res.status === 400) {
                navigate("/login")
            }
        })
        .then((data) => {
            setContent(data ? data : "");
        })
    })

    function logOut() {
        const jwtToken = Cookies.get("token");

        if (jwtToken === undefined) {
            navigate("/login")
            return;
        }

        fetch(`${import.meta.env.VITE_BACKEND_SERVER}/logout`, {
            credentials: "include",
            headers: {
                "Authorization": `Bearer ${jwtToken}`
            }
        })
        .then((res) => {
            if (res.status === 200) {
                navigate("/login");
            }
        })
    }

    return (
        <div style={{ "display": "grid", "placeItems" : "center" , "height" : "100vh"}}>
            <button style={{ "position" : "fixed", "top" : "2rem", "right" : "2rem"}} onClick={logOut}>Log out</button>
            <h1 style={{ "fontSize": "4rem"}}>{content}</h1>
        </div>
    )
}