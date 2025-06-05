//SQL para criar as tabelas
CREATE TABLE venda (
    id SERIAL PRIMARY KEY,
    observacoes VARCHAR(250) NOT NULL,
    data DATE NOT NULL,
    total NUMERIC NOT NULL,
    cliente_id INTEGER NOT NULL
);

CREATE TABLE item_venda (
    id SERIAL PRIMARY KEY,
    quantidade INTEGER NOT NULL,
    valor_unitario NUMERIC NOT NULL,
    valor_total NUMERIC NOT NULL,
    venda_id INTEGER NOT NULL,
    produto_id INTEGER NOT NULL
);

CREATE TABLE produtos(
	id SERIAL PRIMARY KEY,
	descricao VARCHAR(255) NOT NULL,
	categoria VARCHAR(100) NOT NULL,
	valor_unitario NUMERIC NOT NULL,
	quantidade INTEGER NOT NULL
);


//Alterar a tabela venda
ALTER TABLE venda
ADD COLUMN nome_cliente VARCHAR(255),
ADD COLUMN telefone_cliente VARCHAR(50),
ADD COLUMN email_cliente VARCHAR(255);


//View para o Relatorio Detalhado
CREATE OR REPLACE VIEW relatorio_vendas AS
SELECT
    v.id AS venda_id,
    v.data,
    v.nome_cliente,
    p.id AS produto_id,
    p.descricao AS nome_produto,
    iv.quantidade,
    iv.valor_unitario,
    (iv.quantidade * iv.valor_unitario) AS valor_total_item
FROM venda v
JOIN item_venda iv ON v.id = iv.venda_id
JOIN produtos p ON iv.produto_id = p.id;


