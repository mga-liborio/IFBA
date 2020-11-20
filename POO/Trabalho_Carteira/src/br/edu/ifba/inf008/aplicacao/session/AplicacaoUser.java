
package br.edu.ifba.inf008.aplicacao.session;

public class AplicacaoUser {
    
    private String codigo;
    private String descricao;
    private double ganho;

    public AplicacaoUser(String codigo, String descricao, double ganho) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.ganho = ganho;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getGanho() {
        return ganho;
    }
    
    
    
}
