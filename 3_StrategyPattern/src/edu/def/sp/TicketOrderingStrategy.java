package edu.def.sp;

import java.util.ArrayList;

public interface TicketOrderingStrategy {

    /**
     * A function which receives a list and return another list based on the ordering type.
     * @param list: an argument of ArrayList data type which contains SupportTicket objects
     * @return: the same data type of incoming argument, but with different ordering
     */
    public ArrayList<SupportTicket> createOrdering(ArrayList<SupportTicket> list);
}
