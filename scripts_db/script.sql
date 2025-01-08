CREATE DATABASE IF NOT EXISTS bd_inscricoes;
USE bd_inscricoes;

CREATE TABLE IF NOT EXISTS TblFuncionarios (
    CodigoDoFuncionario INT NOT NULL AUTO_INCREMENT,
    NomeDoFuncionario VARCHAR(50) DEFAULT NULL,
    DataDeNascimento DATE DEFAULT NULL,
    DataDeAdmissao DATETIME,
    PRIMARY KEY pk_funcionarios(CodigoDoFuncionario)
);

CREATE TABLE IF NOT EXISTS TblFaltas (
    CodigoDasFaltas INT NOT NULL AUTO_INCREMENT,
    CodigoDoFuncionario INT,
    DataDaFalta DATE,
    MotivoDaFalta VARCHAR(30),
    Observacoes VARCHAR(50),
    PRIMARY KEY pk_faltas(CodigoDasFaltas, CodigoDoFuncionario),
    FOREIGN KEY fk_funcionario_falta(CodigoDoFuncionario)
        REFERENCES TblFuncionarios(CodigoDoFuncionario) 
		ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS TblSalarios (
    CodigoDoSalario INT NOT NULL AUTO_INCREMENT,
    CodigoDoFuncionario INT,
    ValorEmKwanzas DOUBLE DEFAULT 0.0,
    ValorEmDolares DOUBLE DEFAULT 0.0,
    Servico VARCHAR(30),
    Referente VARCHAR(30),
    DataDeEntrega DATETIME NOT NULL,
    Observacoes VARCHAR(50),
    PRIMARY KEY pk_salarios(CodigoDoSalario, CodigoDoFuncionario),
    FOREIGN KEY fk_funcionario_falta(CodigoDoFuncionario)
        REFERENCES TblFuncionarios(CodigoDoFuncionario)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS TblCursos (
    CodigoDoCurso VARCHAR(50) NOT NULL UNIQUE,
    NomeDoCurso VARCHAR(50),
    PrecoUnitario DOUBLE,
    PRIMARY KEY pk_cursos(CodigoDoCurso)
);

CREATE TABLE IF NOT EXISTS TblTurmas (
    CodigoDaTurma VARCHAR(50) NOT NULL UNIQUE,
    NomeDaTurma VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY pk_turmas(CodigoDaTurma)
);

CREATE TABLE IF NOT EXISTS  TblHorarios (
    CodigoDoHorario VARCHAR(50) NOT NULL UNIQUE,
    NomeDoHorario VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY pk_horarios(CodigoDoHorario)
);

CREATE TABLE IF NOT EXISTS TblAlunos (
    CodigoDoAluno INT NOT NULL,
    NomeDoAluno VARCHAR(50),
    TelefoneDoAluno VARCHAR(50),
    MoradaDoAluno VARCHAR(50),
    LocalDeNascimentoDoAluno VARCHAR(30),
    NacionalidadeDoAluno VARCHAR(20),
    HabilitacoesLiterariasDoAluno VARCHAR(80),
    SexoDoAluno ENUM('Masculino', 'Feminimo'),
    OutrosdadosdoAluno TEXT,
    PRIMARY KEY pk_alunos(CodigoDoAluno)
);

CREATE TABLE IF NOT EXISTS TblInscricoes (
    CodigoDaInscricao INT NOT NULL AUTO_INCREMENT,
    DataDaInscricao DATETIME DEFAULT NOW(),
    CodigoDoAluno INT,
	CodigoDoFuncionario INT,
    PRIMARY KEY pk_inscricoes(CodigoDaInscricao),
    FOREIGN KEY fk_aluno_inscricoes(CodigoDoAluno)
        REFERENCES TblAlunos(CodigoDoAluno)
            ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY fk_funcionario_inscricoes(CodigoDoFuncionario)
        REFERENCES TblFuncionarios(CodigoDoFuncionario)
            ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS TblDetalhesDaInscricao (
    CodigoDaInscricao INT NOT NULL,
    CodigoDoCurso VARCHAR(50) NOT NULL,
    CodigoDaTurma VARCHAR(50),
    CodigoDoHorario VARCHAR(50),
    CodigoDoProfessor INT,
    DataDeInicio DATETIME,
    DataDeFim DATETIME,
    ValorPago DOUBLE DEFAULT 0.0,
    ValorPago2 DOUBLE DEFAULT 0.0,
    Observacoes VARCHAR(50) DEFAULT NULL,
    NotaFinal INT DEFAULT NULL,
    PRIMARY KEY pk_detalhes_da_inscricao(CodigoDaInscricao, CodigoDoCurso),
    FOREIGN KEY fk_curso_inscricao(CodigoDoCurso)
        REFERENCES TblCursos(CodigoDoCurso)
            ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY fk_turma_inscricao(CodigoDaTurma)
        REFERENCES TblTurmas(CodigoDaTurma)
            ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY fk_horario_inscricao(CodigoDoHorario)
         REFERENCES TblHorarios(CodigoDoHorario)
             ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY fk_professor_inscricao(CodigoDoProfessor)
		REFERENCES TblFuncionarios(CodigoDoFuncionario)
			ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS TblOperacoes (
	ChaveDaOperacao INT,
    CodigoDaOperacao VARCHAR(50) NOT NULL UNIQUE,
    NomeDaOperacao VARCHAR(50),
    PRIMARY KEY pk_operacoes(CodigoDaOperacao)
);

CREATE TABLE IF NOT EXISTS TblEntradas (
    NumeroDaOperacao INT AUTO_INCREMENT,
    DataDaOperacao DATETIME,
    CodigoDaOperacao VARCHAR(50),
    ValorPagoEmUSD DOUBLE ,
    ValorPagoEmKz DOUBLE,
    PRIMARY KEY pk_entradas(NumeroDaOperacao),
    FOREIGN KEY fk_operacao_entrada(CodigoDaOperacao)
        REFERENCES TblOperacoes(CodigoDaOperacao)
			ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS TblPagamentos (
    codigoAlunoPagamento VARCHAR(50) NOT NULL UNIQUE,
    NomeAlunoPagamento VARCHAR(50),
    turmaAlunoPagamento VARCHAR(50),
    OperacaoPagamento VARCHAR(50),
    ValorEmKzPagamento DOUBLE,
    ValorEmUSDPagamento DOUBLE,
    DataPagamento DATETIME,
    PRIMARY KEY pk_pagamentos(codigoAlunoPagamento),
    FOREIGN KEY fk_turma_aluno_pagamento(turmaAlunoPagamento)
        REFERENCES TblTurmas(CodigoDaTurma)
			ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY fk_operacao_pagamento(OperacaoPagamento)
        REFERENCES TblOperacoes(CodigoDaOperacao)
			ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS tblItemPagamentos (
    IDItemPagamento INT NOT NULL AUTO_INCREMENT,
    OperacaoPagamento VARCHAR(50),
    TurmaPagamento VARCHAR(50),
    ValorKZ DOUBLE,
    ValorUSD DOUBLE,
    PRIMARY KEY pk_item_pagamento(IDItemPagamento),
    FOREIGN KEY fk_turma_pagamento(TurmaPagamento)
		REFERENCES TblTurmas(CodigoDaTurma)
			ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY fk_operacao_pagamento(OperacaoPagamento)
		REFERENCES TblOperacoes(CodigoDaOperacao)
			ON DELETE CASCADE ON UPDATE CASCADE
);