package com.experiment06.entity;


public class Container {
    private String id;
    private double weight;

    public Container(String id, double weight) {
        this.id = id;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }
}