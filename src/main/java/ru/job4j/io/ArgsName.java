package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("This key: '" + key + "' is missing");
        }
        return values.get(key);
    }

    private void parse(String[] args) throws IllegalArgumentException {
        for (String arg : args) {
            Pattern pattern = Pattern.compile("-([\\w?]+)=(.*)");
            Matcher matcher = getMatcher(arg, pattern);
            String key = matcher.group(1);
            String value = matcher.group(2);
                if (value.isEmpty()) {
                throw new IllegalArgumentException("Error: This argument '" + arg + "' does not contain a value");
            }
            values.put(key, value);
        }
    }

    private static Matcher getMatcher(String arg, Pattern pattern) {
        Matcher matcher = pattern.matcher(arg);
        if (!arg.contains("=")) {
            throw new IllegalArgumentException("Error: This argument '" + arg + "' does not contain an equal sign");
        }
        if (!arg.startsWith("-")) {
            throw new IllegalArgumentException("Error: This argument '" + arg + "' does not start with a '-' character");
        }
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Error: This argument '" + arg + "' does not contain a key");
        }
        return matcher;
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
