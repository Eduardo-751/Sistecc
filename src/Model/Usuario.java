package Model;

public class Usuario {
	
	private int usuarioId;
	private int usuarioDesconto;
	private String usuarioNome;
	private String usuarioLogin;
	private String usuarioSenha;
	private Boolean usuarioAtivo;
	private Boolean usuarioCaixa;
	private Boolean usuarioGerente;
	
	//Métodos Construtores
	public Usuario(String usuarioNome, String usuarioLogin, String usuarioSenha, int usuarioDesconto, Boolean usuarioAtivo, Boolean usuarioCaixa, Boolean usuarioGerente) {
		this.usuarioNome = usuarioNome;
		this.usuarioLogin = usuarioLogin;
		this.usuarioSenha = usuarioSenha;
		this.usuarioDesconto = usuarioDesconto;
		this.usuarioAtivo = usuarioAtivo;
		this.usuarioCaixa = usuarioCaixa;
		this.usuarioGerente = usuarioGerente;
	}
	public Usuario() {
		
	}
	
	//Gets and Sets
	public int getId() {
		return usuarioId;
	}
	public void setId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getUsuarioNome() {
		return usuarioNome;
	}
	public void setUsuarioNome(String usuarioNome) {
		this.usuarioNome = usuarioNome;
	}
	public String getUsuarioLogin() {
		return usuarioLogin;
	}
	public void setUsuarioLogin(String usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}
	public String getUsuarioSenha() {
		return usuarioSenha;
	}
	public void setUsuarioSenha(String usuarioSenha) {
		this.usuarioSenha = usuarioSenha;
	}
	public int getUsuarioDesconto() {
		return usuarioDesconto;
	}
	public void setUsuarioDesconto(int usuarioDesconto) {
		this.usuarioDesconto = usuarioDesconto;
	}
	public Boolean getUsuarioAtivo() {
		return usuarioAtivo;
	}
	public void setUsuarioAtivo(Boolean usuarioAtivo) {
		this.usuarioAtivo = usuarioAtivo;
	}
	public Boolean getUsuarioCaixa() {
		return usuarioCaixa;
	}
	public void setUsuarioCaixa(Boolean usuarioCaixa) {
		this.usuarioCaixa = usuarioCaixa;
	}
	public Boolean getUsuarioGerente() {
		return usuarioGerente;
	}
	public void setUsuarioGerente(Boolean usuarioGerente) {
		this.usuarioGerente = usuarioGerente;
	}

}
