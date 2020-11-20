/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer_atividade;
import java.util.Observer;
import java.util.Observable;

/**
 *
 * @author mgali
 */
public class Aluno implements Observer {
    
    private final String nome;
    
    public Aluno(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
    
    @Override
    public void update(Observable obj, Object arg){
        System.out.println("O professor "+ ((Professor)obj).getNome() + "marcou a data da prova para " + arg);
    }
    
}
