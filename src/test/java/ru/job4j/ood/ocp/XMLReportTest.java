package ru.job4j.ood.ocp;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.report.Report;
import ru.job4j.ood.srp.store.MemoryStore;

import javax.xml.bind.JAXBException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.*;

class XMLReportTest {
    @Test
    void whenGenerated() throws JAXBException {
        MemoryStore store = new MemoryStore();
        Employee employee = new Employee("John Doe",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                5000.0);
        Employee employee1 = new Employee("Jane Smith",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                6000.0);
        store.add(employee);
        store.add(employee1);
        Report report = new XMLReport(store);
        String expect = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <employees>
                    <employee>
                        <name>John Doe</name>
                        <hired>08:06:2023 17:41</hired>
                        <fired>08:06:2023 17:41</fired>
                        <salary>5000.0</salary>
                    </employee>
                    <employee>
                        <name>Jane Smith</name>
                        <hired>08:06:2023 17:41</hired>
                        <fired>08:06:2023 17:41</fired>
                        <salary>6000.0</salary>
                    </employee>
                </employees>
                """;
        assertThat(report.generate(em -> true)).isEqualTo(expect);
    }

    @Test
    void whenGeneratedXML() throws JAXBException {
        MemoryStore store = new MemoryStore();
        Calendar calendar = Calendar.getInstance();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        String formatDate = parser.parse(calendar);
        Employee employee = new Employee("John Doe", calendar, calendar, 5000.0);
        Employee employee1 = new Employee("Jane Smith", calendar, calendar, 6000.0);
        store.add(employee);
        store.add(employee1);
        Report report = new XMLReport(store);
        String expect = String.format("""
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <employees>
                    <employee>
                        <name>John Doe</name>
                        <hired>%s</hired>
                        <fired>%s</fired>
                        <salary>5000.0</salary>
                    </employee>
                    <employee>
                        <name>Jane Smith</name>
                        <hired>%s</hired>
                        <fired>%s</fired>
                        <salary>6000.0</salary>
                    </employee>
                </employees>
                """, formatDate, formatDate, formatDate, formatDate);
        assertThat(report.generate(em -> true)).isEqualTo(expect);
    }
}