package Model;

/**
 * Classe contendo os dados do produto
 */
public class Produto {

    private int codigo;
    private String nome;
    private Double precoCompra;
    private Double precoVenda;
    private int quantidade;

    //Métodos Construtores
    public Produto() {
        this.codigo = 0;
        this.nome = "";
        this.precoCompra = 0.0;
        this.precoVenda = 0.0;
        this.quantidade = 0;
    }
    public Produto(int codProduto) {
        this.codigo = codProduto;
        this.nome = "";
        this.precoCompra = 0.0;
        this.precoVenda = 0.0;
        this.quantidade = 0;
    }
    
    //Gets and Sets
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getPrecoCompra() {
        return precoCompra;
    }
    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }
    public Double getPrecoVenda() {
        return precoVenda;
    }
    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    //To string Override
    @Override
    public String toString() {
        return getNome();
    }
}
