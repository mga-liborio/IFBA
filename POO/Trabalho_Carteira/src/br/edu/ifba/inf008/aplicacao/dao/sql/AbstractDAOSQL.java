package br.edu.ifba.inf008.aplicacao.dao.sql;

import br.edu.ifba.inf008.aplicacao.model.Aplicacao;
import br.edu.ifba.inf008.aplicacao.model.Carteira;
import br.edu.ifba.inf008.aplicacao.model.Primaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public abstract class AbstractDAOSQL {

	private static final String URI = "jdbc:postgresql://localhost:5432/TrabalhoPOO";
	private static final String USER = "postgres";
	private static final String PWD = "senha";
        
        private static Connection connection = null;
	
	protected Connection getConnection() throws SQLException{
            
            if (connection == null) {
                    DriverManager.registerDriver(new org.postgresql.Driver());
                    
                    connection = DriverManager.getConnection(AbstractDAOSQL.URI, AbstractDAOSQL.USER, AbstractDAOSQL.PWD);
            }
            
            return connection;
            
	}
        
        public  abstract Aplicacao createAplicacao(String codigo, String descricao, double valorMin, int tipo);
		
	
}