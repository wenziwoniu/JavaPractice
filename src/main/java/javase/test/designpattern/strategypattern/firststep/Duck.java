package javase.test.designpattern.strategypattern.firststep;

public abstract class Duck {

    public void quack() {

    }

    public void swim() {

    }

    /**
     * 每个子类做各自具体的展示
     */
    public abstract void display();

    /**
     * 飞行行为
     * 会导致所有的子类都具有飞行行为，这不是期望的效果
     *
     */
    public abstract void fly();

}
