import {NavigationEventFactory} from './NavigationEventFactory.js';

/**
 * A "simple" homegrown router.
 */
export class Router {

  /**
   *
   * @param {{string:string}} routes
   */
  constructor(routes= {}) {
    this.routes = routes
  }

  registerEventListener() {
    window.onload = (event) => this.handle(NavigationEventFactory.createFrom(event));
    window.onhashchange = (event) => this.handle(NavigationEventFactory.createFrom(event));

    return this;
  }

  /**
   * @param {string} hash The hash for which the component is required.
   * @return {string} the target component HTML template.
   */
  resolveComponent(hash) {
    const key = hash.substring(1);

    if (Object.prototype.hasOwnProperty.call(this.routes, hash.substring(1))) {
      return this.routes[key];
    } else {
      throw new Error('Unknown router key: ' + key);
    }
  }

  /**
   * @param {NavigationEvent} event
   */
  handle(event) {
    // -> publish navigation event
    window.$plopp.events.publish(
      'NavigationEvent',
      event.withComponent(this.resolveComponent(event.hash))
    );
    if (event.isImmediate) {
      // event.isImmediate === true <=>
      //  Original request did not contain hash
      //  (or user went back in browser history -
      //  before the first push)
      window.history.pushState({}, '', event.hash);
    }
  }
}
