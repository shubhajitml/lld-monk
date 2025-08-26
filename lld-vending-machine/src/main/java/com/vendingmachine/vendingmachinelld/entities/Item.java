package com.vendingmachine.vendingmachinelld.entities;

import com.vendingmachine.vendingmachinelld.enums.ItemType;

public class Item {
    private int id;
    private ItemType type;
    private int price;

    public Item(int id, ItemType type, int price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ItemType getType(){
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }
}
