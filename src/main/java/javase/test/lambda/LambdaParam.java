package javase.test.lambda;

public class LambdaParam {

    public static void main(String[] args) {

        // 参数x和y类型相同，则x和y的值由调用的顺序决定
        SameType sameType = (x, y) -> {
            System.out.println(y);
            System.out.println(x);
        };
//        sameType.add(5, 2);

        NotSameType notSameType = (x, y) -> {

//            printInt(x);
        };
//        notSameType.print("a", 1);

    }

    public static void printString(String a) {
        System.out.println(a);
    }

    public static void printInt(int a) {
        System.out.println(a);
    }




    interface SameType{

        public void add(int a, int b);
    }

    interface NotSameType{

        public void print(Item a, int b);
    }

}



