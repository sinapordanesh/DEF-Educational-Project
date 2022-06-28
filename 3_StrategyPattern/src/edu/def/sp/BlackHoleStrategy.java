package edu.def.sp;

import java.util.ArrayList;

public class BlackHoleStrategy implements TicketOrderingStrategy{
    @Override
    public ArrayList<SupportTicket> createOrdering(ArrayList<SupportTicket> list) {
        //just return an empty ArrayList
        return new ArrayList<>();
    }
}
