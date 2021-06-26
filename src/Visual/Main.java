package Visual;

import java.sql.Connection;
import java.sql.SQLException;
import Banco_de_Dados.FabricaConexao;

public class Main {

	public static void main(String[] args) throws SQLException {

		// classe responsavel por sempre deixar a conexão aberta(Heroku demora um pouco ao se conectar,dessa forma não trava)

		FabricaConexao fab = new FabricaConexao();
		Connection con = fab.conectar();  //nao quis criar um static

		// instanciando a janela inicial
		
		TelaInicial Inicio = new TelaInicial(con);
		Inicio.setLocationRelativeTo(null);
		Inicio.setVisible(true);

	}

}
