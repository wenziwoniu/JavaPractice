package javase.test.designpattern.templatemethodpattern.firststep;

public class Tea extends CoffeineBeverage {
    @Override
    public void prepareRecipe() {

        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();

    }

    public void steepTeaBag() {

    }

    public void addLemon() {

    }

}
