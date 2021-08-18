package smarthome;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpClient;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        var localServer = new URL("http://localhost:8080");
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpModeSwitch modeSwitch = new HttpModeSwitch(localServer, httpClient);
        HttpHeatController heatController = new HttpHeatController(localServer);
        HttpAirConditioningController airConditioningController = new HttpAirConditioningController(localServer);
        HttpThermometer thermometer = new HttpThermometer(localServer);
        var thermostat = new Thermostat(
                modeSwitch,
                heatController,
                airConditioningController,
                thermometer
        );

        while(true) {
            thermostat.run(72.0f);
        }
    }
}
