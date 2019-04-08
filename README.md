Sistema de administración de comisiones

Descripción
Sistema RESTFul de carga de notas de estudiantes con reporte de comisiones.
- Backend: REST desarrollado en Spring MVC.
- Frontend: Desarrollado en JQuery + Bootstrap 4

Prerequisitos:
- JDK 1.8
- Apache Maven instalado (setear en la variable de ambiente PATH la ruta al mvn.exe) 
- Base de datos: MySQL. 
-- NOTA: para el ejemplo se usa el usuario "root" con contraseña "root". Si desea utilizar otra configuración recuerde modificar el archivo resources\application.properties.

Ejecución de prueba del sistema
1) Carga de datos
- Abrir consola: cmd
- Entrar en la carpeta miscelaneos/db
- Generar el esquema de base de datos
mysql --user=root --password=root --default-character-set=utf8 commissionsAdminDb < schema.sql
- Cargue los datos de prueba
mysql --user=root --password=root --default-character-set=utf8 commissionsAdminDb < data.sql


Ejecución desde consola de Windows
- git clone https://github.com/thegustaa/commissionsadmin.git 
- cd commissionsadmin
- Abrir terminal CMD
- Setear JAVA_HOME al JDK 1.8 (Ejemplo: set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_181)
- Iniciar API: mvnw spring-boot:run (para detener: Ctrl+C)


Importar en Eclipse:
- git clone https://github.com/thegustaa/commissionsadmin.git 
- Abra el Eclipse
- File -> Import -> Maven -> Existing Maven project y seleccione la carpeta "commissionsadmin"

Ejecutar desde Eclipse:
- Abra "Run configuration" (en el botón verde "Run")
- Crear una nueva "Java Application"
- Complete los datos:
	- Name: commissionsadmin
	- Main class: ar.edu.university.commissionsadmin.CommissionsAdminApplication
	- Project: commissionsadmin
- Presione "Run"


POSTMAN: Ejemplos y pruebas 
- Descargue postman: https://www.getpostman.com/downloads/
- Importe el proyecto: \miscellaneous\postman-api-tests\commissionsadmin.postman_collection.json
- Ejecute el set de pruebas para verificar el correcto funcionamiento de la API.

Documentación 
SWAGGER
-- Abra su navegador preferido.
-- Abra http://localhost:8080/swagger-ui.html
Técnica
- Ver \miscellaneous\doc

Ejecución del frontend
- Abra su navegador preferido.
- Abra http://localhost:8080


