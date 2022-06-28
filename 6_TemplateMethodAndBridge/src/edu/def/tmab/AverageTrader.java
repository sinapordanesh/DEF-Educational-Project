package edu.def.tmab;

import java.util.ArrayList;

public class AverageTrader extends TradingBot{

    /**
     * in java, when a class inherits an abstraction parent, we should have the constructor for the parent on the child class as well. The keyword for it is "super".
     * @param exchange
     */
    AverageTrader(Exchange exchange) {
        super(exchange);
    }

    public float listAverage(ArrayList<Float> list){

        //we don't have any function to calculate sum of the
        // item on a list automatically.
        float sum = 0;
        for (float item: list){
            sum += item;
        }
        return sum/list.size();
    }

    @Override
    public boolean shouldBuy(ArrayList<Float> prices) {
        // "(prices.size() - 1)" on get() method means getting the last item of the list.
        return prices.get(prices.size() - 1) < this.listAverage(prices);
    }

    @Override
    public boolean shouldSell(ArrayList<Float> prices) {
        // "(prices.size() - 1)" on get() method means getting the last item of the list.
        return prices.get(prices.size() - 1) > this.listAverage(prices);
    }
}
