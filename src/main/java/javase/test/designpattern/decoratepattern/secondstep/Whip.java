package javase.test.designpattern.decoratepattern.secondstep;

public class Whip extends CondimentDecorator {

    private Beverage beverage;

    public Whip(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "," + "Whip";
    }

    @Override
    public double cost() {
        return 2 + beverage.cost();
    }
}
