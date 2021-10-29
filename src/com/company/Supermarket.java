package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Supermarket {
    private List<BottleReturnMachine> availableMachines;

    public Supermarket() {
        this.createReturnMachines();
    }

    private void createReturnMachines() {
        this.availableMachines = new ArrayList<>(Constants.RETURN_MACHINE_COUNT);
        for (int i = 0; i < Constants.RETURN_MACHINE_COUNT; i++) {
            var machine = new BottleReturnMachine();
            this.availableMachines.add(machine);
        }
    }

    public synchronized Optional<BottleReturnMachine> useAvailableMachine() {
        if(availableMachines.size() == 0){
            return Optional.empty();
        }
        return Optional.of(availableMachines.remove(0));
    }

    public synchronized void freeMachine(BottleReturnMachine machine) {
        this.availableMachines.add(machine);
    }
}
