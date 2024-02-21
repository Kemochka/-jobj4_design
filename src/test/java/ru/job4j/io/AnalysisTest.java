package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.*;
import java.nio.file.Path;
import static org.assertj.core.api.Assertions.*;

class AnalysisTest {
    @Test
    void unavailableTest(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("server.txt").toFile();
        String ln = System.lineSeparator();
        try (PrintWriter writer = new PrintWriter(source)) {
            writer.println("200 10:56:01"
                    + ln
                    + "500 10:57:01"
                    + ln
                    + "400 10:58:01"
                    + ln
                    + "300 10:59:01");
        }
        File target  = tempDir.resolve("target.txt").toFile();
        Analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder result = new StringBuilder();
        try (BufferedReader input = new BufferedReader(new FileReader(target))) {
            input.lines().forEach(result::append);
        }
        assertThat("10:57:01;10:59:01;").hasToString(result.toString());
    }
}