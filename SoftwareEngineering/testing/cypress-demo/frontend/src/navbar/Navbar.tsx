import { useNavigate } from "react-router-dom";
import Cookies from 'js-cookie';

export default function NavBar() {
    const navigate = useNavigate();

    function logOut() {
        const jwtToken = Cookies.get("token");

        fetch(`${import.meta.env.VITE_BACKEND_SERVER}/logout`, {
            credentials: "include",
            headers: {
                'Authorization': `Bearer ${jwtToken}`
            }
        })
        .then(() => {
            navigate("/login");
        })
    }

    return (
        <div className="flex bg-blue-900 text-white">
        <div className="flex-1 w-14 p-4">
            <p className="text-center">Kilogram</p>
        </div>
        <div className="flex-none flex">
            <a className="px-4 hover:bg-blue-800 flex" href="/about">
                <div className="m-auto">
                    About
                </div>
            </a>
            <a className="px-4 hover:bg-blue-800 flex" href="/editprofile">
                <div className="m-auto">
                    Edit profile
                </div>
            </a>
            <a className="px-4 hover:bg-blue-800 hover:cursor-pointer flex" onClick={logOut} >
                <div className="m-auto">
                    Log out
                </div>
            </a>
        </div>
        </div>
    )
}