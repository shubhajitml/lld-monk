package com.vendingmachine.vendingmachinelld;

import com.vendingmachine.vendingmachinelld.ConcreteStates.DispenseState;
import com.vendingmachine.vendingmachinelld.ConcreteStates.HasMoneyState;
import com.vendingmachine.vendingmachinelld.ConcreteStates.IdleState;
import com.vendingmachine.vendingmachinelld.ConcreteStates.SelectionState;
import com.vendingmachine.vendingmachinelld.entities.Inventory;
import com.vendingmachine.vendingmachinelld.entities.Item;
import com.vendingmachine.vendingmachinelld.enums.Cash;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class VendingMachineContext{
    private VendingMachineState currentState;
    private Inventory inventory;
    private List<Cash> cashList;
    private int selectedItemCode;
    private int shelfId;

    public VendingMachineContext(){
        inventory = new Inventory(10);
        cashList = new ArrayList<>();
        currentState = new IdleState();
        System.out.println("Initialized to state: " + currentState.getStateName());
    }

    public void transitionState() {
        VendingMachineState nextState = currentState.next(this);
        setCurrentState(nextState);
        System.out.println("Transitioned to state: " + currentState.getStateName());
    }

//    1. Idle State,
//    2. clickOnInsertCashButton,
//    3. clickOnStartProductSelectionButton,
//    4. selectProduct,
//    5. processPayment,
//    6. dispenseItem,
//    7. updateInventory,

    public void clickOnInsertCashButton(Cash cash){
        if(currentState instanceof IdleState || currentState instanceof HasMoneyState){
            cashList.add(cash);
            System.out.println("Inserted Cash/Coin : " + cash.name() + " worth " + cash.value);
            transitionState();
        }else{
            System.out.println("Can not Insert Cash/Coin in : " + currentState.getStateName());
        }
    }

    public void clickOnStartProductSelectionButton(int shelfId){
        if(currentState instanceof HasMoneyState){
            transitionState();
            selectProduct(shelfId);
        }else{
            System.out.println("Product selection button can only be selected in : " + currentState.getStateName());
        }
    }

    public void selectProduct(int shelfId){
        if(currentState instanceof SelectionState){
            try {
                Item item = inventory.getItem(shelfId);
                int currentBalance = this.getBalance();
                if(currentBalance < item.getPrice()){
                    System.out.println("Insufficient amount! selected product price: "
                            + item.getPrice() + ", paid: " + currentBalance);
                    return;
                }
                setSelectedItemCode(shelfId);
                transitionState();
                dispenseItem(shelfId);

                // return change if applicable
                if(currentBalance > item.getPrice()){
                    int change = currentBalance - item.getPrice();
                    System.out.println("Returning change: " + change);
                }

            }catch(Exception e){
                System.out.println("Error " + e.getMessage());
            }
        }else{
            System.out.println("Products can only be selected in Selection state");
        }
    }

    public void dispenseItem(int shelfId){
        if(currentState instanceof DispenseState){
            try{
                Item item = inventory.getItem(shelfId);
                System.out.println("Dispensing item: " + item.getType());
                inventory.removeItem(shelfId);
                inventory.updateSoldOutItem(shelfId);

                resetBalance();
                resetSelection();
                transitionState();
            }catch(Exception e){
                System.out.println("Failed to dispense product with code: " + shelfId);
            }
        }else{
            System.out.println("Products can only be dispensed in Dispense state");
        }
    }

    private void resetSelection() {
        this.selectedItemCode = 0;
    }

    private void resetBalance() {
        cashList.clear();
    }

    private int getBalance() {
        int balance = 0;
        for(Cash cash : cashList){
            balance += cash.value;
        }
        return balance;
    }


}
