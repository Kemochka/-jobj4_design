package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
                File file = source.toFile();
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(target))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(output.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void validParameters(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        String directory = argsName.get("d");
        String exclude = argsName.get("e");
        String output = argsName.get("o");
        File dir = new File(directory);
        if (!dir.exists()) {
            throw new IllegalArgumentException("Directory does not exist");
        }
        if (!exclude.startsWith(".")) {
            throw new IllegalArgumentException("Exclusion extension should start with a dot (e.g. .txt)");
        }
        if (!output.endsWith(".zip")) {
            throw new IllegalArgumentException("Output file should have .zip extension");
        }
    }

    public static void main(String[] args) {
        validParameters(args);
        String directory = ArgsName.of(args).get("d");
        String exclude = ArgsName.of(args).get("e");
        String output = ArgsName.of(args).get("o");
        SearchFiles search = new SearchFiles(p -> !p.toFile().getName().endsWith(exclude));
        try {
            Files.walkFileTree(Paths.get(directory), search);
            List<Path> paths = search.getPaths();
            Zip zip = new Zip();
            zip.packFiles(paths, new File(output));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Zip zip1 = new Zip();
        zip1.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
    }
}

