package com.example.elitepage1;

public class Add_Item_Suggest {
    private int suggestedID ;
    private String ItemName;
    private String customerID;


    public Add_Item_Suggest() {

    }

    public Add_Item_Suggest(String itemName, String customerID) {
        ItemName = itemName;
        this.customerID = customerID;
    }

    public Add_Item_Suggest(int suggestedID, String itemName, String customerID) {
        this.suggestedID = suggestedID;
        ItemName = itemName;
        this.customerID = customerID;
    }
    public int getSuggestedID() {
        return suggestedID;
    }

    public String getItemName() {
        return ItemName;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setSuggestedID(int suggestedID) {
        this.suggestedID = suggestedID;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

}
