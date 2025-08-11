package org.example.MultiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintSequencial {
    public static int state = 0;
    public static final Lock lock = new ReentrantLock();
    public PrintSequencial() {

    }

    public static void main(String[] args) {
        PrintSequencial printSequencial = new PrintSequencial();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        while(state <= 3){
            if(state % 3 == 0){
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                state++;
            }
            lock.unlock();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        while(state <= 3){
            if(state % 3 == 1){
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                state++;
            }
            lock.unlock();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        while(state <= 3){
            if(state % 3 == 2){
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                state++;
            }
            lock.unlock();
        }

    }
}
