export class PloppSocket {
  constructor(protocol, hostname, port, resource) {
    this.url = this.getUrl(protocol, hostname, port, resource);

    this.listener = [];

    this.connected = false;

    this.socket = new WebSocket(this.url);

    this.socket.onopen = () => this.onOpen();
    this.socket.onclose = () => this.onClose();
    this.socket.onerror = (error) => this.onError(error);
    this.socket.onmessage = (message) => this.onMessage(message);
  }

  getUrl(protocol, hostname, port, resource) {
    const scheme = protocol.startsWith('https') ? 'wss' : 'ws';
    const portSuffix = port === '' ? '' : `:${port}`;
    return `${scheme}://${hostname}${portSuffix}${resource}`
  }

  send(message) {
    this.socket.send(message);
  }

  addListener(listener) {
    this.listener.push(listener);
  }

  isConnected() {
    return this.connected;
  }

  onOpen() {
    this.connected = true;
  }

  onClose() {
    this.connected = false;
  }

  onError(error) {
    console.error(error);
  }

  onMessage(message) {
    console.log('onMessage()', message);
    this.listener.forEach(listener => listener(message.data));
  }
}
