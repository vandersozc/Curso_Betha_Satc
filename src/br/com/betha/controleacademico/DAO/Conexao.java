package br.com.betha.controleacademico.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static final String STR_CONEXAO = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "controle";
	private static final String PASSWORD = "system";

	private Conexao() {
	}

	public static Connection setConexao() throws SQLException {
		try {
			return DriverManager.getConnection(STR_CONEXAO, USER, PASSWORD);
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

}
