CREATE TABLE ambiente
(
    id_ambiente        INT         NOT NULL,
    descricao_ambiente VARCHAR(45) NOT NULL,
    id_imovel          INT         NOT NULL,
    CONSTRAINT pk_ambiente PRIMARY KEY (id_ambiente)
);

CREATE TABLE armario
(
    id_armario        INT         NOT NULL,
    descricao_armario VARCHAR(45) NOT NULL,
    ambiente          INT         NOT NULL,
    CONSTRAINT pk_armario PRIMARY KEY (id_armario)
);

CREATE TABLE categoriaproduto
(
    id_categoria_produto INT          NOT NULL,
    name                 VARCHAR(255) NOT NULL,
    CONSTRAINT pk_categoriaproduto PRIMARY KEY (id_categoria_produto)
);

CREATE TABLE compartimento
(
    id_compartimento          INT         NOT NULL,
    descricao_compartimento   VARCHAR(45) NOT NULL,
    largura_compartimento     INT NULL,
    comprimento_compartimento INT NULL,
    altura_compartimento      INT NULL,
    id_divisoria              INT NULL,
    id_armario                INT NULL,
    id_ambiente               INT NULL,
    CONSTRAINT pk_compartimento PRIMARY KEY (id_compartimento)
);

CREATE TABLE divisoria
(
    id_divisoria        INT         NOT NULL,
    descricao_divisoria VARCHAR(45) NOT NULL,
    id_armario          INT         NOT NULL,
    CONSTRAINT pk_divisoria PRIMARY KEY (id_divisoria)
);

CREATE TABLE estoque
(
    id_estoque             INT NOT NULL,
    id_produto             INT NOT NULL,
    id_compartimento       INT NOT NULL,
    quantidade             INT NOT NULL,
    data_validade_original date NULL,
    data_validade_pessoal  date NULL,
    CONSTRAINT pk_estoque PRIMARY KEY (id_estoque)
);

CREATE TABLE imovel
(
    id_imovel   INT         NOT NULL,
    apelido     VARCHAR(45) NOT NULL,
    cep         VARCHAR(45) NOT NULL,
    logradouro  VARCHAR(45) NOT NULL,
    numero      INT         NOT NULL,
    complemento VARCHAR(45) NULL,
    bairro      VARCHAR(45) NOT NULL,
    cidade      VARCHAR(45) NOT NULL,
    estado      VARCHAR(45) NOT NULL,
    pais        VARCHAR(45) NOT NULL,
    CONSTRAINT pk_imovel PRIMARY KEY (id_imovel)
);

CREATE TABLE produto
(
    id_produto            INT         NOT NULL,
    nome_produto          VARCHAR(45) NOT NULL,
    descricao_produto     VARCHAR(45) NULL,
    id_unidade            INT NULL,
    quantidade            INT NULL,
    codigo_barras_produto VARCHAR(45) NULL,
    id_categoria_produto  INT NULL,
    consumo_diario        INT NULL,
    CONSTRAINT pk_produto PRIMARY KEY (id_produto)
);

CREATE TABLE unidade
(
    id_unidade   INT         NOT NULL,
    nome_unidade VARCHAR(45) NOT NULL,
    CONSTRAINT pk_unidade PRIMARY KEY (id_unidade)
);

ALTER TABLE imovel
    ADD CONSTRAINT uc_imovel_apelido UNIQUE (apelido);

ALTER TABLE ambiente
    ADD CONSTRAINT FK_AMBIENTE_ON_IDIMOVEL FOREIGN KEY (id_imovel) REFERENCES imovel (id_imovel);

ALTER TABLE armario
    ADD CONSTRAINT FK_ARMARIO_ON_AMBIENTE FOREIGN KEY (ambiente) REFERENCES ambiente (id_ambiente);

ALTER TABLE compartimento
    ADD CONSTRAINT FK_COMPARTIMENTO_ON_IDAMBIENTE FOREIGN KEY (id_ambiente) REFERENCES ambiente (id_ambiente);

ALTER TABLE compartimento
    ADD CONSTRAINT FK_COMPARTIMENTO_ON_IDARMARIO FOREIGN KEY (id_armario) REFERENCES armario (id_armario);

ALTER TABLE compartimento
    ADD CONSTRAINT FK_COMPARTIMENTO_ON_IDDIVISORIA FOREIGN KEY (id_divisoria) REFERENCES divisoria (id_divisoria);

ALTER TABLE divisoria
    ADD CONSTRAINT FK_DIVISORIA_ON_IDARMARIO FOREIGN KEY (id_armario) REFERENCES armario (id_armario);

ALTER TABLE estoque
    ADD CONSTRAINT FK_ESTOQUE_ON_IDCOMPARTIMENTO FOREIGN KEY (id_compartimento) REFERENCES compartimento (id_compartimento);

ALTER TABLE estoque
    ADD CONSTRAINT FK_ESTOQUE_ON_IDPRODUTO FOREIGN KEY (id_produto) REFERENCES produto (id_produto);

ALTER TABLE produto
    ADD CONSTRAINT FK_PRODUTO_ON_IDCATEGORIAPRODUTO FOREIGN KEY (id_categoria_produto) REFERENCES categoriaproduto (id_categoria_produto);

ALTER TABLE produto
    ADD CONSTRAINT FK_PRODUTO_ON_IDUNIDADE FOREIGN KEY (id_unidade) REFERENCES unidade (id_unidade);