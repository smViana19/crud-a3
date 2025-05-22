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
                    scanner.nextLine(); 
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Cor: ");
                    String cor = scanner.nextLine();
                    System.out.print("Ano: ");
                    String ano = scanner.nextLine();
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();

                    Carro novoCarro = new Carro(id, nome, cor, ano, marca);
                    novoCarro.salvar();
                    break;

                case 2:
                    List<Carro> carros = Carro.listar();
                    if (carros.isEmpty()) {
                        System.out.println("Nenhum carro cadastrado.");
                    } else {
                        System.out.println("\nCarros cadastrados:");
                        for (Carro c : carros) {
                            System.out.println("ID: " + c.getId() + " | Nome: " + c.getNome() + " | Cor: " + c.getCor() + " | Ano: " + c.getAno() + " | Marca: " + c.getMarca());
                        }
                    }
                    break;

                case 3:
                    System.out.print("ID do carro para editar: ");
                    int idEditar = scanner.nextInt();
                    scanner.nextLine();

                    Carro carroParaEditar = null;
                    for (Carro c : Carro.listar()) {
                        if (c.getId() == idEditar) {
                            carroParaEditar = c;
                            break;
                        }
                    }

                    if (carroParaEditar != null) {
                        System.out.print("Novo nome: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Nova cor: ");
                        String novaCor = scanner.nextLine();
                        System.out.print("Novo ano: ");
                        String novoAno = scanner.nextLine();
                        System.out.print("Nova marca: ");
                        String novaMarca = scanner.nextLine();

                        carroParaEditar.editar(novoNome, novaCor, novoAno, novaMarca);
                    } else {
                        System.out.println("Carro não encontrado.");
                    }
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
}
