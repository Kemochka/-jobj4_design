package ru.job4j.ood.dip;

public class Examples {
    class MySQLDatabase {
        public void connect() {
            System.out.println("Connecting to MySQL database");
        }
    }

    class UserDAO {
        private MySQLDatabase database;

        public UserDAO() {
            this.database = new MySQLDatabase();
        }

        public void saveUser(String username) {
            database.connect();
            System.out.println("Saving user " + username);
        }
    }
    /*Причина нарушения принципа DIP: Класс UserDAO напрямую зависит
    от конкретной реализации MySQLDatabase в своем конструкторе,
    что делает его жестко привязанным к этой базе данных*/

    interface Car {
        void start();
    }

    class FordCar implements Car {
        @Override
        public void start() {
            System.out.println("Starting Ford car");
        }
    }

    class Driver {
        private FordCar car;

        public Driver() {
            this.car = new FordCar();
        }

        public void drive() {
            car.start();
        }
/*Класс Driver прямо зависит от конкретной реализации FordCar в своем конструкторе,
что делает его жестко привязанным к этому типу автомобиля*/


    }

    class EmailService {
        public void sendEmail(String recipient, String message) {
        }
    }

    class NotificationService {
        private EmailService emailService;

        public NotificationService() {
            this.emailService = new EmailService();
        }

        public void sendNotification(String recipient, String message) {
            emailService.sendEmail(recipient, message);
        }
        /*Класс NotificationService напрямую зависит от конкретной реализации
        EmailService в своем конструкторе, что делает его жестко привязанным к этому сервису*/
    }
}
