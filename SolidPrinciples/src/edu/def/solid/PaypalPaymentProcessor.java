package edu.def.solid;

public class PaypalPaymentProcessor implements PaymentProcessor{
    private String emailAddress;
    private Authorizer authorizer;

    PaypalPaymentProcessor(String emailAddress, Authorizer authorizer){
        this.emailAddress = emailAddress;
        this.authorizer = authorizer;
    }

    @Override
    public void pay(Order order) throws Exception {
        if (!authorizer.isAuthorized()){
            throw new Exception("Not authorized");
        }
        System.out.println("Processing paypal payment type");
        System.out.println("Using email address: " + this.emailAddress);
        order.setStatus("paid");
    }
}

