package edu.def.solid;

public class Main {

    public static void main(String[] args) throws Exception {
        Order order = new Order(10);
        order.addItem("Keyboard", 1, 50);
        order.addItem("SSD", 1, 150);
        order.addItem("USB cable", 2, 5);
        System.out.println(order.totalPrice());
        AuthorizerRobot authorizer = new AuthorizerRobot();
        authorizer.notARobot();
        PaypalPaymentProcessor processor = new PaypalPaymentProcessor("hi@gmail.com", authorizer);
        processor.pay(order);

    }
}
