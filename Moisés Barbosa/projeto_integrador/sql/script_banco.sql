-- 1. Tabela Caminhão
CREATE TABLE caminhao (
    id_caminhao SERIAL PRIMARY KEY,
    placa VARCHAR(8) NOT NULL UNIQUE,
    modelo VARCHAR(50),
    capacidade_ton NUMERIC(5,2),
    status_atual VARCHAR(20),
    comentario TEXT
);

-- 2. Tabela Talhão
CREATE TABLE talhao (
    id_talhao SERIAL PRIMARY KEY,
    codigo_area VARCHAR(20),
    tch_estimado NUMERIC(6,2),
    brix NUMERIC(4,2),
    data_plantio DATE,
    umidade NUMERIC(5,2),
    tem_florada BOOLEAN
);

-- 3. Tabela Viagem
CREATE TABLE viagem (
    id_viagem SERIAL PRIMARY KEY,
    id_caminhao INTEGER,
    id_talhao INTEGER,
    data_hora_inicio TIMESTAMP WITHOUT TIME ZONE,
    data_hora_fim TIMESTAMP WITHOUT TIME ZONE,
    peso_bruto NUMERIC(10,2),

    -- Definição explícita das Chaves Estrangeiras
    CONSTRAINT fk_viagem_caminhao 
        FOREIGN KEY (id_caminhao) 
        REFERENCES caminhao(id_caminhao),
    
    CONSTRAINT fk_viagem_talhao 
        FOREIGN KEY (id_talhao) 
        REFERENCES talhao(id_talhao)
);

-- 4. Tabela Check-in
CREATE TABLE checkin (
    id_checkin SERIAL PRIMARY KEY,
    id_viagem INTEGER,
    localizacao VARCHAR(50),
    data_hora_registro TIMESTAMP WITHOUT TIME ZONE,

    -- Chave Estrangeira com Cascade (Se a viagem sumir, os check-ins somem)
    CONSTRAINT fk_checkin_viagem 
        FOREIGN KEY (id_viagem) 
        REFERENCES viagem(id_viagem) 
        ON DELETE CASCADE
);
