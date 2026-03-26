##### CREATE TABLE fornecedor (

id\_fornecedor SERIAL PRIMARY KEY,

nome VARCHAR(100) NOT NULL,

telefone VARCHAR (20),

endereço VARCHAR (150),

CNPJ VARCHAR (18) NOT NULL

);



CREATE TABLE produto (

&#x20;   idproduto SERIAL PRIMARY KEY,

&#x20;   nome VARCHAR(100),

&#x20;   descricao VARCHAR(300),

&#x20;   categoria VARCHAR(45),

&#x20;   preco DECIMAL(10,2),

&#x20;   quant\_estoque INT,

&#x20;   validade DATE

);



CREATE TABLE compra (

&#x20;   idcompra SERIAL PRIMARY KEY,

&#x20;   data\_emissao DATE,

&#x20;   valor\_total DECIMAL(10,2),

&#x20;   fornecedor\_idfornecedor INT,

&#x20;   FOREIGN KEY (fornecedor\_idfornecedor)

&#x20;       REFERENCES fornecedor(idfornecedor)

);



CREATE TABLE itens\_compra (

&#x20;   compra\_idcompra INT,

&#x20;   produto\_idproduto INT,

&#x20;   FOREIGN KEY (compra\_idcompra)

&#x20;       REFERENCES compra(idcompra),

&#x20;   FOREIGN KEY (produto\_idproduto)

&#x20;       REFERENCES produto(idproduto)

);



CREATE TABLE filial (

&#x20;   idfilial SERIAL PRIMARY KEY,

&#x20;   nome VARCHAR(100),

&#x20;   endereco VARCHAR(150)

);



CREATE TABLE distribuicao (

&#x20;   iddistribuicao SERIAL PRIMARY KEY,

&#x20;   data DATE,

&#x20;   valor DECIMAL(10,2),

&#x20;   filial\_idfilial INT,

&#x20;   FOREIGN KEY (filial\_idfilial)

&#x20;       REFERENCES filial(idfilial)

);



CREATE TABLE itens\_distribuicao (

&#x20;   produto\_idproduto INT,

&#x20;   distribuicao\_iddistribuicao INT,

&#x20;   FOREIGN KEY (produto\_idproduto)

&#x20;       REFERENCES produto(idproduto),

&#x20;   FOREIGN KEY (distribuicao\_iddistribuicao)

&#x20;       REFERENCES distribuicao(iddistribuicao)

);



CREATE TABLE estoque (

&#x20;   id\_estoque SERIAL PRIMARY KEY,

&#x20;   produto\_idproduto INTEGER,

&#x20;   filial\_idfilial INTEGER,

&#x20;   capacidade INTEGER,



&#x20;   CONSTRAINT fk\_produto

&#x20;       FOREIGN KEY (produto\_idproduto)

&#x20;       REFERENCES produto (id\_produto),



&#x20;   CONSTRAINT fk\_filial

&#x20;       FOREIGN KEY (filial\_idfilial)

&#x20;       REFERENCES filial (id\_filial)

);

