import logo from './logo.svg';
import './App.css';

import Home from './components/Home'
import Searchbus from './components/Searchbus';
import SignInSide from './components/login';
import SignUp from './components/SignUp';
import {BrowserRouter as Router,Route, Routes, Link, Switch} from 'react-router-dom';


function App() {
  return (
    <div className="App">
      
      <Router>
        
        <Routes>
        <Route path="/home" element={<Home/>}/>
          <Route path="/login" element={<SignInSide/>}/>
          <Route path="/signup" element={<Sign/>}/>

        </Routes>
        
      </Router>
    </div>
  );
}

export default App;
