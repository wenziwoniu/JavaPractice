package javase.test.designpattern.factorypattern.threestep;


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
