package task5;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main{
    public static void main(String[] args) {
        Random r = new Random();
        List<Bean> beans = new ArrayList<Bean>();
        for (int i=0; i<10; i++){
            beans.add(new Bean(r.nextInt()%100));
        }
        System.out.println(beans);
        BeanSort.sort(beans);
        System.out.println(beans);

        Service service = new Service();
        System.out.println(service.length("Hello World!"));

        Bean bean = new Bean(101);
        System.out.println("Bean: " + bean.toString());
        service.changeField(bean, 102);
        System.out.println("Bean: " + bean.toString());
        service.invokeMethod(bean);
    }
}