javac -h ./src/main/c ./src/main/java/task3/NativeMethods.java ./src/main/java/task3/Bean.java
gcc -shared -Wl,--add-stdcall-alias ./src/main/c/task3_NativeMethods.c -o ./src/main/c/nativelib.dll  -I "P:\Program Files\.jdks\zulu-jdk-17\include" -I "P:\Program Files\.jdks\zulu-jdk-17\include\win32"
