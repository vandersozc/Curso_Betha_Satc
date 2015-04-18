package br.com.betha.controleacademico.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Sobre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Sobre() {
		setAlwaysOnTop(true);
		setAutoRequestFocus(false);
		setResizable(false);
		setTitle("Sobre");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 277, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.setLocationRelativeTo(null);
		
		JPanel painelFundo = new JPanel();
		painelFundo.setBackground(Color.WHITE);
		painelFundo.setForeground(Color.BLACK);
		painelFundo.setBounds(0, 0, 272, 154);
		contentPane.add(painelFundo);
		painelFundo.setLayout(null);
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(204, 204, 255));
				panel.setBounds(0, 0, 271, 153);
				painelFundo.add(panel);
				panel.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("Desenvolvido por: Vanderson Zanoni Campanholi");
				lblNewLabel.setBounds(11, 34, 242, 14);
				panel.add(lblNewLabel);
				
				JLabel lblControleAcadmico = new JLabel("Controle Acad\u00EAmico");
				lblControleAcadmico.setBounds(58, 6, 138, 17);
				lblControleAcadmico.setFont(new Font("Tahoma", Font.BOLD, 14));
				panel.add(lblControleAcadmico);
				
				JLabel lblEmailVandozcgmailcom = new JLabel("Email: vando.zc@gmail.com");
				lblEmailVandozcgmailcom.setBounds(11, 58, 242, 14);
				panel.add(lblEmailVandozcgmailcom);
				
				JLabel lblAno = new JLabel("Ano: 2015");
				lblAno.setBounds(11, 79, 242, 14);
				panel.add(lblAno);
				
				JLabel lblCursoJavaOferecido = new JLabel("Curso de Java, oferecido pela Betha Sistemas ");
				lblCursoJavaOferecido.setBounds(11, 104, 242, 14);
				panel.add(lblCursoJavaOferecido);
	}
}
