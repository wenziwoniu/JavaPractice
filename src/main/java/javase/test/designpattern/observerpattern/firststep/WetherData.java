package javase.test.designpattern.observerpattern.firststep;

/**
 * 错误示范
 */
public abstract class WetherData {

    public abstract Float getTemperature();
    public abstract Float getHumidity();
    public abstract Float getPressure();

    public void measurementsChanged() {

        float temp = getTemperature();
        float humidity = getHumidity();
        float pressure = getPressure();

        // 更新布告板
//        currentConditionsDisplay.update(temp, humidity, pressure);
//        statisticsDisplay.update(temp, humidity, pressure);
//        forecastDisplay.update(temp, humidity, pressure);
    }


}
