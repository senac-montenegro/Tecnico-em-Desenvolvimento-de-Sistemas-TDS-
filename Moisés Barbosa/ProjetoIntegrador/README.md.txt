📝 Frotana - Sistema de Gestão de Logística Agrícola
O Frotana é uma aplicação Java de console desenvolvida para gerenciar o fluxo de transporte de carga pesada (como cana de açúcar), permitindo o controle desde o cadastro de frotas e talhões até o rastreamento em tempo real através de check-ins.

Este projeto foi desenvolvido como parte do curso Técnico em Desenvolvimento de Sistemas no Senac-RS.

🚀 Funcionalidades
O sistema é dividido em quatro módulos principais, cada um com um CRUD completo:

Gestão de Caminhões: Cadastro de placa, modelo, capacidade de carga e status.

Gestão de Talhões: Controle das áreas de plantio, umidade e previsão de colheita.

Controle de Viagens: Início e finalização de trajetos, vinculando caminhões a talhões específicos e calculando o peso bruto.

Rastreamento (Check-in): Registro de pontos de passagem em tempo real para monitoramento da carga.

🛠️ Tecnologias Utilizadas
Java JDK 17: Linguagem principal do projeto.

PostgreSQL: Banco de dados relacional para persistência de dados.

JDBC (Java Database Connectivity): Para comunicação entre a aplicação e o banco.

Padrão DAO (Data Access Object): Organização da camada de persistência.

NetBeans IDE: Ambiente de desenvolvimento.

🏗️ Arquitetura do Projeto
O projeto segue o padrão de camadas para facilitar a manutenção:
src/
 ├── connection/   # Configuração de conexão com o banco (Factory)
 ├── dao/          # Classes de manipulação de dados (SQL)
 ├── model/        # Entidades do sistema (Classes POJO)
 ├── view/         # Interface de usuário (Menu via Console)
 └── validations/  # Lógica de validação de dados e Exceptions

📋 Pré-requisitos
Para rodar o projeto localmente, você precisará de:

Java JDK 17 ou superior.

PostgreSQL instalado e configurado.

Driver JDBC do PostgreSQL (postgresql.jar).

🔧 Instalação e Configuração
Clone o repositório:

git clone Moisés Barbosa/ProjetoIntegrador

Configure o Banco de Dados:

Crie um banco chamado db_logistica.

Execute os scripts SQL (disponíveis na pasta /sql) para criar as tabelas.

Ajuste a conexão:

No arquivo ConnectionFactory.java, insira seu usuário e senha do PostgreSQL.


Moisés Silva Estudante de Sistemas de Desenvolvimento - Senac-RS