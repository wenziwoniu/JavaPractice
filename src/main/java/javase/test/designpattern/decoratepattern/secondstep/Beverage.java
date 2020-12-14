package javase.test.designpattern.decoratepattern.secondstep;

public abstract class Beverage {

    public String getDescription() {
        return description;
    }

    protected String description;

    public abstract double cost();
}
