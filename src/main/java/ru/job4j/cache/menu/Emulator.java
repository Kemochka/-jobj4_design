package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;
import java.util.Scanner;

public class Emulator {
    public static int SET_FILE = 1;
    public static int LOAD_FILE = 2;
    public static int GET_FILE = 3;
    public static final String SELECT = "Выберите меню";
    public static final String CACHE_DIR = "Введите кэшируемую директорию";
    public static final String LOAD = "Загрузить содержимое файла ... в кэш";
    public static final String GET = "Получить содержимое файла ... из кэша";
    public static final String MENU = """
            Введите 1, чтобы указать файл для кэширования.
            Введите 2, чтобы загрузить содержимое файла в кэш.
            Введите 3, чтобы получить содержимое файла из кэша.\s
            Введите любое другое число для выхода.
            """;

    public static void main(String[] args) {
        boolean run = true;
        String fileName = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите директорию:");
        String directory = scanner.nextLine();
        DirFileCache dirFileCache = new DirFileCache(directory);
        while (run) {
            System.out.println(MENU);
            System.out.println(SELECT);
            int userChoice = Integer.parseInt(scanner.nextLine());
            if (SET_FILE == userChoice) {
                System.out.println(CACHE_DIR);
                fileName = scanner.nextLine();
                dirFileCache.get(fileName);
            } else if (LOAD_FILE == userChoice) {
                System.out.println(LOAD);
                if (!"".equals(fileName)) {
                    dirFileCache.get(fileName);
                }
            } else if (GET_FILE == userChoice) {
                System.out.println(GET);
                String rsl = dirFileCache.get(fileName);
                System.out.println(rsl);
            } else {
                run = false;
            }
        }
    }
}
