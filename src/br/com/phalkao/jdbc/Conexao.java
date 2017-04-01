package br.com.phalkao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	
	public static Connection getConnection(){
		Connection conn = null;

		try{
			Class.forName("org.postgresql.Driver");
			conn =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/bancocjweb1","postgres","Yu$uk3" );
			System.out.println("Conectado ao banco.");
		}catch(SQLException e){
			System.out.println("Erro ao conectar ao banco: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Driver não encontrado." + e.getMessage());
		}
		return conn;
	}
}
