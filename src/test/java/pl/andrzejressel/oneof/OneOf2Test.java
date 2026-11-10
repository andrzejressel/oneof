package pl.andrzejressel.oneof;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OneOf2Test {

    @Test
    void shouldMatchCaseOnOneOf() {
        var oneOf = first();

        switch (oneOf) {
            case OneOf2.First(var value) -> assertEquals("first", value);
            case OneOf2.Second(var ignored) -> throw new IllegalStateException("Should not be second");
        }
    }

    @Test
    void shouldCreateVariantFromIndex() {
        OneOf2<String, Integer> first = OneOf2.fromIndex(0, "first");
        OneOf2<String, Integer> second = OneOf2.fromIndex(1, 42);

        assertEquals(OneOf2.first("first"), first);
        assertEquals(OneOf2.second(42), second);
    }

    @Test
    void shouldRejectInvalidIndex() {
        assertThrows(IllegalArgumentException.class, () -> OneOf2.fromIndex(2, "value"));
    }

    private OneOf2<String, Integer> first() {
        return OneOf2.first("first");
    }

}
