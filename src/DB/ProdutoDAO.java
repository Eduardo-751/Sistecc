package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Produto;

public class ProdutoDAO {

	private Connection conexao = null;

	public ProdutoDAO() {
		if(DAL.getConn() == null)
			DAL.getConnection();
		
		this.conexao = DAL.getConn();
	}

	public boolean cadastraProduto(Produto p) {
		
		String statementString = "INSERT INTO produtos (nome_prod, descricao_prod, preco_venda) VALUES (?, ?, ?)";
		
		try {
			PreparedStatement sql = conexao.prepareStatement(statementString);
			sql.setString(1, p.getNome());
			sql.setString(2, p.getDescricao());
			sql.setDouble(3, p.getPrecoVenda());
			
			sql.execute();
			sql.close();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Método para retornar um produto pelo ID
	public Produto getProduto(int id) {
		
		String statementString = "SELECT * FROM produtos WHERE id_prod = ?";
		Produto p = null;
		
		try {
			PreparedStatement sql = conexao.prepareStatement(statementString);
			sql.setInt(1, id);
			
			ResultSet rs = sql.executeQuery();
			if (rs.next()) {
				p = new Produto(rs.getString("nome_prod"), rs.getString("descricao_prod"), rs.getDouble("preco_venda"));
				p.setId(rs.getInt("id_prod"));
			}
			
			sql.close();
			rs.close();
			return p;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Método para retornar todos os produtos como um arraylist
	public ArrayList<Produto> getLista() {
		
		String statementString = "SELECT * FROM produtos ORDER BY id_prod";
		ArrayList<Produto> lista = new ArrayList<>();
		
		try {
			PreparedStatement sql = conexao.prepareStatement(statementString);
			ResultSet rs = sql.executeQuery();
			while (rs.next()) {
				Produto p = this.getProduto(rs.getInt("id_prod"));
				lista.add(p);
			}
			sql.close();
			rs.close();
			return lista;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Método para alterar os dados de um produto já cadastrado
	public boolean alteraProduto(Produto p) {
		
		String statementString = "UPDATE produtos SET nome_prod = ?, descricao_prod = ?, preco_venda = ? WHERE id_prod = ?";
		
		try {
			
			PreparedStatement sql = conexao.prepareStatement(statementString);
			sql.setString(1, p.getNome());
			sql.setString(2, p.getDescricao());
			sql.setDouble(3, p.getPrecoVenda());
			sql.setInt(4, p.getId());
			
			sql.execute();
			sql.close();
			return true;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Método para excluir um produto
	public void excluiProduto(Produto p) {

	}

}
