package com.wego.test.carpark.model;

import java.util.ArrayList;
import java.util.List;

public class Root {
    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    private List<Item> items;
}

