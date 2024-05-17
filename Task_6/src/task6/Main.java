package task6;
import task6.empty.Empty;
import task6.empty.Empty1;
import task6.empty.Empty2;
import task6.empty.Empty3;
import task6.empty.Empty4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main{
    public static void main(String[] args) {
        Random r = new Random();
        List<Bean> beans = new ArrayList<>();
        for (int i=0; i<10; i++){
            beans.add(new Bean(r.nextInt()%100));
        }
        System.out.println(beans);
        BeanSort.sort(beans);
        System.out.println(beans);

        Empty empty1 = new Empty1();
        empty1.emptyMethod();
        Empty empty2 = new Empty2();
        empty2.emptyMethod();
        Empty empty3 = new Empty3();
        //empty3.emptyMethod();
        //Empty empty4 = new Empty4();
        //empty4.emptyMethod();
        //Empty empty5 = new Empty5();
        //empty5.emptyMethod();
    }
}