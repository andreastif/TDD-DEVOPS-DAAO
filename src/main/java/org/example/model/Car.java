package org.example.model;

public class Car {


    LightSystem lightSystem;
    Battery battery;
    private boolean ignition;

    private String model;
    private int currentSpeed;
    private Gear gear;



    public Car() {
        this.battery = new Battery(this);
        this.lightSystem = new LightSystem(this);
    }

    public Gear getGear() {
        return gear;
    }

    public void setGear(Gear gear) {
        if (currentSpeed == 0) {
            this.gear = gear;
        }

    }



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public void setIgnition(boolean b) {
        this.ignition = b;
    }

    public boolean isIgnition() {
        return ignition;
    }



    public void turnOffLights(boolean ignitionIsTrue) {
        if (!ignitionIsTrue) {
            lightSystem.setHeadlights(false);
            lightSystem.setHighBeam(false);
            lightSystem.setLowBeam(false);
            lightSystem.setBackLights(false);
            this.ignition = false;
        }
    }



    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void throttle(int i) {

        for (int j = 0; j < 15; j ++) {
            battery.expendCharge();
        }

        if (this.gear == Gear.DRIVE) {
            this.currentSpeed += Math.min(i, 180);
        } else {
            this.currentSpeed += Math.min(i, 20);
        }

    }

    public void brake(int i) {

        lightSystem.setBrakeLights(true);

        if (currentSpeed - i < 0) {
            this.currentSpeed = 0;
        } else {
        this.currentSpeed -= i;
        }

    }

    public LightSystem getLightSystem() {
        return lightSystem;
    }

    public void setLightSystem(LightSystem lightSystem) {
        this.lightSystem = lightSystem;
    }

    public Battery getBattery() {
        return battery;
    }

}
