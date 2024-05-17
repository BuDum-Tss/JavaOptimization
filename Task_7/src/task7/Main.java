package task7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Main {
    public static void  main(String[] args) {
        // Запускаем два потока, каждый вызывает методы a() и b() каждую секунду
        new Thread(() -> {
            while (true) {
                a();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread A").start();

        new Thread(() -> {
            while (true) {
                b();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread B").start();
        Stack<Thread> threads = new Stack<>();
        // Вечный цикл
        for (int i = 0; ; i++) {
            if (i < 100) {
                // Первые 100 шагов
                Thread thread = new Thread(() -> {
                    while (true) {
                        try {
                            Thread.sleep(Long.MAX_VALUE);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                }, "Thread "+ i);
                threads.push(thread);
                thread.start();
            } else if (i < 200) {
                threads.pop().interrupt();
            }
            // Ждем 0.1 секунду
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void a() {
        try {
            Thread.sleep(1000);
            a1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void a1() {
        try {
            Thread.sleep(2000);
            a2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void a2() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void b() {
        Random random = new Random();
        Integer x = 1;
        for (int i = 0; i < 100000; i++) {
            x = x * random.nextInt();
            Thread.yield();
        }
        b1();
    }

    public static void b1() {
        Random random = new Random();
        Integer x = 1;
        for (int i = 0; i < 200000; i++) {
            x = x * random.nextInt();
            Thread.yield();
        }
        b2();
    }

    public static void b2() {
        Random random = new Random();
        Integer x = 1;
        for (int i = 0; i < 300000; i++) {
            x = x * random.nextInt();
            Thread.yield();
        }
    }
}
