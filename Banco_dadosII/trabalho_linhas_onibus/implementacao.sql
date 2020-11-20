update pg_database set encoding = pg_char_to_encoding('UTF8') where datname = 'BDII'


create table bairro (
	cod_bairro int,
	nome_bairro varchar(50),
	constraint pk_bairro primary key(cod_bairro)
);

create table linha(
	cod_linha int,
	nome_linha varchar(20),
	constraint pk_linha primary key (cod_linha)

);
	
create table empresa(
	CNPJ int,
	nome_empresa varchar(50),
	endereco varchar(100),
	insc_estadual varchar(15),
	constraint pk_empresa primary key(CNPJ)
	)
	
create table passageiro(
	cod_passageiro int, 
	tipo_passageiro varchar(20),
	valor_passagem float,
	constraint pk_passageiro primary key (cod_passageiro))

create table ponto_de_onibus(
	cod_ponto int, 
	cod_bairro int NOT NULL,
	localidade varchar(100),
	constraint pk_ponto primary key (cod_ponto),
	constraint fk_bairro foreign key (cod_bairro) references bairro (cod_bairro)
	)

create table veiculo(
	cod_veiculo int,
	placa_veiculo varchar(9),
	chassi varchar(15),
	modelo varchar(10),
	cnpj_empresa int,
	constraint pk_veiculo primary key (cod_veiculo),
	constraint fk_empresa foreign key (cnpj_empresa) references empresa (cnpj)
	)





create table itinerario(
	cod_itinerario int,
	cod_linha int,
	constraint pk_itinerario primary key (cod_itinerario),
	constraint fk_linha foreign key (cod_linha) references linha (cod_linha)
	)

create table ponto_itinerario(
	cod_ponto_itinerario int,
	cod_ponto int,
	cod_itinerario int,
	constraint pk_ponto_itinerario primary key(cod_ponto_itinerario),
	constraint fk_ponto foreign key (cod_ponto) references ponto_de_onibus (cod_ponto),
	constraint fk_itinerario foreign key (cod_itinerario) references itinerario (cod_itinerario)
	)



create table viagem(
	cod_viagem int, 
	inicio_viagem timestamp,
	termino_viagem timestamp,
	cod_itinerario int,
	cod_veiculo int, 
	constraint pk_viagem primary key (cod_viagem),
	constraint fk_itinerario foreign key (cod_itinerario) references itinerario (cod_itinerario),
	constraint fk_veiculo foreign key (cod_veiculo) references veiculo (cod_veiculo)
	)	

create table passagem(
	cod_passagem int,
	cod_viagem int, 
	cod_passageiro int,
	constraint pk_passagem primary key(cod_passagem),
	constraint fk_viagem foreign key (cod_viagem) references viagem(cod_viagem),
	constraint fk_passageiro foreign key (cod_passageiro) references passageiro (cod_passageiro)
	)



