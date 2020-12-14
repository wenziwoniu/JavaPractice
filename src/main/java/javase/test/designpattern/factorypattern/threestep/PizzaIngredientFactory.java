package javase.test.designpattern.factorypattern.threestep;

/**
 * 抽象工厂
 */
public interface PizzaIngredientFactory {

    public Dough createDough();
    public Clams createClams();

}
