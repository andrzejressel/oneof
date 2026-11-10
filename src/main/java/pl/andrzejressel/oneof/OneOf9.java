package pl.andrzejressel.oneof;

import java.util.function.Function;

sealed public interface OneOf9<T1, T2, T3, T4, T5, T6, T7, T8, T9> permits OneOf9.First, OneOf9.Second, OneOf9.Third, OneOf9.Fourth, OneOf9.Fifth, OneOf9.Sixth, OneOf9.Seventh, OneOf9.Eighth, OneOf9.Ninth {
    default <R> OneOf9<R, T2, T3, T4, T5, T6, T7, T8, T9> mapFirst(Function<? super T1, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(mapper.apply(value));
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(value);
            case Sixth(var value) -> new Sixth<>(value);
            case Seventh(var value) -> new Seventh<>(value);
            case Eighth(var value) -> new Eighth<>(value);
            case Ninth(var value) -> new Ninth<>(value);
        };
    }

    default <R> OneOf9<T1, R, T3, T4, T5, T6, T7, T8, T9> mapSecond(Function<? super T2, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(mapper.apply(value));
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(value);
            case Sixth(var value) -> new Sixth<>(value);
            case Seventh(var value) -> new Seventh<>(value);
            case Eighth(var value) -> new Eighth<>(value);
            case Ninth(var value) -> new Ninth<>(value);
        };
    }

    default <R> OneOf9<T1, T2, R, T4, T5, T6, T7, T8, T9> mapThird(Function<? super T3, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(mapper.apply(value));
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(value);
            case Sixth(var value) -> new Sixth<>(value);
            case Seventh(var value) -> new Seventh<>(value);
            case Eighth(var value) -> new Eighth<>(value);
            case Ninth(var value) -> new Ninth<>(value);
        };
    }

    default <R> OneOf9<T1, T2, T3, R, T5, T6, T7, T8, T9> mapFourth(Function<? super T4, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(mapper.apply(value));
            case Fifth(var value) -> new Fifth<>(value);
            case Sixth(var value) -> new Sixth<>(value);
            case Seventh(var value) -> new Seventh<>(value);
            case Eighth(var value) -> new Eighth<>(value);
            case Ninth(var value) -> new Ninth<>(value);
        };
    }

    default <R> OneOf9<T1, T2, T3, T4, R, T6, T7, T8, T9> mapFifth(Function<? super T5, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(mapper.apply(value));
            case Sixth(var value) -> new Sixth<>(value);
            case Seventh(var value) -> new Seventh<>(value);
            case Eighth(var value) -> new Eighth<>(value);
            case Ninth(var value) -> new Ninth<>(value);
        };
    }

    default <R> OneOf9<T1, T2, T3, T4, T5, R, T7, T8, T9> mapSixth(Function<? super T6, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(value);
            case Sixth(var value) -> new Sixth<>(mapper.apply(value));
            case Seventh(var value) -> new Seventh<>(value);
            case Eighth(var value) -> new Eighth<>(value);
            case Ninth(var value) -> new Ninth<>(value);
        };
    }

    default <R> OneOf9<T1, T2, T3, T4, T5, T6, R, T8, T9> mapSeventh(Function<? super T7, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(value);
            case Sixth(var value) -> new Sixth<>(value);
            case Seventh(var value) -> new Seventh<>(mapper.apply(value));
            case Eighth(var value) -> new Eighth<>(value);
            case Ninth(var value) -> new Ninth<>(value);
        };
    }

    default <R> OneOf9<T1, T2, T3, T4, T5, T6, T7, R, T9> mapEighth(Function<? super T8, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(value);
            case Sixth(var value) -> new Sixth<>(value);
            case Seventh(var value) -> new Seventh<>(value);
            case Eighth(var value) -> new Eighth<>(mapper.apply(value));
            case Ninth(var value) -> new Ninth<>(value);
        };
    }

    default <R> OneOf9<T1, T2, T3, T4, T5, T6, T7, T8, R> mapNinth(Function<? super T9, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(value);
            case Sixth(var value) -> new Sixth<>(value);
            case Seventh(var value) -> new Seventh<>(value);
            case Eighth(var value) -> new Eighth<>(value);
            case Ninth(var value) -> new Ninth<>(mapper.apply(value));
        };
    }

    default <T> T fold(Function<? super T1, ? extends T> firstMapper, Function<? super T2, ? extends T> secondMapper, Function<? super T3, ? extends T> thirdMapper, Function<? super T4, ? extends T> fourthMapper, Function<? super T5, ? extends T> fifthMapper, Function<? super T6, ? extends T> sixthMapper, Function<? super T7, ? extends T> seventhMapper, Function<? super T8, ? extends T> eighthMapper, Function<? super T9, ? extends T> ninthMapper) {
        return switch (this) {
            case First(var value) -> firstMapper.apply(value);
            case Second(var value) -> secondMapper.apply(value);
            case Third(var value) -> thirdMapper.apply(value);
            case Fourth(var value) -> fourthMapper.apply(value);
            case Fifth(var value) -> fifthMapper.apply(value);
            case Sixth(var value) -> sixthMapper.apply(value);
            case Seventh(var value) -> seventhMapper.apply(value);
            case Eighth(var value) -> eighthMapper.apply(value);
            case Ninth(var value) -> ninthMapper.apply(value);
        };
    }

    @SuppressWarnings("unchecked")
    static <T1, T2, T3, T4, T5, T6, T7, T8, T9> OneOf9<T1, T2, T3, T4, T5, T6, T7, T8, T9> fromIndex(int index, Object obj) {
        return switch (index) {
            case 0 -> new First<>((T1) obj);
            case 1 -> new Second<>((T2) obj);
            case 2 -> new Third<>((T3) obj);
            case 3 -> new Fourth<>((T4) obj);
            case 4 -> new Fifth<>((T5) obj);
            case 5 -> new Sixth<>((T6) obj);
            case 6 -> new Seventh<>((T7) obj);
            case 7 -> new Eighth<>((T8) obj);
            case 8 -> new Ninth<>((T9) obj);
            default -> throw new IllegalArgumentException("Invalid index: " + index);
        };
    }

    static <T1, T2, T3, T4, T5, T6, T7, T8, T9> OneOf9<T1, T2, T3, T4, T5, T6, T7, T8, T9> first(T1 value) {
        return new First<>(value);
    }

    static <T1, T2, T3, T4, T5, T6, T7, T8, T9> OneOf9<T1, T2, T3, T4, T5, T6, T7, T8, T9> second(T2 value) {
        return new Second<>(value);
    }

    static <T1, T2, T3, T4, T5, T6, T7, T8, T9> OneOf9<T1, T2, T3, T4, T5, T6, T7, T8, T9> third(T3 value) {
        return new Third<>(value);
    }

    static <T1, T2, T3, T4, T5, T6, T7, T8, T9> OneOf9<T1, T2, T3, T4, T5, T6, T7, T8, T9> fourth(T4 value) {
        return new Fourth<>(value);
    }

    static <T1, T2, T3, T4, T5, T6, T7, T8, T9> OneOf9<T1, T2, T3, T4, T5, T6, T7, T8, T9> fifth(T5 value) {
        return new Fifth<>(value);
    }

    static <T1, T2, T3, T4, T5, T6, T7, T8, T9> OneOf9<T1, T2, T3, T4, T5, T6, T7, T8, T9> sixth(T6 value) {
        return new Sixth<>(value);
    }

    static <T1, T2, T3, T4, T5, T6, T7, T8, T9> OneOf9<T1, T2, T3, T4, T5, T6, T7, T8, T9> seventh(T7 value) {
        return new Seventh<>(value);
    }

    static <T1, T2, T3, T4, T5, T6, T7, T8, T9> OneOf9<T1, T2, T3, T4, T5, T6, T7, T8, T9> eighth(T8 value) {
        return new Eighth<>(value);
    }

    static <T1, T2, T3, T4, T5, T6, T7, T8, T9> OneOf9<T1, T2, T3, T4, T5, T6, T7, T8, T9> ninth(T9 value) {
        return new Ninth<>(value);
    }

    record First<A1, A2, A3, A4, A5, A6, A7, A8, A9>(A1 value) implements OneOf9<A1, A2, A3, A4, A5, A6, A7, A8, A9> {
    }

    record Second<A1, A2, A3, A4, A5, A6, A7, A8, A9>(A2 value) implements OneOf9<A1, A2, A3, A4, A5, A6, A7, A8, A9> {
    }

    record Third<A1, A2, A3, A4, A5, A6, A7, A8, A9>(A3 value) implements OneOf9<A1, A2, A3, A4, A5, A6, A7, A8, A9> {
    }

    record Fourth<A1, A2, A3, A4, A5, A6, A7, A8, A9>(A4 value) implements OneOf9<A1, A2, A3, A4, A5, A6, A7, A8, A9> {
    }

    record Fifth<A1, A2, A3, A4, A5, A6, A7, A8, A9>(A5 value) implements OneOf9<A1, A2, A3, A4, A5, A6, A7, A8, A9> {
    }

    record Sixth<A1, A2, A3, A4, A5, A6, A7, A8, A9>(A6 value) implements OneOf9<A1, A2, A3, A4, A5, A6, A7, A8, A9> {
    }

    record Seventh<A1, A2, A3, A4, A5, A6, A7, A8, A9>(A7 value) implements OneOf9<A1, A2, A3, A4, A5, A6, A7, A8, A9> {
    }

    record Eighth<A1, A2, A3, A4, A5, A6, A7, A8, A9>(A8 value) implements OneOf9<A1, A2, A3, A4, A5, A6, A7, A8, A9> {
    }

    record Ninth<A1, A2, A3, A4, A5, A6, A7, A8, A9>(A9 value) implements OneOf9<A1, A2, A3, A4, A5, A6, A7, A8, A9> {
    }

}
