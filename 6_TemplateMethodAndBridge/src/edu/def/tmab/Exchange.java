package edu.def.tmab;

import java.util.ArrayList;

public interface Exchange {

    public void connect();
    public ArrayList<Float> getMarketData(String coin);
}
