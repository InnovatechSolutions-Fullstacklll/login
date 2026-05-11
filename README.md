# 🔑 MS Login - Inovatech

Microservicio encargado de la autenticación de usuarios.

Permite:
- Login de usuarios
- Generación de JWT
- Consultar usuarios registrados
- Comunicación con MS Register mediante OpenFeign

---

# 📌 Tecnologías utilizadas

- Java 21
- Spring Boot 3
- Spring Security
- OpenFeign
- JWT
- Lombok
- Maven
- Postman

---

# 📦 Dependencias utilizadas

- Spring Web
- Spring Security
- OpenFeign
- Lombok
- DevTools
- Validation
- Spring Boot Starter Test

---

# 🛠 Requisitos previos

## ✅ Java 21

https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html

---

## ✅ Maven

https://maven.apache.org/download.cgi

---

## ✅ IntelliJ IDEA

https://www.jetbrains.com/idea/download/

---

## ✅ Postman

https://www.postman.com/downloads/

---

# ⚙ Configuración

## Puerto

server.port=9092

---

# 🔗 Comunicación entre microservicios

Se utiliza OpenFeign para comunicarse con MS Register.

## Cliente Feign

@FeignClient(name = "register-service", url = "http://localhost:9091")

---

# ▶ Cómo ejecutar

MsLoginApplication

---

# 📡 Endpoints

## Login

POST http://localhost:9090/api/login

## Body ejemplo

{
"email": "camilo@test.com",
"password": "123456"
}

---

## Obtener usuarios registrados

GET http://localhost:9090/api/login/users

---

# 🔐 Seguridad

Se utiliza:
- JWT
- BCrypt
- Spring Security

---

# 🧠 Función del microservicio

Este microservicio:
- Valida credenciales
- Consulta usuarios del MS Register
- Genera tokens JWT
- Maneja autenticación

---

# 🧪 Tests

mvn test

---

# 🔄 Flujo completo del sistema

Frontend React
↓
BFF Gateway
↓
MS Register / MS Login

---

# 👨‍💻 Autores

Camilo Leiva (cc.leiva@duocuc.cl)

Nicolas Rivera (nico.veraf@duocuc.cl)

Ramiro Gomez (ra.gomezv@duocuc.cl)

Laura Fontecilla (la.fontecilla@duocuc.cl)

## **Proyecto desarrollado para Inovatech.**
