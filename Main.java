package edu.def.sp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

public class Main implements Callable{

    public static void main(String[] args) {
        CustomerSupport app = new CustomerSupport();
        app.createTicket("John Smith", "My computer makes strange sounds!");
        app.createTicket("Linus Sebastian", "I can't upload any videos, please help.");
        app.createTicket("Arjan Egges", "VSCode doesn't automatically solve my bugs.");

        app.processTickets(Main.FIFOOrderingStrategy());
    }

    @Override
    public ArrayList<SupportTicket> call() throws Exception {
        return null;
    }

    public static ArrayList<SupportTicket> FIFOOrderingStrategy(ArrayList<SupportTicket> list){
        return (ArrayList<SupportTicket>) list.clone();
    }

    public ArrayList<SupportTicket> FILOOrderingStrategy(ArrayList<SupportTicket> list){
        //clone() reates a partial deep copy of the object
        ArrayList<SupportTicket> listCopy = (ArrayList<SupportTicket>) list.clone();
        //a function to reverse an ArrayList
        Collections.reverse(listCopy);
        return listCopy;
    }

    public ArrayList<SupportTicket> RandomOrderingStrategy(ArrayList<SupportTicket> list){
        ArrayList<SupportTicket> listCopy = (ArrayList<SupportTicket>) list.clone();
        //shuffle the list randomly
        Collections.shuffle(listCopy);
        return listCopy;
    }

    public ArrayList<SupportTicket> BlackHoleStrategy(ArrayList<SupportTicket> list) {
        //just return an empty ArrayList
        return new ArrayList<>();
    }
}
