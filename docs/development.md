# Development

This document describes some guidelines for development. This is the central point to look for answers to the following
questions.

## User Interface

### JavaScript

#### Modules

* `.mjs` (as recommended) may cause the service to respond with an invalid content type (e.g.
  `application/octet-stream`). Use `.js` as long as you do not control the (default) content type.

