# car dealerships

Проект Dealerships.
Автосалоны, продающие автомобили.
В приложении представлены 2 сущности:
- автосалон (dealer);
- машина (car).

Автосалон описывается следующими свойствами:
1. Место расположения (Город) - city;
2. Площадь выставочного зала - square;
3. Арендная плата - rent;
4. Описание - description;
5. Количество персонала - staff;
6. Id;
7. Список машин на продажу.

Машина описывается следующими свойствами:
1. Модель - model;
2. Цвет - color;
3. Стоимость - price;
4. Максимальная скорость - maxSpeed;
5. Id;
6. Id автосалона.

Эндпойнты Car:
- Create - http://localhost:8080/cars  - создать объект car
- Get  - http://localhost:8080/cars/1  - получить объект car по id
- Get - http://localhost:8080/cars - получить все объекты car
- Update  - http://localhost:8080/cars - обновить объект car, id в теле запроса
- Delete - http://localhost:8080/cars/1 - удалить объект car по id

Эндпойнты Dealers:
- Create - http://localhost:8080/dealers - создать объект dealer
- Get  - http://localhost:8080/dealers/1 -  получить объект dealer по id
- Get - http://localhost:8080/dealers - получить все объекты dealer
- Update  - http://localhost:8080/dealers - обновить объект dealer, id в теле запроса
- Create - http://localhost:8080/dealers/1 - удалить объект dealer по id

Тесты c запросами на указанные выше эндпойнты расположены в папке postman.

К проекту подключены следующие зависимости:
- spring-boot-starter-validation, spring-boot-starter-web, spring-boot-starter-test, spring-boot-starter-data-jpa, hibernate-validator для работы Spring Boot и Hibernate;
- lombok для работы аннотаций (@Getter, @Setter и т.д.);
- h2 для подключения к тесовой базе H2 с целью быстрой отладки программы;
- postgresql для основной базы данных PostgreSQL.

Для запуска приложения нужен запущенный Docker.

Пошаговая инструкция запуска приложения:
1. Перейти в корневую папку приложения/убедиться, что находитесь в ней.
2. В открыть терминал на mac/командную строку в windows набрать команду docker build -t car-dealerships .
3. Набрать команду docker-compose up -d

После поднятия контейнеров Docker с прилжением и базой данных можно проверить их работу с помощью тестов Postman. 
Для этого нужно импрортировать файл Dealerships.postman_collection1.json в Postman и запустить коллекцию.
Файл расположен в папке postman в корне.

Основной технологический стек:
- Java 11;
- Spring Boot;
- Hibernate ORM;
- PostgreSQL;
- Apache Maven;
- Docker.




