package org.example.model;

public class Car {

    private boolean headlights;
    private boolean highBeam;
    private boolean lowBeam;
    private boolean backLights;
    private boolean ignition;
    private String model;
    private boolean hazardlights;

    private int currentSpeed;

    public Car() {
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
        this.hazardlights = b;
    }

    public boolean isHazardLights() {
        return hazardlights;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void throttle(int i) {
        this.currentSpeed += Math.min(i, 180);
    }

    public void decreaseSpeed(int i) {
        if (currentSpeed - i < 0) {
            this.currentSpeed = 0;
        } else {
        this.currentSpeed -= i;
        }
    }


}
