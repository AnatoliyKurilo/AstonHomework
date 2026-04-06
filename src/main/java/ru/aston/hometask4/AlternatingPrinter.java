package ru.aston.hometask4;

public class AlternatingPrinter {
    private static final Object lock = new Object();
    private static boolean isTurnOfOne = true; // поток 1 выводит первым

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (!isTurnOfOne) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.print("1 ");
                    isTurnOfOne = false;
                    lock.notify();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (isTurnOfOne) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.print("2 ");
                    isTurnOfOne = true;
                    lock.notify();
                }
            }
        });

        t1.start();
        t2.start();
    }
}