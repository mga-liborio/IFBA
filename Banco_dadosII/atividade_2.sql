CREATE OR REPLACE FUNCTION IDH_GERAL()
  RETURNS TABLE (estado character(20), IDH_Geral_estado numeric) AS
$BODY$
	BEGIN 
		return query(
			select est.nomeestado as estado,(sum(ind.idh_geral)/ count(ind.codmunicipio)) as idh
				from estado est, indice ind, municipio munic
					where est.codestado = munic.codestado and 
					munic.codmunicipio = ind.codmunicipio
				group by est.nomeestado);
	END;
$BODY$ LANGUAGE plpgsql;