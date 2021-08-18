package smarthome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThermostatTest {

    @Test
    @DisplayName("Heating mode, low temp")
    void thermostatTurnsOnWhenHeatingAndTempIsLow() {
        // arrange
        ModeSwitch modeSwitch = new ModeSwitchStub();
        HeatControllerSpy heatController = new HeatControllerSpy();
        Thermometer thermometer = new ThermometerStub();
        Thermostat thermostat = new Thermostat(modeSwitch, heatController, null, thermometer);

        // act
        thermostat.run(74.0f);

        // assert
        assertEquals(heatController.timesCalled, 1);
    }

    //    @Test
    void TurnsOnAirConditionerIfTooHot() {
        ModeSwitch modeSwitch = new ModeSwitchStub();


    }
}