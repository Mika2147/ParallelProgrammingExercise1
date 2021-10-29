package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer implements Runnable{
    private String id;
    private List<BasketOfBottles> baskets;
    private Supermarket supermarket;

    public Customer(Supermarket supermarket){
        this.id = IdentityManager.getNextCustomerId();
        this.supermarket = supermarket;
        int numberOfBaskets = (int)(Math.random() * (Constants.MAX_BASKET_PER_CUSTOMER_COUNT
                - Constants.MIN_BASKET_PER_CUSTOMER_COUNT))
                + Constants.MIN_BASKET_PER_CUSTOMER_COUNT;
        this.baskets = new ArrayList<>(numberOfBaskets);
        this.createBaskets(numberOfBaskets);
    }

    private void createBaskets(int numberOfBaskets){
        for(int i = 0; i < numberOfBaskets; i++){
            this.baskets.add(new BasketOfBottles());
        }
    }

    public String getId() {
        return this.id;
    }

    public List<BasketOfBottles> getBaskets() {
        return this.baskets;
    }

    public synchronized void startReturning(){
        var machine = supermarket.useAvailableMachine();
        while(machine.isEmpty()){
            try {
                wait();
                machine = supermarket.useAvailableMachine();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        machine.get().returnBaskets(this);
    }

    public synchronized void finishReturning(BottleReturnMachine machine){
        supermarket.freeMachine(machine);
        notify();
    }

    @Override
    public void run() {
        startReturning();
    }
}
