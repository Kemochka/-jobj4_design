package ru.job4j.serialization;

import java.io.*;

public record Contact(int zipCode, String phone) implements Serializable {
    @Serial
    private static final long serialVersionUID = 340784786541522499L;

    @Override
    public String toString() {
        return "Contact{" +
                "zipCode=" + zipCode +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Contact contact = new Contact(123456, "+7 (111) 111-11-11");
        try (FileOutputStream fos = new FileOutputStream("data/contactSerialization.txt");
             ObjectOutputStream oos =
                     new ObjectOutputStream(fos)) {
            oos.writeObject(contact);
        }
        try (FileInputStream fis = new FileInputStream("data/contactSerialization.txt");
             ObjectInputStream ois =
                     new ObjectInputStream(fis)) {
            final Contact contactFromFile = (Contact) ois.readObject();
            System.out.println(contactFromFile);
        }
    }
}
