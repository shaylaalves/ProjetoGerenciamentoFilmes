package models;

import java.io.Serializable;

// Superclasse Filme
public class Filme implements Serializable {
    private String titulo;
    private String diretor;
    private int ano;

    public Filme(String titulo, String diretor, int ano) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.ano = ano;
    }

    public String getTitulo() { return titulo; }
    public String getDiretor() { return diretor; }
    public int getAno() { return ano; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDiretor(String diretor) { this.diretor = diretor; }
    public void setAno(int ano) { this.ano = ano; }

    public String getInfo() {
        return titulo + " (" + ano + ") - Dirigido por " + diretor;
    }
}