package edu.def.solid;

public class DebitPaymentProcessor implements PaymentProcessor{
    private int securityCode;
    private Authorizer authorizer;

    DebitPaymentProcessor(int securityCode, Authorizer authorizer){
        this.securityCode = securityCode;
        this.authorizer = authorizer;
    }

    @Override
    public void pay(Order order) throws Exception {
        if (!authorizer.isAuthorized()){
            throw new Exception("Not authorized");
        }
        System.out.println("Processing debit payment type");
        System.out.println("Verifying security code: " + this.securityCode);
        order.setStatus("paid");
    }
}
