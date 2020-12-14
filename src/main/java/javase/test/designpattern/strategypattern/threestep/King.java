package javase.test.designpattern.strategypattern.threestep;

import javase.test.designpattern.strategypattern.threestep.impl.BowAndArrowBehavior;

public class King extends Character {

    @Override
    public void fight() {

        setWeaponBehavior(new BowAndArrowBehavior());
        performWeapon();
    }
}
