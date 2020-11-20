
package br.edu.ifba.inf008.aplicacao.model;

public abstract class Aplicacao {
    
    private String codigo;
    private String descricao;
    private double valorMinimo;
    protected double estimativaRisco;
    protected double estimativaRendimento;
    
    private static final int PRIMARIA = 1;
    private static final int CARTEIRA = 2;
    
    public Aplicacao(String codigo, String descricao, double valorMinimo ){
        
        this.setCodigo(codigo);
        this.setDescricao(descricao);
        this.setValorMinimo(valorMinimo);
        
    }   

    public abstract double getEstimativaRisco();
    
    public abstract double getEstimativaRendimento();
    
    
    
    public void setValorMinimo(double valorMinimo) 
    {
        this.valorMinimo = valorMinimo;
    }
    
    public double getValorMinimo() 
    {
        return this.valorMinimo;
    }
    
    public void setCodigo(String codigo) 
    {
        this.codigo = codigo;
    }
    
    public String getCodigo() 
    {
        return this.codigo;
    }
    
    public void setDescricao(String descricao) 
    {
        this.descricao = descricao;
    }
    
    public String getDescricao() 
    {
        return this.descricao;
    }

}
   
