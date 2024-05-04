package ru.job4j.ood.ocp;

public class Rectangle {
    public double width;
    public double height;

    public double getArea() {
        return width * height;
    }

    protected void setWidth(double width) {
    }

    protected void setHeight(double width) {
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        super.setWidth(height);
    }
/*класс Square изменяет поведение методов унаследованного класса Rectangle,
не расширяя его, что приводит к нарушению принципа открытости/закрытости*/
}
