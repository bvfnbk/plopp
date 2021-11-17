# Routing

The _Plopp_ application implements its own _JavaScript_ based routing.

## Components

* Components are passed as _HTML template_ strings.
* The lifecycle methods of the corresponding web components are called as expected.

## Events

* `window.onload` : Emitted when the page is being loaded the first time.
* `window.onhashchange` : Emitted whenever the hash (i.e. the fragment) changes.

### `window.onload`

This event handler makes sure that any request ends up at the default _hashed_ location, e.g. `#/`. It eventually pushes
the default location if the current hash is _empty_.

### `window.onhashchange`

This event handler makes sure that the target URL contains a hash. It may not (e.g. if pressing the "Back" button after
the very first redirect to the default hash) and will therefore redirect back to the default hash.

## Discussion

* It seems to be a good idea to basically _redirect_ to `#/` if the original URL contains no hash.
* First tests appear to be working.
* The `isImmediate` flag may be not required: simply handle the navigation event (i.e. load component and update router
  view). The immediate push updates the location though (adding the hash).
