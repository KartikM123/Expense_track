package com.example.karti.expense_tracker;

/**
 * Created by karti on 7/19/2017.
 */

public class Item {
    public double cost;
    public String id;
    public String account;
    public Item (String id, double cost){
        this.cost = cost;
        this.id = id;
    }
    @Override
    public String toString() {
        return "id: " + id +  " cost: " + cost;
    }
}
