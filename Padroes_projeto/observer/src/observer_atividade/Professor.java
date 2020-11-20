/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer_atividade;
import java.util.Observable;

/**
 *
 * @author mgali
 */
public class Professor extends Observable {

    private final String nome;
    private String data;
    
    public Professor(String nome){
    this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setDataAvaliacao(String data){
        this.data = data;
        setChanged();
        notifyObservers(data);
    }
}
