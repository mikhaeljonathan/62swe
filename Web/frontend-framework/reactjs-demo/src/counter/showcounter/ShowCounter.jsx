export default function ShowCounter(props) {
    console.log("showcounter rendered");
    return (
        <>
            <p>Counter: </p>
            <p>{props.count}</p>
        </>
    )
}