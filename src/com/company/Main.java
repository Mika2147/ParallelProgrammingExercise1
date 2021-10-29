package com.company;

public class Main {

    public static void main(String[] args) {
        Supermarket supermarket = new Supermarket();
        for (int i = 0; i < Constants.CUSTOMER_COUNT; i++) {
            try {
                Customer customer = new Customer(supermarket);
                Thread thread = new Thread(customer);
                thread.start();
                Thread.sleep(Constants.NEW_CUSTOMER_ARRIVAL_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
