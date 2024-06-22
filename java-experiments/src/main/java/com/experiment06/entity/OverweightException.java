package com.experiment06.entity;


public class OverweightException extends Exception {
    private String shipId;
    private String shipName;
    private double overweightWeight;

    public OverweightException(String shipId, String shipName, double overweightWeight) {
        super("Ship " + shipId + " (" + shipName + ") is overweight by " + overweightWeight + " tons.");
        this.shipId = shipId;
        this.shipName = shipName;
        this.overweightWeight = overweightWeight;
    }

    public String getShipId() {
        return shipId;
    }

    public String getShipName() {
        return shipName;
    }

    public double getOverweightWeight() {
        return overweightWeight;
    }
}