package ru.job4j.ood.isp;

public class Examples {
    interface Vehicle {
        void startEngine();
        void accelerate();
        void stopEngine();
    }

    class Bicycle implements Vehicle {
        public void startEngine() {
        }
        public void accelerate() {
        }
        public void stopEngine() {
        }
/*Класс Bicycle реализует интерфейс Vehicle, который содержит методы для управления двигателем.
E велосипеда нет двигателя, некоторые методы интерфейса для него являются лишними и не используются*/
    }
    interface Animal {
        void eat();
        void sleep();
        void fly();
    }

    class Bird implements Animal {
        public void eat() {
        }

        public void sleep() {
        }

        public void fly() {
        }
    }
/*Класс Bird реализует интерфейс с методами eat(), sleep() и fly().
* Но не все птицы умеют летать и этот метод может быть лишним.*/

    interface Transport {
        void fly();
        void drive();
    }

    class Car implements Transport {
        public void fly() {
        }
        public void drive() {
        }
        /*Класс Car реализует интерфейс Transport с методами drive(), fly(),
        * но не все виды транспорта могут летать*/
    }
}
