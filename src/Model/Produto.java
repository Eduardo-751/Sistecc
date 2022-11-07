package Model;

/**
 * Classe contendo os dados do produto
 */
public class Produto {

    private int id;
    private String descricao;
    private Double qtdDisponivel, precoVenda, precoCompra;
    private int quantidade;

    //Métodos Construtores
    public Produto(Double qtdDisponivel, String descricao, Double precoVenda, Double precoCompra) {
        this.qtdDisponivel = qtdDisponivel;
        this.descricao = descricao;
        this.precoVenda = precoVenda;
        this.precoCompra = precoCompra;
    }
    
    public Produto(int codProduto) {
        this.id = codProduto;
        this.descricao = "";
        this.precoCompra = 0.0;
        this.precoVenda = 0.0;
        this.quantidade = 0;
    }
    
    //Gets and Sets
    public int getId() {
        return id;
    }
    public void setId(int codigo) {
        this.id = codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String nome) {
        this.descricao = nome;
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
    public Double getQtdDisponivel() {
		return qtdDisponivel;
	}

	public void setQtdDisponivel(Double qtdDisponivel) {
		this.qtdDisponivel = qtdDisponivel;
	}

	//To string Override
    @Override
    public String toString() {
        return getDescricao();
    }
}
