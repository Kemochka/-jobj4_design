package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, Path> files = new HashMap<>();
    private List<FileProperty> dup = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(attrs.size(), file.toFile().getName());
        if (!files.containsKey(fileProperty)) {
            files.put(fileProperty, file);
        } else {
            dup.add(fileProperty);
        }
        return super.visitFile(file, attrs);
    }

    public List<Path> getDuplicates() {
        return dup.stream()
                .map(fileProperty -> files.get(fileProperty))
                .collect(Collectors.toList());
    }
}
