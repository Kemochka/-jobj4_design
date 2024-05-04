package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.tools.SalaryCompator;

import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class HRReportTest {

    @Test
    void whenHRGenerated() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee ivan = new Employee("Ivan", now, now, 100);
        Employee vlad = new Employee("Vlad", now, now, 200);
        Employee vasya = new Employee("Vasya", now, now, 300);
        store.add(ivan);
        store.add(vlad);
        store.add(vasya);
        List<Employee> workers = store.findBy(employee -> true);
        workers.sort(new SalaryCompator());
        Report report = new HRReport(store);
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee worker : workers) {
            expected.append(worker.getName()).append(" ")
                    .append(worker.getSalary())
                    .append(System.lineSeparator());
        }
        assertThat(report.generate(employee -> true)).isEqualTo(expected.toString());
    }
}