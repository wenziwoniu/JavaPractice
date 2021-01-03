package javase.test.designpattern.compositepattern;

public class MenuTestDriver {

    public static void main(String[] args) {

        MenuCompoment pancakeHourseMenu = new Menu();
        MenuCompoment dinerMenu = new Menu();
        MenuCompoment dessertMenu = new Menu();

        MenuCompoment allMenu = new Menu();
        allMenu.add(pancakeHourseMenu);
        allMenu.add(dinerMenu);

        dinerMenu.add(new MenuItem());
        dinerMenu.add(dessertMenu);

    }
}
