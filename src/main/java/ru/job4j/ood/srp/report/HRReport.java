package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;
import ru.job4j.ood.srp.tools.SalaryCompator;
import java.util.List;
import java.util.function.Predicate;

public class HRReport implements Report {
    private final Store store;

    public HRReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> sortedEmployee = store.findBy(filter);
        sortedEmployee.sort(new SalaryCompator());
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : sortedEmployee) {
            text.append(employee.getName()).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
