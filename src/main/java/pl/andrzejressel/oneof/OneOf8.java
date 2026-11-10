package pl.andrzejressel.oneof;

import java.util.function.Function;

sealed public interface OneOf8<T1, T2, T3, T4, T5, T6, T7, T8> permits OneOf8.First, OneOf8.Second, OneOf8.Third, OneOf8.Fourth, OneOf8.Fifth, OneOf8.Sixth, OneOf8.Seventh, OneOf8.Eighth {
    default <R> OneOf8<R, T2, T3, T4, T5, T6, T7, T8> mapFirst(Function<? super T1, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(mapper.apply(value));
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(value);
            case Sixth(var value) -> new Sixth<>(value);
            case Seventh(var value) -> new Seventh<>(value);
            case Eighth(var value) -> new Eighth<>(value);
        };
    }

    default <R> OneOf8<T1, R, T3, T4, T5, T6, T7, T8> mapSecond(Function<? super T2, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(mapper.apply(value));
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(value);
            case Sixth(var value) -> new Sixth<>(value);
            case Seventh(var value) -> new Seventh<>(value);
            case Eighth(var value) -> new Eighth<>(value);
        };
    }

    default <R> OneOf8<T1, T2, R, T4, T5, T6, T7, T8> mapThird(Function<? super T3, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(mapper.apply(value));
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(value);
            case Sixth(var value) -> new Sixth<>(value);
            case Seventh(var value) -> new Seventh<>(value);
            case Eighth(var value) -> new Eighth<>(value);
        };
    }

    default <R> OneOf8<T1, T2, T3, R, T5, T6, T7, T8> mapFourth(Function<? super T4, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(mapper.apply(value));
            case Fifth(var value) -> new Fifth<>(value);
            case Sixth(var value) -> new Sixth<>(value);
            case Seventh(var value) -> new Seventh<>(value);
            case Eighth(var value) -> new Eighth<>(value);
        };
    }

    default <R> OneOf8<T1, T2, T3, T4, R, T6, T7, T8> mapFifth(Function<? super T5, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(mapper.apply(value));
            case Sixth(var value) -> new Sixth<>(value);
            case Seventh(var value) -> new Seventh<>(value);
            case Eighth(var value) -> new Eighth<>(value);
        };
    }

    default <R> OneOf8<T1, T2, T3, T4, T5, R, T7, T8> mapSixth(Function<? super T6, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(value);
            case Sixth(var value) -> new Sixth<>(mapper.apply(value));
            case Seventh(var value) -> new Seventh<>(value);
            case Eighth(var value) -> new Eighth<>(value);
        };
    }

    default <R> OneOf8<T1, T2, T3, T4, T5, T6, R, T8> mapSeventh(Function<? super T7, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(value);
            case Sixth(var value) -> new Sixth<>(value);
            case Seventh(var value) -> new Seventh<>(mapper.apply(value));
            case Eighth(var value) -> new Eighth<>(value);
        };
    }

    default <R> OneOf8<T1, T2, T3, T4, T5, T6, T7, R> mapEighth(Function<? super T8, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(value);
            case Third(var value) -> new Third<>(value);
            case Fourth(var value) -> new Fourth<>(value);
            case Fifth(var value) -> new Fifth<>(value);
            case Sixth(var value) -> new Sixth<>(value);
            case Seventh(var value) -> new Seventh<>(value);
            case Eighth(var value) -> new Eighth<>(mapper.apply(value));
        };
    }

    default <T> T fold(Function<? super T1, ? extends T> firstMapper, Function<? super T2, ? extends T> secondMapper, Function<? super T3, ? extends T> thirdMapper, Function<? super T4, ? extends T> fourthMapper, Function<? super T5, ? extends T> fifthMapper, Function<? super T6, ? extends T> sixthMapper, Function<? super T7, ? extends T> seventhMapper, Function<? super T8, ? extends T> eighthMapper) {
        return switch (this) {
            case First(var value) -> firstMapper.apply(value);
            case Second(var value) -> secondMapper.apply(value);
            case Third(var value) -> thirdMapper.apply(value);
            case Fourth(var value) -> fourthMapper.apply(value);
            case Fifth(var value) -> fifthMapper.apply(value);
            case Sixth(var value) -> sixthMapper.apply(value);
            case Seventh(var value) -> seventhMapper.apply(value);
            case Eighth(var value) -> eighthMapper.apply(value);
        };
    }

    @SuppressWarnings("unchecked")
    static <T1, T2, T3, T4, T5, T6, T7, T8> OneOf8<T1, T2, T3, T4, T5, T6, T7, T8> fromIndex(int index, Object obj) {
        return switch (index) {
            case 0 -> new First<>((T1) obj);
            case 1 -> new Second<>((T2) obj);
            case 2 -> new Third<>((T3) obj);
            case 3 -> new Fourth<>((T4) obj);
            case 4 -> new Fifth<>((T5) obj);
            case 5 -> new Sixth<>((T6) obj);
            case 6 -> new Seventh<>((T7) obj);
            case 7 -> new Eighth<>((T8) obj);
            default -> throw new IllegalArgumentException("Invalid index: " + index);
        };
    }

    static <T1, T2, T3, T4, T5, T6, T7, T8> OneOf8<T1, T2, T3, T4, T5, T6, T7, T8> first(T1 value) {
        return new First<>(value);
    }

    static <T1, T2, T3, T4, T5, T6, T7, T8> OneOf8<T1, T2, T3, T4, T5, T6, T7, T8> second(T2 value) {
        return new Second<>(value);
    }

    static <T1, T2, T3, T4, T5, T6, T7, T8> OneOf8<T1, T2, T3, T4, T5, T6, T7, T8> third(T3 value) {
        return new Third<>(value);
    }

    static <T1, T2, T3, T4, T5, T6, T7, T8> OneOf8<T1, T2, T3, T4, T5, T6, T7, T8> fourth(T4 value) {
        return new Fourth<>(value);
    }

    static <T1, T2, T3, T4, T5, T6, T7, T8> OneOf8<T1, T2, T3, T4, T5, T6, T7, T8> fifth(T5 value) {
        return new Fifth<>(value);
    }

    static <T1, T2, T3, T4, T5, T6, T7, T8> OneOf8<T1, T2, T3, T4, T5, T6, T7, T8> sixth(T6 value) {
        return new Sixth<>(value);
    }

    static <T1, T2, T3, T4, T5, T6, T7, T8> OneOf8<T1, T2, T3, T4, T5, T6, T7, T8> seventh(T7 value) {
        return new Seventh<>(value);
    }

    static <T1, T2, T3, T4, T5, T6, T7, T8> OneOf8<T1, T2, T3, T4, T5, T6, T7, T8> eighth(T8 value) {
        return new Eighth<>(value);
    }

    record First<A1, A2, A3, A4, A5, A6, A7, A8>(A1 value) implements OneOf8<A1, A2, A3, A4, A5, A6, A7, A8> {
    }

    record Second<A1, A2, A3, A4, A5, A6, A7, A8>(A2 value) implements OneOf8<A1, A2, A3, A4, A5, A6, A7, A8> {
    }

    record Third<A1, A2, A3, A4, A5, A6, A7, A8>(A3 value) implements OneOf8<A1, A2, A3, A4, A5, A6, A7, A8> {
    }

    record Fourth<A1, A2, A3, A4, A5, A6, A7, A8>(A4 value) implements OneOf8<A1, A2, A3, A4, A5, A6, A7, A8> {
    }

    record Fifth<A1, A2, A3, A4, A5, A6, A7, A8>(A5 value) implements OneOf8<A1, A2, A3, A4, A5, A6, A7, A8> {
    }

    record Sixth<A1, A2, A3, A4, A5, A6, A7, A8>(A6 value) implements OneOf8<A1, A2, A3, A4, A5, A6, A7, A8> {
    }

    record Seventh<A1, A2, A3, A4, A5, A6, A7, A8>(A7 value) implements OneOf8<A1, A2, A3, A4, A5, A6, A7, A8> {
    }

    record Eighth<A1, A2, A3, A4, A5, A6, A7, A8>(A8 value) implements OneOf8<A1, A2, A3, A4, A5, A6, A7, A8> {
    }

}
