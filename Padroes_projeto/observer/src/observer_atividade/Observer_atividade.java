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
public class Observer_atividade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean escolha = false;
        Scanner scan = new Scanner(System.in);
        Objeto ob = new Objeto();
        Instituicao ifba = new Instituicao();
        
        while(escolha == false){
            
            int operacao = ob.imprimeMenu();
            
            switch (operacao){
                case 1 :
                    System.out.println("Digite o nome do professor:\n");
                    String prof = scan.nextLine();
                    ifba.addProfessor(prof);
                    System.out.println("Professor adicionado com sucesso!\n");
                    break;
                case 2 :
                    System.out.println("Digite o nome do aluno:\n");
                    String aluno = scan.nextLine();
                    ifba.addAluno(aluno);
                    System.out.println("Aluno adicionado com sucesso!\n");
                    break;
                case 3 :
                    System.out.println("Primeiro - escolha um professor de acordo com seu numero:\n");
                    ifba.imprimeProfessores();
                    int opProf = ob.testaObjeto();
                    Professor profEscolhido = ifba.getProfessor(opProf);
                    if (profEscolhido == null)
                        System.out.println("numero invalido:\n");
                    else{
                        System.out.println("Segundo - escolha o aluno de acordo com seu numero:\n");
                        ifba.imprimeAlunos();
                        int opAluno = ob.testaObjeto();
                        Aluno alunoEscolhido = ifba.getAluno(opAluno);
                        if (alunoEscolhido == null)
                            System.out.println("numero invalido:\n");
                        else{
                            ifba.conectaProfessorAluno(profEscolhido, alunoEscolhido);
                            System.out.println("Conectados com sucesso!\n");}}
                    break;
                case 4 :
                    System.out.println("Primeiro - escolha um professor de acordo com seu numero:\n");
                    ifba.imprimeProfessores();
                    int opProfremove = ob.testaObjeto();
                    Professor profSelecionado = ifba.getProfessor(opProfremove);
                    if (profSelecionado == null)
                        System.out.println("numero invalido:\n");
                    else{
                        System.out.println("Segundo - escolha o aluno de acordo com seu numero:\n");
                        ifba.imprimeAlunos();
                        int opAlunoremove = ob.testaObjeto();
                        Aluno alunoRemovido = ifba.getAluno(opAlunoremove);
                        if (alunoRemovido == null)
                            System.out.println("numero invalido:\n");
                        else{
                            ifba.desconectaProfessorAluno(profSelecionado, alunoRemovido);
                            System.out.println("Desconectados com sucesso!\n");}}
                    break;
                case 5 :
                    System.out.println("Escolha o professor que quer marcar a prova:\n");
                    ifba.imprimeProfessores();
                    int opProfProva = ob.testaObjeto();
                    Professor profProva = ifba.getProfessor(opProfProva);
                    if (profProva == null)
                        System.out.println("numero invalido:\n");
                    else{
                        System.out.println("Agora escolha a data:\n");
                        String data = scan.nextLine();
                        profProva.setDataAvaliacao(data);}
                    break;
                case 6 :
                    System.out.println("Até Logo! =]");
                    escolha = true;
                    break;
            }
        }    
    }
}
