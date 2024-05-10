package ru.job4j.ood.ocp;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import javax.xml.bind.JAXBException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.*;

class XMLReportTest {
    @Test
    public void whenXMLReport() throws JAXBException {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Date stringDate = now.getTime();
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(stringDate);
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        XMLReport report = new XMLReport(store);
        String expected = String.format("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "<employees>"
                + "<employeeList name=\"Ivan\" "
                + "hired=\"%s\" "
                + "fired=\"%s\" "
                + "salary=\"100.0\"/>"
                + "</employees>", formattedDate, formattedDate);
        assertThat(report.generate(employee -> true)).isEqualTo(expected);
    }
}