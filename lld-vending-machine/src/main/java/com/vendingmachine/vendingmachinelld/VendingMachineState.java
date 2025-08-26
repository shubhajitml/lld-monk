package com.vendingmachine.vendingmachinelld;

public interface VendingMachineState {
    String getStateName();
    VendingMachineState next(VendingMachineContext vendingMachineContext);
}
