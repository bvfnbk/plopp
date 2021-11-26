# plopp

Planning poker revisited.

## Configuration

### Environment Variables

| Key           | Default | Comment                                   |
| ---           | ---     | ---                                       |
| `PORT`        | 8080    | Apparently the preferred means of Heroku. |

## Modules

There are the following modules:

* `service` : The Ktor service application.
* `client` : The _React_ front-end.

**Please note:** A _shared_ module containing model classes may be added later.

## Development

### Modules

* Add `include("name")` to the `./settings.gradle.kts` for a new module.
