package DB;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAL {

	private Connection conn = null;
	private Statement statement;
	private ResultSet resultSet;

	private final String Server = "localhost:3306";
	private final String DataBase = "Sistecc";
	private final String User = "root";
	private final String Pass = "Edu@751463";

	public void getConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + Server + "/" + DataBase, User, Pass);
			if (conn != null) {
				System.out.println("Conexão efetuada com sucesso! " + "ID: " + conn);
			}

		} catch (Exception e) {
			System.out.println("Conexão não realizada - ERRO: " + e.getMessage());
		}
	}

	public void closeConnection(Connection con) {
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int insertSQL(String SQL) {
		int status = 0;
		try {
			this.setStatement(getConn().createStatement());

			this.getStatement().executeUpdate(SQL);

			return status;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return status;
		}
	}

	public void executarSQL(String sql) {
		try {
			this.statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			this.resultSet = this.statement.executeQuery(sql);

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}

	public boolean updateSQL(String pSQL) {
		try {
			this.setStatement(getConn().createStatement());

			getStatement().executeUpdate(pSQL);

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	// Gets and Sets
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
}
