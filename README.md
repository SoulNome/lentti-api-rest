# Lentti · API REST

API REST para una plataforma de pedidos y entregas: gestiona los productos, los
usuarios, las órdenes y las entregas de un negocio. La construí con **Spring
Boot** siguiendo una arquitectura por capas, con documentación interactiva de
los endpoints en **Swagger**.

## Stack

- **Java 8** · **Spring Boot**
- **Spring Data JPA** (Hibernate) sobre **MySQL**
- **Lombok** para reducir el código repetitivo
- **springdoc-openapi** para la documentación Swagger
- **Maven** como gestor del proyecto

## Arquitectura

El proyecto separa responsabilidades en capas bien definidas:

```
com.api_rest.lentti
├── controller/     expone los endpoints REST (Product, Order, User, Deliverie)
├── services/       lógica de negocio — interfaz (I...Service) + implementación
├── repository/     acceso a datos con Spring Data JPA (I...Repository)
├── model/          entidades JPA (Products, Orders, Users, Deliveries)
└── exception/      excepciones propias (BadRequest, Conflict, ModelNotFound)
```

Cada recurso tiene su controlador, su servicio (programado contra una interfaz,
no contra la implementación) y su repositorio. Los errores se manejan con
excepciones propias que devuelven el código HTTP correcto (400, 404, 409).

## Entidades

- **Products** — productos del catálogo.
- **Users** — usuarios de la plataforma.
- **Orders** — pedidos, relacionados con usuarios y productos.
- **Deliveries** — entregas asociadas a los pedidos.

El modelo de datos está en `bd/LENTTI.sql` y el diagrama entidad-relación en
`bd/` (PDF).

## Endpoints

Cada recurso se expone bajo su propia ruta, por ejemplo:

| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/products` | lista los productos |
| GET | `/products/{id}` | un producto por id |
| POST | `/products` | crea un producto |
| PUT | `/products/{id}` | actualiza un producto |
| DELETE | `/products/{id}` | elimina un producto |

Mismo patrón para `/users`, `/orders` y `/deliveries`. La aplicación corre bajo
el *context path* `/lentti`.

## Documentación interactiva (Swagger)

Con la aplicación corriendo:

```
http://localhost:8080/lentti/swagger-ui/index.html
```

Desde ahí se pueden probar todos los endpoints sin herramientas externas.
Durante el desarrollo también probé la API con **Postman**.

## Cómo correrlo

1. Crea la base de datos en MySQL e impórtala:

   ```bash
   mysql -u root -p -e "CREATE DATABASE LENTTI;"
   mysql -u root -p LENTTI < bd/LENTTI.sql
   ```

2. Configura las credenciales por variables de entorno (o usa los valores por
   defecto para desarrollo local):

   ```bash
   set DB_URL=jdbc:mysql://localhost:3306/LENTTI?useSSL=false
   set DB_USERNAME=tu_usuario
   set DB_PASSWORD=tu_password
   ```

3. Levanta la API con Maven:

   ```bash
   cd lENNTI
   ./mvnw spring-boot:run
   ```

La API queda disponible en `http://localhost:8080/lentti`.

## Notas

Las credenciales de la base de datos se leen de variables de entorno
(`DB_URL`, `DB_USERNAME`, `DB_PASSWORD`); no hay contraseñas reales en el
repositorio. Proyecto construido como práctica de desarrollo de APIs REST con
Spring Boot.
