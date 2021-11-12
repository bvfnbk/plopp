# Development

This document describes some guidelines for development. This is the central point to look for answers to the following
questions.

## User Interface

### JavaScript

#### Modules

* `.mjs` (as recommended) may cause the service to respond with an invalid content type (e.g.
  `application/octet-stream`). Use `.js` as long as you do not control the (default) content type.

## Service

### Logging

There is an _annotation_ which automatically injects a logger instance into the component. Use it where required:

```kotlin
import org.springframework.stereotype.Component
import com.github.bvfnbk.plopp.framework.Slf4jLogger
import org.slf4j.Logger

@Component
class SpringComponent {
    companion object {
        @Slf4jLogger
        lateinit var logger: Logger
    }
}
```
