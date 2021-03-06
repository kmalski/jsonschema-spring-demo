# Json Schema Spring Boot Demo
Przykład wykorzystania Json Schema w aplikacji opartej o framework Spring Boot.

## Uruchomienie
Projekt został stworzony z wykorzystaniem Javy w wersji 1.8 oraz Spring Boot w wersji 2.4.4.

W celu uruchomienia aplikacji, najprościej zaimportować projekt do dowolnego IDE np. IntelliJ (najlepiej w wersji Ultimate dla wsparcia Spring Boot) lub Spring Tools Suite 4, a po zainstalowaniu zależności, uruchomić.

Aplikację można również uruchomić z linii poleceń przy pomocy narzędzia Maven. 
Aby zbudować docelową paczkę należy wykonać polecenie:
```bash
mvn [clean] package
```
a następnie uruchomić aplikację jednym z dwóch poleceń:
```bash
java -jar target/jsonschema-demo-1.0-SNAPSHOT.jar
mvn spring-boot:run
```

## Testowanie API
Aplikacja domyślnie uruchamia się na porcie **8090**, a API znajduje się pod adresem http://localhost:8090/api.
Natomiast stworzone za pomocą biblioteki **springdoc** Swagger UI można znaleźć pod adresem http://localhost:8090/api/swagger-ui.html.

