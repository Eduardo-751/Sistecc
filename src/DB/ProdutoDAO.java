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
		this.conexao = DAL.getConn();
	}

	public boolean cadastraProduto(Produto p) {
		try {
			PreparedStatement sql = conexao.prepareStatement("insert into produto "
					+ "(qtd_disponivel, descricao, preco_venda, preco_compra) values " + "(" + p.getQtdDisponivel()
					+ "," + p.getDescricao() + "'," + p.getPrecoVenda() + "," + p.getPrecoCompra() + ")");
			ResultSet rs = sql.executeQuery();
			rs.next();
			sql.execute();
			sql = conexao.prepareStatement("select currval('produto_id_seq')");
			rs = sql.executeQuery();
			rs.next();
			p.setId(rs.getInt("currval"));
			sql.close();
			rs.close();
			sql = conexao.prepareStatement("select setval('produto_id_seq',(select coalesce(max(id),1) from produto))");
			sql.execute();
			sql.close();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Método para retornar um produto pelo ID
	public Produto getProduto(int id) {
		Produto p = null;
		try {
			PreparedStatement sql = conexao.prepareStatement("select * from produto where id = " + id);
			ResultSet rs = sql.executeQuery();
			if (rs.next()) {
				p = new Produto(rs.getDouble("qtdDisponivel"), rs.getString("descricao"), rs.getDouble("precoVenda"),
						rs.getDouble("precoCompra"));
				p.setId(rs.getInt("id"));
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
		ArrayList<Produto> lista = new ArrayList<>();
		try {
			PreparedStatement sql = conexao.prepareStatement("select id from produto order by id");
			ResultSet rs = sql.executeQuery();
			while (rs.next()) {
				Produto p = this.getProduto(rs.getInt("id"));
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
		try {
			PreparedStatement sql = conexao
					.prepareStatement("select count(*)=0 as rs from (select cod_barras from produto where id <> "
							+ p.getId() + ") as rt");
			ResultSet rs = sql.executeQuery();
			rs.next();
			if (rs.getBoolean("rs"))
				try {
					sql = conexao.prepareStatement("update produto set descricao = '" + p.getDescricao()
							+ "',preco_venda = " + p.getPrecoVenda() + ",preco_compra = " + p.getPrecoCompra()
							+ "',qtd_disponivel = " + p.getQtdDisponivel() + "',notificar = ? where id = " + p.getId());
					sql.execute();
					sql.close();
					rs.close();
				} catch (SQLException er) {
					throw new RuntimeException(er);
				}
			else
				return false;
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Método para excluir um produto
	public boolean excluiProduto(Produto p) {
		try {
			PreparedStatement sql = conexao.prepareStatement(
					"select count(*)=0 as rs from (select id_produto from vendaXproduto where id_produto = " + p.getId()
							+ ") as rt");
			ResultSet rs = sql.executeQuery();
			rs.next();
			if (rs.getBoolean("rs"))
				try {
					sql = conexao.prepareStatement("delete from produto where id = " + p.getId());
					sql.execute();
					sql.close();
					rs.close();
				} catch (SQLException er) {
					throw new RuntimeException(er);
				}
			else
				return false;
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
