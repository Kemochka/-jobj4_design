package ru.job4j.ood.ocp;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.report.Report;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;
import java.util.List;
import java.util.function.Predicate;

public class XMLReport implements Report {
    private final Store store;
    private final Marshaller marshaller;

    public XMLReport(Store store) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Employees.class);
        this.marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringWriter writer = new StringWriter();
        try {
            marshaller.marshal(new Employees(store.findBy(employee -> true)), writer);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return writer.getBuffer().toString();
    }

    @XmlRootElement(name = "employees")
    public static class Employees {
        private List<Employee> employees;
        public Employees() {
        }

        public Employees(List<Employee> employee) {
            this.employees = employee;
        }

        public List<Employee> getEmployee() {
            return employees;
        }

        public void setEmployee(List<Employee> employee) {
            this.employees = employee;
        }
    }
}
