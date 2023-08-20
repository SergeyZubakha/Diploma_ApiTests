# Дипломный проект по автоматизации тестирования API сайта <a href="https://reqres.in/">Reqres.in</a></h1>
![logo.png](images/screens/logo.png)
### Технологии и инструменты:
<p align="center">
<img src="images/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/>
<img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/>
<img src="images/logo/Github.svg" width="50" height="50"  alt="Github"/>
<img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/>
<img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/>
<img src="images/logo/Rest-Assured.svg" width="50" height="50"  alt="Rest-Assured"/>
<img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/>
<img src="images/logo/Allure_Report.svg" width="50" height="50"  alt="Allure_Report"/>
<img src="images/logo/Allure_TO.svg" width="50" height="50"  alt="Allure_TO"/>
<img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/>
<img src="images/logo/Jira.svg" width="50" height="50"  alt="Jira"/>
</p>

### Реализованные тесты:
* Успешный логин юзером и проверка ответа
* Неуспешный логин и проверка ответа
* Создание нового юзера и проверка ответа
* Регистрация нового пользователя и проверка ответа
* Получение списка юзеров и проверка ответа  
* Получение конкретного юзера и проверка ответа

### Запуск тестов из терминала
#### Локальный запуск тестов:
```bash
gradle clean test
```

#### Удаленный запуск тестов с параметрами:

```bash
gradle clean test
```

### Запуск тестов в Jenkins
<a target="_blank" href="https://jenkins.autotests.cloud/job/DiplomaWork_Regres.in_ApiTests/">Сборка в Jenkins</a>
<p align="center">
<img title="Jenkins Build" src="images/screens/Jenkins.png">
</p>

### Отчет в Allure report
#### Основная страница отчета
<p align="center">
<img title="Jenkins Build" src="images/screens/AllureReport.png">
</p>

#### Тест-кейсы
<p align="center">
<img title="Jenkins Build" src="images/screens/TK.png">
</p>

### Интеграция с Allure TestOps
#### Dashboard
<p align="center">
<img title="Jenkins Build" src="images/screens/AllureTestOps.png">
</p>

#### Тест-кейсы
<p align="center">
<img title="Jenkins Build" src="images/screens/AllureTestopsTK.png">
</p>

### Интеграция с Jira
<p align="center">
<img title="Jenkins Build" src="images/screens/Jira.png">
</p>

### Уведомления в Telegram с использованием бота
<p >
>По завершению тестов поступают уведомления в Telegram.
</p>
<p align="center">
<img title="Jenkins Build" src="images/screens/Telegram.png">
</p>
