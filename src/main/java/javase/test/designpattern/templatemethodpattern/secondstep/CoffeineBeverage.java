package javase.test.designpattern.templatemethodpattern.secondstep;

public abstract class CoffeineBeverage {

    /**
     * 方法被声明为final,因为我们不希望子类覆盖这个方法
     */
    public final void prepareRecipe() {

        boilWater();
        brew();
        pourInCup();
        addCondiments();
    };

    public abstract void brew();
    public abstract void addCondiments();

    // 不希望子类覆盖该方法
    public final void boilWater() {

    };

    public void pourInCup() {

    };

}
