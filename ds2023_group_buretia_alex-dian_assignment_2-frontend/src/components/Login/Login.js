import React, { useState,useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import PropTypes from 'prop-types';import axios from 'axios';
async function loginUser(credentials) {
    // return fetch('http://localhost:8080/login', {
    //   method: 'POST',
    //   headers: {
    //     'Content-Type': 'application/json'
    //   },
    //   body: JSON.stringify(credentials)
    // })
    //   .then(data => data.json())
   }
export default function Login({ }) {
    const [username, setUserName] = useState();
    const [password, setPassword] = useState();
    const[data1,setData1]=useState([]);
    const[usernames,setUserNames]=useState();
    useEffect(() => {
      axios.get('http://localhost:8081/accounts')
        .then((response) => {
          setData1(response.data);
          // {data1.map((item,index) => (
          //  console.log(item.name)
          // ))}
          //console.log(data1);
        })
        .catch((error) => {
          console.error('Error fetching data:', error);
        });
  
    }, []);
    const handleSubmit = async e => {
        e.preventDefault();
        const token = await loginUser({
          username,
          password
        });
       
    }
    const navigate = useNavigate();

  const handleLogin = () => {

    // Perform login logic
    // If login is successful, redirect to the dashboard
  
    {data1.map((item,index) => {  
      if( item.name===username && item.password===password && item.role==='ADMIN')navigate('/AdminPage');
      if( item.name===username && item.password===password && item.role==='CLIENT')navigate(`/ClientPage/${username}`);

    })}
    //const a=data1.usernames.includes(username);
    //history.push('/dashboard');
  };
  return(
    <div className="login-wrapper">
    <h1>Please Log In</h1>
    <form onSubmit={handleSubmit}>
      <label>
        <p>Username</p>
        <input type="text" onChange={e => setUserName(e.target.value)}/>
      </label>
      <label>
        <p>Password</p>
        <input type="password" onChange={e => setPassword(e.target.value)}/>
      </label>
      <div>
        <button type="submit" onChange={e => setPassword(e.target.value)}>Submit</button>
      </div>
    </form>
    
    <button onClick={handleLogin}>Login</button>
    </div>
  )
}
