ALTER TABLE indice ADD COLUMN IDH_ponderado FLOAT;

CREATE TRIGGER insereIdhNovaLinha
	AFTER INSERT ON indice
	FOR EACH ROW
	EXECUTE PROCEDURE atualiza_IDHponderado();


CREATE OR REPLACE FUNCTION atualiza_IDHponderado()
  RETURNS trigger AS
$BODY$
	begin
		UPDATE
			indice
		SET
			idh_ponderado = idh_geral*5+idh_longevidade*2+idh_educacao*2+idh_renda;
			return null;
	end
$BODY$
  LANGUAGE plpgsql; 

  ALTER FUNCTION update_viagensdia()

  select atualiza_idhponderado()
  DROP FUNCTION atualiza_idhponderado()

  select * from indice


insert into indice VALUES (354880,1900, 1.1, 3, 1, 1, 0);

select * from indice order by ano




CREATE OR REPLACE FUNCTION atualiza_IDHponderado()
  RETURNS float AS
$BODY$
declare
idh_calculado float; 
	begin
		select idh_geral, idh_longevidade, idh_educacao, idh_renda from indice;
		idh_calculado = idh_geral*5+idh_longevidade*2+idh_educacao*2+idh_renda;
		
		return idh_calculado;
	end
$BODY$
  LANGUAGE plpgsql; 


