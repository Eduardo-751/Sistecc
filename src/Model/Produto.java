package Model;

/**
 * Classe contendo os dados do produto
 */
public class Produto {

    private int id;
    private String nome;
    private String descricao;
    private Double precoVenda;

    //Métodos Construtores
    public Produto(String nome, String descricao, Double precoVenda) {
    	this.nome = nome;
        this.descricao = descricao;
        this.precoVenda = precoVenda;
    }
    
    public Produto(int codProduto) {
        this.id = codProduto;
        this.descricao = "";
        this.precoVenda = 0.0;
    }
    
    //Gets and Sets
    public int getId() {
        return id;
    }
    public void setId(int codigo) {
        this.id = codigo;
    }
    public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String nome) {
        this.descricao = nome;
    }
    public Double getPrecoVenda() {
        return precoVenda;
    }
    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

	//To string Override
    @Override
    public String toString() {
        return getDescricao();
    }
}
