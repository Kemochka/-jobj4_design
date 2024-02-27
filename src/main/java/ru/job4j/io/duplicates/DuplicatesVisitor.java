package ru.job4j.io.duplicates;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, List<Path>> files = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        FileProperty fileProperty = new FileProperty(attrs.size(), file.toFile().getName());
        files.putIfAbsent(fileProperty, new ArrayList<>());
        files.get(fileProperty).add(file.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getDuplicates() {
        List<Path> dup = new ArrayList<>();
        files.values().stream()
                .filter(paths -> paths.size() > 1)
                .forEach(dup::addAll);
        return dup;
    }
}
