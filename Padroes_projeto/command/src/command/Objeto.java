/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.util.Scanner;

/**
 *
 * @author mgali
 */
public class Objeto {
    
    int op;
    String palavra;
    Scanner scan;
    
    public Objeto(){
        scan = new Scanner(System.in);
        op = 0;}
    
    public int imprimeMenu(){
        
        boolean escolha = false;
        
        while(escolha == false){
            System.out.println("Escolha a opcao desejada: \n"
                                    + "1 - Mover o retangulo \n"
                                    + "2 - Altera a cor do retangulo \n"
                                    + "3 - Undo \n"
                                    + "4 - Redo \n"
                                    + "5 - Sair da Aplicacao \n");

            op = testaObjeto();
            if(op>0 && op<6)
                escolha = true;
            else
                System.out.println("numero invalido, tente novamente.\n");
        }
        return op;
    }
    
    
    public int testaObjeto(){
        
        boolean escolha = false;
        
        while(escolha == false){
        
            try{
                op = Integer.parseInt(scan.nextLine());
                escolha = true;
            }catch (NumberFormatException ex){
                        System.out.println("Coordenada invalida, digite um numero.\n");}
        }
        return op;
    };
    
     public String testaString(){
         
        boolean escolha = false;
        
        while(escolha == false){
        
            try{
                palavra = scan.nextLine();
                escolha = true;
            }catch (Exception ex){
                        System.out.println("Cor invalida, digite outra.\n");}
        }
        return palavra;
     
     }
    
}
