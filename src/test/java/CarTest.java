
import org.example.model.Car;
import org.example.model.Gear;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {
    Car car;

    @BeforeEach
    public void setup() {
        car = new Car();

    }


    @Test
    public void checkThatCarCanBeInstantiated(){
        assertThat(car).isNotNull();
    }



    @Test
    public void checkThatCarHasNoNullProperties() {
        car.setModel("Lada");
        assertThat(car).hasNoNullFieldsOrProperties();
    }


    @Test
    public void checkThatCarHasPropertyHeadlightsOn() {
        assertThat(car.isHeadlights()).isFalse();
    }

    @Test
    public void checkThatCarCanTurnOnLights() {
        car.setHeadlights(true);
        assertThat(car.isHeadlights()).isTrue();
    }

    @Test
    public void checkThatCarCanTurnOffLights() {
        car.setHeadlights(false);
        assertThat(car.isHeadlights()).isFalse();
    }

    @Test
    public void checkThatCarHasHighBeam() {
        car.setHighBeam(true);
        assertThat(car.isHighBeam()).isTrue();
    }

    @Test
    public void checkThatCarHasLowBeam() {
        car.setLowBeam(true);
        assertThat(car.isLowBeam()).isTrue();
    }

    @Test
    public void checkThatCarHasBackLights() {
        car.setBackLights(true);
        assertThat(car.isBackLights()).isTrue();
    }

    @Test
    public void checkThatEngineIsOn() {
        car.setIgnition(true);
        assertThat(car.isIgnition()).isTrue();
    }

    @Test
    public void checkAllLightsAreOff() {
        car.turnOffLights(car.isIgnition());
        assertThat(car.isLowBeam()).isFalse();
        assertThat(car.isBackLights()).isFalse();
        assertThat(car.isHighBeam()).isFalse();
        assertThat(car.isHeadlights()).isFalse();
    }

    @Test
    public void checkThatHazardLightsWorkWhileEngineIsOff() {
        car.setHazardLights(true);
        assertThat(car.isHazardLights()).isTrue();
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
        car.throttle(99999);
        var maxSpeed = car.getCurrentSpeed();
        assertThat(maxSpeed).isEqualTo(180);
    }

    @Test
    public void checkThatCarCanStop() {
        car.throttle(99999);
        car.decreaseSpeed(180);
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


}
