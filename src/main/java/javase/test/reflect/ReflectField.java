package javase.test.reflect;

import java.lang.reflect.*;

class Person{
    public int age;
    public String name;
}

class Student extends Person{
    public String desc;
    private int score;
    private static String address;
}


public class ReflectField {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Student.class;

        //获取指定name名称、具有public修饰的字段，包含继承字段
        Field field = clazz.getField("age");
        System.out.println("field：" + field);
        System.out.println("-----------------------");

        //获取修饰符为public的字段，包含继承字段
        Field[] fields = clazz.getFields();
        for(Field f:fields) {
            System.out.println("field：" + f);
        }
        System.out.println("-----------------------");


        //获取指定name名称的(包含private修饰的)字段，不包括继承的字段
        Field field2 = clazz.getDeclaredField("desc");
        System.out.println("field2：" + field2);
        System.out.println("-----------------------");

        //获取Class对象所表示的类或接口的所有(包含private修饰的)字段,不包括继承的字段
        Field[] fields2 = clazz.getDeclaredFields();
        for(Field f:fields2) {
            System.out.println("field：" + f);
        }
        System.out.println("-----------------------");


        // 对字段进行操作
        Student student = (Student) clazz.newInstance();
        Field descField = clazz.getDeclaredField("desc");
        descField.setAccessible(true);
        descField.set(student, "i am wang");

        System.out.println(descField.get(student));
    }

}
