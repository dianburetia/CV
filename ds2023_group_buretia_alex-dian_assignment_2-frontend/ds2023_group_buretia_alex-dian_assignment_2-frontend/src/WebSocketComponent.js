import React, { useEffect,useState } from 'react';
import SockJS from 'sockjs-client';
import Stomp from 'stompjs';
const WebSocketComponent = () => {
  const [notifications, setNotifications] = useState([]);

  useEffect(() => {
    const socket = new SockJS('http://localhost:8083/ws');
    const stompClient = Stomp.over(socket);

    stompClient.connect({}, () => {
      console.log('Connected to WebSocket');

      // Subscribe to the specific destination or topic where notifications are sent
      const subscription = stompClient.subscribe('/topic/notifications', (message) => {
        // Handle incoming messages
        const newNotification = JSON.parse(message.body);
        setNotifications((prevNotifications) => [...prevNotifications, newNotification]);
      });

      // Clean up the subscription when the component unmounts
      return () => {
        subscription.unsubscribe();
      };
    });
  }, []); // Empty dependency array ensures that this effect runs once when the component mounts

  return (
    <div>
      <h2>WebSocket Notifications</h2>
      <ul>
        {notifications.map((notification, index) => (
          <li key={index}>{notification.content}</li>
        ))}
      </ul>
    </div>
  );
};

export default WebSocketComponent;