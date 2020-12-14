package javase.test.designpattern.decoratepattern.secondstep;

public class Milk extends CondimentDecorator {

    private Beverage beverage;

    public Milk(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public double cost() {

        double price = beverage.cost();
        return 1 + price;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "," + "milk";
    }

}
