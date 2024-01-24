package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkParse() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("is empty");
    }

    @Test
    void checkContainSymbol() {
        NameLoad nameLoad = new NameLoad();
        String map = "name:five";
        assertThatThrownBy(() -> nameLoad.parse(map))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(map)
                .hasMessageContaining("=")
                .hasMessageContaining("symbol");
    }

    @Test
    void checkContainKey() {
        NameLoad nameLoad = new NameLoad();
        String map = "=0";
        assertThatThrownBy(() -> nameLoad.parse(map))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("=")
                .hasMessageContaining("key");
    }

    @Test
    void checkContainValue() {
        NameLoad nameLoad = new NameLoad();
        String map = "name =";
        assertThatThrownBy(() -> nameLoad.parse(map))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(map)
                .hasMessageContaining("=")
                .hasMessageContaining("value");
    }
}