package javase.test.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class G<T1,T2,T3> {

    private T1 name;
    private T2 age;
    private T3 sex;

    public static void main(String[] args) {

        G<String, Integer, Boolean> g = new G<>();
        printInfo2(g);

        G g2 = new G();
        printInfo2(g2);

        List list = new ArrayList();
        list.add(2L);

        List<String> list2 = new ArrayList<>();

        printInfo3(list);
        printInfo3(list2);
    }

    public static void printInfo(G<String, Integer, Boolean> g) {

    }

    public static void printInfo2(G g) {

    }

    public static void printInfo3(List<String> list) {

    }

    void f(HashMap map) {
        map.put("key", "value");
    }
}
