import React, { useState } from 'react';
import ShowCounter from './showcounter/ShowCounter';

export default function Counter() {
    console.log("counter rendered");
    const [count, setCount] = useState(0);

    function increment() {
        setCount(count + 1);
    }

    return (
        <div>
            <button onClick={increment}>Increment</button>
            <ShowCounter count={count}/>
        </div>
    )
}