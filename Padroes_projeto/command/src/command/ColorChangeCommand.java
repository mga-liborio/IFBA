/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

/**
 *
 * @author mgali
 */
public class ColorChangeCommand implements ICommand{
    
    private Retangulo retangulo;
    private String cor;
    private String corAnterior;
    
    public ColorChangeCommand(Retangulo retangulo, String cor){
        this.retangulo = retangulo;
        this.cor = cor;
        this.corAnterior = retangulo.getCor();
    }

    @Override
    public void redo() {
        retangulo.MudarCor(cor);
    }

    @Override
    public void undo() {
        retangulo.MudarCor(corAnterior);
    }
    
}
