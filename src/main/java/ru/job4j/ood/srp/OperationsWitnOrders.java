package ru.job4j.ood.srp;

public interface OperationsWitnOrders {
    int calculatePay();
    int getCount();
    void add(Object order);
    void save(int id);
    void delete(int id);
    boolean update(int id, Object order);
    /*Принцип SRP нарушается по причине того, что методы add, save, delete
    и update относятся к управлению данными заказа, а методы calculatePay() и getCount()
     связаны с расчетами. Нужно разделить эти методы отдельными интерфейсами, тк здесь
     несколько причин для изменения, что в свою очередь противоречит трактовке принципа*/
}
