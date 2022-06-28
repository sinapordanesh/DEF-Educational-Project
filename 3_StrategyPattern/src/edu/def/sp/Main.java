package edu.def.sp;

public class Main {

    public static void main(String[] args) {
        CustomerSupport app = new CustomerSupport(new RandomOrderingStrategy());

        app.createTicket("John Smith", "My computer makes strange sounds!");
        app.createTicket("Linus Sebastian", "I can't upload any videos, please help.");
        app.createTicket("Arjan Egges", "VSCode doesn't automatically solve my bugs.");

        app.processTickets();
    }
}
