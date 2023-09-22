
import org.example.model.Car;
import org.example.model.Charger;
import org.example.model.Gear;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


public class CarTest {
    Car car;
    Charger charger;

    @BeforeEach
    public void setup() {
        car = new Car();
        charger = new Charger();
    }


    @Test
    public void checkThatCarCanBeInstantiated(){
        assertThat(car).isNotNull();
    }



    @Test
    public void checkThatCarHasNoNullProperties() {
        car.setModel("Lada");
        car.setGear(Gear.DRIVE);
        assertThat(car).hasNoNullFieldsOrProperties();
    }


    @Test
    public void checkThatCarHasPropertyHeadlightsOn() {
        assertThat(car.getLightSystem().isHeadlights()).isFalse();
    }

    @Test
    public void checkThatCarCanTurnOnLights() {
        car.getLightSystem().setHeadlights(true);

        assertThat(car.getLightSystem().isHeadlights()).isTrue();
    }


    @Test
    public void checkThatCarCanTurnOffLights() {

        car.getLightSystem().setHeadlights(false);
        assertThat(car.getLightSystem().isHeadlights()).isFalse();
    }


    @Test
    public void checkThatCarHasHighBeam() {
        car.getLightSystem().setHighBeam(true);
        assertThat(car.getLightSystem().isHighBeam()).isTrue();
    }

    @Test
    public void checkThatCarHasLowBeam() {
        car.getLightSystem().setLowBeam(true);
        assertThat(car.getLightSystem().isLowBeam()).isTrue();
    }
    @Test
    public void checkThatCarHasBackLights() {
        car.getLightSystem().setBackLights(true);
        assertThat(car.getLightSystem().isBackLights()).isTrue();
    }
    @Test
    public void checkThatEngineIsOn() {
        car.setIgnition(true);
        assertThat(car.isIgnition()).isTrue();
    }

    @Test
    public void checkAllLightsAreOff() {
        car.turnOffLights(car.isIgnition());
        assertThat(car.getLightSystem().isLowBeam()).isFalse();
        assertThat(car.getLightSystem().isBackLights()).isFalse();
        assertThat(car.getLightSystem().isHighBeam()).isFalse();
        assertThat(car.getLightSystem().isHeadlights()).isFalse();
    }

    @Test
    public void checkThatHazardLightsWorkWhileEngineIsOff() {
        car.getLightSystem().setHazardLights(true);
        assertThat(car.getLightSystem().isHazardLights()).isTrue();
    }

    @Test
    public void checkThatSpeedCanIncrease() {
        var initialSpeed = car.getCurrentSpeed();
        car.throttle(50);
        var changedSpeed = car.getCurrentSpeed();
        assertThat(initialSpeed).isLessThan(changedSpeed);
    }

    @Test
    public void checkThatSpeedCantGoAbove180() {
        car.setGear(Gear.DRIVE);
        car.throttle(99999);
        var maxSpeed = car.getCurrentSpeed();
        assertThat(maxSpeed).isEqualTo(180);
    }

    @Test
    public void checkThatCarCanStop() {
        car.throttle(99999);
        car.brake(180);
        var currentSpeed = car.getCurrentSpeed();
        assertThat(currentSpeed).isEqualTo(0);
    }


    @Test
    public void checkThatCarIsInDrive(){
        car.setGear(Gear.DRIVE);
        assertThat(car.getGear())
                .isNotNull()
                .isEqualTo(Gear.DRIVE);
    }

    @Test
    public void testThatWhenCarBrakesTheBrakeLightTurnsOn() {
        car.brake(20);

        assertThat(car.getLightSystem().isBrakeLights()).isTrue();
    }

    @Test
    public void testThatCarCanBrakeInReverse() {
        car.setGear(Gear.REVERSE);
        car.throttle(20);
        car.brake(20);
        assertThat(car.getCurrentSpeed()).isEqualTo(0);
    }

    @Test
    public void testThatBatteryChargeIs985() {
        car.setGear(Gear.DRIVE);
        car.throttle(15);

        assertThat(car.getBattery().getCharge()).isEqualTo(985);
    }

    @Test
    public void testThatLightsExpendCharge() {
        car.getLightSystem().setHeadlights(true);
        car.getLightSystem().setLowBeam(true);
        car.getLightSystem().setHighBeam(true);
        car.getLightSystem().setBrakeLights(true);
        car.getLightSystem().setBackLights(true);

        assertThat(car.getBattery().getCharge()).isEqualTo(995);
    }

    @Test
    public void testThatCarCantThrottleWhenNoCharge() {
        car.getBattery().setCharge(14);
        car.throttle(20);

        assertThat(car.getCurrentSpeed()).isEqualTo(0);
    }

    @Test
    public void testThatBatteryShutDownProcedureTurnsOffTheLights() {
        car.getBattery().setCharge(2);
        car.getBattery().expendCharge();
        car.getLightSystem().setHazardLights(true);

        assertAll(
                () -> assertThat(car.getLightSystem().isHeadlights()).isFalse(),
                () -> assertThat(car.getLightSystem().isBackLights()).isFalse(),
                () -> assertThat(car.getLightSystem().isLowBeam()).isFalse(),
                () -> assertThat(car.getLightSystem().isBrakeLights()).isFalse(),
                () -> assertThat(car.getLightSystem().isHighBeam()).isFalse()
        );

        assertThat(car.getLightSystem().isHazardLights()).isTrue();
    }


    @Test
    public void testThatChargerCanBeInstantiated() {
        Charger charger = new Charger();
        assertThat(charger).isNotNull();
    }


    @Test
    public void testThatBatteryCanBeCharged() {
        charger.setCar(car);
        car.getBattery().setCharge(500);
        charger.charge();
        assertThat(car.getBattery().getCharge()).isEqualTo(1000);
    }

    @Test
    public void testThatCarsCanBeAddedToCharger() {
        charger.setCar(car);

        assertThat(charger.getCar()).isNotNull();
    }

    @Test
    public void testThatIterationReturnsCorrectly() {
        car.getBattery().setCharge(100);
        charger.setCar(car);
        var iterations = charger.charge();
        assertThat(iterations).isEqualTo(90);
    }

}
