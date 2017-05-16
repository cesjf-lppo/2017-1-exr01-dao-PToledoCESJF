DROP TABLE pedido;

CREATE TABLE pedido
(
	id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	pedido INTEGER NOT NULL,
        dono VARCHAR(50) NOT NULL,
        valor REAL NOT NULL,
	nome VARCHAR(90) NOT NULL,
        atualizacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO pedido(pedido, dono, valor, nome) VALUES(10, 'Manuel', 3120.70, 'GUITARRA');
INSERT INTO pedido(pedido, dono, valor, nome) VALUES(11, 'Jaquim', 30.20, 'PEDALEIRAS');
INSERT INTO pedido(pedido, dono, valor, nome) VALUES(20, 'Gertrudes', 210.90, 'CONTRABAIXO');

