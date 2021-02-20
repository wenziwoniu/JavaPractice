package javase.test.reflect;

public class ReflectTest {

    public static void main(String[] args) {

        ReflectInterface reflectInterface = new ReflectClass();
        ReflectClass reflectClass = new ReflectClass();

        System.out.println(reflectInterface.getClass().getName());
        System.out.println(reflectClass.getClass().getName());

        System.out.println(ReflectInterface.class.getName());
        System.out.println(ReflectClass.class.getName());
    }
}
