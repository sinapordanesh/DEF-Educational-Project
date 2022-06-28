package edu.def.di;

public class ElectricPowerSwitch {

    private Switchable client;
    private boolean on = false;

    ElectricPowerSwitch(Switchable client){
        this.client = client;
    }

    public void press(){
        if (on){
            client.turnOff();
            on = false;
        } else {
            client.turnOn();
            on = true;
        }
    }
}
