export class BaseComponent extends HTMLElement {
  /**
   * @param {string[]} events The list of event to subscribe to; default `[]`
   */
  constructor(events = []) {
    super();
    this.$events = events;
    this.$eventBus = window.$plopp.events;
    this.attachShadow({mode: 'open'});
  }

  /**
   * 1. Subscribe to the events received from child class
   * 2. Update the inner HTML of the shadow root with the result of the child's render() method call.
   *
   */
  connectedCallback() {
    // Call child...
    this.connect();

    this.$events.forEach(eventType => this.$eventBus.subscribe(eventType, this.accept))
    const {shadowRoot} = this;
    shadowRoot.innerHTML = this.render();
  }

  /**
   * Unsubscribe to the events received from the child class.
   */
  disconnectedCallback() {
    // Call child
    this.disconnect();

    this.$events.forEach(eventType => this.$eventBus.unsubscribe(eventType, this.accept));
  }

  accept(event) {}

  render() {
    return `<span></span>`;
  }

  connect() {}

  disconnect() {}
}
