package edu.def.cac;

public class Application {
    /**
     * to put all different components togather and create an application for a specific brand of car.
     * @param brand: main input to create an application.
     */
    public void registerVehicle(String brand){
        VehicleRegistry registry = new VehicleRegistry();
        Vehicle vehicle = registry.createVehicle(brand);
        vehicle.print();
    }
}
