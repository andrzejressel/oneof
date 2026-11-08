package pl.andrzejressel.oneof;

import java.util.function.Function;

sealed public interface OneOf6<T1, T2, T3, T4, T5, T6> permits OneOf6.First, OneOf6.Second, OneOf6.Third, OneOf6.Fourth, OneOf6.Fifth, OneOf6.Sixth {
    default <R> OneOf6<R, T2, T3, T4, T5, T6> mapFirst(Function<? super T1, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(mapper.apply(value));
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(value);
            case Sixth(var value) -> new Sixth<>(value);
        };
    }

    default <R> OneOf6<T1, R, T3, T4, T5, T6> mapSecond(Function<? super T2, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(mapper.apply(value));
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(value);
            case Sixth(var value) -> new Sixth<>(value);
        };
    }

    default <R> OneOf6<T1, T2, R, T4, T5, T6> mapThird(Function<? super T3, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(mapper.apply(value));
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(value);
            case Sixth(var value) -> new Sixth<>(value);
        };
    }

    default <R> OneOf6<T1, T2, T3, R, T5, T6> mapFourth(Function<? super T4, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(mapper.apply(value));
            case Fifth(var value) -> new Fifth<>(value);
            case Sixth(var value) -> new Sixth<>(value);
        };
    }

    default <R> OneOf6<T1, T2, T3, T4, R, T6> mapFifth(Function<? super T5, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(mapper.apply(value));
            case Sixth(var value) -> new Sixth<>(value);
        };
    }

    default <R> OneOf6<T1, T2, T3, T4, T5, R> mapSixth(Function<? super T6, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(value);
            case Sixth(var value) -> new Sixth<>(mapper.apply(value));
        };
    }

    default <T> T fold(Function<? super T1, ? extends T> firstMapper, Function<? super T2, ? extends T> secondMapper, Function<? super T3, ? extends T> thirdMapper, Function<? super T4, ? extends T> fourthMapper, Function<? super T5, ? extends T> fifthMapper, Function<? super T6, ? extends T> sixthMapper) {
        return switch (this) {
            case First(var value) -> firstMapper.apply(value);
            case Second(var value) -> secondMapper.apply(value);
            case Third(var value) -> thirdMapper.apply(value);
            case Fourth(var value) -> fourthMapper.apply(value);
            case Fifth(var value) -> fifthMapper.apply(value);
            case Sixth(var value) -> sixthMapper.apply(value);
        };
    }

    static <T1, T2, T3, T4, T5, T6> OneOf6<T1, T2, T3, T4, T5, T6> first(T1 value) {
        return new First<>(value);
    }

    static <T1, T2, T3, T4, T5, T6> OneOf6<T1, T2, T3, T4, T5, T6> second(T2 value) {
        return new Second<>(value);
    }

    static <T1, T2, T3, T4, T5, T6> OneOf6<T1, T2, T3, T4, T5, T6> third(T3 value) {
        return new Third<>(value);
    }

    static <T1, T2, T3, T4, T5, T6> OneOf6<T1, T2, T3, T4, T5, T6> fourth(T4 value) {
        return new Fourth<>(value);
    }

    static <T1, T2, T3, T4, T5, T6> OneOf6<T1, T2, T3, T4, T5, T6> fifth(T5 value) {
        return new Fifth<>(value);
    }

    static <T1, T2, T3, T4, T5, T6> OneOf6<T1, T2, T3, T4, T5, T6> sixth(T6 value) {
        return new Sixth<>(value);
    }

    record First<A1, A2, A3, A4, A5, A6>(A1 value) implements OneOf6<A1, A2, A3, A4, A5, A6> {
    }

    record Second<A1, A2, A3, A4, A5, A6>(A2 value) implements OneOf6<A1, A2, A3, A4, A5, A6> {
    }

    record Third<A1, A2, A3, A4, A5, A6>(A3 value) implements OneOf6<A1, A2, A3, A4, A5, A6> {
    }

    record Fourth<A1, A2, A3, A4, A5, A6>(A4 value) implements OneOf6<A1, A2, A3, A4, A5, A6> {
    }

    record Fifth<A1, A2, A3, A4, A5, A6>(A5 value) implements OneOf6<A1, A2, A3, A4, A5, A6> {
    }

    record Sixth<A1, A2, A3, A4, A5, A6>(A6 value) implements OneOf6<A1, A2, A3, A4, A5, A6> {
    }

}
