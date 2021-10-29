package com.company;

public class BasketOfBottles {
    private int timeToReturn;
    private boolean alreadyReturned = false;

    public BasketOfBottles() {
        this.timeToReturn = (int) (Math.random() * (Constants.MAX_BASKET_RETURN_TIME
                - Constants.MIN_BASKET_RETURN_TIME))
                + Constants.MIN_BASKET_RETURN_TIME;

    }

    public void startReturning(Customer customer, BottleReturnMachine machine) {
        if(alreadyReturned) {
            return;
        }
        try {
            System.out.printf("%s started returning basket at %s\n", customer.getId(), machine.getId());
            Thread.sleep(timeToReturn);
            alreadyReturned = true;
            System.out.printf("%s successfully returned basket at %s\n", customer.getId(), machine.getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
