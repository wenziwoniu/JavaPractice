package javase.test.classobject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassObjectDemo {

    public static void main(String[] args) {

//        basicTypeClassObject();
//        classObjectMethod();
//        otherMethodClassObject();

        ClassObjectStudent classObjectStudent = new ClassObjectStudent();

        testExtend(classObjectStudent);
    }

    public static void testExtend(Object object) {
        if (object instanceof Parent) {
            System.out.println("abc");
        }
        if (object instanceof ClassObjectStudent) {
            System.out.println("abcdef");
        }

        if (ClassObjectStudent.class.isInstance(object)) {
            System.out.println("ddddd");
        }

        if (Parent.class.isInstance(object)) {
            System.out.println("EEEEEE");
        }
    }

    /**
     * 相同类加载器加载的同一个类的class对象是相同的
     */
    private static void demo() {

        try {
            // 会对类进行初始化(不是指对象的初始化)
            Class studentClass = Class.forName("javase.test.classobject.ClassObjectStudent");
            // 不会对类进行初始化 因为通过字面量的方法获取Class对象的引用不会自动初始化该类
            Class another = ClassObjectStudent.class;
            ClassObjectStudent classObjectStudent = new ClassObjectStudent();
            Class second = classObjectStudent.getClass();
            System.out.println("abcd");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void basicTypeClassObject() {

        Class<?> intClass = int.class;
        Class integerClass = Integer.class;
        Class priClass = Integer.TYPE;
    }

    /**
     * Class对象的方法含义
     */
    private static void classObjectMethod() {

        try {
            Class studentClass = Class.forName("javase.test.classobject.ClassObjectStudent");
            String name = studentClass.getName();
            String simpleName = studentClass.getSimpleName();
            String canonicalName = studentClass.getCanonicalName();

            String intName = int.class.getName();
            int[] intArray = new int[1];
            System.out.println(intArray.getClass().getName());
            System.out.println(intArray.getClass().getSimpleName());

            System.out.println(studentClass.isInterface());
            System.out.println(studentClass.getInterfaces());
            System.out.println("end");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void otherMethodClassObject() {

        try {
            Class studentClass = ClassObjectStudent.class;
            Class[] interfaceArray = studentClass.getInterfaces();
            Class parentClass = studentClass.getSuperclass();
            Class test = parentClass.getSuperclass();

            // 返回一个Object对象，是实现“虚拟构造器”的一种途径。使用该方法创建的类，必须带有无参的构造器。
            ClassObjectStudent classObjectStudent = (ClassObjectStudent) studentClass.newInstance();

            // 获得某个类的所有的公共（public）的字段，包括继承自父类[包括父类的父类，依次类推][包括实现的接口]的所有公共字段。 类似的还有getMethods和getConstructors。
            Field[] fields = studentClass.getFields();
            // 获得某个类的自己声明的字段，即包括public、private和proteced，默认但是不包括父类声明的任何字段。类似的还有getDeclaredMethods和getDeclaredConstructors。
            Field[] declareFields = studentClass.getDeclaredFields();
            Field nameFiled = studentClass.getField("sex");

            Method[] methods = studentClass.getMethods();
            Method[] declareMethods = studentClass.getDeclaredMethods();

            System.out.println("end");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


        private  class inner{
        }
        public static void test () {
            //普通类
            System.out.println(ClassObjectDemo.class.getSimpleName()); //Test
            System.out.println(ClassObjectDemo.class.getName()); //com.cry.Test
            System.out.println(ClassObjectDemo.class.getCanonicalName()); //com.cry.Test
            //内部类
            System.out.println(inner.class.getSimpleName()); //inner
            System.out.println(inner.class.getName()); //com.cry.Test$inner
            System.out.println(inner.class.getCanonicalName()); //com.cry.Test.inner
            //数组
//            System.out.println(args.getClass().getSimpleName()); //String[]
//            System.out.println(args.getClass().getName()); //[Ljava.lang.String;
//            System.out.println(args.getClass().getCanonicalName()); //java.lang.String[]
            //我们不能用getCanonicalName去加载类对象，必须用getName
            //Class.forName(inner.class.getCanonicalName()); 报错
//            Class.forName(inner.class.getName());
        }


}
