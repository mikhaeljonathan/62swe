import { useEffect, useState } from "react"
import Post from "./Post";
import NavBar from "../navbar/Navbar";
import { useNavigate } from "react-router-dom";
import Cookies from 'js-cookie';

export default function Main() {

    const [posts, setPosts] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        const jwtToken = Cookies.get("token");

        fetch(`${import.meta.env.VITE_BACKEND_SERVER}/posts`, {
            credentials: "include",
            headers: {
                'Authorization': `Bearer ${jwtToken}`
            }
        })
        .then((res) => { 
            if (res.status === 200) {
                return res.json()
            }

            if (res.status === 400) {
                navigate("/login")
            }
        })
        .then((data) => {
            setPosts(data);
        })
    }, [])

    return (
        <>
            <NavBar />
            <div className="flex flex-col items-center">
                {posts.map((post: Post) => (
                    <Post key={ post.username } post={ post }/>
                ))}
            </div>
        </>
    )
}