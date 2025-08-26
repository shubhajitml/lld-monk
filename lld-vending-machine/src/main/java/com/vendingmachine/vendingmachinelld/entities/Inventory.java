package com.vendingmachine.vendingmachinelld.entities;

public class Inventory {
    ItemShelf[] inventory = null;

    public Inventory(int numShelf){
        inventory = new ItemShelf[numShelf];
        initializeEmptyInventory();
    }

    private void initializeEmptyInventory() {
        int startId = 101;
        for(int i = 0; i < inventory.length; ++i){
            ItemShelf shelf = new ItemShelf(startId++);
            inventory[i] = shelf;
        }
    }

    public void addItem(Item item, int shelfId) throws Exception {
        for(ItemShelf shelf : inventory){
            if(shelf.getId() == shelfId){
                shelf.addItem(item);
                return;
            }
        }
        throw new Exception("Invalid Shelf ID");
    }

    public Item getItem(int shelfId) throws Exception {
        for(ItemShelf shelf : inventory){
            if(shelf.getId() == shelfId){
                if(shelf.isSoldOut()) {
                    throw new Exception("Item is already sold out!");
                }else{
                    Item item = shelf.getItems().get(0);
                    return item;
                }
            }
        }
        throw new Exception("Invalid Shelf ID");
    }

    public void updateSoldOutItem(int shelfId) throws Exception {
        for(ItemShelf shelf : inventory){
            if(shelf.getId() == shelfId && shelf.getItems().isEmpty()){
                shelf.setSoldOut(true);
            }
        }
        throw new Exception("Invalid Shelf ID");
    }

    public void removeItem(int shelfId) throws Exception {
        for(ItemShelf shelf : inventory){
            if(shelf.getId() == shelfId){
                if(shelf.isSoldOut()){
                    throw new Exception("Can't remove item from sold-out shelf!");
                }
                Item item = shelf.getItems().get(0);
                shelf.removeItem(item);
            }
        }
        throw new Exception("Invalid Shelf ID");
    }

    public boolean hasItems(){
        for(ItemShelf shelf : inventory){
            if(!shelf.isSoldOut()) { return true;}
        }
        return false;
    }
}
