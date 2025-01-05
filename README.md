
# Prueba Técnica: API RESTful para Gestión de una Biblioteca

Este proyecto implementa una **API RESTful** para gestionar los recursos de una biblioteca, incluyendo autores, editoriales y libros. Utiliza **Spring Boot 3.3.5** con **Java 21** para el backend, vistas **JSP** y **servlets** con **Bootstrap** para el frontend, y **MySQL** como base de datos.

---

## **Tabla de Contenidos**
- [Características](#características)
- [Requisitos Previos](#requisitos-previos)
- [Configuración del Proyecto](#configuración-del-proyecto)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Base de Datos](#base-de-datos)
- [Uso](#uso)
- [Créditos](#créditos)

---

## **Características**
1. **CRUD de Autores**  
   - Crear, leer, actualizar y eliminar autores.
2. **CRUD de Editoriales**  
   - Crear, leer, actualizar y eliminar editoriales.
3. **CRUD de Libros**  
   - Crear, leer, actualizar y eliminar libros.
4. **Relaciones**  
   - Asignar o eliminar libros a los autores.  
   - Asignar o eliminar libros a las editoriales.

---

## **Requisitos Previos**
Asegúrate de tener instalados los siguientes programas:
- **Java 21**  
- **Apache Maven** o **Gradle**  
- **MySQL Server**  
- **Tomcat 10+** para el despliegue de las vistas JSP  
- **Git** (opcional, si deseas clonar el repositorio).

---

## **Configuración del Proyecto**

### **1. Clonar el Repositorio**
```bash
git clone https://github.com/aeonmerx6661/JAVA_PRUEBA
cd gestion-biblioteca
```

### **2. Configurar la Base de Datos**
1. Crea una base de datos en MySQL llamada `biblioteca`.
2. Ejecuta el archivo `schema.sql` incluido en el proyecto para generar las tablas requeridas.

```sql
CREATE DATABASE biblioteca;

USE biblioteca;

-- Tabla de Autores
CREATE TABLE autores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    biografia TEXT
);

-- Tabla de Editoriales
CREATE TABLE editoriales (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    ubicacion VARCHAR(255)
);

-- Tabla de Libros
CREATE TABLE libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    fecha_publicacion DATE,
    autor_id INT,
    editorial_id INT,
    FOREIGN KEY (autor_id) REFERENCES autores(id),
    FOREIGN KEY (editorial_id) REFERENCES editoriales(id)
);
```

### **3. Configurar el archivo `application.properties`**
En el directorio `src/main/resources`, edita el archivo `application.properties` para configurar tu conexión a MySQL:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### **4. Construir y Ejecutar el Proyecto**
#### **Con Maven**
```bash
mvn clean install
mvn spring-boot:run
```

#### **Con Gradle**
```bash
./gradlew clean build
./gradlew bootRun
```

---

## **Estructura del Proyecto**

```plaintext
biblioteca/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.biblioteca/  # Paquete principal del proyecto
│   │   │       ├── controller/          # Controladores REST y servlets
│   │   │       ├── service/             # Lógica de negocio
│   │   │       ├── repository/          # Interfaces JPA
│   │   │       └── model/               # Entidades de la base de datos
│   │   ├── resources/
│   │       ├── application.properties   # Configuración del proyecto
│   │       └── templates/               # Vistas JSP
│   └── test/                            # Tests unitarios y de integración
└── pom.xml                              # Archivo Maven
```

---

## **Base de Datos**
- **Nombre:** `biblioteca`  
- **Tablas:**
  - `autores`
  - `editoriales`
  - `libros`
- **Relaciones:**
  - Un autor puede tener múltiples libros.  
  - Una editorial puede tener múltiples libros.

Incluye el archivo `schema.sql` para la creación inicial de las tablas.

---

## **Uso**
1. Ejecuta la aplicación.
2. Accede al frontend en tu navegador:  
   ```
   http://localhost:8080/
   ```
3. Explora las vistas para realizar operaciones CRUD sobre autores, editoriales y libros.

---

## **Créditos**
Proyecto desarrollado como parte de una **prueba técnica**.  
Tecnologías utilizadas: **Spring Boot**, **JSP/Servlets**, **Bootstrap**, y **MySQL**.
