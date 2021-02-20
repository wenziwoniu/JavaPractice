package javase.test.generic;

import java.util.*;

class Tbin<T> extends ArrayList<T> {}
class TbinList<T> extends ArrayList<Tbin<T>> {}
class TbinList2<T> extends ArrayList<Tbin<? extends T>> {}

class Base {}
class Derived extends Base {}

public class Test3 {


    public static void main(String[] args) {
        ArrayList<Tbin<? extends Base>> test = new ArrayList<>();
        test.add(new Tbin<Derived>());

        TbinList<? extends Base> test2 = new TbinList<>();
//        test2.add(new Tbin<Derived>());

        TbinList2<Base> test3 = new TbinList2();
        test3.add(new Tbin<Derived>());
    }

    public void callTest() {

        Object object = null;
        test((Thread) object);
    }

    public void test(Thread thread) {

    }
}
