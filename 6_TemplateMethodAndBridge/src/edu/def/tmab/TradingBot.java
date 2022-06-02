package edu.def.tmab;

import java.util.ArrayList;

public abstract class TradingBot {
    private Exchange exchange;

    TradingBot(Exchange exchange){
        this.exchange = exchange;
    }

    public void checkPrices(String coin){
        this.exchange.connect();
        ArrayList<Float> prices = this.exchange.getMarketData(coin);

        boolean shouldBuy = this.shouldBuy(prices);
        boolean shouldSell = this.shouldSell(prices);

        if (shouldBuy){
            System.out.println("You should buy " + coin + "!");
        } else if (shouldSell) {
            System.out.println("You should sell " + coin + "!");
        } else {
            System.out.println("No action needed for " + coin + ".");
        }
    }

    public abstract boolean shouldBuy(ArrayList<Float> prices);

    public abstract boolean shouldSell(ArrayList<Float> prices);
}
