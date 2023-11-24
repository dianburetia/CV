import { Client } from '@stomp/stompjs';

const SOCKET_URL = 'http://localhost:8089/ws';

class WebSocketService {
    connect() {
        this.client = new Client();
        this.client.webSocketFactory = () => new SockJS(SOCKET_URL);

        this.client.onConnect = () => {
            console.log('Connected to WebSocket');
        };

        this.client.activate();
    }

    sendNotification(notification) {
        this.client.publish({
            destination: '/app/sendNotification',
            body: JSON.stringify(notification),
        });
    }

    subscribeToNotifications(callback) {
        this.client.subscribe('/topic/notifications', callback);
    }
}

export default new WebSocketService();