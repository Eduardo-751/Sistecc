package Model;

import java.sql.Date;

/**
 * Classe contendo os dados do produto
 */
public class Produto {

    private int id_produto;
    private char tributacao_produto;
    private String codBarra_produto;
    private String descricao_produto;
    private Double preco_produto;
    private String ncm_produto;
    private String cst_produto;
    private Double icms_produto;
    private Double estoque_produto;
    private Date cadastrado_produto;
    private Date alterado_produto;
    private Boolean ativo_produto;
	
	
    //Métodos Construtores
    public Produto(String codBarra_produto, String descricao_produto, Double preco_produto, String ncm_produto,
    			   String cst_produto, char tributacao_produto, Double icms_produto, Double estoque_produto,
    			   Boolean ativo_produto) {
		this.codBarra_produto = codBarra_produto;
		this.descricao_produto = descricao_produto;
		this.preco_produto = preco_produto;
		this.ncm_produto = ncm_produto;
		this.cst_produto = cst_produto;
		this.tributacao_produto = tributacao_produto;
		this.icms_produto = icms_produto;
		this.estoque_produto = estoque_produto;
		this.ativo_produto = ativo_produto;
	}

	public Produto() {
		
	}


	public int getId() {
		return id_produto;
	}
	public void setId(int id_produto) {
		this.id_produto = id_produto;
	}
	public String getCodBarra() {
		return codBarra_produto;
	}
	public void setCodBarra(String cod_barra_produto) {
		this.codBarra_produto = cod_barra_produto;
	}
	public String getDescricao() {
		return descricao_produto;
	}
	public void setDescricao(String descricao_produto) {
		this.descricao_produto = descricao_produto;
	}
	public Double getPreco() {
		return preco_produto;
	}
	public void setPreco(Double preco_produto) {
		this.preco_produto = preco_produto;
	}
	public String getNcm() {
		return ncm_produto;
	}
	public void setNcm(String ncm_produto) {
		this.ncm_produto = ncm_produto;
	}
	public String getCst() {
		return cst_produto;
	}
	public void setCst(String cst_produto) {
		this.cst_produto = cst_produto;
	}
	public char getTributacao() {
		return tributacao_produto;
	}
	public void setTributacao(char tributacao_produto) {
		this.tributacao_produto = tributacao_produto;
	}
	public Double getIcms() {
		return icms_produto;
	}
	public void setIcms(Double icms_produto) {
		this.icms_produto = icms_produto;
	}
	public Double getEstoque() {
		return estoque_produto;
	}
	public void setEstoque(Double estoque_produto) {
		this.estoque_produto = estoque_produto;
	}
	public Date getCadastrado() {
		return cadastrado_produto;
	}
	public void setCadastrado(Date cadastrado_produto) {
		this.cadastrado_produto = cadastrado_produto;
	}
	public Date getAlterado() {
		return alterado_produto;
	}
	public void setAlterado(Date alterado_produto) {
		this.alterado_produto = alterado_produto;
	}
	public Boolean getAtivo() {
		return ativo_produto;
	}
	public void setAtivo(Boolean ativo_produto) {
		this.ativo_produto = ativo_produto;
	}
    
}
