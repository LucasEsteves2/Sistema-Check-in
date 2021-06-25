package Visual;

import java.sql.Connection;
import java.sql.SQLException;
import Banco_de_Dados.FabricaConexao;

public class Main {

	public static void main(String[] args) throws SQLException {

		// classe responsavel por sempre deixar a conexão aberta

		FabricaConexao fab = new FabricaConexao();
		Connection con = fab.conectar();

		// instanciando a janela inicial

		TelaInicial Inicio = new TelaInicial(con);
		Inicio.setLocationRelativeTo(null);
		Inicio.setVisible(true);

	}

}
