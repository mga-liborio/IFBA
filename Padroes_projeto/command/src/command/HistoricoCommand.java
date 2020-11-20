/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mgali
 */
public class HistoricoCommand {
    
    private List<ICommand> historico = new ArrayList<ICommand>();
    private int ultimoExecutado = -1;
    
    
    public void add(ICommand command){
        if(ultimoExecutado != historico.size()-1)
            historico.subList(ultimoExecutado+1, historico.size()).clear();
        
        historico.add(command);
        command.redo();
        ultimoExecutado = historico.size()-1;
    }
    
    public boolean retroceder(){
        if(ultimoExecutado >=0){
            historico.get(ultimoExecutado--).undo();
            return true;
        }else{return false;}
    }
    
    public boolean avancar(){
        if(ultimoExecutado < historico.size()-1){
            historico.get(++ultimoExecutado).redo();
            return true;
        }else {return false;}
    };
    
    
}
