package com.example.elitepage1;

public class ItemList {
    private int id;
    private String name;
    private String price;
    private String category;
    private byte[] image;

    public ItemList() {

    }

    public ItemList(int id, String name, String price, String category, byte[] image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.image = image;
    }

    public ItemList(String name, String price, String category, byte[] image) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
