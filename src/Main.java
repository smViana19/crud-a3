import Exceptions.CamposInvalidosException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int opcao;
    do {
      System.out.println("\n***** MENU CRUD *****");
      System.out.println("1 - Salvar");
      System.out.println("2 - Listar");
      System.out.println("3 - Editar");
      System.out.println("4 - Excluir");
      System.out.println("0 - Sair");
      System.out.print("Escolha uma opção: ");
      opcao = scanner.nextInt();

      switch (opcao) {
        case 1:
          Carro novoCarro = lerDadosDoCarro(scanner);
          try {
            novoCarro.salvar();
          } catch (CamposInvalidosException e) {
            throw new RuntimeException(e);
          }
          break;
        case 2:
          Carro.listar();
          break;
        case 3:
          System.out.print("ID do carro para editar: ");
          int idParaEditar = scanner.nextInt();
          Carro carroEditado = novosDados(scanner);
          Carro.editar(idParaEditar, carroEditado.getNome(), carroEditado.getCor(), carroEditado.getAno(), carroEditado.getMarca());
          break;
        case 4:
          System.out.print("ID do carro para excluir: ");
          int idExcluir = scanner.nextInt();
          Carro.excluir(idExcluir);
          break;

        case 0:
          System.out.println("Saindo...");
          break;

        default:

          System.out.println("Opção inválida.");
      }
    } while (opcao != 0);

    scanner.close();
  }

  private static Carro lerDadosDoCarro(Scanner scanner) {
    System.out.println("Id: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Nome: ");
    String nome = scanner.nextLine();

    System.out.print("Cor: ");
    String cor = scanner.nextLine();

    System.out.print("Ano: ");
    int ano = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Marca: ");
    String marca = scanner.nextLine();

    return new Carro(id, nome, cor, ano, marca);

  }

  private static Carro novosDados(Scanner scanner) {
    System.out.print("Nome: ");
    String nome = scanner.nextLine();

    System.out.print("Cor: ");
    String cor = scanner.nextLine();

    System.out.print("Ano: ");
    int ano = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Marca: ");
    String marca = scanner.nextLine();

    return new Carro(nome, cor, ano, marca);
  }
}
