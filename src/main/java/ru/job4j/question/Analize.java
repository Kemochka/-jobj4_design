package ru.job4j.question;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        Info result = new Info(0, 0, 0);
        Map<Integer, String> mapCurrent = current.stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        for (User user : previous) {
            int key = user.getId();
            String value = user.getName();
            if (!mapCurrent.containsKey(key)) {
                result.setDeleted(result.getDeleted() + 1);
            }
            if (mapCurrent.containsKey(key) && Objects.equals(mapCurrent.get(key), value)) {
                mapCurrent.remove(key);
            }
            if (mapCurrent.containsKey(key) && !Objects.equals(mapCurrent.get(key), value)) {
                mapCurrent.remove(key);
                result.setChanged(result.getChanged() + 1);
            }
        }
        result.setAdded(mapCurrent.size());
        return result;
    }
}
