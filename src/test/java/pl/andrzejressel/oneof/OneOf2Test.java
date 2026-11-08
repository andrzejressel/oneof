package pl.andrzejressel.oneof;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OneOf2Test {

    @Test
    void shouldMatchCaseOnOneOf() {
        var oneOf = first();

        switch (oneOf) {
            case OneOf2.First(var value) -> assertEquals("first", value);
            case OneOf2.Second(var ignored) -> throw new IllegalStateException("Should not be second");
        }
    }

    private OneOf2<String, Integer> first() {
        return OneOf2.first("first");
    }

}
