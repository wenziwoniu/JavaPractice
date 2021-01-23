package javase.test.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 主线程等待子线程执行完成后在执行
 */
public class CountDownLatchTest1 {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {

                @Override
                public void run() {
                    System.out.println("子线程" + Thread.currentThread().getName() + "开始执行");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完成");
                    countDownLatch.countDown();
                }

            };
            service.execute(runnable);
        }

        System.out.println("主线程" + Thread.currentThread().getName() + "等待子线程执行完成...");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程" + Thread.currentThread().getName() + "开始执行...");

        System.exit(0);
    }
}
