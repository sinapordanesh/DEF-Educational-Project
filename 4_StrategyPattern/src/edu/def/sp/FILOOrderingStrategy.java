package edu.def.sp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FILOOrderingStrategy implements TicketOrderingStrategy{

    @Override
    public ArrayList<SupportTicket> createOrdering(ArrayList<SupportTicket> list) {
        //clone() reates a partial deep copy of the object
        ArrayList<SupportTicket> listCopy = (ArrayList<SupportTicket>) list.clone();
        //a function to reverse an ArrayList
        Collections.reverse(listCopy);
        return listCopy;
    }
}
