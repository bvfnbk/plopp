import {NavigationEvent} from './NavigationEvent.js';

/**
 * An event factory creating navigation events.
 */
export class NavigationEventFactory {
  /**
   * Converts the given event to a navigation event.
   *
   * @param {Event | HashChangeEvent} event The event for which the {NavigationEvent} should be created.
   * @return {NavigationEvent} The configured navigation event.
   * @throws {Error} if the given event is `undefined` or `null` or no instance of {@link Event} or
   * {@link HashChangeEvent}
   */
  static createFrom(event) {
    if (typeof event === 'undefined' || event === null) {
      throw new Error('Source event not defined/null');
    }
    if (event instanceof HashChangeEvent) {
      return NavigationEventFactory.fromTargetUrl(event.newURL);
    } else if (event instanceof Event) {
      return NavigationEventFactory.fromLocation(event.target.location);
    } else {
      throw new Error('Unknown event type.');
    }
  }

  /**
   * @param {string} url The new target URL to be used to extract the hash createFrom.
   * @return {NavigationEvent} the navigation event matching the hash contained in the given {@link Location}
   */
  static fromTargetUrl(url) {
    if (typeof url !== 'string' && !(url instanceof String)) {
      throw new Error(`Type constraint error; expected string URL (${url} - ${typeof url})`);
    }

    const parts = url.split('#');

    if (parts.length === 2) {
      return new NavigationEvent(`#${parts[1]}`);
    } else if (parts.length === 1) {
      return new NavigationEvent('#/', true);
    } else {
      throw new Error(`Unsupported URL format: ${url}`);
    }
  }

  /**
   * @param {Location} location The {@link Location} to use the {@link Location.hash} from.
   * @return {NavigationEvent} the navigation event matching the hash contained in the given {@link Location}
   */
  static fromLocation(location) {
    if (location.hash === '') {
      return new NavigationEvent('#/', true);
    } else {
      return new NavigationEvent(location.hash);
    }
  }
}
