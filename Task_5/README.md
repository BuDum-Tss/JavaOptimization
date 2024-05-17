java -jar recaf.jar
java -cp out/production/Task_5 task5.Main
javap -c -v out/production/Task_5/task5/Main.class

Задание:


Сделать класс со следующими методами:

- Получить в параметрах строку String и вернуть её длину
- Получить в параметрах объект, вызвать у него метод и вернуть значение
- Получить объект и поменять значение его java-поля

Посмотреть, как это выглядит в байт-коде

Рядом еще реализовать:

- Класс с полем value.
- Ручную сортировку объектов этого класса по возрастанию value любым способом
- В main - заполнение списка рандомными объектами этого класса, сортировку и распечатку списка

Затем скомпилировать, натравить "javap -c -v" и объяснить, что получилось в байт-коде.
Показать где какие циклы и где какие if-ы и вообще какой код во что преобразился.

Декомпилировать все с помощью recaf - показать полученный исходник.
Внести изменения в код с помощью recaf, показать что работает.

Ссылки:
- https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javap.html
- https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-6.html
- https://github.com/Col-E/Recaf