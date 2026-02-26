-- Garante que estamos usando o schema do Projeto Integrador
SET search_path TO "ProjetoIntegrador";

-- 1. Inserindo Categorias de Farmácia
INSERT INTO categoria_produto (id_categoria_produto, decricao_categoria_produto) 
VALUES 
(1, 'Medicamentos Isentos (MIP)'),
(2, 'Higiene Pessoal'),
(3, 'Suplementos Alimentares');

-- 2. Inserindo Produtos (Note que o id_produto é SERIAL, gerado automaticamente)
-- Exemplo: Dipirona Monoidratada
INSERT INTO produto (nome_produto, descricao_produto, ean_produto, categoria_produto_id_categoria_produto) 
VALUES ('Dipirona 500mg', 'Analgésico e Antitérmico - 20 comprimidos', 789123456, 1);

-- Exemplo: Escova de Dentes Macia
INSERT INTO produto (nome_produto, descricao_produto, ean_produto, categoria_produto_id_categoria_produto) 
VALUES ('Escova Dental Ultra', 'Cerdas macias, cabo ergonômico', 789654321, 2);

-- 3. Inserindo no Estoque (Referenciando os IDs gerados: 1 e 2)
INSERT INTO estoque (id_estoque, produto_id_produto, quantidade_produto) 
VALUES 
(1001, 1, 150), -- 150 unidades de Dipirona no lote 1001
(1002, 2, 45);  -- 45 unidades de Escova no lote 1002

-- 4. Inserindo um Fornecedor (Distribuidora de Medicamentos)
INSERT INTO fornecedor (id_fornecedor) 
VALUES (88); -- ID da Distribuidora Saúde Ltda

-- 5. Registrando uma Entrada de Produto (Compra do fornecedor para o estoque)
INSERT INTO entrada_produto (fornecedor_id_fornecedor, estoque_id_estoque) 
VALUES (88, 1001);

-- 6. Registrando uma Venda no Balcão
INSERT INTO venda (id_venda, data_venda) 
VALUES (501, CURRENT_TIMESTAMP);

-- 7. Registrando a Saída do Produto (O item que saiu do estoque para a venda 501)
INSERT INTO saida_produto (venda_id_venda, estoque_id_estoque) 
VALUES (501, 1001);