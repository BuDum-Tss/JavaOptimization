-libraryjars "P:\Program Files\.jdks\zulu-jdk-17\jmods\java.base.jmod"
-injars ..\task6.jar
-outjars keep-by-names.jar

-dontobfuscate

-keep public class task6.Main {
    public static void main(java.lang.String[]);
}

-keepclassmembers class * {
    void emptyMethod();
}