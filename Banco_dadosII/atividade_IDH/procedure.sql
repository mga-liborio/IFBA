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
