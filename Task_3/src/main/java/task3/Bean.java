package task3;

public class Bean {
    public  final int intValue;
    public  final double doubleValue;
    public  final String stringValue;
    public  final Bean nestedBean;
    public  final int[] intArray;

    public Bean(int intValue, double doubleValue, String stringValue, Bean nestedBean, int[] intArray) {
        this.intValue = intValue;
        this.doubleValue = doubleValue;
        this.stringValue = stringValue;
        this.nestedBean = nestedBean;
        this.intArray = intArray;
    }
    public Bean(String stringValue, int i) {
        this.intValue = i;
        this.doubleValue = 0.0;
        this.stringValue = stringValue;
        this.nestedBean = null;
        this.intArray = new int[]{};
    }
    public void method(){
        System.out.println("Hello, my name "+ this.stringValue+"!\n" +
                "I am " + this.intValue + " years old.");
    }
}


