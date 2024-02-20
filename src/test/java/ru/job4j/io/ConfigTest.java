package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ConfigTest {
    @Test
    void whenPairWithoutComment() {
        String path = "./data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.dialect")).isEqualTo("org.hibernate.dialect.PostgreSQLDialect");
    }

    @Test
    void whenFileWithPatternViolation() {
        String path = "./data/test.properties";
        Config config = new Config(path);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, config::load);
        assertThat(exception.getMessage()).isEqualTo("File contains lines that do not match the key=value pattern");
    }


    @Test
    void whenFileWithSpecialCharactersInValue() {
        String path = "./data/test1.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("key1")).isEqualTo("value1=1");
        assertThat(config.value("key2")).isEqualTo("value=");
    }

    @Test
    void whenFileWithSpecialCharInValue() {
        String path = "./data/test2.properties";
        Config config = new Config(path);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, config::load);
        assertThat(exception.getMessage()).isEqualTo("File contains lines that do not match the key=value pattern");
    }

    @Test
    void whenFileWithoutSpecialCharInPair() {
        String path = "./data/test3.properties";
        Config config = new Config(path);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, config::load);
        assertThat(exception.getMessage()).isEqualTo("File contains lines that do not match the key=value pattern");
    }
}