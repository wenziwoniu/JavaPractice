package javase.test.designpattern.decoratepattern.firststep;

public class DarkRoast extends Berverage {

    public DarkRoast() {
        this.description = "DarkRost";
    }

    @Override
    public Double cost() {

        return 20D + super.cost();
    }

}
