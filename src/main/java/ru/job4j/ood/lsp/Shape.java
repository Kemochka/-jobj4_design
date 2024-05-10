package ru.job4j.ood.lsp;

public class Shape {
    public void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }

    public double getRadius() {
        return radius;
    }
/*Причина нарушения принципа LSP: класс Circle переопределяет метод draw базового класса Shape,
чтобы изменить сообщение о том, что рисуется. Это нарушает принцип LSP,
так как вызов метода draw может давать разные результаты в зависимости от типа объекта*/
}
