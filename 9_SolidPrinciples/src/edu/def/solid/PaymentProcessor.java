package edu.def.solid;

public interface PaymentProcessor {
    public void pay(Order order) throws Exception;
}
