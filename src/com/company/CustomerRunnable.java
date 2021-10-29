package com.company;

public class CustomerRunnable implements Runnable {
    private Supermarket supermarket;

    public CustomerRunnable(Supermarket supermarket){
        this.supermarket = supermarket;
    }

    @Override
    public void run() {
        Customer customer = new Customer(this.supermarket);
        customer.startReturning();
    }
}
