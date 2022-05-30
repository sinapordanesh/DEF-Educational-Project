package edu.def.sp;

import java.util.Random;

public class SupportTicket {
    private String id;
    private String customer;
    private String issue;

    SupportTicket(String customer, String issue){
        this.id = getSaltString("uppercase", 8);
        this.customer = customer;
        this.issue = issue;
    }

    public String getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public String getIssue() {
        return issue;
    }

    /**
     * As we dont have a simple function to arrange a random string on Java, we are implementing
     * this helper method to help us create one.
     * It acts like "random.choices" in Python
     * @param ascii
     * @return
     */
    private String getSaltString(String ascii, int length) {

        //char sets based on the incoming argument
        String SALTCHARS;

        switch (ascii){
            case "uppercase":
                SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                break;
            case "lowercase":
                SALTCHARS = "abcdefghijklmnopqrstuvwxyz";
                break;
            case "digits":
                SALTCHARS = "1234567890";
                break;
            default:
                SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        }
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }
}
