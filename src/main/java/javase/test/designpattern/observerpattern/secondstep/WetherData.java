package javase.test.designpattern.observerpattern.secondstep;

import java.util.ArrayList;
import java.util.List;

/**
 * 错误示范
 */
public class WetherData implements Subject {

    private float temp;
    private float humidity;
    private float pressure;

    private List<Observer> observers;

    public WetherData() {
        observers = new ArrayList<>();
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {

        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        observers.forEach(observer -> observer.update(temp, humidity, pressure));
    }

    public void measurementsChanged() {

        notifyObservers();
    }

    public void setMeasurements(float temp, float humidity, float pressure) {

        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsChanged();
    }
}
