package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Usuario;

public class UsuarioDAO {
	private Connection conexao = null;

	public UsuarioDAO() {
		if(DAL.getConn() == null)
			DAL.getConnection();
		
		this.conexao = DAL.getConn();
	}

	public boolean cadastraUsuario(Usuario user) {
		
		String statementString = "INSERT INTO usuario (nome_usuario, login_usuario, senha_usuario, desconto_usuario, ativo_usuario, caixa_usuario, gerente_usuario) VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement sql = conexao.prepareStatement(statementString);
			sql.setString(1, user.getUsuarioNome());
			sql.setString(2, user.getUsuarioLogin());
			sql.setString(3, user.getUsuarioSenha());
			sql.setInt(4, user.getUsuarioDesconto());
			sql.setBoolean(5, user.getUsuarioAtivo());
			sql.setBoolean(6, user.getUsuarioCaixa());
			sql.setBoolean(7, user.getUsuarioGerente());
			
			sql.execute();
			sql.close();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Método para retornar um Usuario pelo ID
	public Usuario getUsuario(int id) {
		
		String statementString = "SELECT * FROM usuario WHERE id_usuario = ?";
		Usuario user = null;
		
		try {
			PreparedStatement sql = conexao.prepareStatement(statementString);
			sql.setInt(1, id);
			
			ResultSet rs = sql.executeQuery();
			if (rs.next()) {
				user = new Usuario(rs.getString("nome_usuario"), rs.getString("login_usuario"), rs.getString("senha_usuario"), rs.getInt("desconto_usuario"), 
								   rs.getBoolean("ativo_usuario"), rs.getBoolean("caixa_usuario"), rs.getBoolean("gerente_usuario"));
				user.setId(rs.getInt("id_usuario"));
			}
			
			sql.close();
			rs.close();
			return user;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Método para retornar um Usuario pelo Login
		public Usuario getUsuarioByLogin(String login) {
			
			String statementString = "SELECT * FROM usuario WHERE login_usuario = ?";
			Usuario user = null;
			
			try {
				PreparedStatement sql = conexao.prepareStatement(statementString);
				sql.setString(1, login);
				
				ResultSet rs = sql.executeQuery();
				if (rs.next()) {
					user = new Usuario(rs.getString("nome_usuario"), rs.getString("login_usuario"), rs.getString("senha_usuario"), rs.getInt("desconto_usuario"), 
							   rs.getBoolean("ativo_usuario"), rs.getBoolean("caixa_usuario"), rs.getBoolean("gerente_usuario"));
					user.setId(rs.getInt("id_usuario"));
				}
				
				sql.close();
				rs.close();
				return user;
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
	// Método para retornar todos os Usuarios como um arraylist
	public ArrayList<Usuario> getLista() {
		
		String statementString = "SELECT * FROM usuario ORDER BY id_usuario";
		ArrayList<Usuario> lista = new ArrayList<>();
		
		try {
			PreparedStatement sql = conexao.prepareStatement(statementString);
			ResultSet rs = sql.executeQuery();
			while (rs.next()) {
				Usuario p = this.getUsuario(rs.getInt("id_usuario"));
				lista.add(p);
			}
			sql.close();
			rs.close();
			return lista;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Método para alterar os dados de um Usuario já cadastrado
	public boolean alteraUsuario(Usuario user) {
		
		String statementString = "UPDATE usuario SET login_usuario = ?, senha_usuario = ?, desconto_usuario = ?, ativo_usuario = ?, caixa_usuario = ?, gerente_usuario = ? WHERE id_usuario = ?";
		
		try {
			PreparedStatement sql = conexao.prepareStatement(statementString);
			sql.setString(1, user.getUsuarioLogin());
			sql.setString(2, user.getUsuarioSenha());
			sql.setInt(3, user.getUsuarioDesconto());
			sql.setBoolean(4, user.getUsuarioCaixa());
			sql.setBoolean(5, user.getUsuarioGerente());
			sql.setInt(6, user.getId());
			
			sql.execute();
			sql.close();
			return true;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Método para excluir um Usuario
	public boolean excluiUsuario(Usuario p) {
		String statementString = "DELETE FROM usuario WHERE id_usuario = ?";
		try {
			PreparedStatement sql = conexao.prepareStatement(statementString);
			sql.setInt(1, p.getId());

			sql.execute();
			sql.close();
			return true;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
