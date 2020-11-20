CREATE MATERIALIZED VIEW origem_destino
	AS (SELECT SUM(cod_passagem) AS origem, FK_ponto_entra AS localidade
			FROM Passagem AS p
			INNER JOIN ponto_onibus AS o
			ON p.FK_ponto_entra = o.pk_ponto
			INNER JOIN Bairro AS b
			ON o.FK_bairro = b.PK_bairro
			GROUP BY FK_ponto_entra) AS origem) AS origem 


		)