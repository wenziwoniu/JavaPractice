package javase.test.jvm.eight;

public class StaticDispatch {

    static abstract class Human {
        public void sayHello() {
            System.out.println("Human say");
        }
    }

    static class Man extends Human {
//        public void sayHello() {
//            System.out.println("man say");
//        }
    }

    static class Women extends Human {

    }

    static class Son extends Man {
//        public void sayHello() {
//            System.out.println("son say");
//        }
    }

    public void sayHello(Human guy) {

        System.out.println("Hello guy");
    }

//    public void sayHello(Man guy) {
//        System.out.println("Hello man");
//    }

    public void sayHello(Women guy) {

        System.out.println("Hello women");
    }

    public static void main(String[] args) {

        StaticDispatch staticDispatch = new StaticDispatch();

        Man man = new Man();
        Human son = new Son();
        son.sayHello();
    }
}
