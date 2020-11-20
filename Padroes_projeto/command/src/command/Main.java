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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean escolha = false;
        Objeto ob = new Objeto();
        Scanner scan = new Scanner(System.in);
        HistoricoCommand historico = new HistoricoCommand();
        int x;
        int y;
        
        Retangulo retangulo = new Retangulo(0,0, "Preto");
        
        
        while(escolha == false){
            
            int operacao = ob.imprimeMenu();
            
            switch (operacao){
                case 1 :
                    System.out.println("Digite a coordenada X:");
                    x = ob.testaObjeto();
                    System.out.println("Digite a coordenada Y:");
                    y = ob.testaObjeto();
                    MoveCommand move = new MoveCommand(retangulo, x, y);
                    historico.add(move);
                    System.out.println("\n -- O objeto foi movido.-- \n");
                    break;
                case 2 :
                    System.out.println("Digite o nome da cor que deseja mudar o objeto:\n");
                    String cor = ob.testaString();
                    ColorChangeCommand colorir = new ColorChangeCommand(retangulo, cor);
                    historico.add(colorir);
                    System.out.println("\n --O objeto mudou de cor.--\n");
                    break;
                case 3 :
                    historico.retroceder();
                    System.out.println("\n --Undo efetuado.-- \n");
                    break;
                case 4:
                    historico.avancar();
                    System.out.println("\n --Redo efetuado -- \n");
                    break;
                case 5:
                    System.out.println("Até Logo! =]");
                    escolha = true;
                    break;
            }
        }
    }
    
}
