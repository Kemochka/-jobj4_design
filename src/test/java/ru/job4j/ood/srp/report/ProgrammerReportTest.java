package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ProgrammerReportTest {
    @Test
    public void whenProgrammerReportCSVFormat() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report report = new ProgrammerReport(store, parser);
        String expected = "Name; Hired; Fired; Salary;"
                + "\n" + "Ivan " + parser.parse(now) + " "
                + parser.parse(now) + " " + "100.0\n";
        assertThat(report.generate(employee -> true)).isEqualTo(expected);
    }

}