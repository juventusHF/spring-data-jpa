# MySQL mit Spring Data JPA/Hibernate

Starte die Applikation:

    mvn spring-boot:run
    
Du kannst nun die Applikation unter folgenden URLs aufrufen: 
- http://localhost:8080/employees
- http://localhost:8080/departments

Das Resultat der Aufrufe, ist dass die Ressource für unberechtigten Zugriff gesperrt sind.

## Aufgaben

### JPA und Hibernate

Wo befinden sich folgende Elemente in der Applikation?

- JPA Entities
- Spring Data Repositories
- Code, welcher Spring Data Repositories benutzt

### MySQL konfigurieren

Vorraussetzung für diese Übung ist eine Installation von MySQL mit Root-Zugriff.

Zunächst muss eine neue Datenbank und ein technischer User für den Zugriff angelegt werden.

    $ mysql -u root -p
    Enter password: 
    ...
    mysql> 
    GRANT ALL PRIVILEGES ON *.* TO 'jpauser'@'localhost' IDENTIFIED BY 'password';
    CREATE DATABASE jpademo;

Aus dem Namen der Datenbank und Standard-Port 3306 ergibt sich folgende URL: `jdbc:mysql://localhost:3306/jpademo`.

Nun lässt sich MySQL für Spring Data konfigurieren. 
Füge dazu folgende Zeilen in `src/main/resources/application.properties` hinzu:

    spring.jpa.hibernate.ddl-auto=create-drop
    spring.datasource.url=jdbc:mysql://localhost:3306/jpademo
    spring.datasource.username=jpauser
    spring.datasource.password=password
    
Nun muss in `pom.xml` noch die Dependency der H2 Datenbank mit der für MySQL ersetzt werden: 

    <dependency>
       <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>

### Applikation starten und MySQL inspizieren

Starte die Applikation erneut:

    mvn spring-boot:run
    
Durch `spring.jpa.hibernate.ddl-auto=create-drop` wird die Applikation die nötigen Tabellen in MySQL
anlegen und wie zuvor mit initialen Daten füllen.

Verbinde Dich (während die Applikation) läuft mit MySQL und schau den Inhalt der Tabellen an:

    $ mysql -u jpauser -p
    Enter password: 
    ...
    mysql> 
    select * from employee;
    
### Finale Konfiguration

Derzeit wird das Schema nach Beenden der Applikation wieder gelöscht. Schön wäre, wenn die Daten dauerhaft abgelegt wären.

Zunächst soll das Schema beim Applikationsstart zwar angelegt, aber bei Applikationsende nicht mehr gelöscht werden.
In `src/main/resources/application.properties`, passe folgende Zeile an:

    spring.jpa.hibernate.ddl-auto=create
    
Starte die Applikation neu und beende sie dann wieder. 

Nun ändere die Zeile erneut:

    spring.jpa.hibernate.ddl-auto=none
    
In der Klasse `ExampleApplication`, kommentiere die gesamte innere Klasse `initRepositoryCLR` aus, sodass
bei Applikationsstart keine neuen Daten mehr eingefügt werden.

Beim nächsten Start der Applikation werden nun keine Tabellen mehr frisch angelegt und bei Applikationsende
keine Tabellen mehr gelöscht.
