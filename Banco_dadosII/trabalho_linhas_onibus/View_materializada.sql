/*Quantidade de passageiros por dia nas linha */

create materialized view Qtd_passageiros_linhas
	as select linha.cod_linha, count(passagem.cod_passagem)
		from linha
			inner join itinerario
				on (linha.cod_linha = itinerario.cod_linha)
			inner join viagem
				on (viagem.cod_itinerario = itinerario.cod_itinerario)
			inner join passagem
				on (passagem.cod_viagem = viagem.cod_viagem)
		group by linha.cod_linha

/* valor em dinheiro recebido em cada linha*/

create materialized view Qtd_RS_linhas
	as select linha.cod_linha, sum(passageiro.valor_passagem)
		from linha
			inner join itinerario
				on (linha.cod_linha = itinerario.cod_linha)
			inner join viagem
				on (viagem.cod_itinerario = itinerario.cod_itinerario)
			inner join passagem
				on (passagem.cod_viagem = viagem.cod_viagem)
			inner join passageiro
				on (passagem.cod_passageiro = passageiro.cod_passageiro)
		group by linha.cod_linha

/*Quantidade de passageiros por dia em todas as linhas */


CREATE MATERIALIZED VIEW qtd_passageiros_totalDia AS 
 SELECT COUNT(passagem) from passagem

/*OU - como pratica apenas de subconsulta */

create materialized view Qtd_passageiros_total 
	as select sum(PassageirosLinhas.Qtd_passagensLinha) 
					(
						select count(passagem.cod_passagem) as Qtd_passagensLinha 
						from linha
							inner join itinerario
								on (linha.cod_linha = itinerario.cod_linha)
							inner join viagem
								on (viagem.cod_itinerario = itinerario.cod_itinerario)
							inner join passagem
								on (passagem.cod_viagem = viagem.cod_viagem)
						group by linha.cod_linha) as PassageirosLinhas




/* Consulta visão materializada */

select * from Qtd_passageiros_linhas

select * from Qtd_RS_linhas

select * from Qtd_passageiros_total