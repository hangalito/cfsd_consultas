-- MySQL dump 10.13  Distrib 8.4.4, for Linux (x86_64)
--
-- Host: localhost    Database: bd_inscricoes
-- ------------------------------------------------------
-- Server version	8.4.4-cluster

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `TblAlunos`
--

DROP TABLE IF EXISTS `TblAlunos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TblAlunos` (
  `CodigoDoAluno` int NOT NULL,
  `NomeDoAluno` varchar(50) DEFAULT NULL,
  `TelefoneDoAluno` varchar(50) DEFAULT NULL,
  `MoradaDoAluno` varchar(50) DEFAULT NULL,
  `LocalDeNascimentoDoAluno` varchar(30) DEFAULT NULL,
  `NacionalidadeDoAluno` varchar(20) DEFAULT NULL,
  `HabilitacoesLiterariasDoAluno` varchar(80) DEFAULT NULL,
  `SexoDoAluno` enum('Masculino','Feminimo') DEFAULT NULL,
  `OutrosdadosdoAluno` text,
  PRIMARY KEY (`CodigoDoAluno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TblAlunos`
--

LOCK TABLES `TblAlunos` WRITE;
/*!40000 ALTER TABLE `TblAlunos` DISABLE KEYS */;
INSERT INTO `TblAlunos` VALUES (1,'Bartolomeu Hangalo','+244-945-515-954','Quimbango, Kilamba Kiaxi, Luanda','Multiperfil','Angolana','Frequenta o Ensino Secundário no Colégio Mundo Novo','Masculino',NULL),(2,'Idalécio Paulo','+244-999-999-999','Maria Eugénia Neto, Camama','Multiperfil','Angolana','Frequenta o Ensino Secundário no Colégio Mundo Novo','Masculino',NULL),(3,'Paulo Gomes','+244-931-287-432','São Paulo, Luanda','Cazenga','Angolana','Ensino Médio Concluído no curso de Informática','Masculino',NULL),(4,'Clina Pais','+244-998-394-712','Nelito Soares, Rangel, Luanda','Maianga','Angolana','Ensino Médio Concluído no curso de Contabilidade','Feminimo',NULL),(5,'Clina Pires','+244-932-428-937','Lobito, Benguela','Lobito','Angolana','Frequenta o Ensino Médio em Análises Clínicas','Feminimo',NULL),(6,'Leonor Figueira','+244-952-832-129','Qt. W9, Centralidade do Kilamba, Luanda','Belas','Angolana','Frequenta o Ensino Médio no curso de Finanças no Colégio Mundo Novo','Feminimo',NULL),(7,'Délcio Armando','+244-945-295-153','Condomínio dos Astros, Talatona, Luanda','Talatona','Angolana','Frequenta o Ensino Médio no curso de Informática no Colégio Mundo Novo','Masculino',NULL),(8,'Belmiro Faustino','+244-931-491-732','Mbondo Chapé, Talatona, Luanda','Talatona','Angolana','Frequenta o Ensino Médio no curso de Análises Clínicas no Colégio Manita','Masculino',NULL),(9,'Abel Hangalo','+355-321-4123-312','Alghero, Itália','Chibia','Angolana','Frequenta o 1º ano da faculdade de Contabilidade','Masculino',NULL),(10,'André Hangalo','+244-951-543-238','Lubango, Huíla','Lubango','Angolana','Licensiado no curso de Engenharia Informática','Masculino',NULL);
/*!40000 ALTER TABLE `TblAlunos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TblCursos`
--

DROP TABLE IF EXISTS `TblCursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TblCursos` (
  `CodigoDoCurso` varchar(50) NOT NULL,
  `NomeDoCurso` varchar(50) DEFAULT NULL,
  `PrecoUnitario` double DEFAULT NULL,
  PRIMARY KEY (`CodigoDoCurso`),
  UNIQUE KEY `CodigoDoCurso` (`CodigoDoCurso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TblCursos`
--

LOCK TABLES `TblCursos` WRITE;
/*!40000 ALTER TABLE `TblCursos` DISABLE KEYS */;
INSERT INTO `TblCursos` VALUES ('CONTGRL','Contabildade Geral',40000),('CONTINF','Contabilidade Informatizada',45000),('DB101','Base de Dados com Microsoft Access e MySQL',40000),('ENGADV','Inglês - Lower Advanced',25000),('ENGBGN','Inglês - Beginner',10000),('ENGELTR','Inglês - Elementary',15000),('ENGINTR','Inglês - Intermediate',15000),('ENGLWR','Inglês - Lower Intermediate',15000),('ENGUPPR','Inglês - Upper Intermediate',20000),('HRDWR','Hardware',40000),('INFOR01','Informática na Óptica do Utilizador',3000),('J2EE','Desenvolvimento de Aplicações Web Com Jakarta',40000),('JAVA101','Fundamentos de Java',50000),('PWRBI','Análise de Dados com Power BI',40000),('RDS','Redes de Computador',30000);
/*!40000 ALTER TABLE `TblCursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TblDetalhesDaInscricao`
--

DROP TABLE IF EXISTS `TblDetalhesDaInscricao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TblDetalhesDaInscricao` (
  `CodigoDaInscricao` int NOT NULL,
  `CodigoDoCurso` varchar(50) NOT NULL,
  `CodigoDaTurma` varchar(50) DEFAULT NULL,
  `CodigoDoHorario` varchar(50) DEFAULT NULL,
  `CodigoDoProfessor` int DEFAULT NULL,
  `DataDeInicio` datetime DEFAULT NULL,
  `DataDeFim` datetime DEFAULT NULL,
  `ValorPago` double DEFAULT '0',
  `ValorPago2` double DEFAULT '0',
  `Observacoes` varchar(50) DEFAULT NULL,
  `NotaFinal` int DEFAULT NULL,
  PRIMARY KEY (`CodigoDaInscricao`,`CodigoDoCurso`),
  KEY `fk_curso_inscricao` (`CodigoDoCurso`),
  KEY `fk_turma_inscricao` (`CodigoDaTurma`),
  KEY `fk_horario_inscricao` (`CodigoDoHorario`),
  KEY `fk_professor_inscricao` (`CodigoDoProfessor`),
  CONSTRAINT `TblDetalhesDaInscricao_ibfk_1` FOREIGN KEY (`CodigoDoCurso`) REFERENCES `TblCursos` (`CodigoDoCurso`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `TblDetalhesDaInscricao_ibfk_2` FOREIGN KEY (`CodigoDaTurma`) REFERENCES `TblTurmas` (`CodigoDaTurma`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `TblDetalhesDaInscricao_ibfk_3` FOREIGN KEY (`CodigoDoHorario`) REFERENCES `TblHorarios` (`CodigoDoHorario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `TblDetalhesDaInscricao_ibfk_4` FOREIGN KEY (`CodigoDoProfessor`) REFERENCES `TblFuncionarios` (`CodigoDoFuncionario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TblDetalhesDaInscricao`
--

LOCK TABLES `TblDetalhesDaInscricao` WRITE;
/*!40000 ALTER TABLE `TblDetalhesDaInscricao` DISABLE KEYS */;
INSERT INTO `TblDetalhesDaInscricao` VALUES (1,'INFOR01','INFOR','08h-10h',6,'2020-11-03 08:00:00','2020-12-23 10:00:00',0,0,'Bolsa',NULL),(2,'DB101','BD','08h-12h',9,'2020-11-10 08:00:00','2021-02-10 12:00:00',0,0,NULL,NULL),(2,'INFOR01','INFOR','08h-10h',6,'2020-11-03 08:00:00','2020-12-23 10:00:00',0,0,NULL,NULL),(3,'DB101','BD','08h-12h',9,'2020-11-10 08:00:00','2021-02-10 12:00:00',0,0,NULL,NULL),(3,'HRDWR','HARDWARE','14h-16h',7,'2020-11-10 14:00:00','2021-02-10 16:00:00',0,0,NULL,NULL),(3,'INFOR01','INFOR','10h-12h',6,'2020-11-03 08:00:00','2020-12-23 10:00:00',0,0,NULL,NULL),(3,'RDS','REDES','16h-18h',7,'2020-11-10 12:00:00','2021-02-10 18:00:00',0,0,NULL,NULL);
/*!40000 ALTER TABLE `TblDetalhesDaInscricao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TblEntradas`
--

DROP TABLE IF EXISTS `TblEntradas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TblEntradas` (
  `NumeroDaOperacao` int NOT NULL AUTO_INCREMENT,
  `DataDaOperacao` datetime DEFAULT NULL,
  `CodigoDaOperacao` varchar(50) DEFAULT NULL,
  `ValorPagoEmUSD` double DEFAULT NULL,
  `ValorPagoEmKz` double DEFAULT NULL,
  PRIMARY KEY (`NumeroDaOperacao`),
  KEY `fk_operacao_entrada` (`CodigoDaOperacao`),
  CONSTRAINT `TblEntradas_ibfk_1` FOREIGN KEY (`CodigoDaOperacao`) REFERENCES `TblOperacoes` (`CodigoDaOperacao`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TblEntradas`
--

LOCK TABLES `TblEntradas` WRITE;
/*!40000 ALTER TABLE `TblEntradas` DISABLE KEYS */;
/*!40000 ALTER TABLE `TblEntradas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TblFaltas`
--

DROP TABLE IF EXISTS `TblFaltas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TblFaltas` (
  `CodigoDasFaltas` int NOT NULL AUTO_INCREMENT,
  `CodigoDoFuncionario` int NOT NULL,
  `DataDaFalta` date DEFAULT NULL,
  `MotivoDaFalta` varchar(30) DEFAULT NULL,
  `Observacoes` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CodigoDasFaltas`,`CodigoDoFuncionario`),
  KEY `fk_funcionario_falta` (`CodigoDoFuncionario`),
  CONSTRAINT `TblFaltas_ibfk_1` FOREIGN KEY (`CodigoDoFuncionario`) REFERENCES `TblFuncionarios` (`CodigoDoFuncionario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TblFaltas`
--

LOCK TABLES `TblFaltas` WRITE;
/*!40000 ALTER TABLE `TblFaltas` DISABLE KEYS */;
/*!40000 ALTER TABLE `TblFaltas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TblFuncionarios`
--

DROP TABLE IF EXISTS `TblFuncionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TblFuncionarios` (
  `CodigoDoFuncionario` int NOT NULL AUTO_INCREMENT,
  `NomeDoFuncionario` varchar(50) DEFAULT NULL,
  `DataDeNascimento` date DEFAULT NULL,
  `DataDeAdmissao` datetime DEFAULT NULL,
  PRIMARY KEY (`CodigoDoFuncionario`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TblFuncionarios`
--

LOCK TABLES `TblFuncionarios` WRITE;
/*!40000 ALTER TABLE `TblFuncionarios` DISABLE KEYS */;
INSERT INTO `TblFuncionarios` VALUES (1,'Maria Alce Grilo','2006-05-02','2022-03-21 00:00:00'),(2,'Esmeralda Pereira','2005-06-06','2021-10-19 00:00:00'),(3,'Rúben Ventura','2005-06-30','2021-09-21 00:00:00'),(4,'Walter Nascimento','2005-02-28','2021-09-21 00:00:00'),(5,'Anatóvia de Almeida','2004-11-21','2023-05-30 00:00:00'),(6,'Josemar Neves','1995-12-21','2015-08-13 00:00:00'),(7,'António Mendes Peregrino','1981-12-24','2008-03-21 00:00:00'),(8,'Laurindo Baptista','1987-03-15','2016-09-18 00:00:00'),(9,'Joaquim José Hangalo','1971-12-21','2005-03-30 00:00:00');
/*!40000 ALTER TABLE `TblFuncionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TblHorarios`
--

DROP TABLE IF EXISTS `TblHorarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TblHorarios` (
  `CodigoDoHorario` varchar(50) NOT NULL,
  `NomeDoHorario` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CodigoDoHorario`),
  UNIQUE KEY `CodigoDoHorario` (`CodigoDoHorario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TblHorarios`
--

LOCK TABLES `TblHorarios` WRITE;
/*!40000 ALTER TABLE `TblHorarios` DISABLE KEYS */;
INSERT INTO `TblHorarios` VALUES ('07h-08h','07h-08h'),('07h:30-09h:30','07h:30-09h:30'),('08h-10h','08h-10h'),('08h-12h','08h-12h'),('09h:30-11h:30','09h:30-11h:30'),('10h-12h','10h-12h'),('11h:30-13h:30','11h:30-13h:30'),('12h-14h','12h-14h'),('14h-15h:30','14h-15h:30'),('14h-16h','14h-16h'),('15h-16h:30','15h-16h:30'),('16h-18h','16h-18h'),('16h:30-18h','16h:30-18h'),('18h-20h','18h-20h');
/*!40000 ALTER TABLE `TblHorarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TblInscricoes`
--

DROP TABLE IF EXISTS `TblInscricoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TblInscricoes` (
  `CodigoDaInscricao` int NOT NULL AUTO_INCREMENT,
  `DataDaInscricao` datetime DEFAULT CURRENT_TIMESTAMP,
  `CodigoDoAluno` int DEFAULT NULL,
  `CodigoDoFuncionario` int DEFAULT NULL,
  PRIMARY KEY (`CodigoDaInscricao`),
  KEY `fk_aluno_inscricoes` (`CodigoDoAluno`),
  KEY `fk_funcionario_inscricoes` (`CodigoDoFuncionario`),
  CONSTRAINT `TblInscricoes_ibfk_1` FOREIGN KEY (`CodigoDoAluno`) REFERENCES `TblAlunos` (`CodigoDoAluno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `TblInscricoes_ibfk_2` FOREIGN KEY (`CodigoDoFuncionario`) REFERENCES `TblFuncionarios` (`CodigoDoFuncionario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TblInscricoes`
--

LOCK TABLES `TblInscricoes` WRITE;
/*!40000 ALTER TABLE `TblInscricoes` DISABLE KEYS */;
INSERT INTO `TblInscricoes` VALUES (1,'2020-11-01 00:00:00',1,2),(2,'2020-11-01 00:00:00',2,2),(3,'2020-11-01 00:00:00',3,2);
/*!40000 ALTER TABLE `TblInscricoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TblItemPagamentos`
--

DROP TABLE IF EXISTS `TblItemPagamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TblItemPagamentos` (
  `IDItemPagamento` int NOT NULL AUTO_INCREMENT,
  `OperacaoPagamento` varchar(50) DEFAULT NULL,
  `TurmaPagamento` varchar(50) DEFAULT NULL,
  `ValorKZ` double DEFAULT NULL,
  `ValorUSD` double DEFAULT NULL,
  PRIMARY KEY (`IDItemPagamento`),
  KEY `fk_turma_pagamento` (`TurmaPagamento`),
  KEY `fk_operacao_pagamento` (`OperacaoPagamento`),
  CONSTRAINT `TblItemPagamentos_ibfk_1` FOREIGN KEY (`TurmaPagamento`) REFERENCES `TblTurmas` (`CodigoDaTurma`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `TblItemPagamentos_ibfk_2` FOREIGN KEY (`OperacaoPagamento`) REFERENCES `TblOperacoes` (`CodigoDaOperacao`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TblItemPagamentos`
--

LOCK TABLES `TblItemPagamentos` WRITE;
/*!40000 ALTER TABLE `TblItemPagamentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `TblItemPagamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TblOperacoes`
--

DROP TABLE IF EXISTS `TblOperacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TblOperacoes` (
  `ChaveDaOperacao` int DEFAULT NULL,
  `CodigoDaOperacao` varchar(50) NOT NULL,
  `NomeDaOperacao` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CodigoDaOperacao`),
  UNIQUE KEY `CodigoDaOperacao` (`CodigoDaOperacao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TblOperacoes`
--

LOCK TABLES `TblOperacoes` WRITE;
/*!40000 ALTER TABLE `TblOperacoes` DISABLE KEYS */;
INSERT INTO `TblOperacoes` VALUES (2,'INSC','Inscrição'),(3,'MRC','Marcação de Falta'),(1,'PYMNT','Pagamento');
/*!40000 ALTER TABLE `TblOperacoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TblPagamentos`
--

DROP TABLE IF EXISTS `TblPagamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TblPagamentos` (
  `codigoAlunoPagamento` varchar(50) NOT NULL,
  `NomeAlunoPagamento` varchar(50) DEFAULT NULL,
  `turmaAlunoPagamento` varchar(50) DEFAULT NULL,
  `OperacaoPagamento` varchar(50) DEFAULT NULL,
  `ValorEmKzPagamento` double DEFAULT NULL,
  `ValorEmUSDPagamento` double DEFAULT NULL,
  `DataPagamento` datetime DEFAULT NULL,
  PRIMARY KEY (`codigoAlunoPagamento`),
  UNIQUE KEY `codigoAlunoPagamento` (`codigoAlunoPagamento`),
  KEY `fk_turma_aluno_pagamento` (`turmaAlunoPagamento`),
  KEY `fk_operacao_pagamento` (`OperacaoPagamento`),
  CONSTRAINT `TblPagamentos_ibfk_1` FOREIGN KEY (`turmaAlunoPagamento`) REFERENCES `TblTurmas` (`CodigoDaTurma`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `TblPagamentos_ibfk_2` FOREIGN KEY (`OperacaoPagamento`) REFERENCES `TblOperacoes` (`CodigoDaOperacao`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TblPagamentos`
--

LOCK TABLES `TblPagamentos` WRITE;
/*!40000 ALTER TABLE `TblPagamentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `TblPagamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TblSalarios`
--

DROP TABLE IF EXISTS `TblSalarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TblSalarios` (
  `CodigoDoSalario` int NOT NULL AUTO_INCREMENT,
  `CodigoDoFuncionario` int NOT NULL,
  `ValorEmKwanzas` double DEFAULT '0',
  `ValorEmDolares` double DEFAULT '0',
  `Servico` varchar(30) DEFAULT NULL,
  `Referente` varchar(30) DEFAULT NULL,
  `DataDeEntrega` datetime NOT NULL,
  `Observacoes` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CodigoDoSalario`,`CodigoDoFuncionario`),
  KEY `fk_funcionario_falta` (`CodigoDoFuncionario`),
  CONSTRAINT `TblSalarios_ibfk_1` FOREIGN KEY (`CodigoDoFuncionario`) REFERENCES `TblFuncionarios` (`CodigoDoFuncionario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TblSalarios`
--

LOCK TABLES `TblSalarios` WRITE;
/*!40000 ALTER TABLE `TblSalarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `TblSalarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TblTurmas`
--

DROP TABLE IF EXISTS `TblTurmas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TblTurmas` (
  `CodigoDaTurma` varchar(50) NOT NULL,
  `NomeDaTurma` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CodigoDaTurma`),
  UNIQUE KEY `CodigoDaTurma` (`CodigoDaTurma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TblTurmas`
--

LOCK TABLES `TblTurmas` WRITE;
/*!40000 ALTER TABLE `TblTurmas` DISABLE KEYS */;
INSERT INTO `TblTurmas` VALUES ('BD','Base de Dados (10/11/2020)'),('BI101','Análise de Dados com Power BI'),('HARDWARE','Hardware (03/11/2020)'),('INFOR','Informática  (03/11/2020)'),('REDES','Redes (03/11/2020)'),('WEB101','Desenvolvimento Web 2024');
/*!40000 ALTER TABLE `TblTurmas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-23 18:25:47
