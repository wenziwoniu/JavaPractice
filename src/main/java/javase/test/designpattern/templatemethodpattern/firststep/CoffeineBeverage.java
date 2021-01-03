package javase.test.designpattern.templatemethodpattern.firststep;

public abstract class CoffeineBeverage {

    /**
     * 定义抽象方法 子类实现该方法
     */
    public abstract void prepareRecipe();

    /**
     * 子类共用该方法
     */
    public void boilWater() {

    };

    /**
     * 子类共用该方法
     */
    public void pourInCup() {

    };

}
