-- -----------------------------------------------------
-- Schema ProjetoIntegrador
-- No PostgreSQL, usamos "SCHEMA". 
-- O comando "CASCADE" remove tudo o que estiver dentro dele.
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS "ProjetoIntegrador" CASCADE;
CREATE SCHEMA "ProjetoIntegrador";

-- Define o caminho de busca para o novo schema
SET search_path TO "ProjetoIntegrador";

-- -----------------------------------------------------
-- Table categoria_produto
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS categoria_produto (
  id_categoria_produto INT NOT NULL,
  decricao_categoria_produto VARCHAR(45) NULL,
  PRIMARY KEY (id_categoria_produto)
);

-- -----------------------------------------------------
-- Table fornecedor
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS fornecedor (
  id_fornecedor INT NOT NULL,
  PRIMARY KEY (id_fornecedor)
);

-- -----------------------------------------------------
-- Table produto
-- No Postgres, AUTO_INCREMENT é substituído por SERIAL ou IDENTITY
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS produto (
  id_produto SERIAL PRIMARY KEY,
  nome_produto VARCHAR(45) NOT NULL,
  descricao_produto VARCHAR(100) NULL,
  ean_produto INT NOT NULL,
  categoria_produto_id_categoria_produto INT NOT NULL
);

-- -----------------------------------------------------
-- Table estoque
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estoque (
  id_estoque INT NOT NULL,
  produto_id_produto INT NOT NULL,
  quantidade_produto INT NOT NULL,
  PRIMARY KEY (id_estoque)
);

-- -----------------------------------------------------
-- Table entrada_produto
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS entrada_produto (
  fornecedor_id_fornecedor INT NOT NULL,
  estoque_id_estoque INT NOT NULL,
  PRIMARY KEY (fornecedor_id_fornecedor, estoque_id_estoque)
);

-- -----------------------------------------------------
-- Table venda
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS venda (
  id_venda INT NOT NULL,
  data_venda TIMESTAMP NOT NULL,
  PRIMARY KEY (id_venda)
);

-- -----------------------------------------------------
-- Table saida_produto
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS saida_produto (
  venda_id_venda INT NOT NULL,
  estoque_id_estoque INT NOT NULL,
  PRIMARY KEY (venda_id_venda, estoque_id_estoque)
);