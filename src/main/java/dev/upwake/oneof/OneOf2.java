package dev.upwake.oneof;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public class OneOf2<T1, T2> {
  private final @Nullable T1 value1;
  private final @Nullable T2 value2;

  public static @NotNull <T1, T2> OneOf2<T1, T2> of1(@NotNull T1 value) {
    return new OneOf2<>(value, null);
  }

  public static @NotNull <T1, T2> OneOf2<T1, T2> of2(@NotNull T2 value) {
    return new OneOf2<>(null, value);
  }

  protected OneOf2(@Nullable T1 value1,
                   @Nullable T2 value2) {
    this.value1 = value1;
    this.value2 = value2;
  }

  public @Nullable T1 _1() {
    return value1;
  }

  public @Nullable T2 _2() {
    return value2;
  }

  public void match(@NotNull Consumer<T1> consumer1,
                    @NotNull Consumer<T2> consumer2) {
    if (value1 != null) {
      consumer1.accept(value1);
      return;
    }
    if (value2 != null) {
      consumer2.accept(value2);
      return;
    }
    throw new NoSuchElementException("None of the values are present");
  }

  public @NotNull <R> R fold(@NotNull Function<T1, R> function1,
                             @NotNull Function<T2, R> function2) {
    if (value1 != null) {
      return function1.apply(value1);
    }
    if (value2 != null) {
      return function2.apply(value2);
    }
    throw new NoSuchElementException("None of the values are present");
  }

  public @NotNull <R> OneOf2<R, T2> map1(@NotNull Function<T1, R> function) {
    if (value1 != null) {
      return OneOf2.of1(function.apply(value1));
    }
    if (value2 != null) {
      return OneOf2.of2(value2);
    }
    throw new NoSuchElementException("None of the values are present");
  }

  public @NotNull <R> OneOf2<T1, R> map2(@NotNull Function<T2, R> function) {
    if (value1 != null) {
      return OneOf2.of1(value1);
    }
    if (value2 != null) {
      return OneOf2.of2(function.apply(value2));
    }
    throw new NoSuchElementException("None of the values are present");
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final OneOf2<?, ?> oneOf2 = (OneOf2<?, ?>) o;
    return Objects.equals(value1, oneOf2.value1)
        && Objects.equals(value2, oneOf2.value2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value1, value2);
  }

  @Override
  public @NotNull String toString() {
    if (value1 != null) {
      return "1of2{" + value1 + '}';
    }
    if (value2 != null) {
      return "2of2{" + value2 + '}';
    }
    return "NoneOf2";
  }
}
