package edu.def.cac;

/**
 * Public class Vehicle with 3 private parameters
 * and one public method. Plus a constructor with
 * 3 arguments.
 */
public class Vehicle {
    private String id;
    private String licensePlate;
    private VehicleInfo info;

    Vehicle(String id, String licensePlate, VehicleInfo info){
        this.id = id;
        this.licensePlate = licensePlate;
        this.info = info;
    }

    public void print(){
        System.out.println("Id: " + this.id);
        System.out.println("License plate: " + this.licensePlate);
        this.info.print();
    }
}
