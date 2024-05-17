package task6;

import java.util.List;

public class BeanSort {
    public static List<Bean> sort(List<Bean> beanList){
        for (int i=0; i<beanList.size(); i++){
            for (int j=i; j<beanList.size(); j++){
                if (beanList.get(i).id > beanList.get(j).id){
                    Bean temp = beanList.get(i);
                    beanList.set(i, beanList.get(j));
                    beanList.set(j, temp);
                }
            }
        }
        return beanList;
    }
}
