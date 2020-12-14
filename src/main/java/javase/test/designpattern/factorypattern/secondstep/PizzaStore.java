package javase.test.designpattern.factorypattern.secondstep;

import javase.test.designpattern.factorypattern.firststep.Pizza;
import javase.test.designpattern.factorypattern.firststep.PizzaFactory;

public abstract class PizzaStore {


    public Pizza orderPizza(String type) {

        Pizza pizza = pizzaFactoryMethod(type);
        return pizza;
    }

    /**
     * 工厂方法   由子类生产实际的Pizza
     * @param type
     * @return
     */
    public abstract Pizza pizzaFactoryMethod(String type);
}
