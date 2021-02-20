package javase.test.generic;

public class Gen {

    public static void main(String[] args) {

        GenTe gente = new GenTe<>();
        GenTe[] g0 = new GenTe[10]; //ok
        g0[0] = gente;
        GenTe<?>[] g1 = new GenTe<?>[10]; //ok
        GenTe<Integer>[] g2 = new GenTe[10]; //ok 为什么可以？
        GenTe<Long> genTe = new GenTe<>();
//        g2[0] = genTe;
//        GenTe<Integer>[] g3 = new GenTe<Integer>[10]; // error, g2可以，为什么g3不行

//        new SomeClass[]这样的一条语句表明的是创建了一个SomeClass类型的数组，所以如果允许你写new Gen<Integer>[10]的话，就表明创建了一个Gen<Integer>类型的数组，但这是和实际情况相悖的，因为实际上在Java虚拟机中只能创建出一个Gen类型的数组。


    }

    public static void test(Generic generic) {
        GenTe<Integer>[] g2 = new GenTe[10];
//        g2[0] = generic;
    }
}

class GenTe<T> {}

