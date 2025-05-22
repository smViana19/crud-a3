import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("***** MENU CRUD *****");
            System.out.println("1 - Salvar");
            System.out.println("2 - Listar");
            System.out.println("3 - Editar");
            System.out.println("4 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Logica para salvar");
//                    File arquivo = new File("carro");
//                    if(!arquivo.exists()) {
//
//                    }
                case 2:
                    System.out.println("Logica para lsitar");
                case 3:
                    System.out.println("Logica para Editar");
                case 4:
                    System.out.println("Logica para Excluir");
                default:
                    System.out.println("Opção invalida");
            }
        } while (opcao != 0);
        {
            scanner.close();

        }
    }
}