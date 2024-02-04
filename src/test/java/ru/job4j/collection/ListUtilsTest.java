package ru.job4j.collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class ListUtilsTest {
    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenRemoveIf() {
        ListUtils.addAfter(input, 0, 2);
        ListUtils.removeIf(input, num -> num % 2 == 0);
        assertThat(input).containsAnyOf(1, 3);
    }

    @Test
    void whenReplaceIf() {
        ListUtils.addAfter(input, 0, 2);
        ListUtils.replaceIf(input, num -> num % 2 == 0, 0);
        assertThat(input).containsSequence(1, 0, 3);
    }

    @Test
    void whenRemoveAll() {
        ListUtils.removeAll(input, input);
        assertThat(input).contains();
    }
}