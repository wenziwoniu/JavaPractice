package javase.test.designpattern.factorypattern.threestep.impl;

import javase.test.designpattern.factorypattern.threestep.Clams;
import javase.test.designpattern.factorypattern.threestep.Dough;
import javase.test.designpattern.factorypattern.threestep.PizzaIngredientFactory;

public class BjPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return null;
    }

    @Override
    public Clams createClams() {
        return null;
    }
}
