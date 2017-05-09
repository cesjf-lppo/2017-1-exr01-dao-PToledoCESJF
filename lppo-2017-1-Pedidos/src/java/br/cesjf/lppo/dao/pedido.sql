DROP TABLE pedido;

CREATE TABLE pedido
(
	id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	pedido INTEGER NOT NULL,
        dono VARCHAR(50) NOT NULL,
        valor REAL NOT NULL,
	nome VARCHAR(90) NOT NULL,
        atualizacao TIMESTAMP
);

INSERT INTO pedido(pedido, dono, valor, nome) VALUES(01, 'Joao', 320.30, 'TECLADO');

