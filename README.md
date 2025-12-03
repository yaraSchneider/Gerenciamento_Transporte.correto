# 📚 Gerenciamento de Biblioteca — Spring Boot

Sistema desenvolvido em **Java + Spring Boot** para gerenciar livros, usuários e empréstimos.

A API segue uma arquitetura organizada em camadas (Controller, Service, Repository e Model) usando JPA/Hibernate para persistência.

---

## 🚀 Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot** (Web, Data JPA)
* **MySQL**
* **Lombok**
* **Hibernate**
* **Maven**

---
## Passos para Executar a Aplicação

* Clonar o repositório

  git clone [https://github.com/seu-usuario/Gerenciamento.Biblioteca.git](https://github.com/seu-usuario/Gerenciamento.Biblioteca.git)

 ---  

## ⚙️ Configuração e Execução

### Configuração do Banco de Dados

O arquivo de configuração é: `src/main/resources/application.properties`.

```properties
spring.application.name=Gerenciamento.Biblioteca
spring.datasource.url=jdbc:mysql://localhost:3306/db_biblioteca?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
server.port=9090
