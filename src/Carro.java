import java.util.ArrayList;
import java.util.List;
/**
 * Classe que representa um carro e permite realizar operações básicas de CRUD.
 */
public class Carro {
    // Lista estática para armazenar os carros cadastrados
    private static List<Carro> carros = new ArrayList<>(); 
    private int id;
    private String nome;
    private String cor;
    private String ano;
    private String marca;
     /**
     * Construtor da classe Carro.
     *
     * @param id    Identificador do carro
     * @param nome  Nome ou modelo do carro
     * @param cor   Cor do carro
     * @param ano   Ano de fabricação
     * @param marca Marca do carro
     */

    public Carro(int id, String nome, String cor, String ano, String marca) {
        this.id = id;
        this.nome = nome;
        this.cor = cor;
        this.ano = ano;
        this.marca = marca;
    }
 /**
     * Salva o carro na lista estática de carros.
     */

    public void salvar() {
        carros.add(this);
        System.out.println("Carro salvo com sucesso.");
    }
     /**
     * Retorna a lista de carros cadastrados.
     *
     * @return Lista de carros
     */

    public static List<Carro> listar() {
        return carros;
    }
     /**
     * Edita os dados do carro atual.
     *
     * @param novoNome  Novo nome/modelo do carro
     * @param novaCor   Nova cor do carro
     * @param novoAno   Novo ano de fabricação
     * @param novaMarca Nova marca do carro
     */

    public void editar(String novoNome, String novaCor, String novoAno, String novaMarca) {
        this.nome = novoNome;
        this.cor = novaCor;
        this.ano = novoAno;
        this.marca = novaMarca;
        System.out.println("Carro editado com sucesso.");
    }
      /**
     * Exclui um carro da lista com base no ID informado.
     *
     * @param id ID do carro a ser removido
     */

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
    /**
     * Retorna o ID do carro.
     *
     * @return ID do carro
     */

    

    public int getId() {
        return id;
    }
     /**
     * Retorna o nome/modelo do carro.
     *
     * @return Nome do carro
     */

    public String getNome() {
        return nome;
    }
    /**
     * Retorna a cor do carro.
     *
     * @return Cor do carro
     */

    public String getCor() {
        return cor;
    }
     /**
     * Retorna o ano de fabricação do carro.
     *
     * @return Ano do carro
     */

    public String getAno() {
        return ano;
    }
     /**
     * Retorna a marca do carro.
     *
     * @return Marca do carro
     */

    public String getMarca() {
        return marca;
    }
}
