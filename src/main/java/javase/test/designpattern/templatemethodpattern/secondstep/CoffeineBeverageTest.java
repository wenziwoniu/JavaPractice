package javase.test.designpattern.templatemethodpattern.secondstep;

public class CoffeineBeverageTest {

    public static void main(String[] args) {

        Coffee coffee = new Coffee();
        coffee.prepareRecipe();

        Tea tea = new Tea();
        tea.prepareRecipe();

        // 或者
        CoffeineBeverage coffeineBeverage = new Coffee();
        coffeineBeverage.prepareRecipe();

        CoffeineBeverage teaBeverage = new Tea();
        teaBeverage.prepareRecipe();
    }
}
