package design_patterns_practice.Pattern_1_Observer;


public class StatsDisplay implements Observer, DisplayElement {
    private boolean isFirstUpdate = true;
    private float minTemperature;
    private float maxTemperature;
    private float minHumidity;
    private float maxHumidity;
    private float minPressure;
    private float maxPressure;
    private double heatIndex;
    private Subject weatherData;


    public StatsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void display() {
        System.out.println(String.format("Stats: min temperature: %f and max temperature: %f F degrees, minHumidity %f , " +
                "max humidity %f, min pressure %f , max pressure %f", minTemperature, maxTemperature, minHumidity,
                maxHumidity, minPressure, maxPressure));
        System.out.println(String.format("Heat index: %f", heatIndex));
    }

    public void update(float temperature, float humidity, float pressure) {
        analiseTemperature(temperature);
        analiseHumidity(humidity);
        analisePressure(pressure);
        calculateHeatIndex(temperature, humidity);
        display();
        isFirstUpdate = false;
    }

    private void analiseTemperature(float temperature) {
        if(temperature > maxTemperature) {
            maxTemperature = temperature;
        }

        if(isFirstUpdate) {
            minTemperature = temperature;
        } else {
            if(temperature < minTemperature) {
                minTemperature = temperature;
            }
        }
    }

    private void analiseHumidity(float humidity) {
        if(humidity > maxHumidity) {
            maxHumidity = humidity;
        }

        if(isFirstUpdate) {
            minHumidity = humidity;
        } else {
            if(humidity < minHumidity) {
                minHumidity = humidity;
            }
        }
    }

    private void analisePressure(float pressure) {
        if(pressure > maxPressure) {
            maxPressure = pressure;
        }

        if(isFirstUpdate) {
            minPressure = pressure;
        } else {
            if(pressure < minPressure) {
                minPressure = pressure;
            }
        }
    }

    private void calculateHeatIndex(float T, float RH) {
        double result = 16.923 + 1.85212 * Math.pow(10, -1) * T + 5.37941 * RH - 1.00254 * Math.pow(10, -1) * T *
                RH + 9.41695 * Math.pow(10, -3) * Math.pow(T, 2) + 7.28898 * Math.pow(10, -3) *  Math.pow(RH, 2) + 3.45372 * Math.pow(10, -4) * Math.pow(T, 2)
                * RH - 8.14971 * Math.pow(10, -4) * T * Math.pow(RH, 2) + 1.02102 * Math.pow(10, -5) * Math.pow(T, 2) * Math.pow(RH, 2) - 3.8646 *
                Math.pow(10, -5) * Math.pow(T, 3) + 2.91583 * Math.pow(10, -5) * Math.pow(RH, 3) + 1.42721 * Math.pow(10, -6) * Math.pow(T, 3) * RH + 1.97483
                *  Math.pow(10, -7) * T *  Math.pow(RH, 3) - 2.18429 *  Math.pow(10, -8) * Math.pow(T, 3) *  Math.pow(RH, 2) + 8.43296 *  Math.pow(10, -10) * Math.pow(T, 2) *
                Math.pow(RH, 3) - 4.81975 *  Math.pow(10, -11) * Math.pow(T, 3) *  Math.pow(RH, 3);
        this.heatIndex = result;
    }
}
