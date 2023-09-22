package org.example.model;

public class Charger {


    public Charger() {

    }

    public void charge(Battery battery, int charge) {
        battery.setCharge(charge);
    }

}
