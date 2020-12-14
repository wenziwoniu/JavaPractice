package javase.test.designpattern.strategypattern.secondstep;

public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        // 将飞行行为委托(delegate)给FlyBehavior 具体的给FlyBehavior实例由Duck的子类指定
        flyBehavior.fly();
    }

    /**
     * 子类中可以根据不同条件设置不同FlyBehavior的实例
     * @param flyBehavior
     */
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
