import { useState } from "react";

export default function Post({ post } : { post: Post }) {

    const [likedIcon, setLikedIcon] = useState("public/like.svg");

    const onLiked = () => {
        if (likedIcon === "public/like.svg") {
            setLikedIcon("public/liked.svg");
        } else {
            setLikedIcon("public/like.svg");
        }
    }

    return (
        <div className="p-4 rounded-xl border-solid border-gray-600 border-2 m-4">
            <h2>{post.username}</h2>
            <img src={post.imageurl} className="h-72 my-4"></img>
            <img onClick={onLiked} src={likedIcon} className="inline cursor-pointer "/>
            <p className="inline mx-2">{post.likes}</p>
            <p>Desc</p>
        </div>
    )
}