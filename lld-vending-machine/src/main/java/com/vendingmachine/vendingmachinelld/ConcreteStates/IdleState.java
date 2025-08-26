package com.vendingmachine.vendingmachinelld.ConcreteStates;

import com.vendingmachine.vendingmachinelld.VendingMachineContext;
import com.vendingmachine.vendingmachinelld.VendingMachineState;

public class IdleState implements VendingMachineState {
    @Override
    public String getStateName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public VendingMachineState next(VendingMachineContext vendingMachineContext) {
//        if vending machine has coin then proceed to has coin state, else remain idle state
//        return new HasMoneyState();
        return this;
    }
}
