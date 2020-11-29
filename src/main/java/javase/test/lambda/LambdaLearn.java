package javase.test.lambda;

public class LambdaLearn {


    public static void main(String[] args) {

        Runnable runnable = () -> System.out.println("a");
        Thread t = new Thread(runnable);
        t.start();
    }

/*    public static void main(String[] args) {

        ItemCreatorBlankConstruct creator = () -> new Item();
        Item item = creator.getItem();

        ItemCreatorBlankConstruct creator2 = Item::new;

        ItemCreatorParamContruct creator3 = Item::new;
        creator3.getItem(1, "abcd", 12D);


    }*/

    /**
     * lambda 表达式引用方法
     * 有时候我们不是必须要自己重写某个匿名内部类的方法，我们可以可以利用 lambda表达式的接口快速指向一个已经被实现的方法。
     *
     * 语法
     * ​	方法归属者::方法名 静态方法的归属者为类名，普通方法归属者为对象
     * @param args
     */
   /* public static void main(String[] args) {

        int c = 10;
        ReturnOneParam lambda1 = x -> {
            return doubleNum(x);
        };
        lambda1.method(5);

        ReturnOneParam lambda2 = LambdaLearn::doubleNum;

        LambdaLearn lambdaLearn = new LambdaLearn();
        ReturnOneParam lambda4 = lambdaLearn::addTwo;
        System.out.println(lambda4.method(2));
    }*/

    /**
     * 要求
     * 1.参数数量和类型要与接口中定义的一致
     * 2.返回值类型要与接口中定义的一致
     */
    public static int doubleNum(int a) {
        return a * 2;
    }

    public int addTwo(int a) {
        return a + 2;
    }

    /*public static void main(String[] args) {

        NoReturnNoParam noReturnNoParam = () -> System.out.println("noReturnNoParam");
        noReturnNoParam.method();

        NoReturnOneParam noReturnOneParam = x -> System.out.println("noReturnOneParam:" + x);
        noReturnOneParam.method(2);

        NoReturnMultiParam noReturnMultiParam = (x, y) -> {
            System.out.println("x: " + x);
            System.out.println("y: " + y);
            System.out.println("x + y = " + (x + y));
        };
        noReturnMultiParam.method(1,2);

        ReturnNoParam returnNoParam = () -> 5;
        System.out.println(returnNoParam.method());

        ReturnOneParam returnOneParam = (x) -> {
            System.out.println("x:" + x);
            return x * 5;
        };
        returnOneParam.method(2);

        ReturnMultiParam returnMultiParam = (x, y) -> x + y;
        System.out.println(returnMultiParam.method(1, 100));
    }*/

    /**多参数无返回*/
    @FunctionalInterface
    public interface NoReturnMultiParam {
        void method(int a, int b);
    }

    /**无参无返回值*/
    @FunctionalInterface
    public interface NoReturnNoParam {
        void method();
    }

    /**一个参数无返回*/
    @FunctionalInterface
    public interface NoReturnOneParam {
        void method(int a);
    }

    /**多个参数有返回值*/
    @FunctionalInterface
    public interface ReturnMultiParam {
        int method(int a, int b);
    }

    /*** 无参有返回*/
    @FunctionalInterface
    public interface ReturnNoParam {
        int method();
    }

    /**一个参数有返回值*/
//    @FunctionalInterface
    public interface ReturnOneParam {
        int method(int a);
    }

    @FunctionalInterface
    interface ItemCreatorBlankConstruct {
        Item getItem();
    }
    interface ItemCreatorParamContruct {
        Item getItem(int id, String name, double price);
    }

}
