package javase.test.designpattern.decoratepattern.secondstep;

public class Test {

    public static void main(String[] args) {

        Beverage beverage = new Whip(new Milk(new DarkRoast()));
        beverage.getDescription();
        beverage.cost();
    }
}
