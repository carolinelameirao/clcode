DROP DATABASE IF EXISTS clcodebd;

CREATE DATABASE IF NOT EXISTS clcodebd DEFAULT CHARACTER SET UTF8;

USE clcodebd;

CREATE TABLE IF NOT EXISTS Usuario ( 
 Id INT PRIMARY KEY auto_increment,  
 Nome varchar(100) not null,  
 Login varchar(45) not null,  
 Senha varchar(45) not null 
); 

CREATE TABLE IF NOT EXISTS Endereco ( 
 Id INT PRIMARY KEY auto_increment,  
 Logradouro varchar(100) not null,  
 Numero INT not null,  
 Complemento varchar(45) null,  
 Bairro varchar(45) not null,  
 Cidade varchar(45) not null,  
 Estado CHAR(2) NOT NULL,
		CHECK (Estado IN ('AC', 'AL', 'AP', 'AM', ' BA', 'CE', 'DF', 'ES', 'GO', 'MA', 'MT', 'MS', 'MG', 'PA', 'PB', 'PR', 'PE', 'PI', 'RJ', 'RN', 'RS', 'RO', 'RR', 'SC', 'SP', 'SE', 'TO')),  
 CEP varchar(45) not null  
); 

CREATE TABLE IF NOT EXISTS Cliente ( 
 Id INT PRIMARY KEY auto_increment,  
 Nome varchar(100) not null,  
 CPF varchar(11) not null,  
 Telefone varchar(11) not null,  
 Email varchar(45) not null,  
 DataNascimento date not null,  
 Endereco_Id INT NOT NULL,
FOREIGN KEY (Endereco_Id)
	REFERENCES Endereco (Id)
	ON DELETE CASCADE ON UPDATE CASCADE
); 

CREATE TABLE IF NOT EXISTS PrestadorServico ( 
 Id INT PRIMARY KEY auto_increment,  
 Nome varchar(100) not null,  
 Funcao varchar(45) not null,  
 CPF varchar(11) not null,  
 Telefone varchar(11) not null,  
 Email varchar(45) not null,  
 DataNacimento date not null,  
 Endereco_Id INT NOT NULL,
 FOREIGN KEY (Endereco_Id)
	REFERENCES Endereco (Id)
	ON DELETE CASCADE ON UPDATE CASCADE
); 


CREATE TABLE IF NOT EXISTS Servico ( 
 Id INT PRIMARY KEY auto_increment,  
 Tipo varchar(45) not null,  
 Descricao varchar(45) not null,  
 Valor double not null
); 

CREATE TABLE IF NOT EXISTS OrdemServico ( 
 Id INT PRIMARY KEY auto_increment,  
 DataContratacao date not null,  
 PrazoEntrega date not null,
 Cliente_Id Int not null,
 Servico_Id Int not null,
 PrestadorServico_Id Int not null,
 foreign key (Cliente_Id)
	references Cliente (Id)
    on delete cascade on update cascade,
 foreign key (Servico_Id)
	references Servico (Id)
    on delete cascade on update cascade,
 foreign key (PrestadorServico_Id)
	references PrestadorServico (Id)
    on delete cascade on update cascade
); 