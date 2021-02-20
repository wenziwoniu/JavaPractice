package javase.test.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericArray {

    public static void main(String[] args) {

        String[] str = new String[10];
        List[] liststr = new ArrayList[10];

//        List<String>[] ls = new ArrayList<String>[10];
//        List<String>[] ls3 = new List<String>[10];
        List<?>[] ls2 = new ArrayList<?>[10];
    }

    public static void testCorrect() {

        List<?>[] lsa = new List<?>[10]; // OK, array of unbounded wildcard type.
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
        oa[1] = li; // Correct.
        Integer i = (Integer) lsa[1].get(0); // OK
    }
}
