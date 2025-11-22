# SkillBridge - Plataforma de Transição de Carreira (API)

Projeto entregue para a disciplina **Domain Driven Design – Java**.
Tema: **O Futuro do Trabalho** (Requalificação / Transição de carreira)

## 👥 Integrantes do Grupo
 
- Luca Monteiro – RM556906  
- Davi Vieira – RM556798

## Resumo
SkillBridge é uma API RESTful em Java + Spring Boot que permite:
- Gerenciar profissionais em transição (CRUD)
- Gerenciar programas de transição (CRUD)
- Inscrever profissionais em programas
- Seeds iniciais com skills, programas e profissionais

Conecta-se aos ODS: 4 (Educação), 8 (Trabalho), 9 (Inovação), 10 (Redução de desigualdades).

## Tecnologias
- Java 17
- Spring Boot
- Spring Data JPA
- H2 (in-memory)
- Bean Validation (Jakarta Validation)

## Como executar
1. Requisitos: JDK 17 e Maven.
2. Rodar:
```bash
mvn clean install
mvn spring-boot:run
```
A API ficará disponível em `http://localhost:8080`.

## Endpoints principais
Profissionais:
- GET /profissionais
- GET /profissionais/{id}
- POST /profissionais
- PUT /profissionais/{id}
- DELETE /profissionais/{id}

Programas:
- GET /programas
- GET /programas/{id}
- POST /programas
- PUT /programas/{id}
- DELETE /programas/{id}

Inscricoes:
- POST /inscricoes
- GET /inscricoes/profissional/{id}

## Banco de dados
H2 em memória com seeds em `src/main/resources/data.sql`.
Console H2 em `/h2-console` (JDBC URL: `jdbc:h2:mem:skilldb`).

## Observações
- Validações via Bean Validation; tratamento de exceções em `ApiExceptionHandler`.
- Para testes com JSON use Postman/Insomnia. Exemplos de payloads no README do repositório.

