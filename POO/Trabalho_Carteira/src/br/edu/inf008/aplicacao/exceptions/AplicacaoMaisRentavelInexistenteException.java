
package br.edu.inf008.aplicacao.exceptions;

public class AplicacaoMaisRentavelInexistenteException extends Exception {
    
    private double investimento;
    //private double risco;
	
    public AplicacaoMaisRentavelInexistenteException(Exception exception, double investimento){
        
	super(exception);
        this.investimento = investimento;	
    }

    public AplicacaoMaisRentavelInexistenteException(double investimento) {
        this.investimento = investimento;
    }
        
    public double getInvestimento() {
        return investimento;
    }
    
    @Override
    public String toString(){
           
        return "NÃO existe aplicações com investimento abaixo de" + getInvestimento();
    
    }
          
}
