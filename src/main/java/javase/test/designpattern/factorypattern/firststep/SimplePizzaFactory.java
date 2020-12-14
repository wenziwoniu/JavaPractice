package javase.test.designpattern.factorypattern.firststep;

/**
 * 简单工厂模式
 */
public class SimplePizzaFactory implements PizzaFactory {

    public Pizza createPizza(String type) {

        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("")) {
            pizza = new ClamPizza();
        }

        return pizza;
    }
}
