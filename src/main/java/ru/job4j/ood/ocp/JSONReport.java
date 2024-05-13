package ru.job4j.ood.ocp;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.report.Report;
import ru.job4j.ood.srp.store.Store;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class JSONReport implements Report {
    private final Store store;
    public JSONReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("[\n");
        List<Employee> employees = store.findBy(filter);
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (i > 0) {
                text.append(",\n");
            }
            text.append("  {\n");
            text.append("    \"name\": \"").append(employee.getName()).append("\",\n");
            text.append("    \"hired\": \"").append(formatCalendar(employee.getHired())).append("\",\n");
            text.append("    \"fired\": \"").append(formatCalendar(employee.getFired())).append("\",\n");
            text.append("    \"salary\": ").append(employee.getSalary()).append("\n  }");
        }
        text.append("\n]");
        return text.toString();

    }

    private String formatCalendar(Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy HH:mm");
        return sdf.format(calendar.getTime());
    }
}
