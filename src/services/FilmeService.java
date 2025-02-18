package services;

import models.Filme;
import java.util.ArrayList;
import java.util.List;

public class FilmeService {
    private List<Filme> filmes;

    public FilmeService() {
        this.filmes = new ArrayList<>();
    }

    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
    }

    public List<Filme> listarFilmes() {
        return filmes;
    }

    public void removerFilme(String titulo) {
        filmes.removeIf(f -> f.getTitulo().equalsIgnoreCase(titulo));
    }

    public void atualizarFilme(String titulo, Filme novoFilme) {
        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                filmes.set(i, novoFilme);
                break;
            }
        }
    }
}