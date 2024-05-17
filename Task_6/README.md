- Взять сортировку из предыдущего задания
- Реализовать 5 пустых классов с 5 пустыми методами.
- Все скомпилировать, засунуть в jar

- Натравить proguard и сделать, чтобы:
    - Ничего не произошло
proguard-7.4.2\bin\proguard.bat -injars out\production\Task_6\task6\Main.class -outjars out\production\Task_6\task6\Main-nothing.jar
    - proguard сделал все что мог - все вырезал и обфусцировал
proguard-7.4.2\bin\proguard.bat -injars out\production\Task_6\task6\Main.class -outjars out\production\Task_6\task6\Main-all.jar -dontskipnonpubliclibraryclasses
    - не трогал некоторые классы по имени

    - не трогал некоторые методы по имени

    - не трогал некоторые методы по сигнатуре

Потом посмотреть-показать что будет в javap и recaf




Ссылка: https://www.guardsquare.com/proguard