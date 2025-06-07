import Exceptions.CamposInvalidosException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class Carro {
  private int id;
  private String nome;
  private String cor;
  private int ano;
  private String marca;

  private static final String DIRETORIO_PATH = "./arquivos";

  public Carro(int id, String nome, String cor, int ano, String marca) {
    this.id = id;
    this.nome = nome;
    this.cor = cor;
    this.ano = ano;
    this.marca = marca;
  }

  public Carro(String nome, String cor, int ano, String marca) {
    this.nome = nome;
    this.cor = cor;
    this.ano = ano;
    this.marca = marca;
  }

  /**
   * Salva o carro na lista estática de carros.
   */

  public void salvar() throws CamposInvalidosException {
    File diretorio = new File(DIRETORIO_PATH);
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

    System.out.println("Carro salvo com sucesso.");
  }

  /**
   * Le o arquivo e mostra ao usuario todos os carros cadastrados.
   */

  public static void listar() {
    File arquivo = new File(DIRETORIO_PATH, "carros.txt");

    if (!arquivo.exists()) {
      System.out.println("Nenhum carro cadastrado.");
    }

    try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
      String linha;
      while ((linha = leitor.readLine()) != null) {
        System.out.println(linha);
      }
    } catch (Exception e) {
      System.out.println("Erro ao ler o arquivo: " + e.getMessage());
    }
  }

  /**
   * Edita os carros de acordo com o Id
   *
   * @param id
   * @param novoNome
   * @param novaCor
   * @param novoAno
   * @param novaMarca
   */
  public static void editar(int id, String novoNome, String novaCor, int novoAno, String novaMarca) {
    File arquivo = new File(DIRETORIO_PATH, "carros.txt");

    try {
      List<String> linhas = new ArrayList<>();
      boolean encontrado = false;

      try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
        String linha;

        while ((linha = leitor.readLine()) != null) {
          if (linha.contains("Id: " + id + " ")) {
            String novaLinha = "Id: " + id + " | Nome: " + novoNome + " | Cor: " + novaCor + " | Ano: " + novoAno + " | Marca: " + novaMarca;
            linhas.add(novaLinha);
            encontrado = true;
          } else {
            linhas.add(linha);
          }
        }
      }

      try (FileWriter escritor = new FileWriter(arquivo, false)) {
        for (String linha : linhas) {
          escritor.write(linha + "\n");
        }
      }

      if (encontrado) {
        System.out.println("Carro editado com sucesso.");
      } else {
        System.out.println("Carro com ID " + id + " não encontrado.");
      }

    } catch (Exception e) {
      System.out.println("Erro ao editar carro: " + e.getMessage());
    }
  }

  /**
   * Exclui um carro da lista com base no ID informado.
   *
   * @param id ID do carro a ser removido
   */

  public static void excluir(int id) {
    File arquivo = new File(DIRETORIO_PATH, "carros.txt");

    try {
      List<String> linhas = new ArrayList<>();
      boolean encontrado = false;

      try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
        String linha;

        while ((linha = leitor.readLine()) != null) {
          if (linha.contains("Id: " + id + " ")) {
            encontrado = true;
            continue;
          }
          linhas.add(linha);
        }
      }

      try (FileWriter escritor = new FileWriter(arquivo, false)) {
        for (String linha : linhas) {
          escritor.write(linha + "\n");
        }
      }

      if (encontrado) {
        System.out.println("Carro excludio com sucesso.");
      } else {
        System.out.println("Carro não foi encontrado.");
      }

    } catch (Exception e) {
      System.out.println("Erro ao excluir o carro: " + e.getMessage());
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
