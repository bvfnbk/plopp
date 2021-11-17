export class NavigationEvent {
  /**
   * @param {string} hash The hash defining the target route to which the router should navigate to.
   * @param {boolean} isImmediate A boolean flag indicating that the router should immediately follow this navigation
   * request.
   * @param {string | null} component The resolved component; default: `null`
   */
  constructor(hash, isImmediate = false, component= null) {
    this.hash = hash;
    this.isImmediate = isImmediate;
    this.component = component;
  }

  /**
   * Create a new {@link NavigationEvent}, setting the target component.
   *
   * @param {string} newComponent the new component.
   * @return {NavigationEvent}
   */
  withComponent(newComponent) {
    return new NavigationEvent(this.hash, this.isImmediate, newComponent);
  }
}
