package Visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Banco_de_Dados.Bd_Comandos;
import entidades_Listas.Bilhetes;
import entidades_Listas.LinhaOnibus;
import entidades_Listas.Passageiro;
import graphics.Poltrona_Grapich2d;
import graphics.Poltrona_click;

import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JSeparator;

public class Onibuss extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentpane3;
	private JTextField txtPoltrona;
	private final JLabel lblDestino = new JLabel("Destino:");
	private List<Bilhetes> temporaria = new ArrayList<>();

	private Bd_Comandos banco;
	private Connection con;
	
	public List<LinhaOnibus> getOnibus() {
		return Onibus;
	}

	public void setOnibus(List<LinhaOnibus> onibus) {
		Onibus = onibus;
	}

	private List<LinhaOnibus> Onibus = new ArrayList<>();

	public void VerificaPoltrona(LinhaOnibus x) {

		Onibus.add(x);

	}

	public Onibuss(Bd_Comandos banco, Connection con) {

		this.banco=banco;
		this.con=con;
		
		setTitle("Onibus");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Onibuss.class.getResource("/domestic.png")));

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 459);
		contentpane3 = new JPanel();
		contentpane3.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane3);
		contentpane3.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 0));
		panel.setBounds(-54, 0, 566, 40);
		contentpane3.add(panel);
		panel.setLayout(null);
		lblDestino.setBounds(201, 4, 302, 32);
		lblDestino.setIcon(
				new ImageIcon(Onibuss.class.getResource("/location_pointer_map_destination_pin_icon_153125.png")));
		panel.add(lblDestino);
		lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 14));

		ScrollPane scrollPane2 = new ScrollPane();
		scrollPane2.setBounds(-14, 40, 519, 14);
		contentpane3.add(scrollPane2);

		JLabel lblNomeOnibus = new JLabel("Nome:");
		lblNomeOnibus.setIcon(new ImageIcon(Onibuss.class.getResource("/passageiro.png")));
		lblNomeOnibus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeOnibus.setBounds(33, 65, 252, 35);
		contentpane3.add(lblNomeOnibus);

		JLabel lblEmbarque = new JLabel("Embarque:");
		lblEmbarque
				.setIcon(new ImageIcon(Onibuss.class.getResource("/calendar_clock_schedule_icon-icons.com_51085.png")));
		lblEmbarque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmbarque.setBounds(33, 121, 219, 35);
		contentpane3.add(lblEmbarque);

		JLabel lblPartida = new JLabel("Partida:");
		lblPartida
				.setIcon(new ImageIcon(Onibuss.class.getResource("/calendar_clock_schedule_icon-icons.com_51085.png")));
		lblPartida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPartida.setBounds(297, 116, 176, 40);
		contentpane3.add(lblPartida);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setIcon(new ImageIcon(Onibuss.class.getResource("/name-card-icon_31834.png")));
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpf.setBounds(299, 66, 182, 40);
		contentpane3.add(lblCpf);

		JLabel lblinforme = new JLabel("Informe o N\u00B0 Da poltrona desejada");
		lblinforme.setFont(new Font("Arial", Font.PLAIN, 15));
		lblinforme.setBounds(19, 204, 231, 20);
		contentpane3.add(lblinforme);

		txtPoltrona = new JTextField();
		txtPoltrona.setColumns(10);
		txtPoltrona.setBounds(255, 205, 99, 20);
		contentpane3.add(txtPoltrona);

		JButton btnCheck = new JButton("Verificar");
		btnCheck.setBounds(364, 204, 89, 23);
		contentpane3.add(btnCheck);

		JLabel lblPoltronas = new JLabel("Poltronas");
		lblPoltronas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPoltronas.setBounds(195, 162, 81, 40);
		contentpane3.add(lblPoltronas);

		JLabel imgdisponivel = new JLabel("");
		imgdisponivel.setIcon(new ImageIcon(Onibuss.class.getResource("/Untitled-1.png")));
		imgdisponivel.setBounds(58, 358, 164, 33);
		contentpane3.add(imgdisponivel);

		JLabel lbldisponivel = new JLabel("Disponivel");
		lbldisponivel.setBounds(95, 367, 69, 14);
		contentpane3.add(lbldisponivel);

		JLabel lblverde = new JLabel("");
		lblverde.setIcon(new ImageIcon("C:\\Users\\lucas\\Desktop\\Untitled-1.png"));
		lblverde.setBounds(54, 362, 164, 33);
		contentpane3.add(lblverde);

		JLabel lblocupadotxt = new JLabel("Ocupado");
		lblocupadotxt.setBounds(362, 367, 69, 14);
		contentpane3.add(lblocupadotxt);

		JLabel lblOcupado = new JLabel("");
		lblOcupado.setIcon(new ImageIcon(Onibuss.class.getResource("/rede.png")));
		lblOcupado.setBounds(325, 358, 164, 33);
		contentpane3.add(lblOcupado);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-14, 163, 505, 14);
		contentpane3.add(separator);
		
		JLabel lblclique = new JLabel("Ou Clique na Poltrona");
		lblclique.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblclique.setBounds(20, 225, 217, 14);
		contentpane3.add(lblclique);

		JLabel lblvoltar = new JLabel("Voltar");
		lblvoltar.setIcon(new ImageIcon(Onibuss.class.getResource("/previous (2).png")));
		lblvoltar.setBounds(10, 385, 69, 28);
		contentpane3.add(lblvoltar);

		
		//Minhas Poltronas 
		
		Poltrona_Grapich2d p1 = new Poltrona_Grapich2d(Color.GREEN,Color.black, "01","?");
	
		p1.setBounds(14, 251, 45, 39);
		getContentPane().add(p1).addMouseListener(new Poltrona_click(p1,this)); //adicionando o escutador para fazer efeito
		
	
		
		Poltrona_Grapich2d p2 = new Poltrona_Grapich2d(Color.GREEN,Color.black, "02", "?");
		p2.setBounds(72, 251, 45, 39);
		getContentPane().add(p2).addMouseListener(new Poltrona_click(p2,this));;
		
		
		Poltrona_Grapich2d p3 = new Poltrona_Grapich2d(Color.GREEN,Color.black, "03", "?");
		p3.setBounds(130, 251, 45, 39);
		getContentPane().add(p3).addMouseListener(new Poltrona_click(p3,this));;
		
		Poltrona_Grapich2d p4 = new Poltrona_Grapich2d(Color.GREEN,Color.black, "04", "?");
		p4.setBounds(188, 251, 45, 39);
		getContentPane().add(p4).addMouseListener(new Poltrona_click(p4,this));;
		
		
		Poltrona_Grapich2d p5 = new Poltrona_Grapich2d(Color.GREEN,Color.black, "05", "?");
		p5.setBounds(248, 251, 45, 39);
		getContentPane().add(p5).addMouseListener(new Poltrona_click(p5,this));;
		
		
		
		Poltrona_Grapich2d p6 = new Poltrona_Grapich2d(Color.GREEN,Color.black, "06", "?");
		p6.setBounds(306, 251, 45, 39);
		getContentPane().add(p6).addMouseListener(new Poltrona_click(p6,this));;
		

		Poltrona_Grapich2d p7 = new Poltrona_Grapich2d(Color.GREEN,Color.black, "07", "?");
		p7.setBounds(367, 251, 45, 39);
		getContentPane().add(p7).addMouseListener(new Poltrona_click(p7,this));;
		
		
		Poltrona_Grapich2d p8 = new Poltrona_Grapich2d(Color.GREEN,Color.black, "08", "?");
		p8.setBounds(425, 251, 45, 39);
		getContentPane().add(p8).addMouseListener(new Poltrona_click(p8,this));;
		
		
		Poltrona_Grapich2d p9 = new Poltrona_Grapich2d(Color.GREEN,Color.black, "09", "?");
		p9.setBounds(14, 302,45, 39);
		getContentPane().add(p9).addMouseListener(new Poltrona_click(p9,this));;
		
		Poltrona_Grapich2d p10 = new Poltrona_Grapich2d(Color.GREEN,Color.black, "10", "?");
		p10.setBounds(72, 302, 45, 39);
		getContentPane().add(p10).addMouseListener(new Poltrona_click(p10,this));;
		
		Poltrona_Grapich2d p11 = new Poltrona_Grapich2d(Color.GREEN,Color.black, "11", "?");
		p11.setBounds(130, 302, 45, 39);
		getContentPane().add(p11).addMouseListener(new Poltrona_click(p11,this));;
		
		
		Poltrona_Grapich2d p12 = new Poltrona_Grapich2d(Color.GREEN,Color.black, "12", "?");
		p12.setBounds(188, 302, 45, 39);
		getContentPane().add(p12).addMouseListener(new Poltrona_click(p12,this));;
		
		
		Poltrona_Grapich2d p13 = new Poltrona_Grapich2d(Color.GREEN,Color.black, "13", "?");
		p13.setBounds(248, 302, 45, 39);
		getContentPane().add(p13).addMouseListener(new Poltrona_click(p13,this));;
		
		
		Poltrona_Grapich2d p14 = new Poltrona_Grapich2d(Color.GREEN,Color.black, "14", "?");
		p14.setBounds(306, 302, 45, 39);
		getContentPane().add(p14).addMouseListener(new Poltrona_click(p14, this));;
		
		
		Poltrona_Grapich2d p15 = new Poltrona_Grapich2d(Color.GREEN,Color.black, "15", "?");
		p15.setBounds(367, 302, 45, 39);
		getContentPane().add(p15).addMouseListener(new Poltrona_click(p15,this));;
		
		Poltrona_Grapich2d p16 = new Poltrona_Grapich2d(Color.GREEN,Color.black, "16", "?");
		p16.setBounds(425, 302, 45, 39);
		getContentPane().add(p16).addMouseListener(new Poltrona_click(p16,this));;

		//adicioanndo os escutadores
		
		
		
		
		//Metodo que pega o valor do banco e troca as label da tela atual

		pegavalor(banco,lblEmbarque,lblPartida,lblNomeOnibus,lblCpf);
		


		// Passando para executar uma query que retorna as cadeiras ja ocupadas da  respectiva linha
		// Dessa forma eu controlo que os passageiros do mesmo onibus(Destino e hoario) nao ocupem a mesma POLTRONA

		banco.Onibus(temporaria.get(0).getDestino(), temporaria.get(0).getOrigem(), temporaria.get(0).getHora_embarque(), Onibus);

		
		
		//metodo que pega todos os passageiros do mesmo onibus(destino,origem,horario) e marca a cadeira de vermelho 
		MarcaCadeiraOcupada(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16);
		
		
		

		
		// Chama o botao  voltar

		Voltar(lblvoltar, con);
		
		JLabel lblimg = new JLabel("");
		lblimg.setIcon(new ImageIcon(Onibuss.class.getResource("/aadads.png")));
		lblimg.setBounds(134, 323, 180, 128);
		contentpane3.add(lblimg);
				
		
		
	
		
		/// botao checar evento click

		btnCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					if ("".equals(txtPoltrona.getText())) // se o usuario deixar o campo vazio

					{
						JOptionPane.showMessageDialog(null, "Por Favor INFORME uma poltrona , Ou CLIQUE em uma poltrona");

					} else {

						// Pega a cadeira que foi digitada (porem ela é uma string)
						String poltrona = txtPoltrona.getText();

						// transformando em inteiro
						int PoltronaInt = Integer.parseInt(poltrona);

						 
					
						
						
						// Metodo que aloca o valor escolhido na poltrona
						
						VerificaPoltrona(PoltronaInt, banco, con, p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16);
						
						

					}
				} 
				catch (Exception e2)
				{
					JOptionPane.showMessageDialog(null, "Poltrona Invalida!!.");

				}

			}

		});

	}
	
//Metodo que pega o valor do banco de dados e altera o formulario da tela atual
	public void pegavalor(Bd_Comandos banco, JLabel lblEmbarque, JLabel lblPartida, JLabel lblNomeOnibus, JLabel lblCpf) {
		
		

		String Origem = banco.getPassageiro().get(0).getOrigem();
		String Destino = banco.getPassageiro().get(0).getDestino();
		String HoraEmbarque = banco.getPassageiro().get(0).getHora_embarque();
		String HoraPartida = banco.getPassageiro().get(0).getHora_partida();
		String Nome = banco.getPassageiro().get(0).getBilhete().get(0).getNome();
		String cpf = banco.getPassageiro().get(0).getBilhete().get(0).getCpf();

		// Trocando valores da tela

		lblDestino.setText("Destino: " + Destino);
		lblEmbarque.setText("Embarque: " + HoraEmbarque);
		lblPartida.setText("Partida: " + HoraPartida);
		lblNomeOnibus.setText("Nome: " + Nome);
		lblCpf.setText("CPF: " + cpf);
		
		
		Bilhetes bilhete = new Bilhetes(0, Origem, Destino, HoraEmbarque, HoraPartida, null, 0);
		
		
		bilhete.adicionar(new Passageiro(Nome, cpf));
		
		temporaria.add(bilhete);
		
		
		
		
		
	}

	// Metodo que verifica se a poltrona esta ocupada
	public void VerificaPoltrona( int Poltrona, Bd_Comandos banco, Connection con, Poltrona_Grapich2d p1, Poltrona_Grapich2d p2, Poltrona_Grapich2d p3, Poltrona_Grapich2d p4, Poltrona_Grapich2d p5, Poltrona_Grapich2d p6, Poltrona_Grapich2d p7, Poltrona_Grapich2d p8, Poltrona_Grapich2d p9, Poltrona_Grapich2d p10, Poltrona_Grapich2d p11, Poltrona_Grapich2d p12, Poltrona_Grapich2d p13, Poltrona_Grapich2d p14, Poltrona_Grapich2d p15, Poltrona_Grapich2d p16) {

		switch (Poltrona) {
		case 1:
			AlocaPoltrona(Poltrona, banco, con, p1);

			break;

		case 2:
			AlocaPoltrona(Poltrona, banco, con, p2);
			break;

		case 3:
			AlocaPoltrona(Poltrona, banco, con, p3);
			break;

		case 4:
			AlocaPoltrona(Poltrona, banco, con, p4);
			break;

		case 5:
			AlocaPoltrona(Poltrona, banco, con, p5);
			break;

		case 6:
			AlocaPoltrona(Poltrona, banco, con, p6);
			break;

		case 7:
			AlocaPoltrona(Poltrona, banco, con, p7);
			break;

		case 8:
			AlocaPoltrona(Poltrona, banco, con, p8);
			break;

		case 9:
			AlocaPoltrona(Poltrona, banco, con, p9);
			break;

		case 10:
			AlocaPoltrona(Poltrona, banco, con,  p10);
			break;

		case 11:
			AlocaPoltrona(Poltrona, banco, con,  p11);
			break;

		case 12:
			AlocaPoltrona(Poltrona, banco, con,  p12);
			break;

		case 13:
			AlocaPoltrona(Poltrona, banco, con,  p13);
			break;

		case 14:
			AlocaPoltrona(Poltrona, banco, con,  p14);
			break;

		case 15:
			AlocaPoltrona(Poltrona, banco, con,  p15);
			break;

		case 16:
			AlocaPoltrona(Poltrona, banco, con,  p16);
			break;

		default: // caso o usuario digite uma poltrona que nao existe
			JOptionPane.showMessageDialog(null, "Poltrona Invalida!!");
			JOptionPane.showMessageDialog(null, "Não foi possivel realizar o Check-in.");

			TelaPrincipal(con);

		}

	}
	//metodo do click
	
	public void AlocaPoltrona(int Poltrona, Bd_Comandos banco, Connection con, Poltrona_Grapich2d cadeira) {

		
		
		boolean PoltronaOcupada = banco.VerificaPoltrona(Poltrona, banco);
		
		//ocupado
		if(PoltronaOcupada)
		{

			System.out.println(Poltrona);

			// PEGANDO NOME DO PASSAGEIRO QUE ESTA NA CADEIRA

			for (LinhaOnibus linhaOnibus : Onibus) {
				
				if (linhaOnibus.getPoltrona() == Poltrona) {
					String Nome_passageiro = linhaOnibus.getNome();

					JOptionPane.showMessageDialog(null, "Essa Poltrona ja foi Reservada pelo Passageiro " + Nome_passageiro, 
						"POLTRONA OCUPADA!!" , JOptionPane.WARNING_MESSAGE);
					TelaPrincipal(con); // Volta para a tela inicial

				}
			}

		}

		else // se estiver vazia
		{
			try {
				

				// Setando a lista
				banco.getPassageiro().get(0).setPoltrona(Poltrona);

				// pegando valor
				int idbilhete = banco.getPassageiro().get(0).getIdbilhete();

				// Setando no banco de dados
				banco.alocaPolrona(Poltrona, idbilhete);

				// ANIMAÇÃO
					
				cadeira.setBackground(Color.RED);
				cadeira.CadeiraOcupada(Color.RED);

				JOptionPane.showMessageDialog(null, "Check-in realizado com sucesso.!!");
				JOptionPane.showMessageDialog(null, "Voce tbm pode ALOCAR uma cadeira através do CLICK (basta clicar na cadeira desejada)");	

				TelaPrincipal(con); // Volta para a tela inicial

			}

			catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Por favor, informe um NUMERO valido!!.");

			}

		}

	}
	
	
	
	


public void botaoAlocaPassageiro(Poltrona_Grapich2d btnPoltrona, int poltrona) {
	
	for (LinhaOnibus passageiro : Onibus) {
		if (passageiro.getPoltrona() == poltrona) {
			String Nome_passageiro = passageiro.getNome();
			
			JOptionPane.showMessageDialog(null, "Essa Poltrona ja foi Reservada pelo Passageiro " + Nome_passageiro, 
					"POLTRONA OCUPADA!!" , JOptionPane.WARNING_MESSAGE);
			
			btnPoltrona.setBackground(Color.RED);
			btnPoltrona.c1 =Color.RED;
			

		}
	
}
		

	boolean PoltronaOcupada = banco.VerificaPoltrona(poltrona, banco);
	
	//ocupado
	if(PoltronaOcupada)
	{
		System.out.println("Poltrona ocupada");
		System.out.println("EXISTEEEE");
	}
	
	else
	{
		
		//Muda a cor para mostar que esta selecionada e dar um efeito
		btnPoltrona.setBackground(new Color(0, 255, 255));
		btnPoltrona.c1 = new Color(0, 255, 255);


		
		int i = JOptionPane.showConfirmDialog(
		        null, 
		        "Deseja Alocar essa poltrona?",
		        "Poltrona",
		        JOptionPane.OK_CANCEL_OPTION
		        );

		
		
	
		if(i == JOptionPane.YES_OPTION)
		{
		    System.out.println("Clicou em Sim");
		    
		    
		    
			AlocaPoltrona(poltrona, banco, con, btnPoltrona);

		    
		    
		    
		    
		    
		}
		else if(i == JOptionPane.CANCEL_OPTION) {
		    
			System.out.println("Clicou em Não");
		    
				
			
			//Volta a cor Padrão
			btnPoltrona.setBackground(Color.GREEN);
			btnPoltrona.c1=Color.GREEN;;

	
	
	
}

	}
}


	

	// metodo responsavel por colorir a cadeira caso esteja ocupada

	public void MarcaCadeiraOcupada(Poltrona_Grapich2d p1, Poltrona_Grapich2d p2, Poltrona_Grapich2d p3, Poltrona_Grapich2d p4, Poltrona_Grapich2d p5, Poltrona_Grapich2d p6, Poltrona_Grapich2d p7, Poltrona_Grapich2d p8, Poltrona_Grapich2d p9, Poltrona_Grapich2d p10, Poltrona_Grapich2d p11, Poltrona_Grapich2d p12, Poltrona_Grapich2d p13, Poltrona_Grapich2d p14, Poltrona_Grapich2d p15, Poltrona_Grapich2d p16) {

		for (LinhaOnibus linhaOnibus : Onibus) {

			// Alterando a cor dos buttons para vermeelho caso a cadeira esteja ocuapda

			switch (linhaOnibus.getPoltrona()) {
			
			
			case 1:
			
				p1.c1 = Color.RED;

				break;

			case 2:
				
				p2.c1 = Color.RED;

				
				break;

			case 3:
				p3.c1 = Color.RED;

				
				break;

			case 4:

				p4.c1 = Color.RED;

				
				break;

			case 5:

				p5.c1 = Color.RED;

				break;

			case 6:

				p6.c1 = Color.RED;

				break;

			case 7:

				p7.c1 = Color.RED;

				
				break;

			case 8:
				p8.c1 = Color.RED;


				break;

			case 9:

				p9.c1 = Color.RED;

				
				break;

			case 10:


				p10.c1 = Color.RED;

				break;

			case 11:

				p11.c1 = Color.RED;


				break;

			case 12:
				p12.c1 = Color.RED;


				break;

			case 13:
				p13.c1 = Color.RED;


				break;

			case 14:

				p14.c1 = Color.RED;


				break;

			case 15:

				p15.c1 = Color.RED;

				
				break;

			case 16:
				p16.c1 = Color.RED;


				break;

			}

		}
	}

	
	public void TelaPrincipal(Connection con) {

		// chama a tela principal novamente
		TelaInicial Inicio = new TelaInicial(con);
		Inicio.setLocationRelativeTo(null);
		Inicio.setVisible(true);
		
		dispose();

	}

	//esse nao fecha a tela
	public void TelaPrincipall(Connection con) {

		// chama a tela principal novamente
		TelaInicial Inicio = new TelaInicial(con);
		Inicio.setLocationRelativeTo(null);
		Inicio.setVisible(true);
		

	}
	
	

	public void Voltar(JLabel lblVoltar, Connection con) {

		// botão voltar

		lblVoltar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {

				// chama a tela principal novamente

				TelaPrincipal(con);

			}
		});
	}
	
	




public void TrocaImg_BOTAO (JButton btn) {
	btn.setIcon(new ImageIcon(Onibuss.class.getResource("/cinto-de-seguranca (3).png")));
	btn.setText("");
}

public List<Bilhetes> getTemporaria() {
	return temporaria;
}

public void setTemporaria(List<Bilhetes> temporaria) {
	this.temporaria = temporaria;
}
	public Color getContentpane3Background() {
		return contentpane3.getBackground();
	}
	public void setContentpane3Background(Color background) {
		contentpane3.setBackground(background);
	}
}
