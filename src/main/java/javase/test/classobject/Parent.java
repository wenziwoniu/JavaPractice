package javase.test.classobject;

public class Parent extends Ancestor implements InterfaceExample2 {

    private String address;
    public String privince;
    protected String city;

    public String getName() {
        return "a";
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String getPrivince() {
        return this.privince;
    }
}
