package edu.def.cac;

public class VehicleInfo {
    private String brand;
    private boolean electric;
    private int cataloguePrice;

    VehicleInfo(String brand, boolean electric, int cataloguePrice){
        this.brand = brand;
        this.electric = electric;
        this.cataloguePrice = cataloguePrice;
    }

    public double computeTax(){
        double taxPercentage = 0.05;
        if (electric){
            taxPercentage = 0.02;
        }
        return taxPercentage * cataloguePrice;
    }

    public void print(){
        System.out.println("Brand: " + this.brand);
        System.out.println("Payable tax: " + this.computeTax());
    }
}
