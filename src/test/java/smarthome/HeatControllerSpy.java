package smarthome;

public class HeatControllerSpy implements HeatController {
    public int timesCalled = 0;

    @Override
    public void turnOn() {
        timesCalled++;
    }

    @Override
    public void turnOff() {

    }
}
