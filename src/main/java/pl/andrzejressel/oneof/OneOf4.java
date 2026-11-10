package pl.andrzejressel.oneof;

import java.util.function.Function;

sealed public interface OneOf4<T1, T2, T3, T4> permits OneOf4.First, OneOf4.Second, OneOf4.Third, OneOf4.Fourth {
    default <R> OneOf4<R, T2, T3, T4> mapFirst(Function<? super T1, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(mapper.apply(value));
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(value);
        };
    }

    default <R> OneOf4<T1, R, T3, T4> mapSecond(Function<? super T2, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(mapper.apply(value));
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(value);
        };
    }

    default <R> OneOf4<T1, T2, R, T4> mapThird(Function<? super T3, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(mapper.apply(value));
            case Fourth(var value) -> new Fourth<>(value);
        };
    }

    default <R> OneOf4<T1, T2, T3, R> mapFourth(Function<? super T4, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(mapper.apply(value));
        };
    }

    default <T> T fold(Function<? super T1, ? extends T> firstMapper, Function<? super T2, ? extends T> secondMapper, Function<? super T3, ? extends T> thirdMapper, Function<? super T4, ? extends T> fourthMapper) {
        return switch (this) {
            case First(var value) -> firstMapper.apply(value);
            case Second(var value) -> secondMapper.apply(value);
            case Third(var value) -> thirdMapper.apply(value);
            case Fourth(var value) -> fourthMapper.apply(value);
        };
    }

    @SuppressWarnings("unchecked")
    static <T1, T2, T3, T4> OneOf4<T1, T2, T3, T4> fromIndex(int index, Object obj) {
        return switch (index) {
            case 0 -> new First<>((T1) obj);
            case 1 -> new Second<>((T2) obj);
            case 2 -> new Third<>((T3) obj);
            case 3 -> new Fourth<>((T4) obj);
            default -> throw new IllegalArgumentException("Invalid index: " + index);
        };
    }

    static <T1, T2, T3, T4> OneOf4<T1, T2, T3, T4> first(T1 value) {
        return new First<>(value);
    }

    static <T1, T2, T3, T4> OneOf4<T1, T2, T3, T4> second(T2 value) {
        return new Second<>(value);
    }

    static <T1, T2, T3, T4> OneOf4<T1, T2, T3, T4> third(T3 value) {
        return new Third<>(value);
    }

    static <T1, T2, T3, T4> OneOf4<T1, T2, T3, T4> fourth(T4 value) {
        return new Fourth<>(value);
    }

    record First<A1, A2, A3, A4>(A1 value) implements OneOf4<A1, A2, A3, A4> {
    }

    record Second<A1, A2, A3, A4>(A2 value) implements OneOf4<A1, A2, A3, A4> {
    }

    record Third<A1, A2, A3, A4>(A3 value) implements OneOf4<A1, A2, A3, A4> {
    }

    record Fourth<A1, A2, A3, A4>(A4 value) implements OneOf4<A1, A2, A3, A4> {
    }

}
