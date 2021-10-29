package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Supermarket {
    private ArrayList<BottleReturnMachine> returnMachines;
    private Queue<Customer> waitingCustomers;

    public Supermarket(){
        this.createReturnMachines();
        this.waitingCustomers = new PriorityQueue<>(Constants.CUSTOMER_COUNT);
    }

    private void createReturnMachines(){
        this.returnMachines = new ArrayList<>(Constants.RETURN_MACHINE_COUNT);
        for (int i = 0; i < Constants.RETURN_MACHINE_COUNT; i++){
            this.returnMachines.add(new BottleReturnMachine());
        }
    }

}
