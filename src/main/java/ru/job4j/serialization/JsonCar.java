package ru.job4j.serialization;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "car")
public class JsonCar {
    @XmlElement
    private boolean trailer;
    @XmlAttribute
    private int seats;
    @XmlAttribute
    private String model;
    @XmlElement
    private Contact contact;
    @XmlElement
    private String[] statuses;

    public JsonCar() {

    }

    public JsonCar(boolean trailer, int seats, String model, Contact contact, String[] statuses) {
        this.trailer = trailer;
        this.seats = seats;
        this.model = model;
        this.contact = contact;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "JsonCar{"
                + "trailer=" + trailer
                + ", seats=" + seats
                + ", model='" + model + '\''
                + ", contact=" + contact
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }
}
