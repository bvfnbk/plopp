import {BaseComponent} from './BaseComponent.js';
import {EventType} from '../events/EventType.js';

export class RouterView extends BaseComponent {
  constructor() {
    super([EventType.NAVIGATION_EVENT]);

    // parent calls this.accept(event) which eventually is bound to a different prototype (the parent)
    // -> rebind to this.
    this.accept = this.accept.bind(this);
  }

  /**
   *
   * @param {NavigationEvent} event
   */
  handleNavigationEvent(event) {
    const {shadowRoot} = this;
    const view = shadowRoot.getElementById('router-view');

    if (event.component !== null) {
      if (view !== null) {
        view.innerHTML = event.component;
      } else {
        console.warn('Cannot find router view slot...');
      }
    } else {
      console.warn('Component is null.');
    }
  }

  render() {
    // Q: How to attach event listeners etc....i.e. attach behaviour to the template/component? We will see...
    return `
        <div>
            Router View
            <div id="router-view"></div>
        </div>
    `;
  }

  /**
   * @param {CustomEvent} event
   */
  accept(event) {
    if (event.type === EventType.NAVIGATION_EVENT) {
      this.handleNavigationEvent(event.detail);
    } else {
      // what? should i throw or silence the error?
      console.warn(`Unknown event type: ${event.type}`);
    }
  }
}


