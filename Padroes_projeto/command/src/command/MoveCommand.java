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
public class MoveCommand implements ICommand{
    
    private int coordenadaX;
    private int coordenadaY;
    private Retangulo retangulo;
    
    private int anteriorCoordenadaX;
    private int anteriorCoordenadaY;
    
    public MoveCommand (Retangulo retangulo, int coordenadaX, int coordeandaY){
        this.retangulo = retangulo;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.anteriorCoordenadaX = retangulo.getCoordenadaX();
        this.anteriorCoordenadaY = retangulo.getCoordenadaY();
    }

    @Override
    public void redo() {
        retangulo.mover(coordenadaX, coordenadaY);
    }

    @Override
    public void undo() {
        retangulo.mover(anteriorCoordenadaX, anteriorCoordenadaY);
    }   
}
