/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer_atividade;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author mgali
 */
public class Instituicao {
    
    private final List <Professor> docentes;
    private final List <Aluno> discentes;

    public Instituicao() {
        this.discentes = new ArrayList<>();
        this.docentes = new ArrayList<>();
    }
    
    public void addProfessor(String nome){
        Professor prof = new Professor(nome);
        docentes.add(prof);
    }
    
    public void addAluno(String nome){
        Aluno aluno = new Aluno(nome);
        discentes.add(aluno);
    }
    
    public void imprimeProfessores(){
        for(Professor professor : docentes){
            System.out.println((docentes.indexOf(professor)+1)+"-->");
            System.out.println(professor.getNome());
        }
       
    }
    
    public Professor getProfessor(int opProf){
        
        int operacaoProf = (opProf-1);
        for(Professor professor : docentes){
            if((docentes.indexOf(professor)) == operacaoProf)
                return professor;
        }
        return null;
    }
    
     public Aluno getAluno(int opAluno){
        
        int operacaoAluno = (opAluno-1);
        for(Aluno aluno : discentes){
            if((discentes.indexOf(aluno)) == operacaoAluno)
                return aluno;
        }
        return null;
    }
    
    
    public void conectaProfessorAluno(Professor opProf, Aluno opAluno){
        
        for(Professor professor : docentes){
            if(professor == opProf){
                for(Aluno aluno : discentes){
                    if(aluno == opAluno)
                        professor.addObserver(aluno);}  
            }
        }
    }
    
    public void desconectaProfessorAluno(Professor opProf, Aluno opAluno){
        
        for(Professor professor : docentes){
            if(professor == opProf){
                for(Aluno aluno : discentes){
                    if(aluno == opAluno)
                        professor.deleteObserver(aluno);              
                }
            }
        }
    }
    
    public void imprimeAlunos(){
        for(Aluno aluno : discentes){
            System.out.println((discentes.indexOf(aluno)+1)+"-->");
            System.out.println(aluno.getNome());
        }
              
    }  
}
