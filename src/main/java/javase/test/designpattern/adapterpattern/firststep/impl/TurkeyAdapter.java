package javase.test.designpattern.adapterpattern.firststep.impl;

import javase.test.designpattern.adapterpattern.firststep.Duck;
import javase.test.designpattern.adapterpattern.firststep.Turkey;

public class TurkeyAdapter implements Duck {

    private Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {

        this.turkey.gobble();
    }
}
