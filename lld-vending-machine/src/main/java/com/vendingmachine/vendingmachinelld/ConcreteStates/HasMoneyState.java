package com.vendingmachine.vendingmachinelld.ConcreteStates;

import com.vendingmachine.vendingmachinelld.VendingMachineContext;
import com.vendingmachine.vendingmachinelld.VendingMachineState;

public class HasMoneyState implements VendingMachineState {
    @Override
    public String getStateName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public VendingMachineState next(VendingMachineContext vendingMachineContext) {
        return null;
    }
}
