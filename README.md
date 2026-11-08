# OneOf

[![Maven Central](https://img.shields.io/maven-central/v/pl.andrzejressel/oneof)](https://central.sonatype.com/artifact/pl.andrzejressel/oneof)
[![License](https://img.shields.io/github/license/nolequen/oneof)](licence.md)
![Java 21](https://img.shields.io/badge/Supports%20Java-21-orange?logo=java)

The library provides a kind of discriminated unions for Java: `OneOf<T0, ..., Tn>` holds the only value of the listed
types `T0`...`Tn`.

_Fork of [nolequen's](https://github.com/nolequen/oneof) library_

## Installation

```kotlin
implementation("pl.andrzejressel:oneof:0.0.1")
```

## Examples

* Matching the authentication result to one of several states and outputting a corresponding message based on that state
```java
OneOf3<User, AccountBanned, AuthError> result = authService.login(name, password);
switch (result) {
    case OneOf3.First(var user) -> System.out.println("Welcome, " + user.getName() + "!");
    case OneOf3.Second(var ban) -> System.err.println("Account banned: " + ban.getReason());
    case OneOf3.Third(var error) -> System.err.println("Auth error: " + error.getMessage());
};
```
* Folding the outcome of processing a payment into a unified message
```java
String message = paymentService.process(order).fold(
  payment -> "Payment successful: Order " + payment.getOrderId() + ", amount " + payment.getAmount(),
  error -> "Payment error: " + error.getMessage()
);
System.out.println(message);
```
