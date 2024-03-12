package ru.job4j.serialization;

import java.util.Arrays;

public class JsonCar {

    private final boolean trailer;

    private final int seats;

    private final String model;

    private final Contact contact;

    private final String[] statuses;


    public JsonCar(boolean trailer, int seats, String model, Contact contact, String[] statuses) {
        this.trailer = trailer;
        this.seats = seats;
        this.model = model;
        this.contact = contact;
        this.statuses = statuses;
    }

    public int getSeats() {
        return seats;
    }

    public String getModel() {
        return model;
    }

    public boolean isTrailer() {
        return trailer;
    }

    public Contact getContact() {
        return contact;
    }

    public String[] getStatuses() {
        return statuses;
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
