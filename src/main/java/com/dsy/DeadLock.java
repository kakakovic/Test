package main.java.com.dsy;

public class DeadLock {

    private static Object objA = new Object();
    private static Object objB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        thread1.start();
        thread2.start();
    }

    private static class Thread1 implements Runnable{

        @Override
        public void run() {
            synchronized (objA) {
                System.out.println("线程1得到A对象的锁");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (objB) {
                    System.out.println("线程1得到B对象的锁");
                }
            }
        }
    }

    private static class Thread2 implements Runnable{

        @Override
        public void run() {
            synchronized (objB) {
                System.out.println("线程2得到B对象的锁");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (objA) {
                    System.out.println("线程2得到A对象的锁");
                }
            }
        }
    }
}