package ru.job4j.ood.lsp;

public class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostrich cannot fly");
    }
/*Причина нарушения принципа LSP: класс Ostrich переопределяет метод fly
и бросает исключение при вызове этого метода*/
}
