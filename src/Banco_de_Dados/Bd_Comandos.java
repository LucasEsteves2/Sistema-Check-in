package Banco_de_Dados;

import java.awt.TextArea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entidades_Listas.Bilhetes;
import entidades_Listas.LinhaOnibus;
import entidades_Listas.Passageiro;

//Para deixar o codigo mais limpo
//Através dessa classe irei criar metodos para a conexão
public class Bd_Comandos {

	public PreparedStatement stmt = null;
	public Conexao conectar = new Conexao();
	public Connection con = null;
	public ResultSet rs = null;
	private List<Bilhetes> passageiro = new ArrayList<Bilhetes>();
	public int Numero_DE_Passageiro;

	public Bd_Comandos(Connection con) {
		;
		this.con = con;
	}

	public List<Bilhetes> getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(List<Bilhetes> passageiro) {
		this.passageiro = passageiro;
	}

//metodo que verifica se é o bilhete existe no banco de dados 
	public Boolean VerificaBilhete(int bilhete) {

		try {
			stmt = con.prepareStatement(
					"SELECT nome,cpf,Destino,Origem,Hpartida,Hembarque,Poltrona, IDBILHETE FROM BILHETES,Passageiro WHERE IDBILHETE= ? and IDBILHETE =ID_BILHETE");

			stmt.setInt(1, bilhete);

			stmt.execute();

			rs = stmt.getResultSet();

			if (rs.next()) // Se o bilhete for valido
			{
				// Colocando valores em variavel temporaria
				String nome = rs.getString(1);
				String cpf = rs.getString(2);
				String destino = rs.getString(3);
				String origem = rs.getString(4);
				String hora_partida = rs.getString(5);
				String hora_embarque = rs.getString(6);
				int Poltrona = rs.getInt(7);
				int idbilhete = rs.getInt(8);

				// Instanciando valores
				Bilhetes passagem = new Bilhetes(idbilhete, origem, destino, hora_embarque, hora_partida, null,
						Poltrona);

				passagem.adicionar(new Passageiro(nome, cpf));

				passageiro.add(passagem);

				return true; // se retornar true é pq o bilhite informado era valido
			} else {
				return false;
			}

		}

		catch (SQLException e) {
			System.out.println("Erro ao procurar bilhete");
			e.printStackTrace();
		}

		return null;
	}

	// metodo que atualiza passageiro
	public void AtualizaPassageiro(String nome, String NovoCpf, String cpfPrimario) {

		try {

			// Meu cpf é a chjave
			// setando nome

			stmt = con.prepareStatement(" update Passageiro set nome= ? where cpf= ?    ");
			stmt.setString(1, nome);
			stmt.setString(2, cpfPrimario);
			stmt.executeUpdate();

			// setando cpf

			stmt = con.prepareStatement(" update Passageiro set cpf= ? where cpf= ?    ");
			stmt.setString(1, NovoCpf);
			stmt.setString(2, cpfPrimario);
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Passageiro Alterado com sucesso!!");

		} catch (Exception e) {

			e.printStackTrace();

			System.out.println("Erro ao atualizar passageiro!");
			JOptionPane.showMessageDialog(null, "-Erro ao atualizar o passageiro ");
			JOptionPane.showMessageDialog(null, "certifique se de inserir um CPF VALIDO(15 CARACTERES)	 ");
		}

	}

	// metodo que aloca cadeira

	public void alocaPolrona(int Poltrona, int idbilhete) {

		try {

			stmt = con.prepareStatement("  update bilhetes  set Poltrona = ? where IDBILHETE=?               ");

			stmt.setInt(1, Poltrona);
			stmt.setInt(2, idbilhete);

			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Falha ao alocar a poltrona");
			e.printStackTrace();
		}

	}

	// Metodo para desalocar a cadeira do pasasgeiro

	public void limpaCadeira(int Poltrona, int idbilhete) {

		try {

			stmt = con.prepareStatement("  update bilhetes  set Poltrona = ? where IDBILHETE=?               ");

			stmt.setInt(1, 0);
			stmt.setInt(2, idbilhete);

			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Falha ao desalocar a cadeira");
			e.printStackTrace();
		}

	}

	public void Onibus(String Destino, String Origem, String HRembarque, List<LinhaOnibus> onibus) {

		
		
		
		
		
		
		
		
		
		
		try {

			// VAI TRAZER TODAS AS CADEIRAS QUE ESTÃO OCUPADAS do respectivo destino e
			// horario
			stmt = con.prepareStatement("SELECT NOME,POLTRONA FROM BILHETES,PASSAGEIRO WHERE IDBILHETE=ID_BILHETE"
					+ " AND Destino = ? and Origem =? and Hembarque = ? AND POLTRONA !=0");

			stmt.setString(1, Destino);
			stmt.setString(2, Origem);
			stmt.setString(3, HRembarque);

			stmt.execute();

			rs = stmt.getResultSet();

			// Peegar todas as cadeiras ocupadas para poder marcar

			while (rs.next()) {

				String nome = rs.getString(1);
				int poltrona = rs.getInt(2);

				LinhaOnibus linha = new LinhaOnibus(poltrona, nome);

				onibus.add(linha);

			}

		} catch (SQLException e) {
			System.out.println("Erro ao capturar cadeiras ocupadas");
			e.printStackTrace();
		}

	}

	public void CadastrarPassageiro(Connection con, List<Bilhetes> temporaria) {

		
	//verifica se o cpf informado existe
		
		try {
		
			stmt = con.prepareStatement("Select cpf from passageiro where cpf = ?");
			
			stmt.setString(1, temporaria.get(0).getBilhete().get(0).getCpf() );
			stmt.execute();
			
			rs=stmt.getResultSet();
			
			if(rs.next())
			{
				
				JOptionPane.showMessageDialog(null, "ERRO: CPF JA CADASTRADO", "Erro CADASTRO", JOptionPane.ERROR_MESSAGE);
				
			}
			else
			{
				
			
			
			stmt = con.prepareStatement(
					" insert into BILHETES (Destino,Origem,Hpartida, Hembarque,Poltrona)   values(?,?,?,?,NULL)");

			stmt.setString(1, temporaria.get(0).getDestino());
			stmt.setString(2, temporaria.get(0).getOrigem());
			stmt.setString(3, temporaria.get(0).getHora_partida());
			stmt.setString(4, temporaria.get(0).getHora_embarque());

			stmt.execute();

			stmt = con.prepareStatement("select IDBILHETE FROM  BILHETES WHERE poltrona is null ");

			stmt.execute();

			rs = stmt.getResultSet();

			while (rs.next()) {
				int idbilhete = rs.getInt(1);
				temporaria.get(0).setIdbilhete(idbilhete);
			}

			stmt = con.prepareStatement("insert into Passageiro(nome,cpf,ID_BILHETE)  values(?,?,?)");

			stmt.setString(1, temporaria.get(0).getBilhete().get(0).getNome());
			stmt.setString(2, temporaria.get(0).getBilhete().get(0).getCpf());
			stmt.setInt(3, temporaria.get(0).getIdbilhete());

			stmt.execute();

			// VOLTANDO A CADEIRA PARA 0, PARA EVITAR ERRO NOS PROXIMOS USUARIOS CADASTRADOS
			stmt = con.prepareStatement("UPDATE BILHETES SET POLTRONA = 0 WHERE POLTRONA IS NULL");

			stmt.execute();

			// Teste

			String nome = temporaria.get(0).getBilhete().get(0).getNome();
			String cpf = temporaria.get(0).getBilhete().get(0).getCpf();

			String destino = temporaria.get(0).getDestino();
			String Origem = temporaria.get(0).getOrigem();

			String hora_EMBARQUE = temporaria.get(0).getHora_embarque();

			String horasaida = temporaria.get(0).getHora_partida();

			// Instanciando valores
			Bilhetes passagem = new Bilhetes(temporaria.get(0).getIdbilhete(), Origem, destino, hora_EMBARQUE,
					horasaida, null, 0);

			passagem.adicionar(new Passageiro(nome, cpf));

			passageiro.add(passagem);

			// Fim do teste antes do filme

			JOptionPane.showMessageDialog(null, "Passageiro Cadastrado Com sucesso");

			JOptionPane.showMessageDialog(null,"CODIGO LOCALIZADOR DO BILHETE: " + temporaria.get(0).getIdbilhete()," NÃO PERCA", JOptionPane.INFORMATION_MESSAGE);
			
	
			
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERRO: CPF JA CADASTRADO", "Erro CADASTRO", JOptionPane.ERROR_MESSAGE);
			

		}

	}

	
	//Verifica se o onibus ja possui 15 pessoas (maximo de assento no meu onibus)
	public void OnibusCheio(Connection con, List<Bilhetes> temporaria) {
		
		
		//Verifica se o onibus ja possui 15 pessoas (maximo de assento no meu onibus)
		
				try {
					stmt=con.prepareStatement("select count(destino) from bilhetes where destino = ? and Hembarque = ? group by destino" );
				
				stmt.setString(1, temporaria.get(0).getDestino());
				stmt.setString(2, temporaria.get(0).getHora_embarque());
				
				stmt.execute();
				rs=stmt.getResultSet();
				
				while(rs.next())
				{
					Numero_DE_Passageiro = rs.getInt(1);
					
					
				}
				
				
				
				
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "ERRO: ONIBUS LOTADO, Numero de passageiros :"+ Numero_DE_Passageiro);
					e.printStackTrace();
				}
				
		
		
		
	}

	public int getNumero_DE_Passageiro() {
		return Numero_DE_Passageiro;
	}

	public void setNumero_DE_Passageiro(int numero_DE_Passageiro) {
		Numero_DE_Passageiro = numero_DE_Passageiro;
	}
	
	
	
	
	public void exibeTodosPassageiros(TextArea x)
	{
		// VAI TRAZER TODOS OS PASSAGIEROS PARA EXIBIR NO FORMULARIO
		try {
			
			stmt=con.prepareStatement(" select idbilhete, nome,origem,destino from passageiro,bilhetes where idbilhete=id_bilhete \r\n" + 
					"order by idbilhete;");
			
			
			stmt.execute();
			
			
			rs=stmt.getResultSet();
			
			
			while(rs.next())
				
			{
				
				int bilhete = rs.getInt(1);
				String nome = rs.getString(2);
				String destino =rs.getString(3);
				String origem =rs.getString(4);
				
				
			   

				x.append("\r\n    | "+ bilhete + " |         -         " + nome+"     -    "+ origem +"      -  " + destino + " \t\t\r\n\t\r\n ");

			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	
	public boolean VerificaPoltrona(int Num_Poltrona, Bd_Comandos banco) {
		
		try {
			
			stmt=con.prepareStatement("select poltrona from bilhetes where destino= ?   and hpartida =? and poltrona =? and origem =? ");
		
		
		
			stmt.setString(1, banco.getPassageiro().get(0).getDestino());
			
			stmt.setString(2, banco.getPassageiro().get(0).getHora_partida());
		
			stmt.setInt(3, Num_Poltrona);
			stmt.setString(4, banco.getPassageiro().get(0).getOrigem());
			stmt.execute();
			
			rs=stmt.getResultSet();
			
			
			//Se retornar e pq a poltrona es
			if(rs.next())
			{
				
				return true;
			}
			
			
			
			else
			{
				return false;
			}
			
			
		
		} catch (SQLException e) {
		System.out.println("falha na busca");
		}
		return false;
	
		
		
		
	}
	
	
	
	
	
	
}
