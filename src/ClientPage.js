import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import DeviceTable from './DeviceTable';
import axios from 'axios';
import { useCallback } from 'react';
 function ClientPage(){
  const{username}=useParams();
  const [notifications, setNotifications] = useState([]);//nou
  const [clientData, setClientData] = useState();
  const [loading, setLoading] = useState(true);
  const[intermed,setIntermed]=useState([]);
  const [deviceList, setDeviceList] = useState(undefined);
  const fetchClientData = useCallback(async () => {
    let clientDataResponse;
    try {
      clientDataResponse = await axios.get(`http://localhost:8091/accounts/${username}`);
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
      let deviceListResponse = await axios.get(`http://localhost:8090/devices/${clientDataResponse.data.id}`);
      setDeviceList(deviceListResponse.data);
    } catch (error) {
      console.log(`An error occured while getting the accounts: ${error}`);
      return;
    }
  }, [username]);

  // let fct = async () => {}
  // fct();
//nou
const sendNotification = () => {
  const notification = { content: 'New notification!' };
  WebSocketService.sendNotification(notification);
};
//nou
  useEffect(() => {
    fetchClientData();
    //aici nou
    WebSocketService.connect();

        WebSocketService.subscribeToNotifications((message) => {
            const newNotification = JSON.parse(message.body);
            setNotifications((prevNotifications) => [...prevNotifications, newNotification]);
        });

        return () => {
            WebSocketService.client.deactivate();
        };
        //pana aici
  }, []);
  //if (loading) {
  //  return <div>Loading...</div>;
 // }
  if (!clientData || !deviceList) {
    return <div>Error loading client data.</div>;

  }
  return (
    <div>
      <h1>{clientData.name}</h1>
      <p>Role: {clientData.role}</p>
      <p>Password: {clientData.password}</p>
       <DeviceTable devices={deviceList} /> 
    </div>
  );
}
export default ClientPage;