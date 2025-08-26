package com.vendingmachine.vendingmachinelld.enums;

public enum Cash {
    ONE_RUPEE(1),
    TWO_RUPEE(2),
    FIVE_RUPEE(5),
    TEN_RUPEE(10),
    TWENTY_RUPEE(20),
    FIFTY_RUPEE(50),
    HUNDRED_RUPEE(100);

    public int value;
    Cash(int value){
        this.value = value;
    }
}
