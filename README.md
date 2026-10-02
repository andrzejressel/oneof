# OneOf

[![Maven Central](https://img.shields.io/maven-central/v/dev.upwake/oneof)](https://central.sonatype.com/artifact/dev.upwake/oneof)
[![License](https://img.shields.io/github/license/nolequen/oneof)](licence.md)
![Java 1.8](https://img.shields.io/badge/Supports%20Java-1.8-orange?logo=java)

The library provides a kind of discriminated unions for Java: `OneOf<T0, ..., Tn>` holds the only value of the listed
types `T0`...`Tn`.

_Inspired by [OneOf](https://github.com/mcintyre321/OneOf) C# library._

## Installation

```kotlin
implementation("dev.upwake:oneof:2.0.0")
```

> Versions 1.x were published as `io.upwake:oneof` with the `io.upwake.oneof` package.
> To migrate, change the dependency to `dev.upwake:oneof` and the imports to `dev.upwake.oneof`.

## Examples

* Matching the authentication result to one of several states and outputting a corresponding message based on that state
```java
OneOf3<User, AccountBanned, AuthError> result = authService.login(name, password);
result.match(
    user -> System.out.println("Welcome, " + user.getName() + "!"),
    ban -> System.err.println("Account banned: " + ban.getReason()),
    error -> System.err.println("Auth error: " + error.getMessage())
);
```
* Folding the outcome of processing a payment into a unified message
```java
String message = paymentService.process(order).fold(
  payment -> "Payment successful: Order " + payment.getOrderId() + ", amount " + payment.getAmount(),
  error -> "Payment error: " + error.getMessage()
);
System.out.println(message);
```
