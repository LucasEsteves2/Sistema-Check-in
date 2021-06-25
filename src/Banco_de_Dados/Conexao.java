package Banco_de_Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public Connection conectar() {

		Connection Conexao = null;
		try {
			Conexao = DriverManager.getConnection(
					"jdbc:postgresql://ec2-54-90-211-192.compute-1.amazonaws.com:5432/db3m82fgj1uc6m", "urbhrftfrisuxr",
					"103e80239861ecef9fe03b8a428d588673a349a64417311edaf5b28e43938bb3");

			System.out.println("CONEXÃO FEITA COM SUCESSO!!");

		} 
		catch (SQLException e)
		{
			System.out.println("FALHA AO SE CONECTAR COM O BANCO DE DADOS");
		}

		return Conexao;
	}

}
