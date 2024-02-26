package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor duplicatesVisitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("./", "data"), duplicatesVisitor);
        List<Path> duplicates = duplicatesVisitor.getDuplicates();
        for (Path duplicate : duplicates) {
            System.out.println("Duplicate found at: " + duplicate.toAbsolutePath());
        }
    }
}
