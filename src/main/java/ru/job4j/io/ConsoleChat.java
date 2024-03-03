package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    private List<String> botPhrases;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        List<String> chatLog = new ArrayList<>();
        botPhrases = readPhrases();
        boolean shouldAnswer = true;
        boolean chatting = true;
        String input;
        System.out.println("Давайте поговорим?");
            while (chatting) {
                input = scanner.nextLine();
                chatLog.add(input);
                if (OUT.equalsIgnoreCase(input)) {
                    chatting = false;
                    shouldAnswer = false;
                } else if (CONTINUE.equalsIgnoreCase(input)) {
                    shouldAnswer = true;
                } else if (STOP.equalsIgnoreCase(input)) {
                    System.out.println("Напишите 'продолжить', чтобы продолжить диалог");
                    shouldAnswer = false;
                }
                String answer;
                if (shouldAnswer) {
                    answer = getRandomAnswer();
                    chatLog.add(answer);
                    System.out.println(answer);
                }
            }
        saveLog(chatLog);
    }

    private List<String> readPhrases() {
        List<String> phrases = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            String line;
            while ((line = reader.readLine()) != null) {
                phrases.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            for (String entry : log) {
                writer.println(entry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getRandomAnswer() {
        Random random = new Random();
        int index = random.nextInt(botPhrases.size());
        return botPhrases.get(index);
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("data/chatLog.txt", "data/botAnswers.txt");
        consoleChat.run();
    }
}
