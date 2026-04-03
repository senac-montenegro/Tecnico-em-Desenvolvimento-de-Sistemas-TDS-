# 🚛 Frotana - Sistema de Gestão de Logística Agrícola

O **Frotana** é uma aplicação Java de console desenvolvida para gerenciar o fluxo de transporte de carga pesada (como cana-de-açúcar), permitindo o controle desde o cadastro de frotas e talhões até o rastreamento em tempo real através de check-ins.

Este projeto foi desenvolvido como parte do curso **Técnico em Desenvolvimento de Sistemas no Senac-RS**.

## 🚀 Funcionalidades
O sistema é dividido em quatro módulos principais, cada um com um CRUD completo:

* **Gestão de Caminhões:** Cadastro de placa, modelo, capacidade de carga e status.
* **Gestão de Talhões:** Controle das áreas de plantio, umidade e previsão de colheita.
* **Controle de Viagens:** Início e finalização de trajetos e cálculo de peso bruto.
* **Rastreamento (Check-in):** Registro de pontos de passagem em tempo real.

## 🛠️ Tecnologias Utilizadas
* **Java JDK 17:** Linguagem principal do projeto.
* **PostgreSQL:** Banco de dados relacional.
* **JDBC:** Para comunicação com o banco.
* **Padrão DAO:** Organização da camada de persistência.
* **NetBeans IDE:** Ambiente de desenvolvimento.

## 🏗️ Arquitetura do Projeto
O projeto segue o padrão de camadas para facilitar a manutenção:

```text
src/
 ├── connection/  # Configuração de conexão (Factory)
 ├── dao/         # Classes de manipulação de dados (SQL)
 ├── model/       # Entidades do sistema (POJOs)
 ├── view/        # Interface de usuário (Menu Console)
 └── validations/ # Lógica de validação e Exceptions
