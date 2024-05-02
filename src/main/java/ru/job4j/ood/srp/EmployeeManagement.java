package ru.job4j.ood.srp;

public interface EmployeeManagement {
    void addEmployee(Object employee);
    void removeEmployee(int employeeId);
    void generateEmployeeReport(Object employee);
    void sendEmailToEmployee(Object employee, String message);
    /*Интерфейс EmployeeManagement нарушает принцип SRP,
    так как он отвечает за несколько различных аспектов управления сотрудниками:
    добавление и удаление сотрудников, генерация отчетов о сотрудниках и отправка
    электронных писем сотрудникам, следовательно каждый метод можно вынести в
    отдельный интерфейс, чтобы иметь только одну причину для изменения*/
}
