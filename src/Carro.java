import java.util.ArrayList;
import java.util.List;

public class Carro {
    private static List<Carro> carros = new ArrayList<>(); 
    private int id;
    private String nome;
    private String cor;
    private String ano;
    private String marca;

    public Carro(int id, String nome, String cor, String ano, String marca) {
        this.id = id;
        this.nome = nome;
        this.cor = cor;
        this.ano = ano;
        this.marca = marca;
    }

    public void salvar() {
        carros.add(this);
        System.out.println("Carro salvo com sucesso.");
    }

    public static List<Carro> listar() {
        return carros;
    }

    public void editar(String novoNome, String novaCor, String novoAno, String novaMarca) {
        this.nome = novoNome;
        this.cor = novaCor;
        this.ano = novoAno;
        this.marca = novaMarca;
        System.out.println("Carro editado com sucesso.");
    }

    public static void excluir(int id) {
        Carro carroParaRemover = null;
        for (Carro c : carros) {
            if (c.getId() == id) {
                carroParaRemover = c;
                break;
            }
        }

        if (carroParaRemover != null) {
            carros.remove(carroParaRemover);
            System.out.println("Carro removido com sucesso.");
        } else {
            System.out.println("Carro não encontrado.");
        }
    }

    

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public String getAno() {
        return ano;
    }

    public String getMarca() {
        return marca;
    }
}
