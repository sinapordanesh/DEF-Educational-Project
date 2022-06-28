package edu.def.cac;

/**
 * A class with 3 private parameters and two public
 * methods. Also, a constructor with 3 arguments.
 */
public class VehicleInfo {
    private String brand;
    private boolean electric;
    private int cataloguePrice;

    VehicleInfo(String brand, boolean electric, int cataloguePrice){
        this.brand = brand;
        this.electric = electric;
        this.cataloguePrice = cataloguePrice;
    }

    /**
     *
     * @return a double which is the computed tax.
     */
    public double computeTax(){
        double taxPercentage = 0.05;
        if (electric){
            taxPercentage = 0.02;
        }
        return taxPercentage * cataloguePrice;
    }

    /**
     *
     */
    public void print(){
        System.out.println("Brand: " + this.brand);
        System.out.println("Payable tax: " + this.computeTax());
    }
}
