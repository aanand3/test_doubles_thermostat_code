package smarthome;

public class ModeSwitchStub implements ModeSwitch {

    @Override
    public Mode currentMode() {
        return Mode.HEAT;
    }
}
