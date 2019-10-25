# Backend

API desarrollado usando SpringBoot.

## Requerimientos

- JRE (Java Runtime Environment) 8 para ejecutar API
- JDK (Java Development Kit) 8 y Maven para compilar API
- MySQL 5.7 para la persistencia de datos

El archivo `script.sql` contiene las sentencias para creación de la base de datos que usará el API.

### Configuración de la persistencia - Entorno

Se pueden utilizar las siguientes variables de entorno para la configuración del backend:

```sh
SPRING_DATASOURCE_URL=jdbc:mysql://172.17.0.2:3306/db?useSSL=false
SPRING_DATASOURCE_USERNAME=user
SPRING_DATASOURCE_PASSWORD=pass
SPRING_DATASOURCE_TOMCAT_INITIAL_SIZE=3000
SPRING_JPA_HIBERNATE_NAMING_STRATEGY=org.hibernate.cfg.EJB3NamingStrategy
```

Los valores listados pueden ser adaptados para una configuración personalizada.

### Configuración de la persistencia - Archivo [ DEV ]

También se puede tener la configuración de la persistencia mediante el archivo `application.properties`, que deberá estar localizado en la siguiente ruta:
`
src/main/resources/application.properties
`

Un ejemplo de la configuración ahí almacenada es la siguiente:

```
spring.datasource.url=jdbc:mysql://172.17.0.2:3306/db?useSSL=false
spring.datasource.username=user
spring.datasource.password=password
spring.datasource.tomcat.initial-size=3000
spring.jpa.hibernate.naming-strategy=org.hibernate.cfg.EJB3NamingStrategy
```
Los valores listados pueden ser adaptados para una configuración personalizada.

### Edición

El código fuente del backend se puede compilar y correr el servidor en modo de desarrollo usando:

```sh
mvn spring-boot:run
```

Para re-empacar el código como un archivo .jar hay que usar el comando:

```sh
mvn clean package
```

Esto creará una carpeta /target con el archivo jar compilado.

### Ejecución con application.properties

Para correr el servidor con el backend simplemente hay que ejecutar el archivo .jar usando:

```sh
java -jar testserviceapi-0.0.1-SNAPSHOT.jar
```

Esto levantará el servidor de forma local en el puerto **8080**. No debe de existir algún otro servicio corriendo en ese puerto.

```
http://localhost:8080
```

### Ejecución con variables de entorno

Para correr el servidor con el backend simplemente hay que ejecutar el archivo .jar usando:

```sh
SPRING_DATASOURCE_URL=jdbc:mysql://172.17.0.2:3306/db?useSSL=false SPRING_DATASOURCE_USERNAME=user SPRING_DATASOURCE_PASSWORD=pass SPRING_DATASOURCE_TOMCAT_INITIAL_SIZE=3000 SPRING_JPA_HIBERNATE_NAMING_STRATEGY=org.hibernate.cfg.EJB3NamingStrategy java -jar testserviceapi-0.0.1-SNAPSHOT.jar
```

Esto levantará el servidor de forma local en el puerto **8080**. No debe de existir algún otro servicio corriendo en ese puerto.

```
http://localhost:8080
```


## Documentación API - Swagger

Para visualizar la documentación de los servicios hay que ir a la dirección:

```
http://localhost:8080/docapi/index.html#!//
```

## Datos de prueba

```
GET - localhost:8080/mutation/
```

Secuencias sin mutación - se espera código 403
```json
{
  "dna": ["ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"]
}
```
```json
{
  "dna": ["ATGCGA","CAGTGC","TTATAT","AGACGG","GCGTCA","TCACTG"]
}
```


Secuencia con mutación - se espera código 200
```json
{
"dna": ["ATGCGA","CACTAC","TCATCT","AGCCTG","CTCATA","TCACGG"]
}
```