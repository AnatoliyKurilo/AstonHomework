package ru.aston.hometask4;

import java.util.concurrent.atomic.AtomicBoolean;

public class LivelockExample {
    private static final AtomicBoolean flag1 = new AtomicBoolean(true);
    private static final AtomicBoolean flag2 = new AtomicBoolean(false);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                while (!flag1.get()) {
                    Thread.yield();
                }
                System.out.println("Thread 1: trying to do work...");
                // Уступаем, если видим, что другой поток тоже хочет работать
                if (flag2.get()) {
                    System.out.println("Thread 1: yielding to thread 2");
                    flag1.set(false);
                    continue;
                }
                // Здесь могла бы быть полезная работа, но мы её не делаем
                System.out.println("Thread 1: work done");
                flag1.set(false);
                flag2.set(true);
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                while (!flag2.get()) {
                    Thread.yield();
                }
                System.out.println("Thread 2: trying to do work...");
                if (flag1.get()) {
                    System.out.println("Thread 2: yielding to thread 1");
                    flag2.set(false);
                    continue;
                }
                System.out.println("Thread 2: work done");
                flag2.set(false);
                flag1.set(true);
            }
        });

        t1.start();
        t2.start();
    }
}