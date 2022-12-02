package Controller;

import Model.Usuario;

/**
 * Classe modelo que representa um usuario no sistema.
 */
public class ControllerUsuario {

    private static Integer usuarioId;
    private static String usuarioNome;
    private static String usuarioLogin;
    private static String usuarioSenha;
    private static int usuarioDesconto;
    private static boolean usuarioAtivo;
    private static boolean usuarioCaixa;
    private static boolean usuarioGerente;

    /**
     * Construtor padrao
     */
    public ControllerUsuario(Usuario user) {
    	usuarioId = user.getId();
    	usuarioNome = user.getUsuarioNome();
    	usuarioLogin = user.getUsuarioLogin();
    	usuarioSenha = user.getUsuarioSenha();
    	usuarioDesconto = user.getUsuarioDesconto();
    	usuarioAtivo = user.getUsuarioAtivo();
    	usuarioCaixa = user.getUsuarioCaixa();
    	usuarioGerente = user.getUsuarioGerente();
    }

	public Integer getUsuarioId() {
		return usuarioId;
	}
	public String getUsuarioNome() {
		return usuarioNome;
	}
	public String getUsuarioLogin() {
		return usuarioLogin;
	}
	public String getUsuarioSenha() {
		return usuarioSenha;
	}
	public int getUsuarioDesconto() {
		return usuarioDesconto;
	}
	public boolean isUsuarioAtivo() {
		return usuarioAtivo;
	}
	public boolean isUsuarioCaixa() {
		return usuarioCaixa;
	}
	public boolean isUsuarioGerente() {
		return usuarioGerente;
	}
}
