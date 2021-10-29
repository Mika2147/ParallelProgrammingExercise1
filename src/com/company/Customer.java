package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Customer{
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

    public void startReturning(){
        var machine = supermarket.useAvailableMachine();
        machine.returnBaskets(this);
    }

    public void finishReturning(BottleReturnMachine machine){
        supermarket.freeMachine(machine);
    }
}
