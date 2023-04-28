"use strict";
import logo from './logo.svg';
import './App.css';
import { Button} from 'react-bootstrap';
// import Login from "./api/api";
import React, { useEffect, useState } from "react";
import axios from 'axios';

const PATHS = {
    REGISTER_NEW_ACCOUNT: 'http://localhost:8090/dream',
   
};
 async function  Login (duration,energyLevel,stress)  {
  try {
    const response = await axios.post(PATHS.REGISTER_NEW_ACCOUNT, { duration,energyLevel,stress });
    console.log(response);
    return response;
  } catch (error) {
    console.error(error);
  }
};
function App() {
  const [ id, setId ] = useState('');
  const [ name, setName ] = useState('');
  const [ duration, setDuration ] = useState('');
  const [ energyLevel, setEnergyLevel ] = useState('');
  const [ stress, setStress ] = useState('');
  async function handleAdd() {
      console.log(id);
      console.log(name);
      console.log(name);
      //const data=await login(duration,energyLevel,stress)
      Login(duration,energyLevel,stress) ;
       console.log(Login);
  }

  return (
    <div className="App">
      <header className="App-header">
        <h4 className = "">
                                <label> Id </label>
        <input type="text" name="e1"  onChange={(e) => setId(e.target.value)}/></h4>
        <h4 className = "">
                                <label> Name </label>
        <input type="text" name="e2" onChange={(e) => setName(e.target.value)}/></h4>
        <h4 className = "">
                                <label> Duration </label>
        <input type="text" name="e3" onChange={(e) => setDuration(e.target.value)}/></h4>
        <h4 className = "">
                                <label> Energy Level </label>
        <input type="text" name="e4" onChange={(e) => setEnergyLevel(e.target.value)}/></h4>
        <h4 className = "">
                                <label> Stress </label>
          <input type="text" name="p5" onChange={(e) => setStress(e.target.value)}/></h4>
          <button className = "btnAdmin" onClick = {handleAdd}> Submit </button>
      </header>
    </div>
  );
}

export default App;
