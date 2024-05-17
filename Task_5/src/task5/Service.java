package task5;

public class Service {

    public int length(String string){
        return string.length();
    }

    public void invokeMethod(Bean obj){
        obj.sayHello();
    }

    public void changeField(Bean obj, Integer field){
        obj.id = field;
    }
}
