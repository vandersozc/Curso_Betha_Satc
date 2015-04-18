package br.com.betha.controleacademico.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.betha.controleacademico.DAO.InstituicaoDao;
import br.com.betha.controleacademico.modelo.Instituicao;

public class ListaInstituicao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txPesquisa;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tabela;

	public ListaInstituicao() {
		setResizable(false);
		setTitle("Lista de Instituições");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 715, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setLocationRelativeTo(null);

		JPanel painelFundo = new JPanel();
		painelFundo.setBackground(Color.WHITE);
		painelFundo.setForeground(Color.BLACK);
		painelFundo.setBounds(0, 0, 711, 399);
		contentPane.add(painelFundo);
		painelFundo.setLayout(null);
		
		JButton btnNewButton = new JButton("Novo");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CadastroInstituicao inst = new CadastroInstituicao();
				inst.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setBounds(10, 71, 76, 23);
		painelFundo.add(btnNewButton);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = -1;
				
				linhaSelecionada = tabela.getSelectedRow();
				
				if (linhaSelecionada >= 0){
					int codigo = (int)tabela.getValueAt(linhaSelecionada, 0);
					CadastroInstituicao inst = new CadastroInstituicao(codigo, linhaSelecionada, modelo);
					inst.setVisible(true);
					
				} else {
					JOptionPane.showMessageDialog(null, "É necessário selecionar uma instituição para alterar!");
				}
				
			}
		});
		
		btnEditar.setBounds(96, 71, 76, 23);
		painelFundo.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = -1;
				
				linhaSelecionada = tabela.getSelectedRow();
				
				if (linhaSelecionada >= 0){
					int codigo = (int)tabela.getValueAt(linhaSelecionada, 0);
					InstituicaoDao dao = new InstituicaoDao();
					if (dao.removerInstituicao(codigo)){ 
						modelo.removeRow(linhaSelecionada);
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "É necessário selecionar uma institução para remover!");
				}
				
			}
		});
		btnExcluir.setBounds(184, 71, 76, 23);
		painelFundo.add(btnExcluir);

		TextField textField = new TextField();
		textField.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String pesquisa = txPesquisa.getText();
				InstituicaoDao dao = new InstituicaoDao();
				modelo.setNumRows(0);
				
				for (Instituicao inst : dao.listarInstituicao()) {
					modelo.addRow(new Object[]{inst.getCodigo(),
											   inst.getNome(),
											   inst.getEndereco(),
											   inst.getCnpj(),
											   inst.getTelefone()});
				}
			}
		});
		textField.setBounds(266, 72, 433, 22);
		painelFundo.add(textField);
		
		criaTabela();
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 105, 689, 269);
		painelFundo.add(scrollPane);
		
				JLabel lblCadastroDeLivros = new JLabel("Lista de Institui\u00E7\u00F5es");
				lblCadastroDeLivros.setBounds(267, 11, 174, 20);
				painelFundo.add(lblCadastroDeLivros);
				lblCadastroDeLivros.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblCadastroDeLivros.setForeground(new Color(0, 0, 0));
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(176, 224, 230));
				panel.setBounds(0, 0, 709, 55);
				painelFundo.add(panel);
				
						JPanel panelInferior = new JPanel();
						panelInferior.setBounds(0, 375, 709, 24);
						painelFundo.add(panelInferior);
						panelInferior.setBackground(new Color(176, 224, 230));

	}

	private void criaTabela() {
		tabela = new JTable(modelo);
		
		modelo.addColumn("Código");
		modelo.addColumn("Nome");
		modelo.addColumn("Endereço");
		modelo.addColumn("Cnpj");
		modelo.addColumn("Telefone");
		
		carregarTabela();
	
	}

	private void carregarTabela() {
		InstituicaoDao dao =  new InstituicaoDao();
		
		for (Instituicao inst : dao.listarInstituicao()) {
			modelo.addRow(new Object[]{inst.getCodigo(),
									   inst.getNome(),
									   inst.getEndereco(),
									   inst.getCnpj(),
									   inst.getTelefone()});
			
		}
		
	}
}
