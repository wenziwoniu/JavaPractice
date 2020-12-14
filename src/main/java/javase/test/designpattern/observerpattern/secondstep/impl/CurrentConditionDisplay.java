package javase.test.designpattern.observerpattern.secondstep.impl;

import javase.test.designpattern.observerpattern.secondstep.DisplayElement;
import javase.test.designpattern.observerpattern.secondstep.Observer;
import javase.test.designpattern.observerpattern.secondstep.Subject;

public class CurrentConditionDisplay implements Observer, DisplayElement {

    private float temp;
    private float humidity;
    private float pressure;

    private Subject subject;

    public CurrentConditionDisplay(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void display() {

    }

    @Override
    public void update(float temp, float humidity, float pressure) {

        this.temp = temp;
        display();

    }
}
