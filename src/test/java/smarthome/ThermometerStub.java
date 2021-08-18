package smarthome;

public class ThermometerStub implements Thermometer {

    @Override
    public float currentTemp() {
        return 60;
    }
}
