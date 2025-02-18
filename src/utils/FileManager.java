package utils;

import models.Filme;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String FILE_NAME = "filmes.dat";

    // Método para salvar filmes no arquivo
    public static void salvarFilmes(List<Filme> filmes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(filmes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar filmes do arquivo
    public static List<Filme> carregarFilmes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Filme>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>(); // Retorna uma lista vazia se houver erro
        }
    }
}
