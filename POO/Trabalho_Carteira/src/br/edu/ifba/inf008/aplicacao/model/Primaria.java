
package br.edu.ifba.inf008.aplicacao.model;

public class Primaria extends Aplicacao{
    
    public Primaria(String codigo, String descricao, double valorMinimo)
    {
        super(codigo, descricao, valorMinimo);
    }
    
    @Override
    public double getEstimativaRisco()
    {
        return this.estimativaRisco;
    }
    
    @Override
    public double getEstimativaRendimento()
    {
        return this.estimativaRendimento;
    }
    
    public void setEstimativaRisco(double estimativaRendimento){
        this.estimativaRendimento = estimativaRendimento;
    }
    
    public void setEstimativaRendimento(double estimativaRisco ){
        this.estimativaRisco = estimativaRisco;
    }
    
   
}
   
