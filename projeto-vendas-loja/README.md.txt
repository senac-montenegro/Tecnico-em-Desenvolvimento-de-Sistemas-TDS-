# 📊 Projeto de Banco de Dados – Loja de Hardware

## 📌 Descrição do Projeto
Este repositório contém o desenvolvimento de um **projeto de banco de dados relacional** que simula um **sistema de vendas de uma loja de hardware**.

O projeto foi elaborado em **contexto educacional**, com foco na aplicação prática dos conceitos de **modelagem de dados, criação de tabelas, inserção de dados, consultas SQL, criação de views e análise de dados com Power BI**, aproximando o aluno de situações reais do mercado de trabalho.

Todos os dados utilizados são **fictícios**.

---

## 🎯 Objetivos

- Simular um banco de dados relacional para controle de vendas;
- Aplicar conceitos de DDL, DML, DQL e Views;
- Organizar scripts SQL seguindo boas práticas;
- Integrar o banco de dados com o Power BI;
- Disponibilizar o projeto como material didático e portfólio técnico.

---

## 🗂 Estrutura do Repositório

projeto-loja-hardware/
├── data/
│ └── dados_vendas_fixos_atualizado.xlsx
├── database/
│ ├── 01_criacao_tabelas.sql
│ ├── 02_inserts.sql
│ ├── 03_consultas.sql
│ └── 04_views_sql_vendas.sql
├── relatorio_vendas/
│ └── Relatorio_Vendas.pbix
├── docs/
│ └── Relatorio_Projeto_Loja_Hardware_ABNT.docx
└── README.md


---

## 🧱 Modelagem do Banco de Dados

O banco de dados foi desenvolvido seguindo o **modelo relacional**, utilizando **chaves primárias e estrangeiras** para garantir a integridade dos dados.

### Principais entidades
- Categorias  
- Fornecedores  
- Produtos  
- Clientes  
- Vendas  
- Itens da Venda  

Foram criadas **views SQL** para facilitar consultas e padronizar dados para análise e integração com o Power BI.

---

## 🧾 Organização dos Scripts SQL

- **01_criacao_tabelas.sql** – Criação da estrutura do banco (DDL)  
- **02_inserts.sql** – Inserção de dados fictícios (DML)  
- **03_consultas.sql** – Consultas de análise (DQL)  
- **04_views_sql_vendas.sql** – Criação de views analíticas  

---

## 🛠 Tecnologias Utilizadas

- **PostgreSQL** – Sistema Gerenciador de Banco de Dados  
- **SQL** – Criação, manipulação e consulta de dados  
- **Views SQL** – Organização das análises  
- **Power BI** – Relatórios e dashboards  
- **GitHub** – Versionamento e publicação  

---

## 📈 Relatório de Vendas (Power BI)

Na pasta **relatorio_vendas** está disponível o arquivo **Relatorio_Vendas.pbix**, contendo análises visuais como:

- Faturamento;
- Desempenho de produtos;
- Vendas por cliente e período.

As análises utilizam dados provenientes das **views criadas no PostgreSQL**.

---

## ▶️ Como Executar o Projeto

1. Criar o banco de dados no PostgreSQL;  
2. Executar:
   - `01_criacao_tabelas.sql`
   - `02_inserts.sql`
3. Executar:
   - `03_consultas.sql`
   - `04_views_sql_vendas.sql`
4. Abrir o arquivo `Relatorio_Vendas.pbix` no Power BI e configurar a conexão.

---

## 🎓 Contexto Educacional

Projeto desenvolvido para fins educacionais, utilizado como:
- Exemplo prático em aulas de Banco de Dados;
- Material de apoio para alunos;
- Base para projetos acadêmicos;
- Demonstração de boas práticas em SQL e BI.

---

## 🚀 Possíveis Evoluções

- Procedures e funções no PostgreSQL;  
- Inclusão de novos KPIs;  
- Dashboards mais avançados no Power BI;  
- Integração com aplicações web.

---

## 👨‍🏫 Autor

**Eli Sandro Azevedo Torres**  
Docente – Informática e Tecnologia  

