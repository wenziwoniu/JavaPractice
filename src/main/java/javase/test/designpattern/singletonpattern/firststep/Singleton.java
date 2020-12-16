package javase.test.designpattern.singletonpattern.firststep;

/**
 * 单例模式
 */
public class Singleton {

    // 任何类调用getInstance方法时，都可以获得唯一的对象，且没有线程安全性的问题。
    // 当实例化Singleton没有浪费资源且很快时，可以采用该方法
//    private static Singleton uniqueInstance = new Singleton();
//    public static Singleton getInstance() {
//        return uniqueInstance;
//    }

//    private static Singleton uniqueInstance;
      private volatile static Singleton uniqueInstance;

    private Singleton() {

    }

    /**
     * 多线程时会有问题
     * @return
     */
  /*  public static Singleton getInstance() {

        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }

        return uniqueInstance;
    }*/

    /**
     * 可以解决多线程的问题
     * 但是每次调用都会使用同步锁，造成效率低下
     * @return
     */
/*    public static synchronized Singleton getInstance() {

        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }

        return uniqueInstance;
    }*/

    /**
     * 双重检查加锁  配合 private volatile static Singleton uniqueInstance;
     * @return
     */
    public static Singleton getInstance() {

        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }

        }

        return uniqueInstance;
    }
}
