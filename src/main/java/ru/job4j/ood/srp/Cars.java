package ru.job4j.ood.srp;

public interface Cars {
    String name();
    String model();
    void println();
    int getPrice();
    /*Методы name() и model() отвечают за предоставление информации об авто,
    *println() отвечает за вывод информации о машине,
    *getPrice() предоставляет информацию о стоимости
    * нарушается принцип SRP, нужно использовать отдельные иетерфейсы */
}
