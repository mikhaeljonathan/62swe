import React, { useEffect, useState } from 'react';

export default function Content() {

    console.log("Content rendered");

    const [data, setData] = useState("");
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        fetch('https://dummyjson.com/c/3029-d29f-4014-9fb4')
        .then(response => response.json())
        .then(data => setData(data))
        .then(() => setLoading(false));
    }, []);

    return (
        loading ? <p>Loading...</p> : <p>{JSON.stringify(data)}</p>
    );
}