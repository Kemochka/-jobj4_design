package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled
class StringGeneratorTest {
    @Test
    public void whenGenerateIsTrue() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name" ,"Ivan");
        args.put("subject", "you");
        StringGenerator generator = new StringGenerator();
        String result = generator.produce(template, args);
        assertThat(result).isEqualTo("I am Ivan, Who are you");
    }

    @Test
    public void whenKeyNotFound() {
        String template = "I am a ${nam}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Ivan");
        args.put("subject", "you");
        StringGenerator stringGenerator = new StringGenerator();
        assertThatThrownBy(() -> stringGenerator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenThereIsAnExtraKey() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Ivan");
        args.put("subject", "you");
        args.put("subj", "they");
        StringGenerator stringGenerator = new StringGenerator();
        assertThatThrownBy(() -> stringGenerator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenArgsNotFound() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        StringGenerator stringGenerator = new StringGenerator();
        assertThatThrownBy(() -> stringGenerator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenValueIsNull() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Ivan");
        args.put("subject", null);
        StringGenerator stringGenerator = new StringGenerator();
        assertThatThrownBy(() -> stringGenerator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }
}