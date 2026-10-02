package dev.upwake.oneof;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public class OneOf8<T1, T2, T3, T4, T5, T6, T7, T8> {
  private final @Nullable T1 value1;
  private final @Nullable T2 value2;
  private final @Nullable T3 value3;
  private final @Nullable T4 value4;
  private final @Nullable T5 value5;
  private final @Nullable T6 value6;
  private final @Nullable T7 value7;
  private final @Nullable T8 value8;

  public static @NotNull <T1, T2, T3, T4, T5, T6, T7, T8> OneOf8<T1, T2, T3, T4, T5, T6, T7, T8> of1(@NotNull T1 value) {
    return new OneOf8<>(value, null, null, null, null, null, null, null);
  }

  public static @NotNull <T1, T2, T3, T4, T5, T6, T7, T8> OneOf8<T1, T2, T3, T4, T5, T6, T7, T8> of2(@NotNull T2 value) {
    return new OneOf8<>(null, value, null, null, null, null, null, null);
  }

  public static @NotNull <T1, T2, T3, T4, T5, T6, T7, T8> OneOf8<T1, T2, T3, T4, T5, T6, T7, T8> of3(@NotNull T3 value) {
    return new OneOf8<>(null, null, value, null, null, null, null, null);
  }

  public static @NotNull <T1, T2, T3, T4, T5, T6, T7, T8> OneOf8<T1, T2, T3, T4, T5, T6, T7, T8> of4(@NotNull T4 value) {
    return new OneOf8<>(null, null, null, value, null, null, null, null);
  }

  public static @NotNull <T1, T2, T3, T4, T5, T6, T7, T8> OneOf8<T1, T2, T3, T4, T5, T6, T7, T8> of5(@NotNull T5 value) {
    return new OneOf8<>(null, null, null, null, value, null, null, null);
  }

  public static @NotNull <T1, T2, T3, T4, T5, T6, T7, T8> OneOf8<T1, T2, T3, T4, T5, T6, T7, T8> of6(@NotNull T6 value) {
    return new OneOf8<>(null, null, null, null, null, value, null, null);
  }

  public static @NotNull <T1, T2, T3, T4, T5, T6, T7, T8> OneOf8<T1, T2, T3, T4, T5, T6, T7, T8> of7(@NotNull T7 value) {
    return new OneOf8<>(null, null, null, null, null, null, value, null);
  }

  public static @NotNull <T1, T2, T3, T4, T5, T6, T7, T8> OneOf8<T1, T2, T3, T4, T5, T6, T7, T8> of8(@NotNull T8 value) {
    return new OneOf8<>(null, null, null, null, null, null, null, value);
  }

  protected OneOf8(@Nullable T1 value1,
                   @Nullable T2 value2,
                   @Nullable T3 value3,
                   @Nullable T4 value4,
                   @Nullable T5 value5,
                   @Nullable T6 value6,
                   @Nullable T7 value7,
                   @Nullable T8 value8) {
    this.value1 = value1;
    this.value2 = value2;
    this.value3 = value3;
    this.value4 = value4;
    this.value5 = value5;
    this.value6 = value6;
    this.value7 = value7;
    this.value8 = value8;
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

  public @Nullable T4 _4() {
    return value4;
  }

  public @Nullable T5 _5() {
    return value5;
  }

  public @Nullable T6 _6() {
    return value6;
  }

  public @Nullable T7 _7() {
    return value7;
  }

  public @Nullable T8 _8() {
    return value8;
  }

  public void match(@NotNull Consumer<T1> consumer1,
                    @NotNull Consumer<T2> consumer2,
                    @NotNull Consumer<T3> consumer3,
                    @NotNull Consumer<T4> consumer4,
                    @NotNull Consumer<T5> consumer5,
                    @NotNull Consumer<T6> consumer6,
                    @NotNull Consumer<T7> consumer7,
                    @NotNull Consumer<T8> consumer8) {
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
    if (value4 != null) {
      consumer4.accept(value4);
      return;
    }
    if (value5 != null) {
      consumer5.accept(value5);
      return;
    }
    if (value6 != null) {
      consumer6.accept(value6);
      return;
    }
    if (value7 != null) {
      consumer7.accept(value7);
      return;
    }
    if (value8 != null) {
      consumer8.accept(value8);
      return;
    }
    throw new NoSuchElementException("None of the values are present");
  }

  public @NotNull <R> R fold(@NotNull Function<T1, R> function1,
                             @NotNull Function<T2, R> function2,
                             @NotNull Function<T3, R> function3,
                             @NotNull Function<T4, R> function4,
                             @NotNull Function<T5, R> function5,
                             @NotNull Function<T6, R> function6,
                             @NotNull Function<T7, R> function7,
                             @NotNull Function<T8, R> function8) {
    if (value1 != null) {
      return function1.apply(value1);
    }
    if (value2 != null) {
      return function2.apply(value2);
    }
    if (value3 != null) {
      return function3.apply(value3);
    }
    if (value4 != null) {
      return function4.apply(value4);
    }
    if (value5 != null) {
      return function5.apply(value5);
    }
    if (value6 != null) {
      return function6.apply(value6);
    }
    if (value7 != null) {
      return function7.apply(value7);
    }
    if (value8 != null) {
      return function8.apply(value8);
    }
    throw new NoSuchElementException("None of the values are present");
  }

  public @NotNull <R> OneOf8<R, T2, T3, T4, T5, T6, T7, T8> map1(@NotNull Function<T1, R> function) {
    if (value1 != null) {
      return OneOf8.of1(function.apply(value1));
    }
    if (value2 != null) {
      return OneOf8.of2(value2);
    }
    if (value3 != null) {
      return OneOf8.of3(value3);
    }
    if (value4 != null) {
      return OneOf8.of4(value4);
    }
    if (value5 != null) {
      return OneOf8.of5(value5);
    }
    if (value6 != null) {
      return OneOf8.of6(value6);
    }
    if (value7 != null) {
      return OneOf8.of7(value7);
    }
    if (value8 != null) {
      return OneOf8.of8(value8);
    }
    throw new NoSuchElementException("None of the values are present");
  }

  public @NotNull <R> OneOf8<T1, R, T3, T4, T5, T6, T7, T8> map2(@NotNull Function<T2, R> function) {
    if (value1 != null) {
      return OneOf8.of1(value1);
    }
    if (value2 != null) {
      return OneOf8.of2(function.apply(value2));
    }
    if (value3 != null) {
      return OneOf8.of3(value3);
    }
    if (value4 != null) {
      return OneOf8.of4(value4);
    }
    if (value5 != null) {
      return OneOf8.of5(value5);
    }
    if (value6 != null) {
      return OneOf8.of6(value6);
    }
    if (value7 != null) {
      return OneOf8.of7(value7);
    }
    if (value8 != null) {
      return OneOf8.of8(value8);
    }
    throw new NoSuchElementException("None of the values are present");
  }

  public @NotNull <R> OneOf8<T1, T2, R, T4, T5, T6, T7, T8> map3(@NotNull Function<T3, R> function) {
    if (value1 != null) {
      return OneOf8.of1(value1);
    }
    if (value2 != null) {
      return OneOf8.of2(value2);
    }
    if (value3 != null) {
      return OneOf8.of3(function.apply(value3));
    }
    if (value4 != null) {
      return OneOf8.of4(value4);
    }
    if (value5 != null) {
      return OneOf8.of5(value5);
    }
    if (value6 != null) {
      return OneOf8.of6(value6);
    }
    if (value7 != null) {
      return OneOf8.of7(value7);
    }
    if (value8 != null) {
      return OneOf8.of8(value8);
    }
    throw new NoSuchElementException("None of the values are present");
  }

  public @NotNull <R> OneOf8<T1, T2, T3, R, T5, T6, T7, T8> map4(@NotNull Function<T4, R> function) {
    if (value1 != null) {
      return OneOf8.of1(value1);
    }
    if (value2 != null) {
      return OneOf8.of2(value2);
    }
    if (value3 != null) {
      return OneOf8.of3(value3);
    }
    if (value4 != null) {
      return OneOf8.of4(function.apply(value4));
    }
    if (value5 != null) {
      return OneOf8.of5(value5);
    }
    if (value6 != null) {
      return OneOf8.of6(value6);
    }
    if (value7 != null) {
      return OneOf8.of7(value7);
    }
    if (value8 != null) {
      return OneOf8.of8(value8);
    }
    throw new NoSuchElementException("None of the values are present");
  }

  public @NotNull <R> OneOf8<T1, T2, T3, T4, R, T6, T7, T8> map5(@NotNull Function<T5, R> function) {
    if (value1 != null) {
      return OneOf8.of1(value1);
    }
    if (value2 != null) {
      return OneOf8.of2(value2);
    }
    if (value3 != null) {
      return OneOf8.of3(value3);
    }
    if (value4 != null) {
      return OneOf8.of4(value4);
    }
    if (value5 != null) {
      return OneOf8.of5(function.apply(value5));
    }
    if (value6 != null) {
      return OneOf8.of6(value6);
    }
    if (value7 != null) {
      return OneOf8.of7(value7);
    }
    if (value8 != null) {
      return OneOf8.of8(value8);
    }
    throw new NoSuchElementException("None of the values are present");
  }

  public @NotNull <R> OneOf8<T1, T2, T3, T4, T5, R, T7, T8> map6(@NotNull Function<T6, R> function) {
    if (value1 != null) {
      return OneOf8.of1(value1);
    }
    if (value2 != null) {
      return OneOf8.of2(value2);
    }
    if (value3 != null) {
      return OneOf8.of3(value3);
    }
    if (value4 != null) {
      return OneOf8.of4(value4);
    }
    if (value5 != null) {
      return OneOf8.of5(value5);
    }
    if (value6 != null) {
      return OneOf8.of6(function.apply(value6));
    }
    if (value7 != null) {
      return OneOf8.of7(value7);
    }
    if (value8 != null) {
      return OneOf8.of8(value8);
    }
    throw new NoSuchElementException("None of the values are present");
  }

  public @NotNull <R> OneOf8<T1, T2, T3, T4, T5, T6, R, T8> map7(@NotNull Function<T7, R> function) {
    if (value1 != null) {
      return OneOf8.of1(value1);
    }
    if (value2 != null) {
      return OneOf8.of2(value2);
    }
    if (value3 != null) {
      return OneOf8.of3(value3);
    }
    if (value4 != null) {
      return OneOf8.of4(value4);
    }
    if (value5 != null) {
      return OneOf8.of5(value5);
    }
    if (value6 != null) {
      return OneOf8.of6(value6);
    }
    if (value7 != null) {
      return OneOf8.of7(function.apply(value7));
    }
    if (value8 != null) {
      return OneOf8.of8(value8);
    }
    throw new NoSuchElementException("None of the values are present");
  }

  public @NotNull <R> OneOf8<T1, T2, T3, T4, T5, T6, T7, R> map8(@NotNull Function<T8, R> function) {
    if (value1 != null) {
      return OneOf8.of1(value1);
    }
    if (value2 != null) {
      return OneOf8.of2(value2);
    }
    if (value3 != null) {
      return OneOf8.of3(value3);
    }
    if (value4 != null) {
      return OneOf8.of4(value4);
    }
    if (value5 != null) {
      return OneOf8.of5(value5);
    }
    if (value6 != null) {
      return OneOf8.of6(value6);
    }
    if (value7 != null) {
      return OneOf8.of7(value7);
    }
    if (value8 != null) {
      return OneOf8.of8(function.apply(value8));
    }
    throw new NoSuchElementException("None of the values are present");
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final OneOf8<?, ?, ?, ?, ?, ?, ?, ?> oneOf8 = (OneOf8<?, ?, ?, ?, ?, ?, ?, ?>) o;
    return Objects.equals(value1, oneOf8.value1)
        && Objects.equals(value2, oneOf8.value2)
        && Objects.equals(value3, oneOf8.value3)
        && Objects.equals(value4, oneOf8.value4)
        && Objects.equals(value5, oneOf8.value5)
        && Objects.equals(value6, oneOf8.value6)
        && Objects.equals(value7, oneOf8.value7)
        && Objects.equals(value8, oneOf8.value8);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value1, value2, value3, value4, value5, value6, value7, value8);
  }

  @Override
  public @NotNull String toString() {
    if (value1 != null) {
      return "1of8{" + value1 + '}';
    }
    if (value2 != null) {
      return "2of8{" + value2 + '}';
    }
    if (value3 != null) {
      return "3of8{" + value3 + '}';
    }
    if (value4 != null) {
      return "4of8{" + value4 + '}';
    }
    if (value5 != null) {
      return "5of8{" + value5 + '}';
    }
    if (value6 != null) {
      return "6of8{" + value6 + '}';
    }
    if (value7 != null) {
      return "7of8{" + value7 + '}';
    }
    if (value8 != null) {
      return "8of8{" + value8 + '}';
    }
    return "NoneOf8";
  }
}
