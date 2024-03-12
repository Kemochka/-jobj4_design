package ru.job4j.serialization;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class Json {
    public static void main(String[] args) {
        JSONObject jsonContact = new JSONObject("{\"phone\":\"+7(924)111-111-11-11\"}");
        List<String> list = new ArrayList<>();
        list.add("Worker");
        list.add("Family");
        JSONArray jsonStatuses = new JSONArray(list);
        final JsonCar jsonCar = new JsonCar(false, 5, "Toyota",
                new Contact(5, "+7-909-570-34-56"), new String[]{"Personal", "Worker"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("model", jsonCar.getModel());
        jsonObject.put("seats", jsonCar.getSeats());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("statuses", jsonStatuses);
        System.out.println(jsonObject);
        System.out.println(new JSONObject(jsonCar));
    }
}
