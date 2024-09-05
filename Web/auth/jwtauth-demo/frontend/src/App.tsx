import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import Login from './Login';
import Signup from './Signup';
import Content from './Content';

  function App() {

    return (
      <Router>
        <Routes>
          <Route path="/" element={<Navigate to="/content" />} />
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<Signup />} />
          <Route path="/content" element={<Content />} /> 
        </Routes>
      </Router>
    )
  }

  export default App
