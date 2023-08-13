package com.wego.test.carpark.model;

import java.util.ArrayList;

public class Root {
    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    ArrayList<Item> items;
}

