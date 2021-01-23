package javase.test.thread;

/**
 * 类名称:Wait
 * 类描述: 展示wait的基本用法
 * 1. 研究代码的执行顺序
 * 2. 证明wait释放了锁
 *
 * @author: https://javaweixin6.blog.csdn.net/
 * 创建时间:2020/8/29 15:06
 * Version 1.0
 */
public class Wait {

    // 锁对象
    public static final Object object = new Object();

    static class Thread1 extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("线程 "+ Thread.currentThread().getName() + "syn代码块中,  开始执行 ");

                try {
                    Thread.sleep(5000);
                    //调用wait , 释放锁.
                    object.wait();
                } catch (InterruptedException e) {
                    //在执行等待期间, 如果遇到中断了, 就会抛出 InterruptedException
                    e.printStackTrace();
                }
                //重新获取锁
                System.out.println("线程 "+ Thread.currentThread().getName() + " 获取到了锁 ");

            }

        }

    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                //线程1 释放了锁, 线程 2 因此能进入此同步代码块.
                //调用notify的前提是要有线程处于wait状态. 因此要保证线程1 先执行 .
                object.notify();
                System.out.println("线程 "+ Thread.currentThread().getName() + " 调用了notify ");
            }
        }
    }

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread1.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }
}
