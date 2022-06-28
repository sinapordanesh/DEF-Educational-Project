package edu.def.sp;

import java.util.ArrayList;
import java.util.Collections;

public class RandomOrderingStrategy implements TicketOrderingStrategy{

    @Override
    public ArrayList<SupportTicket> createOrdering(ArrayList<SupportTicket> list) {
        ArrayList<SupportTicket> listCopy = (ArrayList<SupportTicket>) list.clone();
        //shuffle the list randomly
        Collections.shuffle(listCopy);
        return listCopy;
    }
}
