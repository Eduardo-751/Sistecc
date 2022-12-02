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
		if (DAL.getConn() == null)
			DAL.getConnection();

		this.conexao = DAL.getConn();
	}

	public boolean cadastraProduto(Produto p) {

		String statementString = "INSERT INTO Produto (ncm_produto, cod_barra_produto, descricao_produto, preco_produto, estoque_produto, "
								+ "cst_produto, tributacao_produto, icms_produto, cadastrado_produto, ativo_produto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement sql = conexao.prepareStatement(statementString);
			sql.setString(1, p.getNcm());
			sql.setString(2, p.getCodBarra());
			sql.setString(3, p.getDescricao());
			sql.setDouble(4, p.getPreco());
			sql.setDouble(5, p.getEstoque());
			sql.setString(6, p.getCst());
			sql.setString(7, String.valueOf(p.getTributacao()));
			sql.setDouble(8, p.getIcms());
			sql.setDate(9, p.getCadastrado());
			sql.setBoolean(10, p.getAtivo());

			sql.execute();
			sql.close();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Método para retornar um produto pelo ID
	public Produto getProduto(int id) {

		String statementString = "SELECT * FROM Produto WHERE id_produto = ?";
		Produto p = null;

		try {
			PreparedStatement sql = conexao.prepareStatement(statementString);
			sql.setInt(1, id);

			ResultSet rs = sql.executeQuery();
			if (rs.next()) {
				p = new Produto(rs.getString("cod_barra_produto"), rs.getString("descricao_produto"), rs.getDouble("preco_produto"), rs.getString("ncm_produto"), 
						        rs.getString("cst_produto"), rs.getString("tributacao_produto").charAt(0), rs.getDouble("icms_produto"), rs.getDouble("estoque_produto"),
						        rs.getBoolean("ativo_produto"));
				p.setId(rs.getInt("id_produto"));
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

		String statementString = "SELECT * FROM Produto ORDER BY id_produto";
		ArrayList<Produto> lista = new ArrayList<>();

		try {
			PreparedStatement sql = conexao.prepareStatement(statementString);
			ResultSet rs = sql.executeQuery();
			while (rs.next()) {
				Produto p = this.getProduto(rs.getInt("id_produto"));
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

		String statementString = "UPDATE produto SET ncm_produto = ?, cod_barra_produto = ?, descricao_produto = ?, preco_produto = ?, "
								+ "estoque_produto = ?, cst_produto = ?, tributacao_produto = ?, icms_produto = ?, cadastrado_produto = ?, "
								+ "alterado_produto = ?, ativo_produto = ? WHERE id_produto = ?";
		
		try {
			PreparedStatement sql = conexao.prepareStatement(statementString);
			sql.setString(1, p.getNcm());
			sql.setString(2, p.getCodBarra());
			sql.setString(3, p.getDescricao());
			sql.setDouble(4, p.getPreco());
			sql.setDouble(5, p.getEstoque());
			sql.setString(6, p.getCst());
			sql.setString(7, String.valueOf(p.getTributacao()));
			sql.setDouble(8, p.getIcms());
			sql.setDate(9, p.getCadastrado());
			sql.setDate(10, p.getAlterado());
			sql.setBoolean(11, p.getAtivo());
			sql.setInt(12, p.getId());

			sql.execute();
			sql.close();
			return true;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Método para excluir um produto
	public boolean excluiProduto(Produto p) {
		String statementString = "DELETE FROM produto WHERE id_produto = ?";
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
