
package br.edu.ifba.inf008.aplicacao.dao;

import br.edu.ifba.inf008.aplicacao.model.Aplicacao;
import br.edu.inf008.aplicacao.exceptions.AplicacaoMaisRentavelInexistenteException;
import java.util.Collection;

public interface AplicacaoDAOIF {
    
    public abstract Collection<Aplicacao> recuperarAplicacoesValorMinimoMenor(double investimento)throws AplicacaoMaisRentavelInexistenteException;
    public Collection<Aplicacao> buscarAplicacoes() throws Exception;
    
}
