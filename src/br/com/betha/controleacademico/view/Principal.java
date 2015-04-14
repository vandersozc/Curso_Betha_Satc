package br.com.betha.controleacademico.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GrayFilter;
import javax.swing.ImageIcon;
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
		setBounds(100, 100, 878, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel painelFundo = new JPanel();
		painelFundo.setBackground(Color.WHITE);
		painelFundo.setForeground(Color.BLACK);
		painelFundo.setBounds(0, 0, 872, 491);
		contentPane.add(painelFundo);
		painelFundo.setLayout(null);

		JPanel panelInferior = new JPanel();
		panelInferior.setBounds(0, 437, 862, 43);
		panelInferior.setBackground(new Color(176, 224, 230));
		painelFundo.add(panelInferior);
		panelInferior.setLayout(null);

		JLabel lblDesenvolvidoPorVanderson = new JLabel("Desenvolvido por Vanderson Campanholi");
		lblDesenvolvidoPorVanderson.setBounds(324, 21, 205, 11);
		lblDesenvolvidoPorVanderson.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDesenvolvidoPorVanderson.setForeground(new Color(0, 0, 0));
		panelInferior.add(lblDesenvolvidoPorVanderson);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 862, 43);
		menuBar.setForeground(new Color(0, 0, 0));
		painelFundo.add(menuBar);
		
		JMenu mnInstituio = new JMenu("Institui\u00E7\u00E3o");
		mnInstituio.setForeground(new Color(0, 0, 0));
		mnInstituio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		menuBar.add(mnInstituio);
		mnInstituio.setHorizontalAlignment(SwingConstants.CENTER);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mntmCadastrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				CadastroInstituicao inst = new CadastroInstituicao();
				inst.setVisible(true);
			}
		});
		mnInstituio.add(mntmCadastrar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mntmListar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				ListaInstituicao list = new ListaInstituicao();
				list.setVisible(true);
			}
		});
		mnInstituio.add(mntmListar);
		
		JMenu mnAlunos = new JMenu("Alunos");
		mnAlunos.setForeground(new Color(0, 0, 0));
		mnAlunos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(mnAlunos);
		mnAlunos.setHorizontalAlignment(SwingConstants.CENTER);
		
		JMenuItem mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mntmCadastrar_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mntmCadastrar_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				CadastroAlunos alunos = new CadastroAlunos();
				alunos.setVisible(true);
			}
		});
		mnAlunos.add(mntmCadastrar_1);
		
		JMenuItem mntmListar_1 = new JMenuItem("Listar");
		mntmListar_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mntmListar_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null, "Em construção");
				ListaAluno list = new ListaAluno();
				list.setVisible(true);
			}
		});
		mnAlunos.add(mntmListar_1);
		
		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setForeground(new Color(0, 0, 0));
		mnSobre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(mnSobre);
	}
}
