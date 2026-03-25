SET search_path TO "ProjetoIntegrador";

-- 1. Categorias
INSERT INTO categoria_produto (id_categoria_produto, decricao_categoria_produto) VALUES 
(1, 'Medicamentos de Referência'),
(2, 'Genéricos'),
(3, 'Higiene e Cuidados'),
(4, 'Dermocosméticos'),
(5, 'Suplementos e Vitaminas')
ON CONFLICT (id_categoria_produto) DO NOTHING;

-- 2. Produtos (100 itens)
INSERT INTO produto (nome_produto, descricao_produto, ean_produto, categoria_produto_id_categoria_produto)
SELECT 
    'Produto Farmacêutico ' || i,
    'Descrição detalhada do item lote ' || (random()*1000)::int,
    (789000000 + i),
    (1 + floor(random() * 5))
FROM generate_series(1, 100) AS s(i) -- Define explicitamente a coluna i
ON CONFLICT DO NOTHING;

-- 3. Fornecedores
INSERT INTO fornecedor (id_fornecedor)
SELECT i FROM generate_series(1, 10) AS s(i)
ON CONFLICT (id_fornecedor) DO NOTHING;

-- 4. Estoque
INSERT INTO estoque (id_estoque, produto_id_produto, quantidade_produto)
SELECT 
    i + 1000,
    i,
    (random() * 200 + 10)::int
FROM generate_series(1, 100) AS s(i)
ON CONFLICT (id_estoque) DO NOTHING;

-- 5. Vendas (200 vendas)
INSERT INTO venda (id_venda, data_venda)
SELECT 
    i, 
    NOW() - (random() * INTERVAL '30 days')
FROM generate_series(1, 200) AS s(i)
ON CONFLICT (id_venda) DO NOTHING;

-- 6. Entradas
INSERT INTO entrada_produto (fornecedor_id_fornecedor, estoque_id_estoque)
SELECT 
    (1 + floor(random() * 10)),
    (1001 + floor(random() * 100))
FROM generate_series(1, 100) AS s(i)
ON CONFLICT DO NOTHING;

-- 7. Saídas
INSERT INTO saida_produto (venda_id_venda, estoque_id_estoque)
SELECT 
    (1 + floor(random() * 200)),
    (1001 + floor(random() * 100))
FROM generate_series(1, 300) AS s(i)
ON CONFLICT DO NOTHING;