package javase.test.generic;

import java.util.List;

public class GenericWildcard {

    public static void main(String[] args) {

        Generic<Number> gNumber = new Generic<Number>(1);
        Generic<Integer> gInteger = new Generic<Integer>(2);
        Generic<Long> gLong = new Generic<Long>(3L);
        showKeyValue1(gNumber);
//        showKeyValue1(gInteger);

        showKeyValue2(gNumber);
        showKeyValue2(gInteger);
        showKeyValue2(gLong);

        showKeyValue3(gNumber);
        showKeyValue3(gInteger);
        showKeyValue3(gLong);

        showKeyValue4(gInteger);
        showKeyValue4(gNumber);
//        showKeyValue4(gLong);

        showKeyValue5(gInteger);
    }

    public static void showKeyValue1(Generic<Number> obj) {
//        obj.getKey().get
        System.out.println(obj.getKey() instanceof Number);
//        System.out.println("泛型通配符测试" +  obj.getKey());
    }

    public static void showKeyValue2(Generic<?> obj) {
//        System.out.println("2" + (obj.getKey() instanceof Number));
        System.out.println("2" + (obj.getKey().getClass().getName()));
//        System.out.println("泛型通配符测试" +  obj.getKey());
    }

    public static void showKeyValue3(Generic<? extends Number> obj) {
//        System.out.println("泛型通配符测试" +  obj.getKey());
    }

    public static void showKeyValue4(Generic<? super Integer> obj) {
//        System.out.println("泛型通配符测试" +  obj.getKey());
    }



    public static void showKeyValue5(Generic obj) {

//        obj.getKey()
//        obj.getKey().hashCode()
       System.out.println("5" + (obj.getKey() instanceof Number));
       System.out.println("5" + (obj.getKey().getClass().getName()));
//       System.out.println("泛型通配符测试" +  obj.getKey());
    }
}

class Generic<T> {

    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public void setCollect(List<T> list) {

    }

    public T getKey() {
        return this.key;
    }

    public void setKey(T key) {
        this.key = key;
    }

}
