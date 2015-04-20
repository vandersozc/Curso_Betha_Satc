package br.com.betha.controleacademico.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.betha.controleacademico.DAO.InstituicaoDao;
import br.com.betha.controleacademico.modelo.Instituicao;

public class CadastroInstituicao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txCodigo;
	private JTextField txNome;
	private JTextField txEndereco;
	private JTextField txComplemento;
	private DefaultTableModel modelo = new DefaultTableModel();
	private int linhaSelecionada;
	private JTextField txCnpj;
	private JTextField txTelefone;

	 
	public CadastroInstituicao() {
		setResizable(false);
		setTitle("Cadastro de Instituições de Ensino");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 627, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setLocationRelativeTo(null);

		JPanel painelFundo = new JPanel();
		painelFundo.setBackground(Color.WHITE);
		painelFundo.setForeground(Color.BLACK);
		painelFundo.setBounds(0, 0, 621, 387);
		contentPane.add(painelFundo);
		painelFundo.setLayout(null);

		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(new Color(176, 224, 230));
		panelInferior.setBounds(0, 332, 621, 55);
		painelFundo.add(panelInferior);
				panelInferior.setLayout(null);
		
				JButton btnSalvar = new JButton("Salvar");
				btnSalvar.setBounds(399, 11, 83, 25);
				panelInferior.add(btnSalvar);
				btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 13));
				
						JButton btnLimpar = new JButton("Limpar");
						btnLimpar.setBounds(492, 11, 83, 25);
						panelInferior.add(btnLimpar);
						btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 13));
						btnLimpar.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {

								txCodigo.setText("");
								txNome.setText("");
								txEndereco.setText("");
								txCnpj.setText("");
								txTelefone.setText("");
								txComplemento.setText("");

							}
						});
				
						btnSalvar.addActionListener(new ActionListener() {
				
							public void actionPerformed(ActionEvent arg0) {
								
								Instituicao inst = new Instituicao();
								inst.setNome(txNome.getText());
								inst.setEndereco(txEndereco.getText());
								inst.setCnpj(txCnpj.getText());
								inst.setTelefone(txTelefone.getText());
								inst.setComplemento(txComplemento.getText());
								
								InstituicaoDao dao = new InstituicaoDao();
								
								if (!txCodigo.getText().equals("")) {
									inst.setCodigo(Integer.parseInt(txCodigo.getText()));
									if (dao.editarInstituicao(inst)) {
										modelo.removeRow(linhaSelecionada);
										modelo.addRow(new Object[] { inst.getCodigo(),
												                     inst.getNome(),
												                     inst.getEndereco(),
												                     inst.getCnpj(),
												                     inst.getTelefone()});
									}
								} else {
									dao.inserirInstituicao(inst);
									ListaInstituicao lista = new ListaInstituicao();
									lista.setVisible(true);
								}
								dispose();
							}
							
						});

		JLabel lblCdigo = new JLabel("C\u00F3digo: ");
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCdigo.setBounds(10, 84, 94, 14);
		painelFundo.add(lblCdigo);

		txCodigo = new JTextField();
		txCodigo.setBounds(10, 99, 94, 20);
		painelFundo.add(txCodigo);
		txCodigo.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome da Institui\u00E7\u00E3o: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 130, 147, 14);
		painelFundo.add(lblNewLabel);

		txNome = new JTextField();
		txNome.setBounds(10, 144, 569, 20);
		painelFundo.add(txNome);
		txNome.setColumns(10);

		JLabel lblAutor = new JLabel("Endere\u00E7o:");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAutor.setBounds(10, 175, 107, 14);
		painelFundo.add(lblAutor);

		txEndereco = new JTextField();
		txEndereco.setBounds(10, 190, 465, 20);
		painelFundo.add(txEndereco);
		txEndereco.setColumns(10);

		JLabel lblEdio = new JLabel("CNPJ:");
		lblEdio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEdio.setBounds(10, 221, 107, 14);
		painelFundo.add(lblEdio);

		JLabel lblEditora = new JLabel("Telefone: ");
		lblEditora.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEditora.setBounds(175, 221, 107, 14);
		painelFundo.add(lblEditora);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblComplemento.setBounds(10, 265, 107, 14);
		painelFundo.add(lblComplemento);

		txComplemento = new JTextField();
		txComplemento.setBounds(10, 281, 569, 40);
		painelFundo.add(txComplemento);
		txComplemento.setColumns(10);
		
				JLabel lblCadastroDeLivros = new JLabel("Cadastro de Institui\u00E7\u00E3o");
				lblCadastroDeLivros.setVerticalAlignment(SwingConstants.TOP);
				lblCadastroDeLivros.setBounds(208, 11, 196, 20);
				painelFundo.add(lblCadastroDeLivros);
				lblCadastroDeLivros.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblCadastroDeLivros.setForeground(new Color(0, 0, 0));
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(176, 224, 230));
				panel.setBounds(0, 0, 621, 55);
				painelFundo.add(panel);
				
				txCnpj = new JTextField();
				txCnpj.setBounds(10, 234, 107, 20);
				painelFundo.add(txCnpj);
				txCnpj.setColumns(10);
				
				txTelefone = new JTextField();
				txTelefone.setBounds(175, 234, 107, 20);
				painelFundo.add(txTelefone);
				txTelefone.setColumns(10);

	}
	
	public CadastroInstituicao(int codigo, int linhaSelecionada, DefaultTableModel modelo){
		
		this();
		this.modelo = modelo;
		this.linhaSelecionada = linhaSelecionada;
		
		InstituicaoDao dao = new InstituicaoDao();
		Instituicao inst = dao.listarCodigo(codigo);
		
		txCodigo.setText(String.valueOf(inst.getCodigo()));
		txNome.setText(inst.getNome());
		txEndereco.setText(inst.getEndereco());
		txCnpj.setText(inst.getCnpj());
		txTelefone.setText(inst.getTelefone());
		txComplemento.setText(inst.getComplemento());

	}
}
