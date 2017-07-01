# DeviceRemote

Задание 1. Примерно на 40-60 минут времени.
Структура приложения:
База данных, содержащая 2 таблицы:

Таблица 1: classes
id::integer

classname::characrer varying

1    ie.globalcom.Bell

2    ie.globalcom.Bulb

3    ie.globalcom.Valve

4    ie.globalcom.Burner

5    ie.globalcom.Computer

6    ie.globalcom.Amplifier

7    ie.globalcom.RobotCleaner

8    ie.globalcom.Toster

9    ie.globalcom.Microwave

…    …

Таблица 2: keywords

Id::integer

keyword::character varying   binded_class::integer

1  ring   1

2  bell   1

3  light  2

…    …    …
Веб-сервер tomcat8

Клиентская часть на JavaScript (можно использовать jQuery, angular.js и прочие)

 
Клиент вводит на странице ключевое слово и делает submit на сервер (использовать ajax вместо стандартных форм). В базе хранятся соответствия ключевых слов определенным классам.
Каждый класс реализует метод, позволяющий включить/выключить соответствующее ему устройство (toggle). В рамках данного задания достаточно написать сообщение в системный поток вывода, например: “Toster: I am turned on!”, “Microwave: I am turnedoff!”
По запросу требуется включить/выключить соответствующее ключевому слову устройство и сообщить об этом на клиентское приложение. Формат отправки и получения данных – JSON.
Устройств в базе может быть сколько угодно. Предусмотреть возможность расширения.
Использовать стандартные средства java, jsp, соответствующий JDBC-драйвер, библиотеку Gson или jackson для работы с JSON-форматом. Плюсом будет использование struts2.


 При запуске приложения  создаются таблицы.
Через вебинтерфейс программа получает доступ к девайсам  и при вводе названия девайса 
переключает его состояние , выводит текущее состояние девайса и заносит это состояние в бд.

 