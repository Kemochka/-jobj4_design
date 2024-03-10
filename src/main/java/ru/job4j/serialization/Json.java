package ru.job4j.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Json {
    public static void main(String[] args) throws JAXBException {
        JsonCar jsonCar = new JsonCar(false, 5, "Toyota",
                new Contact("11-111"), new String[]{"Personal, Family"});
        JAXBContext context = JAXBContext.newInstance(JsonCar.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(jsonCar, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            JsonCar result = (JsonCar) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
