package com.company;

import java.util.ArrayList;

public class Customer {
    private ArrayList<BasketOfBottles> baskets;

    public Customer(){
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
}
