package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Json {
    public static void main(String[] args) {
        JsonCar jsonCar = new JsonCar(false, 5, "Toyota",
                new Contact(5,"11-111"), new String[]{"Personal, Family"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(jsonCar));
        final String carJson =
                "{"
                        + "\"trailer\":false,"
                        + "\"seats\":2,"
                        + "\"model\":Bentley,"
                        + "\"contact\":"
                        + "{"
                        + "\"phone\":\"+7(924)-222-12-12\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Personal\",\"Free\"]"
                        + "}";
        final JsonCar jsonCar1 = gson.fromJson(carJson, JsonCar.class);
        System.out.println(jsonCar1);
    }
}
