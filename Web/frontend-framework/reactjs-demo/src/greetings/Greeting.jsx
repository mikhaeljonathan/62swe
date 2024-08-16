import styles from './Greeting.module.css';

export default function Greeting(props) {
    return (
        <h1 className={styles.red}>
            Hello, {props.name}!
        </h1>
    )
}