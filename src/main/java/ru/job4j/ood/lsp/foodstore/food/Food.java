package ru.job4j.ood.lsp.foodstore.food;


public  class Food {
    private final String name;
    private final int createDate;
    private final int expiryDate;
    private int price;
    private int discount;
    private final int percentFresh;

    public Food(String name, int createDate, int expiryDate, int price) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.discount = 0;
        this.percentFresh = doPercentFresh();
    }

    private int doPercentFresh() {
        int now = 20;
        return (this.expiryDate - now) * 100 / (this.expiryDate - this.createDate);
    }

    public int getPercentFresh() {
        return percentFresh;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
