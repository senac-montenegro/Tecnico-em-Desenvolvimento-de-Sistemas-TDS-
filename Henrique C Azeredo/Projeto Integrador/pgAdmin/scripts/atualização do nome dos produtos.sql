SET search_path TO "ProjetoIntegrador";

-- Limpa os dados de estoque e produtos para recomeçar com nomes reais
TRUNCATE TABLE saida_produto, entrada_produto, estoque, produto CASCADE;

-- Inserindo Medicamentos Reais
INSERT INTO produto (id_produto, nome_produto, descricao_produto, ean_produto, categoria_produto_id_categoria_produto) VALUES
-- Categoria 1: Referência
(1, 'Novalgina 500mg', 'Analgésico e antitérmico - 10 comprimidos', 7891010, 1),
(2, 'Buscopan Composto', 'Antiespasmódico - 20 drágeas', 7891011, 1),
(3, 'Tylenol 750mg', 'Paracetamol para alívio de dor - 20 comprimidos', 7891012, 1),
(4, 'Allegra 120mg', 'Anti-histamínico para alergia - 10 comprimidos', 7891013, 1),
(5, 'Advil 400mg', 'Ibuprofeno em cápsulas líquidas - 8 cápsulas', 7891014, 1),

-- Categoria 2: Genéricos
(6, 'Dipirona Sódica 500mg', 'Genérico Medley - 20 comprimidos', 7892010, 2),
(7, 'Amoxicilina 500mg', 'Genérico EMS - Antibiótico - 21 cápsulas', 7892011, 2),
(8, 'Losartana Potássica 50mg', 'Genérico Neo Química - Controle de pressão', 7892012, 2),
(9, 'Omeprazol 20mg', 'Genérico Eurofarma - Protetor gástrico', 7892013, 2),
(10, 'Sildenafila 50mg', 'Genérico Germed - 4 comprimidos', 7892014, 2),

-- Categoria 3: Higiene e Cuidados
(11, 'Sabonete Dove Original', 'Sabonete em barra 90g', 7893010, 3),
(12, 'Escova Dental Colgate', 'Escova cerdas macias 360 graus', 7893011, 3),
(13, 'Fralda Pampers G', 'Pacote econômico - 32 unidades', 7893012, 3),
(14, 'Desodorante Rexona Men', 'Aerosol Invisible 150ml', 7893013, 3),
(15, 'Creme Dental Sensodyne', 'Alívio para dentes sensíveis 90g', 7893014, 3),

-- Categoria 4: Dermocosméticos
(16, 'Protetor Solar La Roche-Posay', 'Anthelios FPS 60 - 50g', 7894010, 4),
(17, 'Água Micelar LOréal', 'Limpeza facial 200ml', 7894011, 4),
(18, 'Hidratante Vichy Mineral 89', 'Fortalecedor facial com ácido hialurônico', 7894012, 4),

-- Categoria 5: Suplementos e Vitaminas
(19, 'Centrum Todo Dia', 'Multivitamínico de A a Z - 30 comprimidos', 7895010, 5),
(20, 'Vitamina C Redoxon', 'Efervescente 1g - 10 comprimidos', 7895011, 5),
(21, 'Ômega 3 Lavitan', 'Suplemento de óleo de peixe - 60 cápsulas', 7895012, 5);

-- Inserindo Estoque para esses produtos (100 unidades de cada para teste)
INSERT INTO estoque (id_estoque, produto_id_produto, quantidade_produto)
SELECT id_produto + 1000, id_produto, 100 FROM produto;