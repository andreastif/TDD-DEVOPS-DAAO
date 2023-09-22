package org.example.model;

public class Battery {

    private int charge;





    public Battery() {
        this.charge = 100;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = Math.max(charge, 0);
    }

    public void expendCharge() {
        this.charge -= 1;
    }
}
