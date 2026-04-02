-- O ID da Novalgina no estoque é 1001 (conforme o script acima)
CALL "ProjetoIntegrador".registrar_venda(202601, 1001, 3);

-- Verificando se baixou para 97 unidades
SELECT * FROM "ProjetoIntegrador".estoque WHERE id_estoque = 1001;