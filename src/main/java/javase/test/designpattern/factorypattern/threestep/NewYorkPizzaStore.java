package javase.test.designpattern.factorypattern.threestep;


import javase.test.designpattern.factorypattern.threestep.impl.CheesePizza;

public class NewYorkPizzaStore extends PizzaStore {

    private PizzaIngredientFactory ingredientFactory;

    public NewYorkPizzaStore(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public Pizza pizzaFactoryMethod(String type) {

        Pizza pizza = null;
        if (type.equals("chess")) {
            pizza = new CheesePizza(ingredientFactory);
        }

        return pizza;
    }
}
