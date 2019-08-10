DROP TABLE IF EXISTS contas;

CREATE TABLE contas (
    id IDENTITY PRIMARY KEY,
    nome VARCHAR(250) NOT NULL,
    tipo ENUM('PAGAR', 'RECEBER') NOT NULL DEFAULT 'PAGAR',
    ciclo ENUM('PERMANENTE', 'PARCELADA') NOT NULL DEFAULT 'PERMANENTE',
    parcelas INT NOT NULL DEFAULT 1,
    valor NUMERIC(18,2) NOT NULL DEFAULT 0.0,
    data_criacao DATE NOT NULL,
    id_primeira_parcela INT DEFAULT NULL
);

INSERT INTO contas(id, nome, tipo, ciclo, parcelas, valor, data_criacao, id_primeira_parcela) VALUES
    (100, 'Joao', 'RECEBER', 'PERMANENTE', 1, 503.56, CURRENT_DATE, null),
    (101, 'Maria', 'PAGAR', 'PERMANENTE', 1, 102.30, CURRENT_DATE, null),
    (102, 'Josefina', 'RECEBER', 'PARCELADA', 4, 2500.00, CURRENT_DATE, null),
    (103, 'Josefina', 'RECEBER', 'PARCELADA', 4, 2500.00, DATEADD(MONTH, 1, CURRENT_DATE), 102),
    (104, 'Josefina', 'RECEBER', 'PARCELADA', 4, 2500.00, DATEADD(MONTH, 2, CURRENT_DATE), 102),
    (105, 'Josefina', 'RECEBER', 'PARCELADA', 4, 2500.00, DATEADD(MONTH, 3, CURRENT_DATE), 102),
    (106, 'Godofredo', 'PAGAR', 'PARCELADA', 3, 6666.00, CURRENT_DATE, null),
    (107, 'Godofredo', 'PAGAR', 'PARCELADA', 3, 6666.00, DATEADD(MONTH, 1, CURRENT_DATE), 106),
    (108, 'Godofredo', 'PAGAR', 'PARCELADA', 3, 6666.00, DATEADD(MONTH, 2, CURRENT_DATE), 106);