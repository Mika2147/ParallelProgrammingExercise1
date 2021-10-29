package com.company;

public class BasketOfBottles {
    private int timeToReturn;
    private boolean alreadyReturned = false;

    public BasketOfBottles() {
        this.timeToReturn = (int) (Math.random() * (Constants.MAX_BASKET_RETURN_TIME_IN_SECONDS
                - Constants.MIN_BASKET_RETURN_TIME_IN_SECONDS))
                + Constants.MIN_BASKET_RETURN_TIME_IN_SECONDS;

    }

    public boolean isAlreadyReturned() {
        return alreadyReturned;
    }

    public void startReturning(Customer customer) {

    }
}
