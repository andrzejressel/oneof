package pl.andrzejressel.oneof;

import java.util.function.Function;

sealed public interface OneOf3<T1, T2, T3> permits OneOf3.First, OneOf3.Second, OneOf3.Third {
    default <R> OneOf3<R, T2, T3> mapFirst(Function<? super T1, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(mapper.apply(value));
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
        };
    }

    default <R> OneOf3<T1, R, T3> mapSecond(Function<? super T2, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(mapper.apply(value));
            case Third(var value) -> new Third<>(value);
        };
    }

    default <R> OneOf3<T1, T2, R> mapThird(Function<? super T3, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(mapper.apply(value));
        };
    }

    default <T> T fold(Function<? super T1, ? extends T> firstMapper, Function<? super T2, ? extends T> secondMapper, Function<? super T3, ? extends T> thirdMapper) {
        return switch (this) {
            case First(var value) -> firstMapper.apply(value);
            case Second(var value) -> secondMapper.apply(value);
            case Third(var value) -> thirdMapper.apply(value);
        };
    }

    @SuppressWarnings("unchecked")
    static <T1, T2, T3> OneOf3<T1, T2, T3> fromIndex(int index, Object obj) {
        return switch (index) {
            case 0 -> new First<>((T1) obj);
            case 1 -> new Second<>((T2) obj);
            case 2 -> new Third<>((T3) obj);
            default -> throw new IllegalArgumentException("Invalid index: " + index);
        };
    }

    static <T1, T2, T3> OneOf3<T1, T2, T3> first(T1 value) {
        return new First<>(value);
    }

    static <T1, T2, T3> OneOf3<T1, T2, T3> second(T2 value) {
        return new Second<>(value);
    }

    static <T1, T2, T3> OneOf3<T1, T2, T3> third(T3 value) {
        return new Third<>(value);
    }

    record First<A1, A2, A3>(A1 value) implements OneOf3<A1, A2, A3> {
    }

    record Second<A1, A2, A3>(A2 value) implements OneOf3<A1, A2, A3> {
    }

    record Third<A1, A2, A3>(A3 value) implements OneOf3<A1, A2, A3> {
    }

}
