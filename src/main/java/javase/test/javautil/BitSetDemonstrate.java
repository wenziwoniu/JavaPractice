package javase.test.javautil;

import org.junit.Test;

import java.util.BitSet;

public class BitSetDemonstrate {

    @Test
    public void test1() {

        BitSet bitSet = new BitSet();
        System.out.println("size:" + bitSet.size());
        System.out.println("length:" + bitSet.length());

        BitSet bitSet2 = new BitSet(128);
        System.out.println("size:" + bitSet2.size());
        System.out.println("length:" + bitSet2.length());
        bitSet2.set(5);
        System.out.println(bitSet2.get(5));
        System.out.println(bitSet2.length());
        bitSet2.set(10, false);
    }

    @Test
    public void test2() {

        BitSet bitSet = new BitSet();
        bitSet.set(3);
        System.out.println(bitSet.get(3));
        System.out.println(bitSet.get(400));

        System.out.println(bitSet.length());

        bitSet.set(10, false);
        System.out.println(bitSet.length());
        System.out.println(bitSet.get(10));

        bitSet.set(100);
        System.out.println(bitSet.length());
    }

    @Test
    public void test3() {

//        BitSet bitSet = new BitSet();
//        System.out.println(bitSet.size());
//        System.out.println(bitSet.length());
//        bitSet.set(0);
//        System.out.println(bitSet.get(0));

        BitSet bitSet2 = new BitSet(125);
        System.out.println(bitSet2.size());
        System.out.println(bitSet2.length());

        bitSet2.set(121);
        System.out.println(bitSet2.get(121));
        System.out.println(bitSet2.size());
        System.out.println(bitSet2.length());

        System.out.println("-------------------");
        bitSet2.set(321);
        System.out.println(bitSet2.get(321));
        System.out.println(bitSet2.get(322));
        bitSet2.set(3);
        System.out.println(bitSet2.size());
        System.out.println(bitSet2.length());

        System.out.println(bitSet2.cardinality());
//        System.out.println(wordIndex(0));
    }

    @Test
    public void testWordIndex() {
        System.out.println(wordIndex(321));
    }

    public static int wordIndex(int bitIndex) {
        return bitIndex >> 6;
    }

}
