create materialized view origem_destino2
as
select h.bairro, sum(h.qtd_subida) as origem , sum(h.qtd_descida) as destino 
from (
select nome_bairro as bairro, count(cod_passagem) as qtd_subida, 0 as qtd_descida 
	from passagem p, bairro b
	where p.cod_origem = b.cod_bairro 
	group by nome_bairro
	union 
	select nome_bairro as bairro, 0 as qtd_subida, count(cod_passagem)  as qtd_descida 
	from passagem p, bairro b
	where p.cod_destino = b.cod_bairro 
	group by nome_bairro) as h
group by h.bairro


select nome_bairro as bairro, (count(cod_passagem)+count(cod_passagem)) as qtd_subida, 0 as qtd_descida 
	from passagem p, bairro b
	where p.cod_origem = b.cod_bairro 
	group by nome_bairro
	union 
	select nome_bairro as bairro, 0 as qtd_subida, count(cod_passagem)  as qtd_descida 
	from passagem p, bairro b
	where p.cod_destino = b.cod_bairro 
	group by nome_bairro) as h


select cod_origem from passagem