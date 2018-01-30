use BD_cemiterio7

-- -----------------------------------------------------
-- Table BD_cemiterio.declarante
-- -----------------------------------------------------

CREATE TABLE declarante (
  cpf CHAR(15) NOT NULL,
  nascimento DATETIME NOT NULL,
  rg CHAR(15) NOT NULL,
  nome VARCHAR(100) NOT NULL,
  sexo CHAR(1) NOT NULL,
  cep CHAR(9) NOT NULL,
  endereco VARCHAR(150) NOT NULL,
  numero INT NOT NULL,
  complemento VARCHAR(50) NOT NULL,
  bairro VARCHAR(50) NOT NULL,
  cidade VARCHAR(100) NOT NULL,
  uf CHAR(2) NOT NULL,
  profissao VARCHAR(50) NOT NULL,
  parentesco VARCHAR(30) NOT NULL,
  telefone CHAR(15) NOT NULL,
  celular CHAR(15) NOT NULL,
  email VARCHAR(100) NOT NULL,
  PRIMARY KEY (cpf)
  )

-- -----------------------------------------------------
-- Table BD_cemiterio.jazigo
-- -----------------------------------------------------

CREATE TABLE jazigo (
codigo INT NOT NULL identity,
rua VARCHAR(150) NOT NULL,
quadra CHAR(8) NOT NULL,
gaveta INT NOT NULL,
numero INT NOT NULL,
PRIMARY KEY (codigo)
 )
 -------------------------------------------------
-- Table BD_cemiterio.falecido
-- -----------------------------------------------------

CREATE TABLE falecido (
  cpf CHAR(15) NOT NULL,
  cpfDeclarante CHAR(15) NOT NULL,
  codigoJazigo INT NOT NULL,
  rg CHAR(15) NOT NULL,
  nome VARCHAR(100) NOT NULL,
  sexo CHAR(1) NOT NULL,
  naturalidade VARCHAR(25) NOT NULL,
  nacionalidade VARCHAR(25) NOT NULL,
  etnia VARCHAR(25) NOT NULL,
  nascimento DATETIME NOT NULL,
  profissao VARCHAR(45) NOT NULL,
  estadoCivil VARCHAR(20) NOT NULL,
  tituloEleitor CHAR(20) NOT NULL,
  zona INT NOT NULL,
  secao INT NOT NULL,
  cep CHAR(9) NOT NULL,
  endereco VARCHAR(150) NOT NULL,
  numero INT NOT NULL,
  bairro VARCHAR(50) NOT NULL,
  complemento VARCHAR(50) NOT NULL,
  cidade VARCHAR(100) NOT NULL,
  uf CHAR(2) NOT NULL,
  foto IMAGE,
  dataFalecimento DATETIME NOT NULL,
  dataExumacao DATETIME NOT NULL,
  horaFalecimento DATETIME NOT NULL,
  horaExumacao DATETIME NOT NULL,
  localFalecimento VARCHAR(100) NOT NULL,
  cartorio VARCHAR(45) NOT NULL,
  registroObito DATETIME NOT NULL,
  crm CHAR(15) NULL,
  causaMorte VARCHAR(150) NULL,
  idade int,
  PRIMARY KEY (cpf),
  FOREIGN KEY (cpfDeclarante) REFERENCES declarante (cpf),
  FOREIGN KEY (codigoJazigo) REFERENCES Jazigo (codigo)
  )
	
-- -----------------------------------------------------
-- Table BD_cemiterio.falecimento
-- -----------------------------------------------------

CREATE TABLE falecimento (
cpfFalecido CHAR(15) NOT NULL,
dataFalecimento DATETIME NOT NULL,
dataExumacao DATETIME NOT NULL,
horaFalecimento DATETIME NOT NULL,
horaExumacao DATETIME NOT NULL,
localFalecimento VARCHAR(100) NOT NULL,
cartorio VARCHAR(45) NOT NULL,
registroObito DATETIME NOT NULL,
crm CHAR(15) NULL,
causaMorte VARCHAR(150) NULL,
FOREIGN KEY (cpfFalecido) REFERENCES Falecido(cpf)
)

CREATE TABLE dono(
id int not null identity,
cpf char(15)NOT NULL,
nome VARCHAR(100) NOT NULL,
codigoJazigo int NOT NULL,
FOREIGN KEY (codigoJazigo) REFERENCES Jazigo (codigo),
PRIMARY KEY (id)
)

CREATE TABLE usuario (
  id VARCHAR(30)  NOT NULL,
  nivel VARCHAR(13),
  nome VARCHAR(100) NOT NULL,
  nascimento DATETIME NOT NULL,
  senha VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
  )

  CREATE TABLE colaborador (
  id int  NOT NULL identity,
  nome VARCHAR(100) NOT NULL,
  servico VARCHAR(100)NOT NULL,
  email VARCHAR(100) NOT NULL,
  telefone CHAR(15) NOT NULL,
  PRIMARY KEY (id)
  )

SELECT * FROM falecido
SELECT * FROM jazigo 
SELECT * FROM colaborador
SELECT * FROM declarante
SELECT * FROM usuario
SELECT * FROM  dono

SELECT cpf,nome,codigo, rua, quadra, gaveta,numero FROM dono INNER JOIN jazigo on codigoJazigo = codigo
 WHERE nome LIKE 'Teste'



INSERT INTO jazigo ( rua, quadra, gaveta, numero)  VALUES ('Rua tal tal' , 12345 ,2,2);
INSERT INTO dono (cpf,nome,codigoJazigo) VALUES( '111.111.111-11', 'teste1', 3);   

drop table falecido 
ALTER TABLE `falecimento` CHANGE `crm` `crm` char(15)

ALTER TABLE falecido ALTER COLUMN tituloEleitor char(20)
ALTER TABLE falecido ADD idade int
ALTER TABLE jazigo ADD dono varchar(100)

update jazigo Set dono = null where dono ='Teste'
 delete dono from jazigo where dono='Teste'
 
 ALTER TABLE jazigo DROP CONSTRAINT numero
 alter table jazigo add constraint codigo primary key;
-- ---- drop database BD_cemiterio3
 drop table falecido

INSERT INTO usuario (id, nivel, nome, nascimento, senha )  VALUES (1, 'adm' , 'teste' ,'1111-11-11' ,123 );

INSERT INTO usuario (id, nivel, nome, nascimento, senha )  VALUES (2, 'Administrador' , 'teste' ,'1111-11-11' ,123 );