CREATE TABLE TblFuncionarios
(
    CodigoDoFuncionario INT NOT NULL,
    NomeDoFuncionario   VARCHAR(50) DEFAULT NULL,
    DataDeNascimento    DATE        DEFAULT NULL,
    DataDeAdmissao      DATETIME,
    PRIMARY KEY (CodigoDoFuncionario)
);
GO

CREATE TABLE TblFaltas
(
    CodigoDasFaltas     INT NOT NULL,
    CodigoDoFuncionario INT,
    DataDaFalta         DATE,
    MotivoDaFalta       VARCHAR(30),
    Observacoes         VARCHAR(50),
    PRIMARY KEY (CodigoDasFaltas, CodigoDoFuncionario),
    FOREIGN KEY (CodigoDoFuncionario)
        REFERENCES TblFuncionarios (CodigoDoFuncionario)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
GO

CREATE TABLE TblSalarios
(
    CodigoDoSalario     INT      NOT NULL,
    CodigoDoFuncionario INT,
    ValorEmKwanzas      DOUBLE PRECISION DEFAULT 0.0,
    ValorEmDolares      DOUBLE PRECISION DEFAULT 0.0,
    Servico             VARCHAR(30),
    Referente           VARCHAR(30),
    DataDeEntrega       DATETIME NOT NULL,
    Observacoes         VARCHAR(50),
    PRIMARY KEY (CodigoDoSalario, CodigoDoFuncionario),
    FOREIGN KEY (CodigoDoFuncionario)
        REFERENCES TblFuncionarios (CodigoDoFuncionario)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
GO

CREATE TABLE TblCursos
(
    CodigoDoCurso VARCHAR(50) NOT NULL UNIQUE,
    NomeDoCurso   VARCHAR(50),
    PrecoUnitario DOUBLE PRECISION,
    PRIMARY KEY (CodigoDoCurso)
);
GO

CREATE TABLE TblTurmas
(
    CodigoDaTurma VARCHAR(50) NOT NULL UNIQUE,
    NomeDaTurma   VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (CodigoDaTurma)
);
GO

CREATE TABLE TblHorarios
(
    CodigoDoHorario VARCHAR(50) NOT NULL UNIQUE,
    NomeDoHorario   VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (CodigoDoHorario)
);
GO

CREATE TABLE TblAlunos
(
    CodigoDoAluno                 INT NOT NULL,
    NomeDoAluno                   VARCHAR(50),
    TelefoneDoAluno               VARCHAR(50),
    MoradaDoAluno                 VARCHAR(50),
    LocalDeNascimentoDoAluno      VARCHAR(30),
    NacionalidadeDoAluno          VARCHAR(20),
    HabilitacoesLiterariasDoAluno VARCHAR(80),
    SexoDoAluno                   VARCHAR(50),
    OutrosdadosdoAluno            VARCHAR(255),
    PRIMARY KEY (CodigoDoAluno)
);
GO

CREATE TABLE TblInscricoes
(
    CodigoDaInscricao   INT NOT NULL,
    DataDaInscricao     DATETIME DEFAULT GETDATE(),
    CodigoDoAluno       INT,
    CodigoDoFuncionario INT,
    PRIMARY KEY (CodigoDaInscricao),
    FOREIGN KEY (CodigoDoAluno)
        REFERENCES TblAlunos (CodigoDoAluno)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (CodigoDoFuncionario)
        REFERENCES TblFuncionarios (CodigoDoFuncionario)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
GO

CREATE TABLE TblDetalhesDaInscricao
(
    CodigoDaInscricao INT         NOT NULL,
    CodigoDoCurso     VARCHAR(50) NOT NULL,
    CodigoDaTurma     VARCHAR(50),
    CodigoDoHorario   VARCHAR(50),
    CodigoDoProfessor INT,
    DataDeInicio      DATETIME,
    DataDeFim         DATETIME,
    ValorPago         DOUBLE PRECISION,
    ValorPago2        DOUBLE PRECISION DEFAULT 0.0,
    Observacoes       VARCHAR(50)      DEFAULT NULL,
    NotaFinal         INT              DEFAULT NULL,
    PRIMARY KEY (CodigoDaInscricao, CodigoDoCurso),
    FOREIGN KEY (CodigoDoCurso)
        REFERENCES TblCursos (CodigoDoCurso)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (CodigoDaTurma)
        REFERENCES TblTurmas (CodigoDaTurma)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (CodigoDoHorario)
        REFERENCES TblHorarios (CodigoDoHorario)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
GO

CREATE TABLE TblOperacoes
(
    ChaveDaOperacao  INT,
    CodigoDaOperacao VARCHAR(50) NOT NULL UNIQUE,
    NomeDaOperacao   VARCHAR(50),
    PRIMARY KEY (CodigoDaOperacao)
);
GO

CREATE TABLE TblEntradas
(
    NumeroDaOperacao INT,
    DataDaOperacao   DATETIME,
    CodigoDaOperacao VARCHAR(50),
    ValorPagoEmUSD   DOUBLE PRECISION,
    ValorPagoEmKz    DOUBLE PRECISION,
    PRIMARY KEY (NumeroDaOperacao),
    FOREIGN KEY (CodigoDaOperacao)
        REFERENCES TblOperacoes (CodigoDaOperacao)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
GO

CREATE TABLE TblPagamentos
(
    codigoAlunoPagamento VARCHAR(50) NOT NULL UNIQUE,
    NomeAlunoPagamento   VARCHAR(50),
    turmaAlunoPagamento  VARCHAR(50),
    OperacaoPagamento    VARCHAR(50),
    ValorEmKzPagamento   DOUBLE PRECISION,
    ValorEmUSDPagamento  DOUBLE PRECISION,
    DataPagamento        DATETIME,
    PRIMARY KEY (codigoAlunoPagamento),
    FOREIGN KEY (turmaAlunoPagamento)
        REFERENCES TblTurmas (CodigoDaTurma)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (OperacaoPagamento)
        REFERENCES TblOperacoes (CodigoDaOperacao)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
GO

CREATE TABLE TblItemPagamentos
(
    IDItemPagamento   INT NOT NULL,
    OperacaoPagamento VARCHAR(50),
    TurmaPagamento    VARCHAR(50),
    ValorKZ           DOUBLE PRECISION,
    ValorUSD          DOUBLE PRECISION,
    PRIMARY KEY (IDItemPagamento),
    FOREIGN KEY (TurmaPagamento)
        REFERENCES TblTurmas (CodigoDaTurma)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (OperacaoPagamento)
        REFERENCES TblOperacoes (CodigoDaOperacao)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
GO
