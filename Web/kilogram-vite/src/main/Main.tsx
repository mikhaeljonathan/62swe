import { useEffect, useState } from "react"
import Post from "./Post";

export default function Main() {

    const [posts, setPosts] = useState([]);

    useEffect(() => {
        fetch('http://localhost:5000/posts')
        .then(res => res.json())
        .then(data => {setPosts(data); console.log(data)})
    }, [])

    return (
        <div className="flex flex-col items-center">
            {posts.map((post: Post) => (
                <Post key={ post.username } post={ post }/>
            ))}
        </div>
    )
}