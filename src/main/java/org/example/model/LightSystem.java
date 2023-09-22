package org.example.model;

public class LightSystem {

    private final Car car;
    private boolean headlights;
    private boolean highBeam;
    private boolean lowBeam;
    private boolean backLights;
    private boolean hazardLights;
    private boolean brakeLights;

    public LightSystem(Car car) {
        this.car = car;
    }

    public boolean isHeadlights() {
        return headlights;
    }

    public void setHeadlights(boolean headlights) {
        this.headlights = headlights;
        if (headlights) {
            car.getBattery().expendCharge();
        }
    }

    public boolean isHighBeam() {
        return highBeam;
    }

    public void setHighBeam(boolean highBeam) {
        this.highBeam = highBeam;
        if (highBeam) {
            car.getBattery().expendCharge();
        }
    }

    public boolean isLowBeam() {
        return lowBeam;
    }

    public void setLowBeam(boolean lowBeam) {
        this.lowBeam = lowBeam;
        if (lowBeam) {
            car.getBattery().expendCharge();
        }
    }

    public boolean isBackLights() {
        return backLights;
    }

    public void setBackLights(boolean backLights) {
        this.backLights = backLights;
        if (backLights) {
            car.getBattery().expendCharge();
        }
    }

    public boolean isHazardLights() {
        return hazardLights;

    }

    public void setHazardLights(boolean hazardLights) {
        this.hazardLights = hazardLights;
        if (hazardLights) {
            car.getBattery().expendCharge();
        }
    }

    public boolean isBrakeLights() {
        return brakeLights;
    }

    public void setBrakeLights(boolean brakeLights) {
        this.brakeLights = brakeLights;
        if (brakeLights) {
            car.getBattery().expendCharge();
        }
    }

    public Car getCar() {
        return car;
    }
}
