import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import DeviceTable from './DeviceTable';import SockJS from 'sockjs-client';
import Stomp from 'stompjs';
import DataChart from './DataChart';
import axios from 'axios';import WebSocketComponent from './WebSocketComponent';
import { useCallback } from 'react';
 function ClientPage(){
  const{username}=useParams();const [clientId, setClientId] = useState(null);
  const [notifications, setNotifications] = useState([]);//nou
  const [clientData, setClientData] = useState();
  const [loading, setLoading] = useState(true);
  const[intermed,setIntermed]=useState([]);
  const [deviceList, setDeviceList] = useState(undefined);
  const fetchClientData = useCallback(async () => {
    let clientDataResponse;
    try {
      clientDataResponse = await axios.get(`http://localhost:8081/accounts/${username}`);
      if (!clientDataResponse) return;
      setClientData(clientDataResponse.data);
    } catch (error) {
      console.log(`An error occured while getting the accounts: ${error}`);
      return;
    }

    if (!clientDataResponse) {
      console.log(`Bad response from getting the accounts`);
      return;
    }
  
    try {
      let deviceListResponse = await axios.get(`http://localhost:8082/devices/${clientDataResponse.data.id}`);
      setDeviceList(deviceListResponse.data);
    } catch (error) {
      console.log(`An error occured while getting the accounts: ${error}`);
      return;
    }
  }, [username]);

  // let fct = async () => {}
  // fct();
//nou

//nou

        //pana aici

        useEffect(() => {
          fetchClientData();
        }, [fetchClientData]);
      
        if (!clientData || !deviceList) {
          return <div>Loading...</div>;
        }
  return (
    <div>
      <h1>{username}</h1>
      <p>Role: {clientData.role}</p>
      <p>Password: {clientData.password}</p>
      <DeviceTable devices={deviceList} /> 
      <DataChart />
      <WebSocketComponent />
    </div>
  );
}
export default ClientPage;