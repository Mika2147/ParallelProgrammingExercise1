package com.company;

public class IdentityManager {
    private static int customerCount = 0;
    private static int machineCount = 0;

    public static synchronized String getNextCustomerId(){
        var id = String.valueOf(customerCount);
        customerCount++;
        return id;
    }

    public static synchronized String getNextMachineId(){
        var id = String.valueOf(machineCount);
        machineCount++;
        return id;
    }
}
