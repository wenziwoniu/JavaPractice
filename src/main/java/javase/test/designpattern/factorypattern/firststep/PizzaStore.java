package javase.test.designpattern.factorypattern.firststep;

public class PizzaStore {

    private PizzaFactory pizzaFactory;

    public PizzaStore(PizzaFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;
    }

    public Pizza orderPizza(String type) {

        Pizza pizza = pizzaFactory.createPizza(type);
        return pizza;
    }
}
