package javase.test.reflect;

import java.lang.reflect.*;

class Shape{
    public void draw() {
        System.out.println("draw");
    }

    public void draw(int count,String name) {
        System.out.println("draw" + name + ",count=" + count);
    }
}


class Circle extends Shape{
    private void drawCircle() {
        System.out.println("drawCircle");
    }

    public int getAllCount() {
        return 100;
    }

}

public class ReflectMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
        Class clazz = Class.forName("Circle");

        //返回一个 Method 对象，它反映此 Class 对象所表示的类或接口的public方法，包括继承的方法
        Method method = clazz.getMethod("draw", int.class,String.class);
        System.out.println("method:" + method);
        System.out.println("-----------------------------------------");


        //返回一个包含某些 Method 对象的数组，这些对象反映此 Class 对象所表示的类或接口（包括那些由该类或接口声明的以及从超类和超接口继承的那些的类或接口）的所有public方法
        Method[] methods = clazz.getMethods();
        for(Method m:methods) {
            System.out.println("method:" + m);
        }
        System.out.println("-----------------------------------------");


        //返回一个指定参数的Method对象，该对象反映此 Class 对象所表示的类或接口的方法，该方法可以是公共、保护、默认（包）访问或者私有方法，但不可以是继承的方法
        Method method1 = clazz.getDeclaredMethod("drawCircle");
        System.out.println("method:" + method1);
        System.out.println("-----------------------------------------");

        //返回 Method 对象的一个数组，这些对象反映此 Class 对象表示的类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法
        Method[] methods1 = clazz.getDeclaredMethods();
        for(Method m:methods1) {
            System.out.println("method:" + m);
        }
        System.out.println("-----------------------------------------");



    }
}
