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
public class Retangulo {
    
    private int coordenadaY;
    private int coordenadaX;
    private String cor;
    
    public Retangulo(int coordenadaX, int coordenadaY, String cor){
        this.coordenadaY = coordenadaY;
        this.coordenadaX = coordenadaX;
        this.cor = cor;
    }
    
    // move o retangulo para novas coordenadas
    public void mover (int coordenadaX, int coordenadaY){
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }
    
    public void MudarCor (String cor){
        this.cor = cor;
    }

    String getCor(){
        return this.cor;
    }
    
    public int getCoordenadaX(){
        return this.coordenadaX;
    }
    
    public int getCoordenadaY(){
        return this.coordenadaY;
    }
    
}
