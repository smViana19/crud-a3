import java.util.List;

public class Carro {
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

    }

    public List<Carro> listar() {
        return null;
    }

    public void editar() {
    }

    public void excluir() {
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

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
