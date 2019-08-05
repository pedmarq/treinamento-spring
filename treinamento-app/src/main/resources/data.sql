DROP TABLE IF EXISTS contas;

CREATE TABLE contas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(250) NOT NULL,
    valor NUMERIC(18,2) DEFAULT 0.0,
    tipo CHAR DEFAULT 'R'
);

INSERT INTO contas(descricao, valor, tipo) VALUES
    ('Joao', 503.56, 'R'),
    ('Maria', 102.30, 'P'),
    ('Josefina', 10000.00, 'R');