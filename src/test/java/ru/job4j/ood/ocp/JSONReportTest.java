package ru.job4j.ood.ocp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class JSONReportTest {
    @Test
    void whenJSONReport() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").create();
        JSONReport engine = new JSONReport(store, gson);
        String expected = String.format("[{\"name\":\"Ivan\","
                + "\"hired\":{\"year\":%d,\"month\":%d,\"dayOfMonth\":%d,\"hourOfDay\":%d,\"minute\":%d,\"second\":%d},"
                + "\"fired\":{\"year\":%d,\"month\":%d,\"dayOfMonth\":%d,\"hourOfDay\":%d,\"minute\":%d,\"second\":%d},"
                + "\"salary\":100.0}]",
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH),
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                now.get(Calendar.SECOND),
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH),
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                now.get(Calendar.SECOND));
        assertThat(engine.generate(employee -> true)).isEqualTo(expected);
    }
}