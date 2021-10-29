package com.company;

public class Main {

    public static void main(String[] args) {
        Supermarket supermarket = new Supermarket();
        for (int i = 0; i < Constants.CUSTOMER_COUNT; i++) {
            try {
                CustomerRunnable runnable = new CustomerRunnable(supermarket);
                Thread thread = new Thread(runnable);
                thread.start();
                Thread.sleep(Constants.NEW_CUSTOMER_ARRIVAL_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
