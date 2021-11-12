# Messages

## Server to Front-End

### Session

Notify the client of its session id.

```kotlin
data class Session(
  val id: String
)
```

**Please note:** The client may show a "loading" state until it received a session ID.
