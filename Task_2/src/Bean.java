import java.util.ArrayList;
import java.util.Random;

public class Bean {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private final String name;
    private final byte[] info;
    private final ArrayList<Bean> beans;
    private final int intValue;
    private final double doubleValue;
    private final char charValue;
    private final boolean booleanValue;

    public Bean(String name){
        this.name = name;
        this.info = new byte[] {};
        this.beans = new ArrayList<>();
        this.intValue = 0;
        this.doubleValue = 0.0;
        this.charValue = 'a';
        this.booleanValue = false;
    }
    public Bean(String name, byte[] info, ArrayList<Bean> beans, int intValue, float floatValue, char charValue, boolean booleanValue){
        this.name = name;
        this.info = info;
        this.beans = beans;
        this.intValue = intValue;
        this.doubleValue = floatValue;
        this.charValue = charValue;
        this.booleanValue = booleanValue;
    }
    public void addFriend(Bean bean){
        beans.add(bean);
    }

    public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }
    public String writeMessage(){
        return generateRandomString(100_000);
    }
}
