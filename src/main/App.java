package main;

import models.*;
import services.FilmeService;
import utils.FileManager;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        FilmeService filmeService = new FilmeService();
        Scanner scanner = new Scanner(System.in);

        // Carregar filmes salvos
        List<Filme> filmesCarregados = FileManager.carregarFilmes();
        filmesCarregados.forEach(filmeService::adicionarFilme);

        while (true) {
            System.out.println("\nSistema de Gerenciamento de Filmes");
            System.out.println("1. Adicionar Filme Nacional");
            System.out.println("2. Adicionar Filme Internacional");
            System.out.println("3. Listar Filmes");
            System.out.println("4. Remover Filme");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String tituloNacional = scanner.nextLine();
                    System.out.print("Diretor: ");
                    String diretorNacional = scanner.nextLine();
                    System.out.print("Ano: ");
                    int anoNacional = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Estado de produção: ");
                    String estado = scanner.nextLine();

                    filmeService.adicionarFilme(new FilmeNacional(tituloNacional, diretorNacional, anoNacional, estado));
                    break;
                case 2:
                    System.out.print("Título: ");
                    String tituloInternacional = scanner.nextLine();
                    System.out.print("Diretor: ");
                    String diretorInternacional = scanner.nextLine();
                    System.out.print("Ano: ");
                    int anoInternacional = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("País de produção: ");
                    String pais = scanner.nextLine();
                    System.out.print("Idioma: ");
                    String idioma = scanner.nextLine();

                    filmeService.adicionarFilme(new FilmeInternacional(tituloInternacional, diretorInternacional, anoInternacional, pais, idioma));
                    break;
                case 3:
                    System.out.println("\nLista de Filmes:");
                    filmeService.listarFilmes().forEach(f -> System.out.println(f.getInfo()));
                    break;
                case 4:
                    System.out.print("Digite o título do filme a remover: ");
                    String tituloRemover = scanner.nextLine();
                    filmeService.removerFilme(tituloRemover);
                    System.out.println("Filme removido!");
                    break;
                case 5:
                    System.out.println("Salvando filmes e saindo...");
                    FileManager.salvarFilmes(filmeService.listarFilmes());
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
