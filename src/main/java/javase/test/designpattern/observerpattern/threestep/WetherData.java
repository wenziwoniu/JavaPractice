package javase.test.designpattern.observerpattern.threestep;

import javase.test.designpattern.observerpattern.secondstep.Observer;
import javase.test.designpattern.observerpattern.secondstep.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * 错误示范
 */
public class WetherData extends Observable {

    public float getTemp() {
        return temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    private float temp;
    private float humidity;
    private float pressure;



    public void measurementsChanged() {

        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temp, float humidity, float pressure) {

        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsChanged();
    }
}
