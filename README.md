# Задача №1 по курсу «DEV-J200. Java EE. Разработка корпоративных приложений»
# (avalon-dev-j200-lab-1-SoundlyGifted)

Написать Web-приложение, реализующее следующий алгоритм:

1.	Пользователь заполняет HTML-форму, содержащую одно текстовое поле ввода и кнопку отправки содержимого поля на сервер. В текстовое поле пользователь может занести произвольный текст.

2.	Пользователь отправляет строку на сервер.

3.	Сервер анализирует строку и отвечает следующим образом:

•	если поле содержит целое число, то пользователю возвращается страница, которая показывает любое целое число, превышающее исходное;

•	если строка содержит текст, то сервер возвращает страницу, которая показывает пользователю исходную строку и число слов в этой строке (словом считается любая непустая последовательность символов, которая завершается любым пробельным символом, синтаксическим символом или символом конца строки);

•	если строка не содержит ни одного символа (пустая строка или null-строка), то пользователь получает страницу аналогичную исходной с просьбой повторить ввод.
