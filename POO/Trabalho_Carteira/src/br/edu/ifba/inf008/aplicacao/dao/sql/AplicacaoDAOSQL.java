
package br.edu.ifba.inf008.aplicacao.dao.sql;

import br.edu.ifba.inf008.aplicacao.dao.AplicacaoDAOIF;
import br.edu.ifba.inf008.aplicacao.model.Aplicacao;
import br.edu.ifba.inf008.aplicacao.model.Carteira;
import br.edu.ifba.inf008.aplicacao.model.Primaria;
import br.edu.inf008.aplicacao.exceptions.AplicacaoMaisRentavelInexistenteException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AplicacaoDAOSQL extends AbstractDAOSQL implements AplicacaoDAOIF{
    
    private static final String SELECT_ALL = "SELECT codigo, descricao, valorMin, tipo FROM \\\"APLICACOES\\\"";
    
    
    public Aplicacao createAplicacao(String codigo, String descricao, double valorMin, int tipo) {
        
        Aplicacao aplicacao = null;
        System.out.print("tipo " + tipo);
        if(tipo == 1){
            aplicacao = new Primaria(codigo, descricao, valorMin);    
        }else if(tipo == 2){
            aplicacao = new Carteira(codigo, descricao, valorMin);
        }
        return aplicacao;
    }
    
    public Collection<Aplicacao> buscarAplicacoes() throws Exception {
        
		Collection <Aplicacao> aplicacoes = new ArrayList<Aplicacao>();
                System.out.print("ante");
		PreparedStatement stmt = this.getConnection().prepareStatement(SELECT_ALL);
		System.out.print("antes2");
                ResultSet rSet = stmt.executeQuery();
                System.out.print("antes3");
		while(rSet.next()){
			String codigo = rSet.getString("codigo");
			String descricao = rSet.getString("descricao");
			double valorMin = rSet.getDouble("valorMin");
                        int tipo = rSet.getInt("tipo");
			Aplicacao aplicacao = this.createAplicacao(codigo, descricao, valorMin, tipo);
			aplicacoes.add(aplicacao);
		}
		return aplicacoes;
    }
    

    @Override
    public Collection<Aplicacao> recuperarAplicacoesValorMinimoMenor (double investimento) throws AplicacaoMaisRentavelInexistenteException{
    
        Collection<Aplicacao> menorValorMin = new ArrayList<Aplicacao>();
        Collection<Aplicacao> aplicacoes = new ArrayList<Aplicacao>();
        
        try {
            aplicacoes.addAll(this.buscarAplicacoes());
           
            for(Aplicacao aplicacao: aplicacoes){
            
                if(aplicacao.getValorMinimo() < investimento)
                    menorValorMin.add(aplicacao);
            }
        } catch (Exception ex) {
            Logger.getLogger(AplicacaoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } 
             
        if(!(menorValorMin.isEmpty()))
            return menorValorMin;
                
        throw new AplicacaoMaisRentavelInexistenteException(investimento);
    }
}
 