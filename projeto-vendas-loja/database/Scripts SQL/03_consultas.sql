
-- ============================================
-- CONSULTAS SQL - SISTEMA DE VENDAS
-- Banco: PostgreSQL (compatível com outros SGBDs com pequenos ajustes)
-- ============================================

-- 1. Listar todos os vendedores
SELECT id_vendedor, nome_vendedor
FROM vendedores
ORDER BY nome_vendedor;

-- --------------------------------------------

-- 2. Listar todos os produtos com seus preços
SELECT id_produto, nome_produto, valor_unitario
FROM produtos
ORDER BY nome_produto;

-- --------------------------------------------

-- 3. Listar cidades por estado
SELECT nome_cidade, uf, regiao
FROM localidades
ORDER BY uf, nome_cidade;

-- --------------------------------------------

-- 4. Listar vendas com nome do vendedor e cidade
SELECT 
    v.id_venda,
    ve.nome_vendedor,
    v.data_venda,
    l.nome_cidade,
    l.uf
FROM vendas v
JOIN vendedores ve ON v.id_vendedor = ve.id_vendedor
JOIN localidades l ON v.id_cidade = l.id_cidade
ORDER BY v.data_venda;

-- --------------------------------------------

-- 5. Itens vendidos com nome do produto
SELECT
    iv.id_item_venda,
    iv.id_venda,
    p.nome_produto,
    iv.quantidade,
    iv.preco_unitario_venda,
    iv.valor_total_venda
FROM itens_venda iv
JOIN produtos p ON iv.id_produto = p.id_produto
ORDER BY iv.id_venda;

-- --------------------------------------------

-- 6. Valor total de cada venda
SELECT
    v.id_venda,
    SUM(iv.valor_total_venda) AS total_venda
FROM vendas v
JOIN itens_venda iv ON v.id_venda = iv.id_venda
GROUP BY v.id_venda
ORDER BY total_venda DESC;

-- --------------------------------------------

-- 7. Total vendido por vendedor
SELECT
    ve.nome_vendedor,
    SUM(iv.valor_total_venda) AS total_vendido
FROM vendedores ve
JOIN vendas v ON ve.id_vendedor = v.id_vendedor
JOIN itens_venda iv ON v.id_venda = iv.id_venda
GROUP BY ve.nome_vendedor
ORDER BY total_vendido DESC;

-- --------------------------------------------

-- 8. Total vendido por cidade
SELECT
    l.nome_cidade,
    l.uf,
    SUM(iv.valor_total_venda) AS total_vendido
FROM localidades l
JOIN vendas v ON l.id_cidade = v.id_cidade
JOIN itens_venda iv ON v.id_venda = iv.id_venda
GROUP BY l.nome_cidade, l.uf
ORDER BY total_vendido DESC;

-- --------------------------------------------

-- 9. Total vendido por região
SELECT
    l.regiao,
    SUM(iv.valor_total_venda) AS total_vendido
FROM localidades l
JOIN vendas v ON l.id_cidade = v.id_cidade
JOIN itens_venda iv ON v.id_venda = iv.id_venda
GROUP BY l.regiao
ORDER BY total_vendido DESC;

-- --------------------------------------------

-- 10. Quantidade total vendida por produto
SELECT
    p.nome_produto,
    SUM(iv.quantidade) AS quantidade_vendida
FROM produtos p
JOIN itens_venda iv ON p.id_produto = iv.id_produto
GROUP BY p.nome_produto
ORDER BY quantidade_vendida DESC;

-- --------------------------------------------

-- 11. Faturamento por produto
SELECT
    p.nome_produto,
    SUM(iv.valor_total_venda) AS faturamento
FROM produtos p
JOIN itens_venda iv ON p.id_produto = iv.id_produto
GROUP BY p.nome_produto
ORDER BY faturamento DESC;

-- --------------------------------------------

-- 12. Total vendido por data
SELECT
    v.data_venda,
    SUM(iv.valor_total_venda) AS total_dia
FROM vendas v
JOIN itens_venda iv ON v.id_venda = iv.id_venda
GROUP BY v.data_venda
ORDER BY v.data_venda;

-- --------------------------------------------

-- 13. Total vendido por mês
SELECT
    DATE_TRUNC('month', v.data_venda) AS mes,
    SUM(iv.valor_total_venda) AS total_mes
FROM vendas v
JOIN itens_venda iv ON v.id_venda = iv.id_venda
GROUP BY mes
ORDER BY mes;

-- --------------------------------------------

-- 14. Relatório detalhado de vendas
SELECT
    v.id_venda,
    v.data_venda,
    ve.nome_vendedor,
    l.nome_cidade,
    p.nome_produto,
    iv.quantidade,
    iv.preco_unitario_venda,
    iv.valor_total_venda
FROM vendas v
JOIN vendedores ve ON v.id_vendedor = ve.id_vendedor
JOIN localidades l ON v.id_cidade = l.id_cidade
JOIN itens_venda iv ON v.id_venda = iv.id_venda
JOIN produtos p ON iv.id_produto = p.id_produto
ORDER BY v.data_venda, v.id_venda;
