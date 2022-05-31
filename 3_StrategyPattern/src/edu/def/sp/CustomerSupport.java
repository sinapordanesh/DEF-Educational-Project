package edu.def.sp;

import java.util.ArrayList;

public class CustomerSupport {

    private ArrayList<SupportTicket> tickets;
    private TicketOrderingStrategy processingStrategy;

    CustomerSupport(TicketOrderingStrategy processingStrategy){
        tickets = new ArrayList<>();
        this.processingStrategy = processingStrategy;
    }


    public void createTicket(String customer, String issue){
        tickets.add(new SupportTicket(customer, issue));
    }


    public void processTickets(){
        ArrayList<SupportTicket> ticketList = this.processingStrategy.createOrdering(this.tickets);

        if (ticketList.size() == 0){
            System.out.println("There are no tickets to process. Well done!");
            return;
        }

        for (SupportTicket ticket: ticketList){
            this.processTicket(ticket);
        }
    }

    /**
     * As it has only internal usage, we can define this function as a private one.
     * @param ticket
     */
    private void processTicket(SupportTicket ticket){
        System.out.println("==================================");
        System.out.println("Processing ticket id: " + ticket.getId());
        System.out.println("Customer: " + ticket.getCustomer());
        System.out.println("Issue: " + ticket.getIssue());
        System.out.println("==================================");
    }

}
