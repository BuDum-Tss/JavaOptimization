import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Singleton {
    private static Singleton singleton;
    private List<Bean> members;
    private List<byte[]> chat;

    public Singleton() {
        this.chat = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    static Singleton getSingleton(){
        if (singleton ==null){
            singleton = new Singleton();
        }
        return singleton;
    }

    public void addMember(Bean bean) {
        this.members.add(bean);
    }
    synchronized public void addMessage(byte[] bytes){
        chat.add(bytes);
    }
    synchronized public String readChat(){
        return chat.stream().map(message -> new String(message) +"\n").collect(Collectors.joining());
    }
}
