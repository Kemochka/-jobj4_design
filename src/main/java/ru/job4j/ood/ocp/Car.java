package ru.job4j.ood.ocp;

public class Car {
    public String color;

    public void paint(String newColor) {
        this.color = newColor;
    }
}

class ElectricCar extends Car {
    public void recharge() {
    }
    /*класс ElectricCar добавляет новый функционал,
    но не через расширение существующего класса*/
}
