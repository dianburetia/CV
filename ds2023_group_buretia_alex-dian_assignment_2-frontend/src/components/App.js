import React, { useState } from 'react';
import { Button, Navbar } from 'react-bootstrap'
import './App.css';
import ClientPage from '../ClientPage.js';
import { BrowserRouter, Route, Routes,Link } from 'react-router-dom';
import Dashboard from './Dashboard/Dashboard';
import Preferences from './Preferences/Preferences';
import Login from './Login/Login';
import AdminPage from '../AdminPage.js';
import PrivateRoute from '../PrivateRoute.js';
import useToken from './useToken';
import {  } from 'react-router';
// function setToken(userToken) {
//   sessionStorage.setItem('token', JSON.stringify(userToken));
// }

// function getToken() {
//   const tokenString = sessionStorage.getItem('token');
//   const userToken = JSON.parse(tokenString);
//   return userToken?.token
// }
function App() {
//   const { token, setToken } = useToken();
//   if(!token) {
//    return <Login setToken={setToken} />
//  }
  return (
    <div className="wrapper">
      <h1>Application</h1>
      <BrowserRouter>
        <div>
          <Navbar /> {/* Place your Navbar component inside the Router */}
          <nav>
            <ul>
              <li>
                <Link to="/AdminPage">Admin Page</Link>
              </li>
              <li>
                <Link to="/ClientPage">Client Page</Link>
              </li>
              <li>
                <Link to="/preferences">Home</Link>
              </li>
              <li>
                <Link to="/">Login</Link>
              </li>
            </ul>
          </nav>
          <Routes>
            <Route path="/AdminPage" element={<AdminPage />} />
            <Route path="/ClientPage/:username" element={<ClientPage />} />
            <Route path="/preferences" element={<Preferences />} />
            <Route path="/" element={<Login />} />
          </Routes>
        </div>
      </BrowserRouter>
    </div>
  );
}

export default App;
