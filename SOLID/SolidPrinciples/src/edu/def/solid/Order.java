package edu.def.solid;

public class Order {
    private String[] items;
    private int[] quantities;
    private int[] prices;
    private String status = "open";
    int numberOfItems = 0;

    Order(int numberOfItems){
        items = new String[numberOfItems];
        quantities = new int[numberOfItems];
        prices = new int[numberOfItems];
    }

    public void addItem(String name, int quantity, int price){
        this.items[numberOfItems] = name;
        this.quantities[numberOfItems] = quantity;
        this.prices[numberOfItems] = price;
        numberOfItems++;
    }

    public int totalPrice(){
        int total = 0;
        for (int i = 0; i < numberOfItems; i++){
            total += this.quantities[i] * this.prices[i];
        }
        return total;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
