package com.company;

public class BottleReturnMachine {
    private String id;
    private boolean available = true;

    public BottleReturnMachine(){
        this.id = IdentityManager.getNextMachineId();
    }

    public void returnBaskets(Customer customer){
        for(var basket: customer.getBaskets()){
            basket.startReturning(customer, this);
        }
        customer.finishReturning(this);
    }

    public String getId() {
        return this.id;
    }
}
