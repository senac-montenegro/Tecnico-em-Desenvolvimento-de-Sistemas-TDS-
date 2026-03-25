“CREATE OR REPLACE PROCEDURE "ProjetoIntegrador".registrar_venda( 

    IN p_id_venda INT, 

    IN p_id_estoque INT, 

    IN p_quantidade_venda INT 

) 

LANGUAGE plpgsql 

AS $$ 

BEGIN 

    -- 1. Insere a venda (usando a data/hora atual) 

    INSERT INTO "ProjetoIntegrador".venda (id_venda, data_venda) 

    VALUES (p_id_venda, CURRENT_TIMESTAMP); 

  

    -- 2. Insere o registro na tabela de saída de produtos 

    INSERT INTO "ProjetoIntegrador".saida_produto (venda_id_venda, estoque_id_estoque) 

    VALUES (p_id_venda, p_id_estoque); 

  

    -- 3. Diminui a quantidade na tabela de estoque 

    UPDATE "ProjetoIntegrador".estoque 

    SET quantidade_produto = quantidade_produto - p_quantidade_venda 

    WHERE id_estoque = p_id_estoque; 

  

    -- Validação simples: Se o estoque ficar negativo, o banco pode disparar um erro 

    -- (Opcional: Você pode adicionar um IF para barrar vendas sem estoque aqui) 

     

    RAISE NOTICE 'Venda % registrada e estoque do item % atualizado em -% unidades.', p_id_venda, p_id_estoque, p_quantidade_venda; 

END; 

$$;” 

 

Select para consulta: 

“-- Passo A: Veja o estoque antes (Ex: do lote/estoque 1001) SELECT * FROM "ProjetoIntegrador".estoque WHERE id_estoque = 1001; 

-- Passo B: Execute a venda (ID da Venda: 999, No Estoque: 1001, Quantidade: 5 itens) CALL "ProjetoIntegrador".registrar_venda(999, 1001, 5); 

-- Passo C: Veja o estoque depois (Ele deve estar com 5 unidades a menos) SELECT * FROM "ProjetoIntegrador".estoque WHERE id_estoque = 1001;” 