CREATE DATABASE casaBancaria;

CREATE TABLE Cliente (
	cpf int not null primary key,
	nome varchar(40) not null,
	idade int not null,
	salario numeric(16,4) not null
);