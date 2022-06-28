package edu.def.solid;

import java.util.ArrayList;

public class OrderOriginal {

    private ArrayList<String> items;
    private ArrayList<Integer> quantities;
    private ArrayList<Integer> prices;
    private String status = "open";

    OrderOriginal(){
        this.items = new ArrayList<>();
        this.quantities = new ArrayList<>();
        this.prices = new ArrayList<>();
    }

    public void addItem(String name, int quantity, int price){
        this.items.add(name);
        this.quantities.add(quantity);
        this.prices.add(price);
    }

    public double totalPrice(){
        double total = 0;
        for (int i = 0; i < this.prices.size(); i++){
            total += prices.get(i) * quantities.get(i);
        }
        return total;
    }

    public void pay(String paymentType, String securityCode) throws Exception {
        if (paymentType == "debit"){
            System.out.println("Processing debit payment type");
            System.out.println("Verifying security code: " + securityCode);
            this.status = "paid";
        } else if (paymentType == "credit") {
            System.out.println("Processing credit payment type");
            System.out.println("Verifying security code: " + securityCode);
            this.status = "paid";
        } else {
            throw new Exception("Unknown payment type: " + paymentType);
        }
    }

    public static void main(String[] args) throws Exception {
        OrderOriginal order = new OrderOriginal();
        order.addItem("Keyboard", 1, 50);
        order.addItem("SSD", 1, 150);
        order.addItem("USB cable", 2, 5);

        System.out.println(order.totalPrice());
        order.pay("debit", "0372846");
    }

}