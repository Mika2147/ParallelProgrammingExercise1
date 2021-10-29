package com.company;

import java.util.*;

public class Supermarket {
    private List<BottleReturnMachine> returnMachines;
    private List<BottleReturnMachine> availableMachines;

    public Supermarket() {
        this.createReturnMachines();
    }

    private void createReturnMachines() {
        this.returnMachines = new ArrayList<>(Constants.RETURN_MACHINE_COUNT);
        this.availableMachines = new ArrayList<>(Constants.RETURN_MACHINE_COUNT);
        for (int i = 0; i < Constants.RETURN_MACHINE_COUNT; i++) {
            var machine = new BottleReturnMachine();
            this.returnMachines.add(machine);
            this.availableMachines.add(machine);
        }
    }

    public synchronized BottleReturnMachine useAvailableMachine() {
        while (this.availableMachines.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.availableMachines.remove(0);

    }

    public synchronized void freeMachine(BottleReturnMachine machine) {
        this.availableMachines.add(machine);
        notify();
    }
}
