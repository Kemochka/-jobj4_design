package ru.job4j.io;

import java.io.*;

public class Analysis {
    public static void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new FileWriter(target))) {
            String line;
            String start = null;
            String end;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                if ((line.contains("400") || line.contains("500")) && start == null) {
                    start = words[1];
                }
                if ((line.contains("200") || line.contains("300")) && start != null) {
                    end = words[1];
                    writer.printf("%s%s%s%s", start, ";",  end, ";");
                    start = null;
                    writer.print(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
