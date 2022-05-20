package edu.def.cac;

import java.util.HashMap;
import java.util.Random;

public class VehicleRegistry {

    /**
     * We use HashMap in java when we want to have a data structure as shows Key -> Value
     * here, the key is the car's brand and its is a VehicleInfo object
     */
    HashMap<String, VehicleInfo> vehicleInfo = new HashMap<>();

    VehicleRegistry(){
        //Saturating the HashMap on constructor
        this.addVehicleInfo("Tesla Model 3", true, 60000);
        this.addVehicleInfo("Volkswagen ID3", true, 35000);
        this.addVehicleInfo("BMW 5", false, 45000);
        this.addVehicleInfo("Tesla Model Y", true, 75000);
    }

    public  void addVehicleInfo(String brand, boolean electric, int cataloguePrice){
        /*create an entry for the HashMap which the Key is String type and the Vale is a
        non-primary data type VehicleInfo
         */
        this.vehicleInfo.put(brand, new VehicleInfo(brand, electric, cataloguePrice));
    }

    /**
     * As we dont have a simple function to arrange a random string on Java, we are implementing
     * this helper method to help us create one.
     * It acts like "random.choices" in Python
     * @param ascii
     * @return
     */
    protected String getSaltString(String ascii, int length) {

        //char sets based on the incoming argument
        String SALTCHARS;

        switch (ascii){
            case "uppercase":
                SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            case "lowercase":
                SALTCHARS = "abcdefghijklmnopqrstuvwxyz";
            case "digits":
                SALTCHARS = "1234567890";
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
