import './App.css';
import Content from './content/Content';
import Counter from './counter/Counter';
import Greeting from './greetings/Greeting';

function App() {
  return (
    <>
      <Greeting name="MJ"></Greeting>
      <h1 className="red">asdf</h1>
      <Counter />
      <Content />
    </>
  );
}

export default App;
