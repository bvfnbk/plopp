import {Home} from './components/pages/Home.js';
import {About} from './components/pages/About.js';
import {RouterView} from './components/RouterView.js';
import {Application} from './components/Application.js';
import {EventBus} from './events/EventBus.js';
import {PloppSocket} from './PloppSocket.js';
import {Router} from './routing/Router.js';

if (!Object.prototype.hasOwnProperty.call(window, '$plopp')) {
  window.$plopp = {
    events: new EventBus(),
    socket: new PloppSocket(location.protocol, location.hostname, location.port, '/events')
  };
} else {
  console.log('$plopp already set up.');
}

/*
   * Create & Configure Router
   *
   * Please note: Currently, the components are specified as
   * HTML template string. The router view inserts these into
   * the particular <div> in the `innerHTML`.
   *
   * The connected/disconnected callbacks are correctly called.
   *
   * The component must be passed as some sort of factory such
   * that properties/attributes can be added when injecting it.
   */

new Router({
  '/': `<plopp-home></plopp-home>`,
  '/about': `<plopp-about></plopp-about>`
}).registerEventListener();

customElements.define('plopp-home', Home);
customElements.define('plopp-about', About);
customElements.define('plopp-router-view', RouterView);
customElements.define('plopp-application', Application);
