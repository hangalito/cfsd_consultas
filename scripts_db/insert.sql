INSERT INTO `bd_inscricoes`.`tblalunos`
(`CodigoDoAluno`, `NomeDoAluno`, `TelefoneDoAluno`,
`MoradaDoAluno`, `LocalDeNascimentoDoAluno`, `NacionalidadeDoAluno`,
`HabilitacoesLiterariasDoAluno`, `SexoDoAluno`, `OutrosdadosdoAluno`)
VALUES (1, 'Bartolomeu Hangalo', '+244-945-515-954',
       'Quimbango, Kilamba Kiaxi, Luanda', 'Multiperfil', 'Angolana',
       'Frequenta o Ensino Secundário no Colégio Mundo Novo', 'Masculino', NULL),
	   (2, 'Idalécio Paulo', '+244-999-999-999',
       'Maria Eugénia Neto, Camama', 'Multiperfil', 'Angolana',
       'Frequenta o Ensino Secundário no Colégio Mundo Novo', 'Masculino', NULL),
	   (3, 'Paulo Gomes', '+244-931-287-432',
       'São Paulo, Luanda', 'Cazenga', 'Angolana',
       'Ensino Médio Concluído no curso de Informática', 'Masculino', NULL),
	   (4, 'Clina Pais', '+244-998-394-712',
       'Nelito Soares, Rangel, Luanda', 'Maianga', 'Angolana',
       'Ensino Médio Concluído no curso de Contabilidade', 'Feminimo', NULL),
	   (5, 'Clina Pires', '+244-932-428-937',
       'Lobito, Benguela', 'Lobito', 'Angolana',
       'Frequenta o Ensino Médio em Análises Clínicas', 'Feminimo', NULL),
       (6, 'Leonor Figueira', '+244-952-832-129',
       'Qt. W9, Centralidade do Kilamba, Luanda', 'Belas', 'Angolana',
       'Frequenta o Ensino Médio no curso de Finanças no Colégio Mundo Novo', 'Feminimo',	NULL),
       (7, 'Délcio Armando', '+244-945-295-153',
       'Condomínio dos Astros, Talatona, Luanda', 'Talatona',	'Angolana',
       'Frequenta o Ensino Médio no curso de Informática no Colégio Mundo Novo', 'Masculino', NULL),
	   (8, 'Belmiro Faustino', '+244-931-491-732',
       'Mbondo Chapé, Talatona, Luanda', 'Talatona', 'Angolana',
       'Frequenta o Ensino Médio no curso de Análises Clínicas no Colégio Manita', 'Masculino', NULL),
       (9, 'Abel Hangalo', '+355-321-4123-312',
       'Alghero, Itália', 'Chibia', 'Angolana',
       'Frequenta o 1º ano da faculdade de Contabilidade', 'Masculino', NULL),
       (10, 'André Hangalo', '+244-951-543-238',
       'Lubango, Huíla', 'Lubango', 'Angolana',
       'Licensiado no curso de Engenharia Informática', 'Masculino', NULL);

INSERT INTO `bd_inscricoes`.`tblcursos`
(`CodigoDoCurso`, `NomeDoCurso`, `PrecoUnitario`)
VALUES ('JAVA101', 'Fundamentos de Java', 50000),
	   ('PWRBI', 'Análise de Dados com Power BI', 40000),
       ('INFOR01', 'Informática na Óptica do Utilizador', 3000),
       ('CONTGRL', 'Contabildade Geral', 40000),
       ('CONTINF', 'Contabilidade Informatizada', 45000),
       ('J2EE', 'Desenvolvimento de Aplicações Web Com Jakarta', 40000),
       ('DB101', 'Base de Dados com Microsoft Access e MySQL', 40000),
       ('ENGBGN', 'Inglês - Beginner', 10000),
       ('ENGELTR', 'Inglês - Elementary', 15000),
       ('ENGLWR', 'Inglês - Lower Intermediate', 15000),
       ('ENGINTR', 'Inglês - Intermediate', 15000),
       ('ENGUPPR', 'Inglês - Upper Intermediate', 20000),
       ('ENGADV', 'Inglês - Lower Advanced', 25000);

INSERT INTO `bd_inscricoes`.`tblfuncionarios`
(`CodigoDoFuncionario`, `NomeDoFuncionario`,
`DataDeNascimento`, `DataDeAdmissao`)
VALUES (1, 'Maria Alce Grilo', '2006-05-02', '2022-03-21'),
	   (2, 'Esmeralda Pereira', '2005-06-06', '2021-10-19'),
       (3, 'Rúben Ventura', '2005-06-30', '2021-09-21'),
       (4, 'Walter Nascimento', '2005-02-28', '2021-09-21'),
       (5, 'Anatóvia de Almeida', '2004-11-21', '2023-05-30');

INSERT INTO `bd_inscricoes`.`tblhorarios`
(`CodigoDoHorario`, `NomeDoHorario`)
VALUES ('07h-08h', '07h-08h'),
	   ('07h:30-09h:30', '07h:30-09h:30'),
	   ('08h-10h', '08h-10h'),
       ('09h:30-11h:30', '09h:30-11h:30'),
       ('10h-12h', '10h-12h'),
       ('11h:30-13h:30', '11h:30-13h:30'),
       ('12h-14h', '12h-14h'),
       ('14h-16h', '14h-16h'),
       ('14h-15h:30', '14h-15h:30'),
       ('15h-16h:30', '15h-16h:30'),
       ('16h-18h', '16h-18h'),
       ('16h:30-18h', '16h:30-18h'),
       ('18h-20h', '18h-20h');

INSERT INTO `bd_inscricoes`.`tbloperacoes`
(`ChaveDaOperacao`, `CodigoDaOperacao`, `NomeDaOperacao`)
VALUES (1, 'PYMNT', 'Pagamento'),
	   (2, 'INSC', 'Inscrição'),
       (3, 'MRC', 'Marcação de Falta');
