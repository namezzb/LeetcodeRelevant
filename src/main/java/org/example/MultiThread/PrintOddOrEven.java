package org.example.MultiThread;

public class PrintOddOrEven {
    private static int num = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new oddPrinter(), "Odd").start();
        new Thread(new evenPrinter(), "Even").start();
    }

    static class oddPrinter implements Runnable{
        public void run(){
            while(true){
                synchronized(lock){
                    while(num <= 100 && (num & 1) == 0){
                        try{
                            lock.wait();
                        }catch(Exception e){

                        }
                    }
                    if(num > 100) break;
                    System.out.print(Thread.currentThread().getName() +   num + " ");
                    num++;
                    lock.notifyAll();
                }
            }
        }
    }

    static class evenPrinter implements Runnable{
        public void run(){
            while(true){
                synchronized(lock){
                    while(num <= 100 && (num & 1) == 1){
                        try{
                            lock.wait();
                        }catch(Exception e){

                        }
                    }
                    if(num > 100) break;
                    System.out.print(Thread.currentThread().getName() +   num + " ");
                    num++;
                    lock.notifyAll();
                }
            }
        }
    }

//    static class OddPrinter implements Runnable {
//        public void run() {
//            while (true) {
//                synchronized (lock) {
//                    while (num <= 100 && (num & 1) == 0) { // 轮到偶数线程
//                        try { lock.wait(); } catch (InterruptedException ignored) {}
//                    }
//                    if (num > 100) break;
//                    System.out.print(num + " ");
//                    num++;
//                    lock.notifyAll();
//                }
//            }
//        }
//    }
//
//    static class EvenPrinter implements Runnable {
//        public void run() {
//            while (true) {
//                synchronized (lock) {
//                    while (num <= 100 && (num & 1) == 1) { // 轮到奇数线程
//                        try { lock.wait(); } catch (InterruptedException ignored) {}
//                    }
//                    if (num > 100) break;
//                    System.out.print(num + " ");
//                    num++;
//                    lock.notifyAll();
//                }
//            }
//        }
//    }
}