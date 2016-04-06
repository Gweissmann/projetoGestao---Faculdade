
CREATE TABLE IF NOT EXISTS `projetogestao`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  `confirmacaoSenha` VARCHAR(45) NULL,
  `salarioMensal` DOUBLE NULL,
  `rendaExtra` DOUBLE NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `projetogestao`.`CadastroConta` (
  `idCadastroConta` INT NOT NULL AUTO_INCREMENT,
  `tipoTitulo` VARCHAR(45) NULL,
  `nome` VARCHAR(45) NULL,
  `dataCadastro` VARCHAR(45) NULL,
  `dataVencimento` VARCHAR(45) NULL,
  `numeroParcelas` INT NULL,
  `valor` DOUBLE NULL,
  `jurosDia` DOUBLE NULL,
  PRIMARY KEY (`idCadastroConta`))
ENGINE = InnoDB;
