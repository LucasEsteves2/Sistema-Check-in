package Banco_de_Dados;

import java.sql.Connection;

public class FabricaConexao {

	private static Conexao banco = new Conexao();

	public static Connection conectar() {

		Connection con = banco.conectar();
		return con;

	}

}
