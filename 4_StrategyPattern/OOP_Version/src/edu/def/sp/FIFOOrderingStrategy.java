package edu.def.sp;

import java.util.ArrayList;

public class FIFOOrderingStrategy implements TicketOrderingStrategy{

    @Override
    public ArrayList<SupportTicket> createOrdering(ArrayList<SupportTicket> list) {
        return (ArrayList<SupportTicket>) list.clone();
    }
}
