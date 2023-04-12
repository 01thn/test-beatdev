Стек:

    Java 8
    Spring-boot
    Spring WEB
    Spring Data JPA
    Gradle
    MySQL
    Docker-compose
    Hibernate validation
    Swagger
    Mapstruct
    Lombock

Запуск приложения:

    В файле application.properties нужно указать путь к базе данных и пароль. 
    Кроме этого, для быстрого запуска БД есть файл docker-compose. С помощью команды docker-compose up можно запустить готовый инстанс БД и ничего менять не придется
    Запустить приложение можно командой ./gradlew build && java -jar build/libs/test-beatdev-0.0.1-SNAPSHOT-plain.jar

Endpoints:

    Для удобства работы рекомендуется использовать Swagger UI: http://localhost:80/swagger-ui/index.html
    
    
    http://localhost:80/user/add - сохранение нового пользователя
    http://localhost:80/user/get/{id} - получить пользователя по id
    http://localhost:80/user/update/{id} - обновить пользователя по id
    http://localhost:80/user/delete/{id} - удалить пользователя по id
    http://localhost:80/user/status/{id} - обновить статус пользователя по id

