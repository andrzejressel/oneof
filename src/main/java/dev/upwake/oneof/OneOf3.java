package dev.upwake.oneof;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public class OneOf3<T1, T2, T3> {
  private final @Nullable T1 value1;
  private final @Nullable T2 value2;
  private final @Nullable T3 value3;

  public static @NotNull <T1, T2, T3> OneOf3<T1, T2, T3> of1(@NotNull T1 value) {
    return new OneOf3<>(value, null, null);
  }

  public static @NotNull <T1, T2, T3> OneOf3<T1, T2, T3> of2(@NotNull T2 value) {
    return new OneOf3<>(null, value, null);
  }

  public static @NotNull <T1, T2, T3> OneOf3<T1, T2, T3> of3(@NotNull T3 value) {
    return new OneOf3<>(null, null, value);
  }

  protected OneOf3(@Nullable T1 value1,
                   @Nullable T2 value2,
                   @Nullable T3 value3) {
    this.value1 = value1;
    this.value2 = value2;
    this.value3 = value3;
  }

  public @Nullable T1 _1() {
    return value1;
  }

  public @Nullable T2 _2() {
    return value2;
  }

  public @Nullable T3 _3() {
    return value3;
  }

  public void match(@NotNull Consumer<T1> consumer1,
                    @NotNull Consumer<T2> consumer2,
                    @NotNull Consumer<T3> consumer3) {
    if (value1 != null) {
      consumer1.accept(value1);
      return;
    }
    if (value2 != null) {
      consumer2.accept(value2);
      return;
    }
    if (value3 != null) {
      consumer3.accept(value3);
      return;
    }
    throw new NoSuchElementException("None of the values are present");
  }

  public @NotNull <R> R fold(@NotNull Function<T1, R> function1,
                             @NotNull Function<T2, R> function2,
                             @NotNull Function<T3, R> function3) {
    if (value1 != null) {
      return function1.apply(value1);
    }
    if (value2 != null) {
      return function2.apply(value2);
    }
    if (value3 != null) {
      return function3.apply(value3);
    }
    throw new NoSuchElementException("None of the values are present");
  }

  public @NotNull <R> OneOf3<R, T2, T3> map1(@NotNull Function<T1, R> function) {
    if (value1 != null) {
      return OneOf3.of1(function.apply(value1));
    }
    if (value2 != null) {
      return OneOf3.of2(value2);
    }
    if (value3 != null) {
      return OneOf3.of3(value3);
    }
    throw new NoSuchElementException("None of the values are present");
  }

  public @NotNull <R> OneOf3<T1, R, T3> map2(@NotNull Function<T2, R> function) {
    if (value1 != null) {
      return OneOf3.of1(value1);
    }
    if (value2 != null) {
      return OneOf3.of2(function.apply(value2));
    }
    if (value3 != null) {
      return OneOf3.of3(value3);
    }
    throw new NoSuchElementException("None of the values are present");
  }

  public @NotNull <R> OneOf3<T1, T2, R> map3(@NotNull Function<T3, R> function) {
    if (value1 != null) {
      return OneOf3.of1(value1);
    }
    if (value2 != null) {
      return OneOf3.of2(value2);
    }
    if (value3 != null) {
      return OneOf3.of3(function.apply(value3));
    }
    throw new NoSuchElementException("None of the values are present");
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final OneOf3<?, ?, ?> oneOf3 = (OneOf3<?, ?, ?>) o;
    return Objects.equals(value1, oneOf3.value1)
        && Objects.equals(value2, oneOf3.value2)
        && Objects.equals(value3, oneOf3.value3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value1, value2, value3);
  }

  @Override
  public @NotNull String toString() {
    if (value1 != null) {
      return "1of3{" + value1 + '}';
    }
    if (value2 != null) {
      return "2of3{" + value2 + '}';
    }
    if (value3 != null) {
      return "3of3{" + value3 + '}';
    }
    return "NoneOf3";
  }
}
