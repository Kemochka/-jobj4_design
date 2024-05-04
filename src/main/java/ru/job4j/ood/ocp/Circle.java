package ru.job4j.ood.ocp;

public class Circle {
    public double radius;

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Ellipse extends Circle {
    public double minorRadius;

    @Override
    public double getArea() {
        return Math.PI * radius * minorRadius;
    }
/*класс Ellipse изменяет существующий метод
getArea класса Circle, не расширяя его, что
приводит к нарушению принципа открытости/закрытости*/
}
