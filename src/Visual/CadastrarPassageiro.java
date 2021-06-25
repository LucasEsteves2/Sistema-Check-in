package Visual;

import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Banco_de_Dados.Bd_Comandos;
import entidades_Listas.Bilhetes;
import entidades_Listas.Passageiro;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CadastrarPassageiro extends JFrame {

	private static final long serialVersionUID = 1L;

	private List<Bilhetes> temporaria = new ArrayList<>();

	// Formulario edit
	private JPanel contetpane2;
	private JTextField txtNome;
	private JTextField txtCpf;

	public CadastrarPassageiro(Connection con) {
		// formulario alterar dados pessoais

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarPassageiro.class.getResource("/cinto-de-seguranca (3).png")));

		setTitle("cadastro ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 268, 430);
		contetpane2 = new JPanel();

		contetpane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contetpane2);
		contetpane2.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(16, 48, 60, 30);
		contetpane2.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(64, 53, 122, 20);
		contetpane2.add(txtNome);
		txtNome.setColumns(10);

		txtCpf = new JTextField();
		txtCpf.setBounds(64, 102, 119, 20);
		contetpane2.add(txtCpf);
		txtCpf.setColumns(10);

		JButton btnProximo1 = new JButton("Salvar");

		btnProximo1.setIcon(new ImageIcon(CadastrarPassageiro.class.getResource("/salve-.png")));
		btnProximo1.setBounds(134, 341, 110, 40);
		contetpane2.add(btnProximo1);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 139, 278, 14);
		contetpane2.add(separator);

		JLabel imgAlterar2 = new JLabel("");
		imgAlterar2.setIcon(new ImageIcon(CadastrarPassageiro.class.getResource("/travel (2).png")));
		imgAlterar2.setBounds(198, 95, 37, 40);
		contetpane2.add(imgAlterar2);

		JLabel imgAlterar = new JLabel("");
		imgAlterar.setIcon(new ImageIcon(CadastrarPassageiro.class.getResource("/seat-belt.png")));
		imgAlterar.setBounds(196, 43, 32, 32);
		contetpane2.add(imgAlterar);

		ScrollPane scrollPane2_1 = new ScrollPane();
		scrollPane2_1.setBackground(Color.GREEN);
		scrollPane2_1.setBounds(-153, 0, 526, 9);
		contetpane2.add(scrollPane2_1);

		JButton btnVoltarr = new JButton("Voltar\r\n");
		btnVoltarr.setIcon(new ImageIcon(CadastrarPassageiro.class.getResource("/cancelar (2).png")));
		btnVoltarr.setBounds(14, 341, 110, 41);
		contetpane2.add(btnVoltarr);

		JLabel lbltitulo = new JLabel("PASSAGEIRO");
		lbltitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbltitulo.setBounds(80, 12, 90, 30);
		contetpane2.add(lbltitulo);

		JLabel lblAtt_cpf_1 = new JLabel("CPF:");
		lblAtt_cpf_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAtt_cpf_1.setBounds(25, 101, 60, 20);
		contetpane2.add(lblAtt_cpf_1);

		JLabel lblBilhetes = new JLabel("BILHETE");
		lblBilhetes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBilhetes.setBounds(93, 143, 78, 30);
		contetpane2.add(lblBilhetes);

		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDestino.setBounds(16, 241, 60, 20);
		contetpane2.add(lblDestino);

		JLabel lblOrigem = new JLabel("Origem");
		lblOrigem.setFont(new Font("Arial", Font.PLAIN, 12));
		lblOrigem.setBounds(16, 185, 60, 20);
		contetpane2.add(lblOrigem);

		JLabel imgAlterar_1 = new JLabel("");
		imgAlterar_1.setIcon(new ImageIcon(CadastrarPassageiro.class.getResource("/direct-flight.png")));
		imgAlterar_1.setBounds(199, 172, 32, 32);
		contetpane2.add(imgAlterar_1);

		JLabel imgAlterar2_1 = new JLabel("");
		imgAlterar2_1.setIcon(new ImageIcon(CadastrarPassageiro.class.getResource("/international.png")));
		imgAlterar2_1.setBounds(198, 226, 37, 40);
		contetpane2.add(imgAlterar2_1);

		JLabel lblEmbarque = new JLabel("Embarque");
		lblEmbarque.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEmbarque.setBounds(16, 289, 60, 30);
		contetpane2.add(lblEmbarque);

		JList list = new JList();
		list.setBounds(40, 179, 1, 1);
		contetpane2.add(list);

		JComboBox cbOrigem = new JComboBox();
		cbOrigem.setModel(
				new DefaultComboBoxModel(new String[] { "Juiz de Fora", "Rio de Janeiro", "Espirito Santo" }));
		cbOrigem.setBounds(64, 184, 122, 22);
		contetpane2.add(cbOrigem);

		JComboBox cbDestino = new JComboBox();
		cbDestino.setModel(
				new DefaultComboBoxModel(new String[] { "Rio de Janeiro", "Juiz de Fora", "Espirito Santo" }));
		cbDestino.setBounds(64, 241, 122, 22);
		contetpane2.add(cbDestino);

		JComboBox cbEmbarque = new JComboBox();
		cbEmbarque.setModel(new DefaultComboBoxModel(
				new String[] { "10:00", "12:00", "14:00", "16:00", "18:00", "20:00", "22:00", "00:00" }));
		cbEmbarque.setToolTipText("\r\n10:00\r\n12:00\r\n14:00\r\n16:00\r\n18:00\r\n20:00\r\n22:00\r\n24:00");
		cbEmbarque.setBounds(80, 293, 74, 22);
		contetpane2.add(cbEmbarque);

		JLabel imgAlterar2_1_1 = new JLabel("");
		imgAlterar2_1_1.setIcon(new ImageIcon(
				CadastrarPassageiro.class.getResource("/calendar_clock_schedule_icon-icons.com_51085.png")));
		imgAlterar2_1_1.setBounds(159, 287, 37, 30);
		contetpane2.add(imgAlterar2_1_1);

		// EVENTO BOTÃO CANCELAR
		btnVoltarr.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ExibirTelaInicial(con);

			}
		});

		// EVENTO BOTAO salvar

		btnProximo1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Pegando valores
				String nome = txtNome.getText();
				String cpf = txtCpf.getText();

				// se estiver vazio, vai mandar o usuario preenchera lgo
				if ("".equals(nome))

				{
					JOptionPane.showMessageDialog(null, "Por favor Preencha o campo 'NOME'");

				}

				if ("".equals(cpf)) {
					JOptionPane.showMessageDialog(null, "Por favor Preencha o campo 'CPF' ");

				} else {

					// pegando valor do cbbox
					String Origem = (String) cbOrigem.getSelectedItem();
					String Destino = (String) cbDestino.getSelectedItem();

					String Embarque = (String) cbEmbarque.getSelectedItem();

					String hora_partida = (String) cbEmbarque.getSelectedItem();

					if (Origem.equals(Destino)) {
						JOptionPane.showMessageDialog(null, "ERRO: OS CAMPOS 'ORIGEM' E 'DESTINO' DEVEM SER DIFERENTES", "ERRO", JOptionPane.ERROR_MESSAGE);

					}

					else {

						Bilhetes b1 = new Bilhetes(1, Origem, Destino, Embarque, hora_partida, null, 0);

						b1.adicionar(new Passageiro(nome, cpf));

						temporaria.add(b1);

						// pega o horario de embarque e aumenta em 10 mnts

						TrocaHrPartida(Embarque);

						Bd_Comandos banco = new Bd_Comandos(con);

						//Verifica se o onibus ja possui 16 pessoas (maximo de poltrona no meu onibus)

						banco.OnibusCheio(con, temporaria);
						
						if(banco.getNumero_DE_Passageiro()>16) {
						
							JOptionPane.showMessageDialog(null, "ERRO:ONIBUS LOTADO!!", "ONIBUS LOTADO", JOptionPane.ERROR_MESSAGE);
							JOptionPane.showMessageDialog(null, "Esse onibus ja possui "+banco.getNumero_DE_Passageiro()+" Passageiros");
						}
						
						else
						{
							
						
						banco.CadastrarPassageiro(con, temporaria);

						
						chamaTelaOnibus(banco,con);
						}
					

					}

				}

			}
		});

	}

	public void chamaTelaOnibus(Bd_Comandos banco, Connection con) {
		Onibuss Onibus = new Onibuss(banco, con);
		Onibus.setLocationRelativeTo(null);
		Onibus.setVisible(true);
		
		dispose();
		
	}

	public void ExibirTelaInicial(Connection con) {

		TelaInicial Verificador = new TelaInicial(con);

		Verificador.setLocationRelativeTo(null);
		Verificador.setVisible(true);
		dispose();

	}

	public void TrocaHrPartida(String Embarque) {

		switch (Embarque) {
		case "10:00":
			temporaria.get(0).setHora_partida("10:10");

			break;

		case "12:00":
			temporaria.get(0).setHora_partida("12:10");

			break;

		case "14:00":
			temporaria.get(0).setHora_partida("14:10");

			break;

		case "16:00":
			temporaria.get(0).setHora_partida("16:10");

			break;

		case "18:00":
			temporaria.get(0).setHora_partida("18:10");

			break;

		case "20:00":
			temporaria.get(0).setHora_partida("20:10");

			break;

		case "22:00":
			temporaria.get(0).setHora_partida("22:10");

			break;

		case "00:00":
			temporaria.get(0).setHora_partida("00:10");

			break;

		default:
			break;
		}

	}

	public void exibirbilhete(Connection con) {
		VerificaBilhete Verificador = new VerificaBilhete(con);

		Verificador.setLocationRelativeTo(null);
		Verificador.setVisible(true);
		dispose();

	}
}
