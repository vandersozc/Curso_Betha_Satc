package br.com.betha.controleacademico.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.betha.controleacademico.DAO.AlunoDao;
import br.com.betha.controleacademico.modelo.Aluno;

public class CadastroAlunos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txCodigo;
	private JTextField txNome;
	private JTextField txMatricula;
	private JTextField txCpf;
	private JTextField txTelefone;
	private JTextField txEmail;
	private DefaultTableModel modelo = new DefaultTableModel();
	private int linhaSelecionada;
	private JTextField txEndereco;

	public CadastroAlunos() {
		setResizable(false);
		setTitle("Cadastro de Alunos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 630, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel painelFundo = new JPanel();
		painelFundo.setBackground(Color.WHITE);
		painelFundo.setForeground(Color.BLACK);
		painelFundo.setBounds(0, 0, 624, 387);
		contentPane.add(painelFundo);
		painelFundo.setLayout(null);

		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(new Color(176, 224, 230));
		panelInferior.setBounds(0, 332, 624, 66);
		painelFundo.add(panelInferior);
		panelInferior.setLayout(null);
		
				JButton btnSalvar = new JButton("Salvar");
				btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 13));
				btnSalvar.setBounds(403, 11, 79, 30);
				panelInferior.add(btnSalvar);
				
						JButton btnLimpar = new JButton("Limpar");
						btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 13));
						btnLimpar.setBounds(501, 11, 85, 30);
						panelInferior.add(btnLimpar);
						btnLimpar.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {

								txCodigo.setText("");
								txNome.setText("");
								txMatricula.setText("");
								txCpf.setText("");
								txTelefone.setText("");
								txEmail.setText("");
								txEndereco.setText("");

							}
						});
				
						btnSalvar.addActionListener(new ActionListener() {
				
							public void actionPerformed(ActionEvent arg0) {
								
								Aluno al = new Aluno();
								al.setNome(txNome.getText());
								al.setCpf(Integer.parseInt(txCpf.getText()));
								al.setMatricula(Integer.parseInt(txMatricula.getText()));
								al.setTelefone(txTelefone.getText());
								al.setEmail(txEmail.getText());
								al.setEndereco(txEndereco.getText());
								
								AlunoDao dao = new AlunoDao();
								
								if (!txCodigo.getText().equals("")) {
									al.setCodigo(Integer.parseInt(txCodigo.getText()));
									if (dao.editarAluno(al)) {
										modelo.removeRow(linhaSelecionada);
										modelo.addRow(new Object[] { al.getCodigo(),
												                     al.getNome(),
												                     al.getCpf(),
												                     al.getMatricula(),
												                     al.getEmail(),
												                     al.getTelefone()});
									}
								} else {
									dao.inserirALuno(al);
									ListaAluno lista = new ListaAluno();
									lista.setVisible(true);
								}
								dispose();
							}
							
						});

		JLabel lblCdigo = new JLabel("C\u00F3digo: ");
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCdigo.setBounds(10, 58, 94, 14);
		painelFundo.add(lblCdigo);

		txCodigo = new JTextField();
		txCodigo.setBounds(10, 77, 94, 20);
		painelFundo.add(txCodigo);
		txCodigo.setColumns(10);

		JLabel lblNome = new JLabel("Nome do Aluno: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(10, 108, 147, 14);
		painelFundo.add(lblNome);

		txNome = new JTextField();
		txNome.setBounds(10, 122, 572, 20);
		painelFundo.add(txNome);
		txNome.setColumns(10);

		JLabel lblMatricula = new JLabel("Matr\u00EDcula:");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMatricula.setBounds(10, 153, 107, 14);
		painelFundo.add(lblMatricula);

		txMatricula = new JTextField();
		txMatricula.setBounds(10, 168, 112, 20);
		painelFundo.add(txMatricula);
		txMatricula.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpf.setBounds(288, 155, 107, 14);
		painelFundo.add(lblCpf);

		txCpf = new JTextField();
		txCpf.setBounds(288, 168, 147, 20);
		painelFundo.add(txCpf);
		txCpf.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefone.setBounds(445, 153, 107, 14);
		painelFundo.add(lblTelefone);

		txTelefone = new JTextField();
		txTelefone.setBounds(445, 168, 137, 20);
		painelFundo.add(txTelefone);
		txTelefone.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(10, 245, 107, 14);
		painelFundo.add(lblEmail);

		txEmail = new JTextField();
		txEmail.setBounds(10, 270, 572, 20);
		painelFundo.add(txEmail);
		txEmail.setColumns(10);
		
				JLabel lblCadastroDeLivros = new JLabel("Cadastro de Alunos");
				lblCadastroDeLivros.setVerticalAlignment(SwingConstants.TOP);
				lblCadastroDeLivros.setBounds(214, 11, 168, 20);
				painelFundo.add(lblCadastroDeLivros);
				lblCadastroDeLivros.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblCadastroDeLivros.setForeground(new Color(0, 0, 0));
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(176, 224, 230));
				panel.setBounds(0, 0, 624, 55);
				painelFundo.add(panel);
				
				JLabel lblEndereco = new JLabel("Endere\u00E7o:");
				lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblEndereco.setBounds(10, 199, 107, 14);
				painelFundo.add(lblEndereco);
				
				txEndereco = new JTextField();
				txEndereco.setColumns(10);
				txEndereco.setBounds(10, 214, 572, 20);
				painelFundo.add(txEndereco);
				
				JComboBox cbbNivel = new JComboBox();
				cbbNivel.setFont(new Font("Tahoma", Font.PLAIN, 11));
				cbbNivel.setModel(new DefaultComboBoxModel(new String[] {"Ensino M\u00E9dio", "Ensino Fundamental", "Ensino T\u00E9cnico", "Ensino Superior"}));
				cbbNivel.setBounds(132, 168, 146, 20);
				painelFundo.add(cbbNivel);
				
				JLabel lblNivel = new JLabel("N\u00EDvel:");
				lblNivel.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNivel.setBounds(134, 153, 119, 14);
				painelFundo.add(lblNivel);
	}
	
	
	public CadastroAlunos(int codigo, int linhaSelecionada, DefaultTableModel modelo){
		
		this();
		this.modelo = modelo;
		this.linhaSelecionada = linhaSelecionada;
		
		AlunoDao dao = new AlunoDao();
		Aluno al = dao.listarCodigo(codigo);
		
		txCodigo.setText(String.valueOf(al.getCodigo()));
		txNome.setText(al.getNome());
		txCpf.setText(String.valueOf(al.getCpf()));
		txMatricula.setText(String.valueOf(al.getMatricula()));
		txTelefone.setText(al.getTelefone());
		txEmail.setText(al.getEmail());
		txEndereco.setText(al.getEndereco());

	}
}
