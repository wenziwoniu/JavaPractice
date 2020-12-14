package javase.test.designpattern.observerpattern.threestep;

import javase.test.designpattern.observerpattern.secondstep.DisplayElement;
import javase.test.designpattern.observerpattern.secondstep.Subject;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {

    private float temp;
    private float humidity;
    private float pressure;

    private Observable observable;

    public CurrentConditionDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

        WetherData wetherData = (WetherData) o;
        this.temp = wetherData.getTemp();
        display();
    }

    @Override
    public void display() {

    }

}
