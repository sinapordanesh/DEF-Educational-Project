package edu.def.sp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class CustomerSupport {

    ArrayList<SupportTicket> tickets;

    CustomerSupport(){
        tickets = new ArrayList<>();
    }

    public void createTicket(String customer, String issue){
        tickets.add(new SupportTicket(customer, issue));
    }

    public void processTickets(Method method) throws InvocationTargetException, IllegalAccessException {
        ArrayList<SupportTicket> list = (ArrayList<SupportTicket>) method.invoke(tickets);
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
