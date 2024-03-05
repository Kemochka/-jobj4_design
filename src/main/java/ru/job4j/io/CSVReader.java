package ru.job4j.io;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CSVReader {
    public static void handle(ArgsName argsName) {
        String output = argsName.get("out");
        try (Scanner scanner = new Scanner(new FileInputStream(argsName.get("path")));
             PrintStream out = "stout".equals(output) ? new PrintStream(System.out)
                     : new PrintStream(new FileOutputStream(output))) {
            scanner.useDelimiter(System.lineSeparator());
            List<String> filters = new ArrayList<>(Arrays.asList(argsName.get("filter").split(",")));
            List<String> columns = new ArrayList<>(Arrays.asList(scanner.next().split(argsName.get("delimiter"))));
            List<Integer> indexes = filters.stream()
                    .mapToInt(columns::indexOf)
                    .filter(index -> index != -1)
                    .boxed()
                    .toList();
            String filteredColumns = filterLine(columns, indexes, argsName.get("delimiter"));
            out.println(filteredColumns);
            while (scanner.hasNext()) {
                List<String> line = Arrays.asList(scanner.next().split(argsName.get("delimiter")));
                String filteredLine = filterLine(line, indexes, argsName.get("delimiter"));
                out.println(filteredLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String filterLine(List<String> line, List<Integer> indexes, String delimiter) {
        return indexes.stream()
                .map(line::get)
                .collect(Collectors.joining(delimiter));
    }

    private static boolean checkArgs(ArgsName argsName) {
        if (!Paths.get(argsName.get("path")).toFile().exists()) {
            throw new IllegalArgumentException("The file does not exist");
        }
        if (argsName.get("out").isEmpty()) {
            throw new IllegalArgumentException("Out does not exist");
        }
        if (argsName.get("filter").isBlank()) {
            throw new IllegalArgumentException("Filter does not exist");
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            throw new IllegalArgumentException();
        }
        if (checkArgs(ArgsName.of(args))) {
            handle(ArgsName.of(args));
        }
    }
}
