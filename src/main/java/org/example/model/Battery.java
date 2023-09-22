package org.example.model;

public class Battery {

    private final Car car;
    private int charge;





    public Battery(Car car) {
        this.car = car;
        this.charge = 1000;
    }

    public Car getCar() {
        return car;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = Math.max(charge, 0);
    }

    public void expendCharge() {
        this.charge -= 1;
        if (this.charge < 0) {
            this.charge = 0;
        }
        batteryShutDownProcedure();
    }

    public void batteryShutDownProcedure() {
        if (this.charge <= 1) {
            car.turnOffLights(false);
        }
    }

}
