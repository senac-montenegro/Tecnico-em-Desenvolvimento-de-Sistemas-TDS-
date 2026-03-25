SELECT 
    p.nome_produto AS "Medicamento/Produto", 
    c.decricao_categoria_produto AS "Categoria",
    e.quantidade_produto AS "Qtd. em Estoque"
FROM "ProjetoIntegrador".produto p
JOIN "ProjetoIntegrador".categoria_produto c ON p.categoria_produto_id_categoria_produto = c.id_categoria_produto
JOIN "ProjetoIntegrador".estoque e ON e.produto_id_produto = p.id_produto
ORDER BY c.decricao_categoria_produto;