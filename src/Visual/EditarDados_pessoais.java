package Visual;

import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Banco_de_Dados.Bd_Comandos;

public class EditarDados_pessoais extends JFrame {

	private static final long serialVersionUID = 1L;

	// Formulario edit
	private JPanel contetpane2;
	private JTextField txtAtt_nome;
	private JTextField txtAtt_cpf;

	public EditarDados_pessoais(Bd_Comandos x, JLabel lblNome, JLabel lblcpf) {
		// formulario alterar dados pessoais

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditarDados_pessoais.class.getResource("/passageiro.png")));

		setTitle("Alterar Dados Pessoais");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 265, 211);
		contetpane2 = new JPanel();

		contetpane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contetpane2);
		contetpane2.setLayout(null);

		JButton btnAttsalvar = new JButton("Salvar");

		btnAttsalvar.setIcon(new ImageIcon(EditarDados_pessoais.class.getResource("/salve-.png")));
		btnAttsalvar.setBounds(123, 121, 118, 41);
		contetpane2.add(btnAttsalvar);

		JButton btnVoltarr = new JButton("Cancelar");
		btnVoltarr.setIcon(new ImageIcon(EditarDados_pessoais.class.getResource("/cancelar (2).png")));
		btnVoltarr.setBounds(12, 121, 104, 41);
		contetpane2.add(btnVoltarr);
		
		JLabel lblNome_1 = new JLabel("Nome:");
		lblNome_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome_1.setBounds(16, 24, 60, 30);
		contetpane2.add(lblNome_1);
		
		txtAtt_nome = new JTextField();
		txtAtt_nome.setColumns(10);
		txtAtt_nome.setBounds(64, 29, 122, 20);
		contetpane2.add(txtAtt_nome);
		
		JLabel imgAlterar = new JLabel("");
		imgAlterar.setIcon(new ImageIcon(EditarDados_pessoais.class.getResource("/seat-belt.png")));
		imgAlterar.setBounds(196, 19, 32, 32);
		contetpane2.add(imgAlterar);
		
		txtAtt_cpf = new JTextField();
		txtAtt_cpf.setColumns(10);
		txtAtt_cpf.setBounds(64, 78, 119, 20);
		contetpane2.add(txtAtt_cpf);
		
		JLabel lblAtt_cpf_1 = new JLabel("CPF:");
		lblAtt_cpf_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAtt_cpf_1.setBounds(25, 77, 60, 20);
		contetpane2.add(lblAtt_cpf_1);
		
		JLabel imgAlterar2 = new JLabel("");
		imgAlterar2.setIcon(new ImageIcon(EditarDados_pessoais.class.getResource("/travel (2).png")));
		imgAlterar2.setBounds(198, 71, 37, 40);
		contetpane2.add(imgAlterar2);
		
		ScrollPane scrollPane2_1_1 = new ScrollPane();
		scrollPane2_1_1.setBounds(-153, 0, 526, 13);
		contetpane2.add(scrollPane2_1_1);

		// Alterando os valores padrão pelo do bilhete
				txtAtt_nome.setText(x.getPassageiro().get(0).getBilhete().get(0).getNome());
				txtAtt_cpf.setText(x.getPassageiro().get(0).getBilhete().get(0).getCpf());

		
		
		// EVENTO BOTÃO CANCELAR
		btnVoltarr.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				dispose();

			}
		});

		// EVENTO BOTAO SALVAR

		btnAttsalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Verificando se o campo possui algum valor
				if ("".equals(txtAtt_nome.getText()))

				{
					JOptionPane.showMessageDialog(null, "Por favor preencha o campo NOME");

				} else if ("".equals(txtAtt_cpf.getText())) {
					JOptionPane.showMessageDialog(null, "Por favor preencha o campo CPF");

				} else {

					String cpfPrimario = x.getPassageiro().get(0).getBilhete().get(0).getCpf();

					String NomeTemporario = txtAtt_nome.getText();
					String CpfTemporario = txtAtt_cpf.getText();

					// Alterando as lbl do formulario

					lblNome.setText("Nome: " + NomeTemporario);
					lblcpf.setText("CPF: " + CpfTemporario);

					// Setando os dados da lista
					x.getPassageiro().get(0).getBilhete().get(0).setNome(NomeTemporario);
					x.getPassageiro().get(0).getBilhete().get(0).setCpf(CpfTemporario);

					// Setando no banco de dados

					x.AtualizaPassageiro(NomeTemporario, CpfTemporario, cpfPrimario);

					dispose();
				}

			}
		});

	}
}
