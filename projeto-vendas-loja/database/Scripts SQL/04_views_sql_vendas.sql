
-- ============================================
-- VIEWS SQL - SISTEMA DE VENDAS
-- Banco: PostgreSQL
-- ============================================

-- View 1: Vendas com vendedor e cidade
CREATE OR REPLACE VIEW vw_vendas_resumo AS
SELECT 
    v.id_venda,
    v.data_venda,
    ve.nome_vendedor,
    l.nome_cidade,
    l.uf,
    l.regiao
FROM vendas v
JOIN vendedores ve ON v.id_vendedor = ve.id_vendedor
JOIN localidades l ON v.id_cidade = l.id_cidade;

-- --------------------------------------------

-- View 2: Itens de venda detalhados
CREATE OR REPLACE VIEW vw_itens_venda_detalhado AS
SELECT
    iv.id_item_venda,
    iv.id_venda,
    p.nome_produto,
    iv.quantidade,
    iv.preco_unitario_venda,
    iv.valor_total_venda
FROM itens_venda iv
JOIN produtos p ON iv.id_produto = p.id_produto;

-- --------------------------------------------

-- View 3: Total por venda
CREATE OR REPLACE VIEW vw_total_por_venda AS
SELECT
    v.id_venda,
    SUM(iv.valor_total_venda) AS total_venda
FROM vendas v
JOIN itens_venda iv ON v.id_venda = iv.id_venda
GROUP BY v.id_venda;

-- --------------------------------------------

-- View 4: Total vendido por vendedor
CREATE OR REPLACE VIEW vw_total_por_vendedor AS
SELECT
    ve.id_vendedor,
    ve.nome_vendedor,
    SUM(iv.valor_total_venda) AS total_vendido
FROM vendedores ve
JOIN vendas v ON ve.id_vendedor = v.id_vendedor
JOIN itens_venda iv ON v.id_venda = iv.id_venda
GROUP BY ve.id_vendedor, ve.nome_vendedor;

-- --------------------------------------------

-- View 5: Total vendido por produto
CREATE OR REPLACE VIEW vw_total_por_produto AS
SELECT
    p.id_produto,
    p.nome_produto,
    SUM(iv.quantidade) AS quantidade_vendida,
    SUM(iv.valor_total_venda) AS faturamento
FROM produtos p
JOIN itens_venda iv ON p.id_produto = iv.id_produto
GROUP BY p.id_produto, p.nome_produto;

-- --------------------------------------------

-- View 6: Total vendido por cidade
CREATE OR REPLACE VIEW vw_total_por_cidade AS
SELECT
    l.id_cidade,
    l.nome_cidade,
    l.uf,
    SUM(iv.valor_total_venda) AS total_vendido
FROM localidades l
JOIN vendas v ON l.id_cidade = v.id_cidade
JOIN itens_venda iv ON v.id_venda = iv.id_venda
GROUP BY l.id_cidade, l.nome_cidade, l.uf;

-- --------------------------------------------

-- View 7: Total vendido por região
CREATE OR REPLACE VIEW vw_total_por_regiao AS
SELECT
    l.regiao,
    SUM(iv.valor_total_venda) AS total_vendido
FROM localidades l
JOIN vendas v ON l.id_cidade = v.id_cidade
JOIN itens_venda iv ON v.id_venda = iv.id_venda
GROUP BY l.regiao;

-- --------------------------------------------

-- View 8: Total vendido por data
CREATE OR REPLACE VIEW vw_total_por_data AS
SELECT
    v.data_venda,
    SUM(iv.valor_total_venda) AS total_dia
FROM vendas v
JOIN itens_venda iv ON v.id_venda = iv.id_venda
GROUP BY v.data_venda;

-- --------------------------------------------

-- View 9: Total vendido por mês
CREATE OR REPLACE VIEW vw_total_por_mes AS
SELECT
    DATE_TRUNC('month', v.data_venda) AS mes,
    SUM(iv.valor_total_venda) AS total_mes
FROM vendas v
JOIN itens_venda iv ON v.id_venda = iv.id_venda
GROUP BY mes;
