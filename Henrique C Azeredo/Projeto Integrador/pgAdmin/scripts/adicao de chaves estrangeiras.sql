-- -----------------------------------------------------
-- Schema ProjetoIntegrador
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS "ProjetoIntegrador" CASCADE;
CREATE SCHEMA "ProjetoIntegrador";

-- Define o caminho de busca para o novo schema
SET search_path TO "ProjetoIntegrador";

-- -----------------------------------------------------
-- Table categoria_produto
-- -----------------------------------------------------
CREATE TABLE categoria_produto (
  id_categoria_produto INT PRIMARY KEY,
  decricao_categoria_produto VARCHAR(45)
);

-- -----------------------------------------------------
-- Table produto
-- -----------------------------------------------------
CREATE TABLE produto (
  id_produto SERIAL PRIMARY KEY,
  nome_produto VARCHAR(45) NOT NULL,
  descricao_produto VARCHAR(100),
  ean_produto INT NOT NULL,
  categoria_produto_id_categoria_produto INT NOT NULL,
  
  -- Relacionamento: Produto -> Categoria
  CONSTRAINT fk_produto_categoria 
    FOREIGN KEY (categoria_produto_id_categoria_produto) 
    REFERENCES categoria_produto (id_categoria_produto)
    ON DELETE CASCADE
);

-- -----------------------------------------------------
-- Table estoque
-- -----------------------------------------------------
CREATE TABLE estoque (
  id_estoque INT PRIMARY KEY,
  produto_id_produto INT NOT NULL,
  quantidade_produto INT NOT NULL,
  
  -- Relacionamento: Estoque -> Produto
  CONSTRAINT fk_estoque_produto 
    FOREIGN KEY (produto_id_produto) 
    REFERENCES produto (id_produto)
    ON DELETE CASCADE
);

-- -----------------------------------------------------
-- Table fornecedor
-- -----------------------------------------------------
CREATE TABLE fornecedor (
  id_fornecedor INT PRIMARY KEY
);

-- -----------------------------------------------------
-- Table entrada_produto (Tabela de Junção/Histórico)
-- -----------------------------------------------------
CREATE TABLE entrada_produto (
  fornecedor_id_fornecedor INT NOT NULL,
  estoque_id_estoque INT NOT NULL,
  PRIMARY KEY (fornecedor_id_fornecedor, estoque_id_estoque),
  
  CONSTRAINT fk_entrada_fornecedor 
    FOREIGN KEY (fornecedor_id_fornecedor) 
    REFERENCES fornecedor (id_fornecedor),
    
  CONSTRAINT fk_entrada_estoque 
    FOREIGN KEY (estoque_id_estoque) 
    REFERENCES estoque (id_estoque)
);

-- -----------------------------------------------------
-- Table venda
-- -----------------------------------------------------
CREATE TABLE venda (
  id_venda INT PRIMARY KEY,
  data_venda TIMESTAMP NOT NULL
);

-- -----------------------------------------------------
-- Table saida_produto (Tabela de Junção/Histórico)
-- -----------------------------------------------------
CREATE TABLE saida_produto (
  venda_id_venda INT NOT NULL,
  estoque_id_estoque INT NOT NULL,
  PRIMARY KEY (venda_id_venda, estoque_id_estoque),
  
  CONSTRAINT fk_saida_venda 
    FOREIGN KEY (venda_id_venda) 
    REFERENCES venda (id_venda),
    
  CONSTRAINT fk_saida_estoque 
    FOREIGN KEY (estoque_id_estoque) 
    REFERENCES estoque (id_estoque)
);