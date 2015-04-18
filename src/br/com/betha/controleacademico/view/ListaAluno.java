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

import br.com.betha.controleacademico.DAO.AlunoDao;
import br.com.betha.controleacademico.modelo.Aluno;

public class ListaAluno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txPesquisa;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tabela;

	public ListaAluno() {
		setResizable(false);
		setTitle("Lista de Alunos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 715, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
					CadastroAlunos al = new CadastroAlunos(codigo, linhaSelecionada, modelo);
					al.setVisible(true);
					
				} else {
					JOptionPane.showMessageDialog(null, "É necessário selecionar um aluno para alterar!");
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
					AlunoDao dao = new AlunoDao();
					if (dao.removerAluno(codigo)){ 
						modelo.removeRow(linhaSelecionada);
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "É necessário selecionar um aluno para remover!");
				}
				
			}
		});
		btnExcluir.setBounds(184, 71, 76, 23);
		painelFundo.add(btnExcluir);

		TextField textField = new TextField();
		textField.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String pesquisa = txPesquisa.getText();
				AlunoDao dao = new AlunoDao();
				modelo.setNumRows(0);
				
				for (Aluno al : dao.listarAluno()) {
					modelo.addRow(new Object[]{al.getCodigo(),
											   al.getNome(),
											   al.getCpf(),
											   al.getMatricula(),
											   al.getTelefone(),
											   al.getEndereco(),
											   al.getEmail()});
				}
			}
		});
		textField.setBounds(266, 72, 433, 22);
		painelFundo.add(textField);
		
		criaTabela();
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 105, 689, 269);
		painelFundo.add(scrollPane);
		
				JLabel lblCadastroDeLivros = new JLabel("Lista de Alunos");
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
		modelo.addColumn("CPF");
		modelo.addColumn("Matrícula");
		modelo.addColumn("Email");
		modelo.addColumn("Endereço");
		carregarTabela();
	}

	private void carregarTabela() {
		AlunoDao dao =  new AlunoDao();
		
		for (Aluno al : dao.listarAluno()) {
			modelo.addRow(new Object[]{al.getCodigo(),
									   al.getNome(),
									   al.getCpf(),
									   al.getMatricula(),
									   al.getTelefone(),
									   al.getEndereco(),
									   al.getEmail()});
			
		}
		
	}
}
