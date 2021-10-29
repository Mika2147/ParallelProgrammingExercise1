package com.company;

public class BottleReturnMachine {
    private String id;

    public BottleReturnMachine(){
        this.id = IdentityManager.getNextMachineId();
    }

    public void returnBaskets(Customer customer){
        //if(this.id.equals("1"))System.out.printf("Machine %s entered by %s\n", id, customer.getId());
        for(var basket: customer.getBaskets()){
            basket.startReturning(customer, this);
        }
        //if(this.id.equals("1"))System.out.printf("Machine %s exit by %s\n", id, customer.getId());
        customer.finishReturning(this);
    }

    public String getId() {
        return this.id;
    }
}
