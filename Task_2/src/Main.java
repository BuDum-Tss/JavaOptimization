/*
Реализовать приложение-пример, которое содержит:
+ Класс с сигнлтоном
+ Класс Bean с полем-именем, содежащий массив байт, ArrayList, примитивы и ссылку на себя.
+ Несколько экземпляров класса Bean, замкнутых в кольцо своими ссылками.
+ Несколько потоков, бесконечно висящих в sleep.
- Каждый поток имеет свою ссылку на сигнлтон и создает свой экземпляр класса Bean.
- "Вредный" поток, который ломает все по OutOfMemory, бесконечно аллоцируя массивы
- Вредный поток запускать специальной командой
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Bean mike = new Bean("Mike");
        Bean jane = new Bean("Jane");
        Bean fione = new Bean("Fione");
        Bean shrek = new Bean("Shrek");
        mike.addFriend(jane);
        mike.addFriend(shrek);
        jane.addFriend(fione);
        jane.addFriend(mike);
        fione.addFriend(jane);
        fione.addFriend(shrek);
        shrek.addFriend(fione);
        shrek.addFriend(mike);

        Thread sleepingThread1 = new Thread(()->{
            Bean bean = new Bean("Thread1");
            Singleton.getSingleton().addMember(bean);
            Singleton.getSingleton().addMessage(("Hello, i am Thread1!").getBytes(StandardCharsets.UTF_8));
            while (true){
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Bean1Thread");
        Thread sleepingThread2 = new Thread(()->{
            Bean bean = new Bean("Thread2");
            Singleton.getSingleton().addMember(bean);
            Singleton.getSingleton().addMessage(("Hello, i am Thread2!").getBytes(StandardCharsets.UTF_8));
            while (true){
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Bean2Thread");
        Thread sleepingThread3 = new Thread(()->{
            Bean bean = new Bean("Thread3");
            Singleton.getSingleton().addMember(bean);
            Singleton.getSingleton().addMessage(("Hello, i am Thread3!").getBytes(StandardCharsets.UTF_8));
            while (true){
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Bean3Thread");
        sleepingThread1.start();
        sleepingThread2.start();
        sleepingThread3.start();
        Thread badTread = new Thread(()->{
            Bean bean = new Bean("Spamer");
            while (! Thread.currentThread().isInterrupted()){
                Singleton.getSingleton().addMessage(bean.writeMessage().getBytes(StandardCharsets.UTF_8));
            }
        },"SpamThread");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            try {
                System.out.print("On/off bad thread?\n> ");
                String result = reader.readLine();
                if (Objects.equals(result, "on")){
                    badTread.start();
                }
                else if (Objects.equals(result, "off")){
                    badTread.interrupt();
                }
                else if (Objects.equals(result, "chat")){
                    System.out.println(Singleton.getSingleton().readChat());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}