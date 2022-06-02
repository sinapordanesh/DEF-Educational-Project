package edu.def.tmab;

import java.util.ArrayList;

public class Binance implements Exchange{

    @Override
    public void connect() {
        System.out.println("Connecting to Binance exchange...");
    }
    @Override
    public ArrayList<Float> getMarketData(String coin) {
        return new ArrayList<>(){{
            add(10f);
            add(12f);
            add(18f);
            add(14f);
        }};
    }
}
