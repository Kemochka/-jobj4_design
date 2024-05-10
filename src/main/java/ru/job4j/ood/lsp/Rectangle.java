package ru.job4j.ood.lsp;

class Rectangle {
    private int width;
    private int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return this.width * this.height;
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }

    /*Причина нарушения принципа LSP: класс Square переопределяет методы setWidth и setHeight,
    так чтобы при установке ширины он автоматически устанавливал высоту и наоборот.
    В результате такая реализация приводит к нарушению LSP, так как наследник должен использоваться
    вместо родителя и вести себя так же, что не выполняется в данном случае*/
}


