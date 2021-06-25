package Visual;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Banco_de_Dados.Bd_Comandos;

import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.ScrollPane;
import java.awt.Toolkit;

public class Passageiros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Passageiros(Bd_Comandos banco, Connection con) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Passageiros.class.getResource("/passageiro.png")));
		setResizable(false);
		setTitle("Banco de dados");
		setBounds(100, 100, 482, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(127, 255, 212));
		panel.setBounds(-20, -15, 566, 40);
		contentPane.add(panel);
		
		JLabel lblNewLabel_4 = new JLabel("PASSAGEIROS");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(203, 13, 93, 29);
		panel.add(lblNewLabel_4);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(-12, 25, 510, 14);
		contentPane.add(scrollPane);
		
		TextArea textArea = new TextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);
		
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("BILHETE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(61, 75, 53, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(176, 75, 81, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ORIGEM");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(282, 67, 81, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("DESTINO");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1.setBounds(392, 69, 54, 26);
		contentPane.add(lblNewLabel_2_1);
		
		
	
		
		
		textArea.setFont(new Font("Arial", Font.PLAIN, 12));
		banco.exibeTodosPassageiros(textArea);
		
		textArea.setBounds(24, 99, 425, 237);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Passageiros.class.getResource("/passageiro.png")));
		lblNewLabel_3.setBounds(138, 62, 51, 34);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(Passageiros.class.getResource("/direct-flight.png")));
		lblNewLabel_3_1.setBounds(247, 62, 51, 34);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setIcon(new ImageIcon(Passageiros.class.getResource("/location_pointer_map_destination_pin_icon_153125.png")));
		lblNewLabel_3_1_1.setBounds(356, 59, 90, 34);
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setIcon(new ImageIcon(Passageiros.class.getResource("/imagens/passport (4).png")));
		lblNewLabel_3_2.setBounds(27, 62, 32, 34);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblFechar = new JLabel("FECHAR");
		lblFechar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechar.setIcon(new ImageIcon(Passageiros.class.getResource("/cancelar (2).png")));
		lblFechar.setBounds(183, 336, 98, 53);
		contentPane.add(lblFechar);
		
		
		Voltar(lblFechar);
		
		
		
		
	}
	
	
	public void Voltar(JLabel lblFechar) {

		// botão voltar

		lblFechar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {

				// chama a tela principal novamente

				dispose();

			}
		});
	}
}
