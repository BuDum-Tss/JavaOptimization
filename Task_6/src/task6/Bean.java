package task6;

public class Bean {
    public Integer id;

    public Bean(Integer id){

        this.id = id;
    }
    public void sayHello(){
        System.out.println("Hello, i am "+id.toString());
    }

    public String toString(){
        return "task5.Bean ( "+ id.toString()+" )";
    }
}
