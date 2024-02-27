package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        validArgs(args);
        Path start = Paths.get(args[0]);
        String extension = args[1];
        search(start, path -> path.toFile().getName().endsWith(extension)).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void validArgs(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Root folder is null. Usage  ROOT_FOLDER.");
        }
        if (!Files.exists(Paths.get(args[0]))) {
            throw new IllegalArgumentException("Incorrect parameters");
        }
        if (!args[1].startsWith(".")) {
            throw new IllegalArgumentException("Incorrect parameters");
        }
    }
}
