package Visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Banco_de_Dados.Bd_Comandos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.ScrollPane;
import javax.swing.JSeparator;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	public TelaInicial(Connection con) {

		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInicial.class.getResource("/travel (1).png")));
		setTitle("Checking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ScrollPane scrollPane2_1 = new ScrollPane();
		scrollPane2_1.setBounds(-7, 0, 526, 14);
		contentPane.add(scrollPane2_1);

		JLabel lblchecking2 = new JLabel("");
		lblchecking2.setBounds(6, 11, 230, 56);
		contentPane.add(lblchecking2);

		JLabel lblcadastrar2 = new JLabel("");
		lblcadastrar2.setBounds(8, 64, 226, 54);
		contentPane.add(lblcadastrar2);

		JLabel lblchecking = new JLabel("Realizar Check-in");
		lblchecking.setIcon(new ImageIcon(TelaInicial.class.getResource("/checking.png")));
		lblchecking.setFont(new Font("Arial", Font.BOLD, 14));
		lblchecking.setBounds(35, 22, 184, 32);
		contentPane.add(lblchecking);

		JLabel lblcadastrar = new JLabel("Add Passageiro");
		lblcadastrar.setIcon(new ImageIcon(TelaInicial.class.getResource("/seat-belt.png")));
		lblcadastrar.setFont(new Font("Arial", Font.BOLD, 14));
		lblcadastrar.setBounds(36, 78, 169, 32);
		contentPane.add(lblcadastrar);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(6, 121, 230, 2);
		contentPane.add(separator_2_1);
		
		JLabel lblPassageiros = new JLabel("Ver Passageiros");
		lblPassageiros.setIcon(new ImageIcon(TelaInicial.class.getResource("/passageiro.png")));
		lblPassageiros.setFont(new Font("Arial", Font.BOLD, 14));
		lblPassageiros.setBounds(35, 134, 169, 32);
		contentPane.add(lblPassageiros);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(6, 66, 230, 11);
		contentPane.add(separator_2);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(-26, 0, 32, 177);
		contentPane.add(scrollPane);

		ScrollPane scrollPane_1 = new ScrollPane();
		scrollPane_1.setEnabled(false);
		scrollPane_1.setBounds(3, -6, 236, 183);
		contentPane.add(scrollPane_1);

		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(TelaInicial.class.getResource("/Untitled-2.png")));
		lblFundo.setBounds(-3, 63, 357, 219);
		contentPane.add(lblFundo);

		ScrollPane scrollPane2_2 = new ScrollPane();
		scrollPane2_2.setBounds(-79, 0, 519, 11);
		contentPane.add(scrollPane2_2);

		

		JLabel lblclickPassageiro = new JLabel("");
		lblclickPassageiro.setBounds(6, 122, 223, 53);
		contentPane.add(lblclickPassageiro);
		
		//Chama botao Cadastrar
		AbrirTelaCadastro(lblcadastrar2,con);
		
		
		//Chama botao Checkin
		AbrirTelachecking(lblchecking2, con);
		
		
		//Mostra todos os passageiros

		AbrirAllPassageiros(lblclickPassageiro, con);
		
		
		

	}
	
	
	
	//escutador btn checking
	public void AbrirTelachecking(JLabel lblchecking2, Connection con)
	{
		
		lblchecking2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {

				ExibirTelaBilhete(con);

			}
		});
		
		
	}
	//escutador btn cadastrar
	public void AbrirTelaCadastro(JLabel lblcadastrar2, Connection con)
	{
		
		lblcadastrar2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {

				ExibirTelaCadrasto(con);
			}
		});
		
	}
	
	public void AbrirAllPassageiros(JLabel lblclickPassageiro, Connection con)
	{
		
		lblclickPassageiro.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {

				exibirTelaPassageiro(con);
				
			}
		});
		
	}
	

	public void ExibirTelaCadrasto(Connection con) {

		CadastrarPassageiro novoPassageiro = new CadastrarPassageiro(con);

		novoPassageiro.setLocationRelativeTo(null);
		novoPassageiro.setVisible(true);
		dispose();

	}

	public void ExibirTelaBilhete(Connection con) {

		VerificaBilhete Verificador = new VerificaBilhete(con);

		Verificador.setLocationRelativeTo(null);
		Verificador.setVisible(true);
		dispose();
		
	

	}
	
	
	public void exibirTelaPassageiro(Connection con)
	{
		
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
		    
		    Bd_Comandos banco = new  Bd_Comandos(con);
		    
		    
		    Passageiros All_Passagieros = new Passageiros(banco,con);
		    All_Passagieros.setLocationRelativeTo(null);

		    All_Passagieros.setVisible(true);
		    
		   
		}
		else if(i == JOptionPane.CANCEL_OPTION) {
		    
			System.out.println("Clicou em Não");
		    
	

			// chama a tela inicial
		
			
		

	
	
	
}
	
	}
	
	
	
	
	
	
	
	
	
}