package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
public class Main {
    public static void main(String[] args) {
        Bean bean = new Bean("Mike", 16);
        NativeMethods nm = new NativeMethods();
        System.out.println("\nNF callObjectMethod()");
        nm.callObjectMethod(bean);
        System.out.println("\nNF allocateMemory()");
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Before: " + usedMemory);
        nm.allocateMemory();
        usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("After: " + usedMemory);
        System.out.println("\nNF getStringLength()");
        System.out.println(nm.getStringLength("Hello"));
        System.out.println("\nNF bean()");
        nm.bean(bean, 20);
        bean.method();

        System.out.println("\nNF allocateNativeStruct()");
        usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Before: " + usedMemory);
        long pointer =nm.allocateNativeStruct();
        usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("After: " + usedMemory);

        System.out.println("\nNF getStructValue()");
        System.out.println(nm.getStructValue(pointer));

        System.out.println("\nNF freeNativeStruct()");
        usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Before: " + usedMemory);
        nm.freeNativeStruct(pointer);
        usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("After: " + usedMemory);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("crashJvm or callNativeMethods");
            String result = reader.readLine();
            System.out.println(result);
            if (Objects.equals(result, "crashJvm")){
                System.out.println("JVM crashing...");
                nm.crashJvm();
            }
            else if (Objects.equals(result, "callNativeMethods")){
                System.out.println("Calling NativeMethods...");
                nm.callNativeMethods();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}