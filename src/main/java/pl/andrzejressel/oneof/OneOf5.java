package pl.andrzejressel.oneof;

import java.util.function.Function;

sealed public interface OneOf5<T1, T2, T3, T4, T5> permits OneOf5.First, OneOf5.Second, OneOf5.Third, OneOf5.Fourth, OneOf5.Fifth {
    default <R> OneOf5<R, T2, T3, T4, T5> mapFirst(Function<? super T1, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(mapper.apply(value));
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(value);
        };
    }

    default <R> OneOf5<T1, R, T3, T4, T5> mapSecond(Function<? super T2, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(mapper.apply(value));
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(value);
        };
    }

    default <R> OneOf5<T1, T2, R, T4, T5> mapThird(Function<? super T3, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(mapper.apply(value));
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(value);
        };
    }

    default <R> OneOf5<T1, T2, T3, R, T5> mapFourth(Function<? super T4, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(mapper.apply(value));
            case Fifth(var value) -> new Fifth<>(value);
        };
    }

    default <R> OneOf5<T1, T2, T3, T4, R> mapFifth(Function<? super T5, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(mapper.apply(value));
        };
    }

    default <T> T fold(Function<? super T1, ? extends T> firstMapper, Function<? super T2, ? extends T> secondMapper, Function<? super T3, ? extends T> thirdMapper, Function<? super T4, ? extends T> fourthMapper, Function<? super T5, ? extends T> fifthMapper) {
        return switch (this) {
            case First(var value) -> firstMapper.apply(value);
            case Second(var value) -> secondMapper.apply(value);
            case Third(var value) -> thirdMapper.apply(value);
            case Fourth(var value) -> fourthMapper.apply(value);
            case Fifth(var value) -> fifthMapper.apply(value);
        };
    }

    @SuppressWarnings("unchecked")
    static <T1, T2, T3, T4, T5> OneOf5<T1, T2, T3, T4, T5> fromIndex(int index, Object obj) {
        return switch (index) {
            case 0 -> new First<>((T1) obj);
            case 1 -> new Second<>((T2) obj);
            case 2 -> new Third<>((T3) obj);
            case 3 -> new Fourth<>((T4) obj);
            case 4 -> new Fifth<>((T5) obj);
            default -> throw new IllegalArgumentException("Invalid index: " + index);
        };
    }

    static <T1, T2, T3, T4, T5> OneOf5<T1, T2, T3, T4, T5> first(T1 value) {
        return new First<>(value);
    }

    static <T1, T2, T3, T4, T5> OneOf5<T1, T2, T3, T4, T5> second(T2 value) {
        return new Second<>(value);
    }

    static <T1, T2, T3, T4, T5> OneOf5<T1, T2, T3, T4, T5> third(T3 value) {
        return new Third<>(value);
    }

    static <T1, T2, T3, T4, T5> OneOf5<T1, T2, T3, T4, T5> fourth(T4 value) {
        return new Fourth<>(value);
    }

    static <T1, T2, T3, T4, T5> OneOf5<T1, T2, T3, T4, T5> fifth(T5 value) {
        return new Fifth<>(value);
    }

    record First<A1, A2, A3, A4, A5>(A1 value) implements OneOf5<A1, A2, A3, A4, A5> {
    }

    record Second<A1, A2, A3, A4, A5>(A2 value) implements OneOf5<A1, A2, A3, A4, A5> {
    }

    record Third<A1, A2, A3, A4, A5>(A3 value) implements OneOf5<A1, A2, A3, A4, A5> {
    }

    record Fourth<A1, A2, A3, A4, A5>(A4 value) implements OneOf5<A1, A2, A3, A4, A5> {
    }

    record Fifth<A1, A2, A3, A4, A5>(A5 value) implements OneOf5<A1, A2, A3, A4, A5> {
    }

}
