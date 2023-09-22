package org.example.model;

public class Charger {

    private Car car;


    public Charger() {

    }


    public int charge() {
       int iteration = (1000 - car.getBattery().getCharge()) / 10;
       for (int i = 0; i < iteration; i++) {
           car.getBattery().setCharge(car.getBattery().getCharge() + 10);
       }
       if (car.getBattery().getCharge() >= 991 && car.getBattery().getCharge() < 1000) {
           car.getBattery().setCharge(1000);
           iteration += 1;
       }


       return iteration;
    }


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
