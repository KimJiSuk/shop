# 과제

### Overview
API 개발
- 객체
  - 회원
  - 주문
- 기능
  - 회원 가입
  - 로그인(인증) 
  - 로그아웃 [구현 X]
  - 단일 회원 상세 정보 조회
  - 단일 회원의 주문 목록 조회
  - 여러 회원 목록 조회

### 실행
```
./gradlew build
docker-compose up -d --build

Mysql Port 3306
Api Server 8080
```

### API 문서
```
http://localhost:8080/swagger-ui.html
```

### Table DDL
```
src/sql/ddl.sql
```

### Requirements
```
Java 11
Spring boot 2.5.6
Swagger2,UI 2.9.2
JPA latest
QueryDSL latest
```