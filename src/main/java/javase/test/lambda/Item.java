package javase.test.lambda;

public class Item {

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Item() {

    }

    public Item(int id, String name, double price) {

    }

    public Item(String name, String price) {
        this.name = name;
        this.address = price;
    }


}
