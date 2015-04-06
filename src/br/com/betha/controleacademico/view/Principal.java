package br.com.betha.controleacademico.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		setTitle("Controle Acadêmico");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 607, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel painelFundo = new JPanel();
		painelFundo.setBackground(Color.WHITE);
		painelFundo.setForeground(Color.BLACK);
		painelFundo.setBounds(0, 0, 591, 325);
		contentPane.add(painelFundo);
		painelFundo.setLayout(null);

		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(new Color(176, 196, 222));
		panelInferior.setBounds(0, 304, 591, 21);
		painelFundo.add(panelInferior);

		JLabel lblDesenvolvidoPorVanderson = new JLabel("Desenvolvido por Vanderson Campanholi");
		lblDesenvolvidoPorVanderson.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblDesenvolvidoPorVanderson.setForeground(new Color(0, 0, 0));
		panelInferior.add(lblDesenvolvidoPorVanderson);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 591, 21);
		painelFundo.add(menuBar);
		
		JMenu mnInstituio = new JMenu("Institui\u00E7\u00E3o");
		menuBar.add(mnInstituio);
		mnInstituio.setHorizontalAlignment(SwingConstants.CENTER);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				CadastroInstituicao inst = new CadastroInstituicao();
				inst.setVisible(true);
			}
		});
		mnInstituio.add(mntmCadastrar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				ListaInstituicao list = new ListaInstituicao();
				list.setVisible(true);
			}
		});
		mnInstituio.add(mntmListar);
		
		JMenu mnAlunos = new JMenu("Alunos");
		menuBar.add(mnAlunos);
		mnAlunos.setHorizontalAlignment(SwingConstants.CENTER);
		
		JMenuItem mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mntmCadastrar_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				CadastroAlunos alunos = new CadastroAlunos();
				alunos.setVisible(true);
			}
		});
		mnAlunos.add(mntmCadastrar_1);
		
		JMenuItem mntmListar_1 = new JMenuItem("Listar");
		mntmListar_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Em construção");
				//ListaAlunos list = new ListaAlunos();
				//list.setVisible(true);
			}
		});
		mnAlunos.add(mntmListar_1);
		
		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);
	}
	
}
