-- SCRIPT DE CRIAÇÃO E POPULAÇÃO DO BANCO DE DADOS 'vendas_db'

-- Excluir tabelas se já existirem (para facilitar re-execução)
DROP TABLE IF EXISTS itens_venda;
DROP TABLE IF EXISTS vendas;
DROP TABLE IF EXISTS localidades;
DROP TABLE IF EXISTS produtos;
DROP TABLE IF EXISTS vendedores;

-- Tabela de Vendedores
CREATE TABLE vendedores (
    id_vendedor INTEGER PRIMARY KEY,
    nome_vendedor VARCHAR(255) NOT NULL
);

-- Tabela de Produtos
CREATE TABLE produtos (
    id_produto INTEGER PRIMARY KEY,
    nome_produto VARCHAR(255) NOT NULL,
    valor_unitario NUMERIC(10, 2) NOT NULL
);

-- Tabela de Localidades
CREATE TABLE localidades (
    id_cidade INTEGER PRIMARY KEY,
    nome_cidade VARCHAR(255) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    regiao VARCHAR(255) NOT NULL
);

-- Tabela de Vendas
CREATE TABLE vendas (
    id_venda INTEGER PRIMARY KEY,
    id_vendedor INTEGER REFERENCES vendedores(id_vendedor),
    data_venda DATE NOT NULL,
    id_cidade INTEGER REFERENCES localidades(id_cidade)
);

-- Tabela de Itens da Venda
CREATE TABLE itens_venda (
    id_item_venda INTEGER PRIMARY KEY,
    id_venda INTEGER REFERENCES vendas(id_venda),
    id_produto INTEGER REFERENCES produtos(id_produto),
    quantidade INTEGER NOT NULL,
    preco_unitario_venda NUMERIC(10, 2) NOT NULL,
    valor_total_venda NUMERIC(10, 2) NOT NULL
);