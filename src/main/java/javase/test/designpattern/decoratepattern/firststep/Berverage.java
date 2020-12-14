package javase.test.designpattern.decoratepattern.firststep;

public class Berverage {

    protected String description;
    private boolean milk;
    private boolean soy;

    public String getDescription() {
        return this.description;
    }

    public Double cost() {

        double milkPrice = hasMilk() ? 10D : 0;
        double soyPrice = hasSoy() ? 20D : 0;

        return milkPrice + soyPrice;
    }

    public boolean hasMilk() {
        return this.milk;
    }

    public boolean hasSoy() {
        return this.soy;
    }

}
