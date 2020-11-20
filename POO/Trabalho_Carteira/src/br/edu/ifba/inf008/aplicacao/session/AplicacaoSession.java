
package br.edu.ifba.inf008.aplicacao.session;

import br.edu.ifba.inf008.aplicacao.dao.AplicacaoDAOIF;
import br.edu.ifba.inf008.aplicacao.dao.sql.AplicacaoDAOSQL;
import br.edu.ifba.inf008.aplicacao.model.Aplicacao;
import br.edu.inf008.aplicacao.exceptions.AplicacaoMaisRentavelInexistenteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AplicacaoSession {

    private AplicacaoDAOSQL aplicacaoDAO = new AplicacaoDAOSQL();	
    
    public AplicacaoUser recuperarAplicacaoMaisRentavel(double investimento, double risco) throws AplicacaoMaisRentavelInexistenteException{
        System.out.print("marilia");
        Collection<Aplicacao> aplicacoes = this.aplicacaoDAO.recuperarAplicacoesValorMinimoMenor(investimento);
        List<Aplicacao> riscoMenor = this.getRiscoMenor(aplicacoes, risco);
        
        return this.maiorGanho(riscoMenor, investimento);
    }
    
    public void setAplicacaoDAO(AplicacaoDAOSQL aplicacaoDAO){
        this.aplicacaoDAO = aplicacaoDAO;
    }
    
    private List<Aplicacao> getRiscoMenor(Collection<Aplicacao> aplicacoes, double risco){
        
        List<Aplicacao> riscoMenor = new ArrayList<Aplicacao>();
        for(Aplicacao aplicacao : aplicacoes){
            if(aplicacao.getEstimativaRisco() < risco)
                riscoMenor.add(aplicacao);
        }
        return riscoMenor;
    }
    
    private AplicacaoUser maiorGanho(List<Aplicacao> riscoMenor, double investimento){
        
        Aplicacao maior = null;
        
        for(Aplicacao aplicacao : riscoMenor){
            if(maior == null)
                maior = aplicacao;
            else if(aplicacao.getEstimativaRendimento() * investimento > maior.getEstimativaRendimento() * investimento)
                maior = aplicacao;
        }
        return new AplicacaoUser(maior.getCodigo(), maior.getDescricao(), maior.getEstimativaRendimento() * investimento);
    }

}
