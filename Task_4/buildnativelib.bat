javac -h ./src/main/c ./src/main/java/task4/NativeMatrix.java
gcc -shared -O3 -Wl,--add-stdcall-alias ./src/main/c/task4_NativeMatrix.c -o ./src/main/c/matrixlib.dll  -I "P:\Program Files\.jdks\zulu-jdk-17\include" -I "P:\Program Files\.jdks\zulu-jdk-17\include\win32"
