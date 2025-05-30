import Exceptions.CamposInvalidosException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um carro e permite realizar operações básicas de CRUD.
 */
public class Carro {
    private static List<Carro> carros = new ArrayList<>();
    private int id;
    private String nome;
    private String cor;
    private int ano;
    private String marca;

    public Carro(int id, String nome, String cor, int ano, String marca) {
        this.id = id;
        this.nome = nome;
        this.cor = cor;
        this.ano = ano;
        this.marca = marca;
    }

    /**
     * Salva o carro na lista estática de carros.
     */

    public void salvar() throws CamposInvalidosException {
        File diretorio = new File("crud-a3/src/arquivos");
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

        File arquivo = new File(diretorio, "carros.txt");
        validaCampos();

        try (FileWriter escreverArquivo = new FileWriter(arquivo, true)) {
            escreverArquivo.write("Id: " + getId() + " | Nome: " + getNome() + " | Cor: " + getCor() + " | Ano: " + getAno() + " | Marca: " + getMarca() + "\n");
        } catch (Exception e) {
            System.out.println("Erro ao criar o arquivo: " + e.getMessage());
        }

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

    public void editar(String novoNome, String novaCor, int novoAno, String novaMarca) {
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

    private void validaCampos() throws CamposInvalidosException {
        if (getId() <= 0) {
            throw new CamposInvalidosException("O id deve ser um numero inteiro maior que 0");
        }

        if (getNome() == null || getNome().isEmpty()) {
            throw new CamposInvalidosException("O nome do carro deve ser informado");
        }

        if (getCor() == null || getCor().isEmpty()) {
            throw new CamposInvalidosException("A cor do carro deve ser informada");
        }

        if (getMarca() == null || getMarca().isEmpty()) {
            throw new CamposInvalidosException("A marca do carro deve ser informada");
        }

        if (getAno() < 1886 || getAno() > 2025) {
            throw new CamposInvalidosException("O ano deve estar entre 1886 e 2025");
        }


    }

    public static List<Carro> getCarros() {
        return carros;
    }

    public static void setCarros(List<Carro> carros) {
        Carro.carros = carros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
