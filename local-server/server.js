const WebSocket = require('ws');
const http = require('http');

const port = 8080;
const server = http.createServer();
const wss = new WebSocket.Server({ server });

let clients = [];

wss.on('connection', function connection(ws) {
  clients.push(ws);
  console.log('New client connected');

  ws.on('message', function incoming(message) {
    console.log('received: %s', message);
    // Broadcast message to all other clients
    clients.forEach(client => {
      if (client !== ws && client.readyState === WebSocket.OPEN) {
        client.send(message);
      }
    });
  });

  ws.on('close', () => {
    clients = clients.filter(client => client !== ws);
    console.log('Client disconnected');
  });
});

server.listen(port, () => {
  console.log(`Local chat server running on port ${port}`);
});
