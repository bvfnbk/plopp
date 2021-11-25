import {BaseComponent} from './BaseComponent.js';

export class Application extends BaseComponent {
  constructor() {
    super();
  }

  render() {
    return `
      <div>
        Application Element
        <plopp-router-view />
      </div>
    `;
  }
}


