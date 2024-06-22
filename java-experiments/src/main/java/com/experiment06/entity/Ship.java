package com.experiment06.entity;


import java.util.ArrayList;
import java.util.List;

public class Ship {
    private String id;
    private String name;
    private double maxWeight;
    private List<Container> containers;

    public Ship(String id, String name, double maxWeight) {
        this.id = id;
        this.name = name;
        this.maxWeight = maxWeight;
        this.containers = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public List<Container> getContainers() {
        return containers;
    }

    public void loadContainer(Container container) throws OverweightException {
        double currentWeight = containers.stream().mapToDouble(Container::getWeight).sum();
        if (currentWeight + container.getWeight() > maxWeight) {
            throw new OverweightException(this.id, this.name, currentWeight + container.getWeight() - maxWeight);
        }
        containers.add(container);
    }
}