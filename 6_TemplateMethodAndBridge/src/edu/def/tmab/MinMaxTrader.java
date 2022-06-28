package edu.def.tmab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class MinMaxTrader extends TradingBot{

    /**
     * in java, when a class inherits an abstraction parent, we should have the constructor for the parent on the child class as well. The keyword for it is "super".
     * @param exchange
     */
    MinMaxTrader(Exchange exchange) {
        super(exchange);
    }

    @Override
    public boolean shouldBuy(ArrayList<Float> prices) {
        // "(prices.size() - 1)" on get() method means getting the last item of the list.
        //Also, Collections.min() will find the maximum item in a list
        return Objects.equals(prices.get(prices.size() - 1), Collections.min(prices));
    }

    @Override
    public boolean shouldSell(ArrayList<Float> prices) {
        // "(prices.size() - 1)" on get() method means getting the last item of the list.
        //Also, Collections.max() will find the maximum item in a list.
        return prices.get(prices.size() - 1) == Collections.max(prices);
    }
}
