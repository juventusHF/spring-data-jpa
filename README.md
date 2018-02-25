# Zugriffskontrolle mit Spring Security

Starte die Applikation:

    mvn spring-boot:run
    
Du kannst nun die Applikation unter folgenden URLs aufrufen: 
- http://localhost:8080/employees
- http://localhost:8080/departments

Das Resultat der Aufrufe, ist dass die Ressource für unberechtigten Zugriff gesperrt sind.

## cURL

Um mit dieser Übung arbeiten zu können, solltest Du cURL installieren. 

- macOS: `brew install curl`
- Windows: https://stackoverflow.com/a/16216825/5155817

Hinweis: Mit `curl -v ...` werden die Details der Kommunikation via HTTP angezeigt.

## Aufgaben

### MySQL konfigurieren

technischen user für die app anlegen

