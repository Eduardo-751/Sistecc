package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAL {

	private static Connection conn = null;

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

	// Gets and Sets
	public static Connection getConn() {
		return conn;
	}
}
