package javase.test.classobject;

public class ClassObjectStudent extends Parent implements InterfaceExample1 {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    public String sex;
    protected String age;

    private String getSex() {
        return this.sex;
    }

    protected String getAge() {
        return this.age;
    }

    private static void test() {

    }

    public static void test1() {

    }

    @Override
    public void test3() {

    }
}
