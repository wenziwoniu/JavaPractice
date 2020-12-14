package javase.test.designpattern.strategypattern.secondstep;


import javase.test.designpattern.strategypattern.secondstep.impl.FlyWithWings;
import javase.test.designpattern.strategypattern.secondstep.impl.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {

        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();

    }
}
