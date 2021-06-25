package Visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Banco_de_Dados.Bd_Comandos;
import entidades_Listas.Bilhetes;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.ScrollPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class VerificaBilhete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBilhete;
	private JLabel lblPassageiro;

	private List<Bilhetes> temporario = new ArrayList<>();

	public VerificaBilhete(Connection con) {

		setIconImage(Toolkit.getDefaultToolkit().getImage(VerificaBilhete.class.getResource("/passport (1).png")));
		setTitle("Localizar Bilhetes");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-3, -18, 499, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCodigo = new JLabel("Insira o Codigo localizador do bilhete");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCodigo.setBounds(27, 13, 244, 20);
		contentPane.add(lblCodigo);

		txtBilhete = new JTextField();
		txtBilhete.setColumns(10);
		txtBilhete.setBounds(272, 11, 86, 24);
		contentPane.add(txtBilhete);

		JButton btnproximo = new JButton("Proximo");
		btnproximo.setBounds(368, 11, 85, 23);
		contentPane.add(btnproximo);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(-14, 40, 519, 8);
		contentPane.add(scrollPane);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setIcon(new ImageIcon(VerificaBilhete.class.getResource("/passageiro.png")));

		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(23, 93, 266, 40);
		contentPane.add(lblNome);
		lblNome.setVisible(false);

		lblPassageiro = new JLabel("Passageiro");

		lblPassageiro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassageiro.setBounds(187, 47, 85, 40);
		contentPane.add(lblPassageiro);
		lblPassageiro.setVisible(false);

		JLabel lblcpf = new JLabel("Cpf:");
		lblcpf.setIcon(new ImageIcon(VerificaBilhete.class.getResource("/name-card-icon_31834.png")));
		lblcpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblcpf.setBounds(315, 93, 160, 40);
		contentPane.add(lblcpf);
		lblcpf.setVisible(false);

		ScrollPane scrollPane_1 = new ScrollPane();
		scrollPane_1.setBackground(new Color(0, 255, 0));
		scrollPane_1.setBounds(-14, 198, 506, 8);
		contentPane.add(scrollPane_1);
		scrollPane_1.setVisible(false);

		JLabel lblpassagem = new JLabel("Bilhete");
		lblpassagem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblpassagem.setBounds(206, 204, 81, 40);
		contentPane.add(lblpassagem);
		lblpassagem.setVisible(false);

		JLabel lblOrigem = new JLabel("Origem");
		lblOrigem.setIcon(new ImageIcon(VerificaBilhete.class.getResource("/time.png")));
		lblOrigem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrigem.setBounds(50, 238, 223, 40);
		contentPane.add(lblOrigem);
		lblOrigem.setVisible(false);

		JLabel lblDestinoo = new JLabel("Destino");
		lblDestinoo.setIcon(new ImageIcon(VerificaBilhete.class.getResource("/location_pointer_map_destination_pin_icon_153125.png")));
		lblDestinoo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDestinoo.setBounds(283, 238, 176, 40);
		contentPane.add(lblDestinoo);
		lblDestinoo.setVisible(false);

		JLabel lblHora_embarque = new JLabel("Embarque:");
		lblHora_embarque.setIcon(
				new ImageIcon(VerificaBilhete.class.getResource("/calendar_clock_schedule_icon-icons.com_51085.png")));
		lblHora_embarque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHora_embarque.setBounds(50, 306, 227, 40);
		contentPane.add(lblHora_embarque);
		lblHora_embarque.setVisible(false);

		JLabel lblHora_partida = new JLabel("Partida:");
		lblHora_partida.setIcon(
				new ImageIcon(VerificaBilhete.class.getResource("/calendar_clock_schedule_icon-icons.com_51085.png")));
		lblHora_partida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHora_partida.setBounds(283, 306, 176, 40);
		contentPane.add(lblHora_partida);
		lblHora_partida.setVisible(false);

		JButton btnContinuar = new JButton("Proximo");

		btnContinuar.setBounds(158, 361, 134, 33);
		contentPane.add(btnContinuar);
		btnContinuar.setVisible(false);

		JLabel lblHora_atual = new JLabel("Hora Atual");
		lblHora_atual.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblHora_atual.setBounds(185, -1, 134, 44);
		lblHora_atual.setVisible(false);
		contentPane.add(lblHora_atual);

		JLabel imgRelogio = new JLabel("");
		imgRelogio.setIcon(new ImageIcon(VerificaBilhete.class.getResource("/iconfinder-document09-1622827_121958.png")));
		imgRelogio.setBounds(150, 5, 46, 33);
		imgRelogio.setVisible(false);
		contentPane.add(imgRelogio);

		JPanel pnlcorprincip = new JPanel();
		pnlcorprincip.setBackground(new Color(255, 255, 0));
		pnlcorprincip.setBounds(0, 0, 505, 40);
		contentPane.add(pnlcorprincip);

		JPanel pnlCor = new JPanel();
		pnlCor.setBackground(new Color(0, 255, 255));
		pnlCor.setBounds(-1, -1, 506, 44);
		contentPane.add(pnlCor);
		pnlCor.setLayout(null);

		JLabel lblPoltronaAlocada = new JLabel("Poltrona:");
		lblPoltronaAlocada.setIcon(new ImageIcon(VerificaBilhete.class.getResource("/seat-belt.png")));
		lblPoltronaAlocada.setBounds(150, 359, 190, 33);
		contentPane.add(lblPoltronaAlocada);

		JLabel lblVoltar = new JLabel("VOLTAR");
		lblVoltar.setBounds(15, 359, 85, 44);
		contentPane.add(lblVoltar);
		lblVoltar.setFont(new Font("Arial", Font.BOLD, 11));
		lblVoltar.setIcon(new ImageIcon(VerificaBilhete.class.getResource("/previous (2).png")));

		JButton btnEditarDados = new JButton("Editar dados ");
		btnEditarDados.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEditarDados.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditarDados.setIcon(new ImageIcon(VerificaBilhete.class.getResource("/businessapplication_edit_male_user_thepencil_theclient_negocio_2321 (2).png")));
		btnEditarDados.setBounds(164, 156, 134, 36);
		contentPane.add(btnEditarDados);

		btnEditarDados.setVisible(false);

		JLabel lblDeletar = new JLabel("Limpar");
		lblDeletar.setFont(new Font("Arial", Font.BOLD, 11));
		lblDeletar.setIcon(new ImageIcon(VerificaBilhete.class.getResource("/cancelar (2).png")));
		lblDeletar.setBounds(397, 358, 85, 44);
		contentPane.add(lblDeletar);
		JLabel background = new JLabel("\r\n");
		background.setIcon(new ImageIcon(VerificaBilhete.class.getResource("/backgroundl2c.jpg")));
		background.setBounds(-3, 44, 496, 370);
		contentPane.add(background);
		lblPoltronaAlocada.setVisible(false);
		pnlCor.setVisible(false);
		btnEditarDados.setVisible(false);
		lblVoltar.setVisible(false);
		lblDeletar.setVisible(false);

		// evento click bottão proximo

		btnproximo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// se estiver vazio, vai mandar o usuario preenchera lgo
				if ("".equals(txtBilhete.getText()))

				{
					JOptionPane.showMessageDialog(null, "Por favor insira um codigo valido");

				}

				else { // caso o campo nao esteja vazio ele vai entrar em ação

					try {
						int Bilhete = Integer.parseInt(txtBilhete.getText());

						// CLASS RESPONSAVEL Por fazer os statments
						Bd_Comandos banco = new Bd_Comandos(con);

						//Se o bilhete Informado existir vai retornar as informação do passageiro
						boolean existe = banco.VerificaBilhete(Bilhete);

						if (existe) // caso o bilhete exista
						{
							
							JOptionPane.showMessageDialog(null, "Bilhete Encontrado no banco de Dados");
							
							
							
							int idbilhete = banco.getPassageiro().get(0).getIdbilhete();
							int Poltrona = banco.getPassageiro().get(0).getPoltrona();


							// Coloquei tudo em metodos pois fica mais facil de entender e de programar
							
							// botão voltar
							ChamaBotaoVoltar(lblVoltar, con);

							// botão excluir

							ChamaBotaoExcluir(con, lblDeletar, banco, Poltrona, idbilhete);

							// BOTÃO EDITAR DADOS

							ChamaBotaoEditarDados(btnEditarDados, banco, lblNome, lblcpf);

							// ACÃO BOTAO CONTINUAR

							ChamaBotaoContinuar(btnContinuar, Poltrona, banco, con);

							
							
						
							// EXIBINDO COMPONENTES OCULTOS(PASSANDO PARA FUNÇÃO EXIBIR PARA FICAR MAIS
							// LIMPO AQUI NA TELA)
							
							ExibirComponentes(pnlcorprincip, background, lblCodigo, txtBilhete, btnEditarDados,
									scrollPane_1, lblpassagem, lblpassagem, lblNome, lblcpf, lblDestinoo,
									lblHora_embarque, lblHora_partida, lblOrigem, pnlCor, btnproximo, imgRelogio,
									lblHora_atual);
							
							lblVoltar.setVisible(true);
							lblPassageiro.setVisible(true);

							// Pegando valores do banco de dados e trocando a tela pelos respectivos
							PegavalorBanco(banco, lblDeletar, btnContinuar, lblPoltronaAlocada, lblVoltar, lblDestinoo,
									lblOrigem, lblHora_embarque, lblHora_partida, lblHora_atual, lblNome, lblcpf);

						}

						else {

							JOptionPane.showMessageDialog(null, "Bilhete não encontrado no banco de dados");
							
						
							//Metodo responsavel por mostrar todos os passageiros, caso o usario queira,caso contrario ele retorna ao menu
							
							Exibir_Todos_Passsageiros(con,banco);
								
							
							
							
							

						}
					}

					catch (Exception e2) {
						
						JOptionPane.showMessageDialog(null, "Bilhete não encontrado no banco de dados");
						Bd_Comandos banco = new Bd_Comandos(con);
						Exibir_Todos_Passsageiros(con,banco);

					}

				}
			}
		});

	}
	
	public void Exibir_Todos_Passsageiros(Connection con, Bd_Comandos banco) {
		
		//funcao nova
		int i = JOptionPane.showConfirmDialog(
		        null, 
		        "Deseja Visualizar todos os Passageiros Cadastrados?",
		        "Passageiros",
		        JOptionPane.OK_CANCEL_OPTION
		        );

		
		
	
		if(i == JOptionPane.YES_OPTION)
		{
		    System.out.println("Clicou em Sim");
		    
		  
		    Passageiros All_Passagieros = new Passageiros(banco,con);
		    All_Passagieros.setLocationRelativeTo(null);

		    All_Passagieros.setVisible(true);
		    
		   
		}
		else if(i == JOptionPane.CANCEL_OPTION) {
		    
			System.out.println("Clicou em Não");
		    
	

			// chama a tela inicial
			Tela1(con);
			
			
		

	
	
	
}
	
		
	}

	//Metodo que pega as informaçao do banco de dados e troca a tela atual

	public void PegavalorBanco(Bd_Comandos banco, JLabel lblDeletar, JButton btnContinuar, JLabel lblPoltronaAlocada,
			JLabel lblVoltar, JLabel lblDestinoo, JLabel lblOrigem, JLabel lblHora_embarque, JLabel lblHora_partida,
			JLabel lblHora_atual, JLabel lblNome, JLabel lblcpf) {

		@SuppressWarnings("unused")
		int idbilhete = banco.getPassageiro().get(0).getIdbilhete();

		String nome = banco.getPassageiro().get(0).getBilhete().get(0).getNome();

		String cpf = banco.getPassageiro().get(0).getBilhete().get(0).getCpf();

		String Destino = banco.getPassageiro().get(0).getDestino();

		int Poltrona = banco.getPassageiro().get(0).getPoltrona();

		String Origem = banco.getPassageiro().get(0).getOrigem();

		String Hora_embarque = banco.getPassageiro().get(0).getHora_embarque();

		String Hora_partida = banco.getPassageiro().get(0).getHora_partida();

		// Verificando se o passageiro ja esta em alguma cadeira alocada

		if (Poltrona != 0) {
			System.out.println("Esse Passageiro ja possui uma Poltrona alocada");
			int temp = Poltrona;
			lblDeletar.setVisible(true);
			btnContinuar.setVisible(false);
			lblPoltronaAlocada.setVisible(true);
			lblPoltronaAlocada.setText("N° Poltrona Alocada: " + temp);
			lblVoltar.setVisible(true);
		}

		else {
			btnContinuar.setVisible(true);

		}

		String timeStamp = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());

		// trocando valores dos objetos pela lista

		lblDestinoo.setText("Destino: " + Destino);

		lblOrigem.setText("Origem: " + Origem);

		lblHora_embarque.setText("Embarque: " + Hora_embarque);

		lblHora_partida.setText(" Partida: " + Hora_partida);

		lblHora_atual.setText("Horario: " + timeStamp);

		lblNome.setText("Nome: " + nome);

		lblcpf.setText("CPF: " + cpf);

	}

//
	public void ChamaBotaoContinuar(JButton btnContinuar, int Poltrona, Bd_Comandos banco, Connection con) {

		btnContinuar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (Poltrona == 0) {

					// passando os valores daqui para la
					Onibuss Onibus = new Onibuss(banco, con);
					Onibus.setLocationRelativeTo(null);
					Onibus.setVisible(true);

					dispose();

				} else {

					JOptionPane.showMessageDialog(null, "Passageiro ja possui uma poltrona alocada");
					dispose();

				}

			}
		});

	}

	// Escutador que é acionado quando o botao editar dados é clicado
	public void ChamaBotaoEditarDados(JButton btnEditarDados, Bd_Comandos banco, JLabel lblNome, JLabel lblcpf) {

		btnEditarDados.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				EditarDados_pessoais janela = new EditarDados_pessoais(banco, lblNome, lblcpf);

				janela.setLocationRelativeTo(null);
				janela.setVisible(true);

			}
		});

	}

	// Metodo para excluir cadeira

	public void ChamaBotaoExcluir(Connection con, JLabel lblDeletar, Bd_Comandos banco, int Poltrona, int idbilhete) {

		lblDeletar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {

				// Limpa a polrona do passageiro

				banco.limpaCadeira(Poltrona, idbilhete);
				JOptionPane.showMessageDialog(null, "Cadeira Desalocada com suceso!!");

				TelaPrincipal(con);

			}
		});

	}

	// Metodo que instancia a tela principal e chama ela de volta
	public void TelaPrincipal(Connection con) {

		// chama a tela principal novamente
		TelaInicial Inicio = new TelaInicial(con);
		Inicio.setLocationRelativeTo(null);
		Inicio.setVisible(true);

		dispose();

	}

	// metodo que chama a primeira tela
	public void Tela1(Connection con) {

		// chama a tela principal novamente
		TelaInicial Inicio = new TelaInicial(con);
		Inicio.setLocationRelativeTo(null);
		Inicio.setVisible(true);

		dispose();

	}

	// Fiz uma pequena "GAMBIARRA" POREM VAI DEIXAR O CODIGO A CIMA MAIS LIMPO e tbm
	// mais facil de entender

	public void ExibirComponentes(JPanel pnlcorprincip, JLabel background2, JLabel lblCodigo, JTextField txtBilhete,
			JButton btnEditarDados, ScrollPane scrollPane_1, JLabel lblpassagem, JLabel lblPassageiro, JLabel lblNome,
			JLabel lblcpf, JLabel lblDestinoo, JLabel lblHora_embarque, JLabel lblHora_partida, JLabel lblOrigem,
			JPanel pnlCor, JButton btnproximo, JLabel imgRelogio, JLabel lblHora_atual) {

		// Colocando na tela quando usuario clicar
		pnlcorprincip.setVisible(false);
		background2.setVisible(false);
		lblCodigo.setVisible(false);
		txtBilhete.setVisible(false);
		btnEditarDados.setVisible(true);
		scrollPane_1.setVisible(true);

		btnEditarDados.setVisible(true);
		lblpassagem.setVisible(true);
		lblPassageiro.setVisible(true);
		lblNome.setVisible(true);
		lblcpf.setVisible(true);

		lblDestinoo.setVisible(true);
		lblHora_embarque.setVisible(true);
		lblHora_partida.setVisible(true);
		lblOrigem.setVisible(true);

		btnEditarDados.setVisible(true);

		// Ocultando botao e exibindo a hora atual cm img

		pnlCor.setVisible(true);
		btnproximo.setVisible(false);
		imgRelogio.setVisible(true);
		lblHora_atual.setVisible(true);

	}

//Metodo responsavel por chamar o botao VOLTAR  quando ele for clicado
	public void ChamaBotaoVoltar(JLabel lblVoltar, Connection con) {

		// botão voltar

		lblVoltar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {

				// chama a tela principal novamente
				TelaPrincipal(con);

			}
		});

	}

	public List<Bilhetes> getTemporario() {
		return temporario;
	}

	public void setTemporario(List<Bilhetes> temporario) {
		this.temporario = temporario;
	}

}
