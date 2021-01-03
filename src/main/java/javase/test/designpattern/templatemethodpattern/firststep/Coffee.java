package javase.test.designpattern.templatemethodpattern.firststep;

public class Coffee extends CoffeineBeverage {

    @Override
    public void prepareRecipe() {

        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }

    public void brewCoffeeGrinds() {

    }

    public void addSugarAndMilk() {

    }

}
