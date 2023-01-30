# Calculadora POC
Calculadora Microservicio con operaciones de adición y resta usando Maven y Spring boot. 

API REST realizando un POST a la URL (/api/ejecuta)

## Instalación

Para su instalación bastará con tener última versión de Maven y Java 14. Para poder instalar seguir los siguientes pasos:

1. `git clone https://github.com/javierfm27/calculadora.git`
1. `mvn clean verify` para comprobar que todo esta correcto y puede seguir con la instalación
2. `mvn clean`
3. `mvn install`

Accedemos al directorio `/target` y se habrá generado un archivo JAR, donde si ejecutamos el siguiente comando:

`java -jar target/calculadora-0.0.1.jar`

Esto generará una API Rest en la dirección `http://localhost:8080/api/ejecuta`. Para poder porbar esta pequeña calculadora POC, se recomienda acceder a `http://localhost:8080/swagger-ui.html`.

Esto ayudará a comprender como usar esta pequeña calculadora POC.
