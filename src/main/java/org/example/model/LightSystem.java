package org.example.model;

public class LightSystem {

    private boolean headlights;
    private boolean highBeam;
    private boolean lowBeam;
    private boolean backLights;
    private boolean hazardLights;
    private boolean brakeLights;

    public LightSystem() {
    }

    public boolean isHeadlights() {
        return headlights;
    }

    public void setHeadlights(boolean headlights) {
        this.headlights = headlights;
    }

    public boolean isHighBeam() {
        return highBeam;
    }

    public void setHighBeam(boolean highBeam) {
        this.highBeam = highBeam;
    }

    public boolean isLowBeam() {
        return lowBeam;
    }

    public void setLowBeam(boolean lowBeam) {
        this.lowBeam = lowBeam;
    }

    public boolean isBackLights() {
        return backLights;
    }

    public void setBackLights(boolean backLights) {
        this.backLights = backLights;
    }

    public boolean isHazardLights() {
        return hazardLights;
    }

    public void setHazardLights(boolean hazardLights) {
        this.hazardLights = hazardLights;
    }

    public boolean isBrakeLights() {
        return brakeLights;
    }

    public void setBrakeLights(boolean brakeLights) {
        this.brakeLights = brakeLights;
    }
}
