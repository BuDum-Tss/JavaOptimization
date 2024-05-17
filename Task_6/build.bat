@echo off
javac -d out src/task6/*.java src/task6/empty/*.java
echo Main-Class: task6.Main > Manifest.txt
jar cfm task6.jar Manifest.txt -C out .
