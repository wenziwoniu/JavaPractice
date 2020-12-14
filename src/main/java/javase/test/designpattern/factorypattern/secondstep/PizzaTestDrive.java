package javase.test.designpattern.factorypattern.secondstep;

import javase.test.designpattern.factorypattern.firststep.Pizza;

public class PizzaTestDrive {

    public static void main(String[] args) {

        PizzaStore nyStore = new NewYorkPizzaStore();
        Pizza pizza = nyStore.orderPizza("cheese");
    }
}
