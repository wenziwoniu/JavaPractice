package javase.test.designpattern.factorypattern.threestep.impl;


import javase.test.designpattern.factorypattern.threestep.Pizza;
import javase.test.designpattern.factorypattern.threestep.PizzaIngredientFactory;

public class CheesePizza extends Pizza {

    private PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {

        ingredientFactory.createClams();
        ingredientFactory.createDough();

    }
}
