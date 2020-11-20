
package br.edu.ifba.inf008.aplicacao.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carteira extends Aplicacao{
    
    private double estimativaRisco;
    private double estimativaRendimento;
    
    private List<Primaria> carteiraAplicacoes;
    private List<Double> fatias;
    //private Map<Double, Primaria> fatiaAplicacao;
 
    
    public Carteira(String codigo, String descricao, double valorMinimo){
        
        super(codigo, descricao, valorMinimo);
        this.carteiraAplicacoes = new ArrayList<Primaria>();
        this.fatias = new ArrayList<Double>();
        //this.fatiaAplicacao = new HashMap<Double, Primaria>();
    }
    
     public void addAplicacao(Primaria aplicacao, double fatia){
         
        this.carteiraAplicacoes.add(aplicacao);
        this.fatias.add(fatia);
      //  this.fatiaAplicacao.put(fatia, aplicacao);
    }
    
    public double getEstimativaRisco(){
        
        double resultado = 0.0;
        
        for (int i = 0; i < this.carteiraAplicacoes.size(); i++)
            resultado += this.carteiraAplicacoes.get(i).getEstimativaRisco()* this.fatias.get(i);;
            
        return resultado/100;
    }
    
    public double getEstimativaRendimento(){
        
        double resultado = 0;
        
        for (int i = 0; i < this.carteiraAplicacoes.size(); i++)
            resultado += this.carteiraAplicacoes.get(i).getEstimativaRendimento()* this.fatias.get(i);
            
        return resultado/100;
    }
    
    
    
}
