package pl.andrzejressel.oneof;

import java.util.function.Function;

sealed public interface OneOf2<T1, T2> permits OneOf2.First, OneOf2.Second {
    default <R> OneOf2<R, T2> mapFirst(Function<? super T1, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(mapper.apply(value));
            case Second(var value) -> new Second<>(value);
        };
    }

    default <R> OneOf2<T1, R> mapSecond(Function<? super T2, ? extends R> mapper) {
        return switch (this) {
            case First(var value) -> new First<>(value);
            case Second(var value) -> new Second<>(mapper.apply(value));
        };
    }

    default <T> T fold(Function<? super T1, ? extends T> firstMapper, Function<? super T2, ? extends T> secondMapper) {
        return switch (this) {
            case First(var value) -> firstMapper.apply(value);
            case Second(var value) -> secondMapper.apply(value);
        };
    }

    @SuppressWarnings("unchecked")
    static <T1, T2> OneOf2<T1, T2> fromIndex(int index, Object obj) {
        return switch (index) {
            case 0 -> new First<>((T1) obj);
            case 1 -> new Second<>((T2) obj);
            default -> throw new IllegalArgumentException("Invalid index: " + index);
        };
    }

    static <T1, T2> OneOf2<T1, T2> first(T1 value) {
        return new First<>(value);
    }

    static <T1, T2> OneOf2<T1, T2> second(T2 value) {
        return new Second<>(value);
    }

    record First<A1, A2>(A1 value) implements OneOf2<A1, A2> {
    }

    record Second<A1, A2>(A2 value) implements OneOf2<A1, A2> {
    }

}
