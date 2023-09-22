package org.example.model;

public class Car {

    private boolean headlights;
    private boolean highBeam;
    private boolean lowBeam;
    private boolean backLights;
    private boolean ignition;
    private boolean hazardLights;
    private boolean brakeLights;
    private String model;
    private int currentSpeed;
    private Gear gear;



    public Car() {
    }

    public Gear getGear() {
        return gear;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
    }

    public boolean isHeadlights() {
        return headlights;
    }

    public void setHeadlights(boolean headlights) {
        this.headlights = headlights;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHighBeam(boolean highBeam) {
        this.highBeam = highBeam;
    }

    public boolean isHighBeam() {
        return highBeam;
    }

    public void setLowBeam(boolean lowBeam) {
        this.lowBeam = lowBeam;
    }

    public boolean isLowBeam() {
        return lowBeam;
    }

    public void setBackLights(boolean b) {
        this.backLights = b;
    }

    public boolean isBackLights() {
        return this.backLights;
    }

    public void setIgnition(boolean b) {
        this.ignition = b;
    }

    public boolean isIgnition() {
        return ignition;
    }

    public boolean isBrakeLights() {
        return brakeLights;
    }

    public void setBrakeLights(boolean brakeLights) {
        this.brakeLights = brakeLights;
    }

    public void turnOffLights(boolean ignitionIsTrue) {
        if (!ignitionIsTrue) {
            this.headlights = false;
            this.highBeam = false;
            this.lowBeam = false;
            this.backLights = false;
            this.ignition = false;
        }
    }

    public void setHazardLights(boolean b) {
        this.hazardLights = b;
    }

    public boolean isHazardLights() {
        return hazardLights;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void throttle(int i) {
        this.currentSpeed += Math.min(i, 180);
    }

    public void brake(int i) {

        this.brakeLights = true;

        if (currentSpeed - i < 0) {
            this.currentSpeed = 0;
        } else {
        this.currentSpeed -= i;
        }

    }


}
