@echo off
SET PARAM=%~1
javap -c -v -cp proguard\%PARAM%.jar task6.Main > javapmain\%PARAM%-main.txt