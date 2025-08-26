package com.vendingmachine.vendingmachinelld.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class ItemShelf {
    @Getter
    @Setter
    private int id;

    @Getter
    private List<Item> items;

    @Getter
    @Setter
    private boolean isSoldOut;

    public ItemShelf(int id) {
        this.id = id;
        this.items = new ArrayList<>();
        this.isSoldOut = true;
    }

    public void setItems(List<Item> items) {
        this.items = items;
        if(isSoldOut) { setSoldOut(false); }
    }

    public void addItem(Item item){
        items.add(item);
        if(isSoldOut) { setSoldOut(false); }
    }

    public void removeItem(Item item){
        items.remove(item);
        if(items.isEmpty()) { setSoldOut(true); }
    }

}
