/**
 * An event handling callback.
 * @typedef {function(CustomEvent): *} CustomEventHandler The callback function handling the event.
 */

export class EventBus {
  constructor() {
    this.bus = document.createElement('__event_bus__');
  }

  /**
   * @param {string} event The event type to subscribe to.
   * @param {CustomEventHandler} callback the callback
   */
  subscribe(event, callback) {
    this.bus.addEventListener(event, callback);
  }

  /**
   * @param {string} event The event type to unsubscribe from.
   * @param {CustomEventHandler} callback The callback function handling the event.
   */
  unsubscribe(event, callback) {
    this.bus.removeEventListener(event, callback);
  }

  publish(event, detail = {}) {
    this.bus.dispatchEvent(new CustomEvent(event, {detail}));
  }
}
