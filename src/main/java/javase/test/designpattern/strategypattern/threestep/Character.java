package javase.test.designpattern.strategypattern.threestep;

public abstract class Character {

    private WeaponBehavior weaponBehavior;

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }

    public abstract void fight();

    public void performWeapon() {

        weaponBehavior.useWeapon();
    }
}
