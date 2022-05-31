package edu.def.di;

public class Main {
    public static void main(String[] args) {
        LightBulb l = new LightBulb();
        Fan f = new Fan();
        ElectricPowerSwitch switch1 = new ElectricPowerSwitch(f);
        switch1.press();
        switch1.press();
    }
}
