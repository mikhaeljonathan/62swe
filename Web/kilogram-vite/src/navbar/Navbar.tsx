export default function NavBar() {
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
            <a className="px-4 hover:bg-blue-800 flex" href="/logout">
                <div className="m-auto">
                    Log out
                </div>
            </a>
        </div>
        </div>
    )
}