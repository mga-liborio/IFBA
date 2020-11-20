/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer_atividade;

import java.util.Scanner;

/**
 *
 * @author mgali
 */
public class Objeto {
    
    int op;
    Scanner scan;
    
    public Objeto(){
        scan = new Scanner(System.in);
        op = 0;
    }
    
    
    
    public int imprimeMenu(){
        
        boolean escolha = false;
        
        while(escolha == false){
            System.out.println("Escolha a opcao desejada: \n"
                                    + "1 - Criar Professor \n"
                                    + "2 - Criar Aluno \n"
                                    + "3 - Conectar Aluno a Professor \n"
                                    + "4 - Desconectar Aluno de Professor \n"
                                    + "5 - Definir data de avaliacao \n"
                                    + "6 - Sair da Aplicacao \n");

            op = testaObjeto();
            if(op>0 && op<7)
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
                        System.out.println("opcao invalida, digite um numero.\n");}
        }
        return op;
};
    
}
