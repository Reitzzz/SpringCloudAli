# SpringCloud_Ali Multi-Module Demo

This project is split into independent modules:

- `common`: shared entities and DTOs
- `book_service`: book query service
- `user_service`: user query service
- `borrow_service`: borrow aggregation service (uses OpenFeign)

## Stack

- Java 17
- Spring Boot 3.2.12
- Spring Cloud 2023.0.1
- Spring Cloud Alibaba 2023.0.1.0
- MyBatis 3.0.3
- MySQL
- Nacos Discovery

## Database

Use the SQL below:

```sql
CREATE DATABASE IF NOT EXISTS cloudstudy;
USE cloudstudy;

CREATE TABLE `DB_USER` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `DB_BOOK` (
  `bid` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `DB_BORROW` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int DEFAULT NULL,
  `bid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

INSERT INTO DB_USER VALUES (1, 'zhangsan', 'male'), (2, 'xiaohong', 'female');
INSERT INTO DB_BOOK VALUES (1, 'Deep Java VM', 'classic'), (2, 'SpringCloud Practice', 'good');
INSERT INTO DB_BORROW VALUES (1, 1, 1), (2, 1, 2), (3, 2, 1);
```

## Default Ports

- `book_service`: `8101`
- `user_service`: `8201`
- `borrow_service`: `8301`

## Service Names in Nacos

- `bookservice`
- `userservice`
- `borrowservice`

## Build

```powershell
cd "D:\JetBrain IDEA\Project\SpringCloud_Ali"
.\mvnw.cmd -DskipTests package
```

## Run Services

Run each service in its own terminal:

```powershell
cd "D:\JetBrain IDEA\Project\SpringCloud_Ali"
.\mvnw.cmd -pl book_service spring-boot:run
```

```powershell
cd "D:\JetBrain IDEA\Project\SpringCloud_Ali"
.\mvnw.cmd -pl user_service spring-boot:run
```

```powershell
cd "D:\JetBrain IDEA\Project\SpringCloud_Ali"
.\mvnw.cmd -pl borrow_service spring-boot:run
```

## API Quick Check

```powershell
curl http://localhost:8101/book/1
curl http://localhost:8201/user/1
curl http://localhost:8301/borrow/1
```

