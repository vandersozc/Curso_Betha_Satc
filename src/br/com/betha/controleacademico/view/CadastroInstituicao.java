package br.com.betha.controleacademico.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
	private JTextField txCnpj;
	private JTextField txTelefone;
	private JTextField txComplemento;
	private DefaultTableModel modelo = new DefaultTableModel();
	private int linhaSelecionada;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CadastroInstituicao frame = new CadastroInstituicao();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public CadastroInstituicao() {
		setTitle("Cadastro de Instituições de Ensino");
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

		JLabel lblCdigo = new JLabel("C\u00F3digo: ");
		lblCdigo.setBounds(10, 32, 46, 14);
		painelFundo.add(lblCdigo);

		txCodigo = new JTextField();
		txCodigo.setBounds(10, 47, 94, 20);
		painelFundo.add(txCodigo);
		txCodigo.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome da Institui\u00E7\u00E3o: ");
		lblNewLabel.setBounds(10, 78, 147, 14);
		painelFundo.add(lblNewLabel);

		txNome = new JTextField();
		txNome.setBounds(10, 92, 451, 20);
		painelFundo.add(txNome);
		txNome.setColumns(10);

		JLabel lblAutor = new JLabel("Endere\u00E7o:");
		lblAutor.setBounds(10, 123, 107, 14);
		painelFundo.add(lblAutor);

		txEndereco = new JTextField();
		txEndereco.setBounds(10, 138, 312, 20);
		painelFundo.add(txEndereco);
		txEndereco.setColumns(10);

		JLabel lblEdio = new JLabel("CNPJ:");
		lblEdio.setBounds(10, 169, 107, 14);
		painelFundo.add(lblEdio);

		txCnpj = new JTextField();
		txCnpj.setBounds(10, 182, 147, 20);
		painelFundo.add(txCnpj);
		txCnpj.setColumns(10);

		JLabel lblEditora = new JLabel("Telefone: ");
		lblEditora.setBounds(10, 213, 107, 14);
		painelFundo.add(lblEditora);

		txTelefone = new JTextField();
		txTelefone.setBounds(10, 226, 147, 20);
		painelFundo.add(txTelefone);
		txTelefone.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(10, 257, 107, 14);
		painelFundo.add(lblComplemento);

		txComplemento = new JTextField();
		txComplemento.setBounds(10, 273, 451, 20);
		painelFundo.add(txComplemento);
		txComplemento.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");

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
		btnSalvar.setBounds(487, 87, 94, 30);
		painelFundo.add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
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
		btnLimpar.setBounds(487, 123, 94, 30);
		painelFundo.add(btnLimpar);
		
				JLabel lblCadastroDeLivros = new JLabel("Cadastro de Institui\u00E7\u00E3o");
				lblCadastroDeLivros.setVerticalAlignment(SwingConstants.TOP);
				lblCadastroDeLivros.setBounds(199, 11, 196, 20);
				painelFundo.add(lblCadastroDeLivros);
				lblCadastroDeLivros.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblCadastroDeLivros.setForeground(new Color(0, 0, 0));
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
