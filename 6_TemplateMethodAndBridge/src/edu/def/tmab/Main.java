package edu.def.tmab;

public class Main {

    public static void main(String[] args) {
        AverageTrader application = new AverageTrader(new Coinbase());
        application.checkPrices("BTC/USD");
    }
}
