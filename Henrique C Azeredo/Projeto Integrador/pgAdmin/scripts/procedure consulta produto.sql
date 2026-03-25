“CREATE OR REPLACE PROCEDURE "ProjetoIntegrador".consulta_estoque_produto( 

    IN p_nome VARCHAR,  

    INOUT p_result REFCURSOR DEFAULT 'meu_cursor' 

) 

LANGUAGE plpgsql 

AS $$ 

BEGIN 

    OPEN p_result FOR 

    SELECT   

        p.nome_produto,   

        e.quantidade_produto 

    FROM "ProjetoIntegrador".produto p 

    JOIN "ProjetoIntegrador".estoque e ON p.id_produto = e.produto_id_produto 

    WHERE p.nome_produto ILIKE '%' || p_nome || '%'; 

END; 

$$;” 

 

Consulta do produto: 

“BEGIN; 

  CALL "ProjetoIntegrador".consulta_estoque_produto('Dipirona');  

  FETCH ALL IN "meu_cursor"; 

COMMIT;” 