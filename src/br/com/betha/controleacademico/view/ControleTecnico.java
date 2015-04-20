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

import br.com.betha.controleacademico.DAO.AlunoTecnicoDAO;
import br.com.betha.controleacademico.modelo.AlunoTecnico;

public class ControleTecnico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txPeriodo;
	private JTextField txVencimentoMat;
	private JTextField txPercDesc;
	private JTextField txPercAcre;
	private JTextField txObs;
	private JTextField txCodigo;

	public ControleTecnico() {
		setResizable(false);
		setTitle("Controle Ensino Técnico");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 418, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setLocationRelativeTo(null);

		JPanel painelFundo = new JPanel();
		painelFundo.setBackground(Color.WHITE);
		painelFundo.setForeground(Color.BLACK);
		painelFundo.setBounds(0, 0, 414, 283);
		contentPane.add(painelFundo);
		painelFundo.setLayout(null);

		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(new Color(255, 255, 153));
		panelInferior.setBounds(0, 237, 414, 46);
		painelFundo.add(panelInferior);
		panelInferior.setLayout(null);
		
				JButton btnSalvar = new JButton("Salvar");
				btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 13));
				btnSalvar.setBounds(143, 11, 79, 30);
				panelInferior.add(btnSalvar);
				
						JButton btnLimpar = new JButton("Limpar");
						btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 13));
						btnLimpar.setBounds(319, 11, 85, 30);
						panelInferior.add(btnLimpar);
						
						JButton btnExcluir = new JButton("Excluir");
						btnExcluir.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent arg0) {
								AlunoTecnicoDAO dao = new AlunoTecnicoDAO();
								
								if (!txCodigo.getText().equals("")) {
									int codigo = Integer.parseInt(txCodigo.getText());
									dao.deleteAlunoTecnico(codigo);
								} else {
									dao.SemDados();
								}
							}
						});
						btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 13));
						btnExcluir.setBounds(230, 11, 79, 30);
						panelInferior.add(btnExcluir);
						btnLimpar.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {

								txCodigo.setText("");
								txPeriodo.setText("");
								txVencimentoMat.setText("");
								txPercDesc.setText("");
								txPercAcre.setText("");
								txObs.setText("");

							}
						});
				
						btnSalvar.addActionListener(new ActionListener() {
				
							public void actionPerformed(ActionEvent arg0) {
								
								AlunoTecnico tec = new AlunoTecnico();   
								
								tec.setPeriodo(txPeriodo.getText());
								tec.setVencMatricula(txVencimentoMat.getText());
								tec.setPercentDesc(Double.parseDouble(txPercDesc.getText()));
								tec.setPercentAcresc(Double.parseDouble(txPercAcre.getText()));
								tec.setObservacao(txObs.getText());
								
								AlunoTecnicoDAO dao = new AlunoTecnicoDAO();
								
								if (!txCodigo.getText().equals("")) {
									tec.setCodigo(Integer.parseInt(txCodigo.getText()));
									dao.editarAlunoTecnico(tec);
								} else {
									dao.inserirAlunoTecnico(tec);
								}
								dispose();
							}
							
						});

		JLabel lblPeriodo = new JLabel("Per\u00EDodo:");
		lblPeriodo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPeriodo.setBounds(10, 93, 137, 14);
		painelFundo.add(lblPeriodo);

		txPeriodo = new JTextField();
		txPeriodo.setBounds(10, 107, 160, 20);
		painelFundo.add(txPeriodo);
		txPeriodo.setColumns(10);

		JLabel lblVencimentoMat = new JLabel("Venc. Matr\u00EDcula");
		lblVencimentoMat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVencimentoMat.setBounds(254, 93, 107, 14);
		painelFundo.add(lblVencimentoMat);

		txVencimentoMat = new JTextField();
		txVencimentoMat.setBounds(254, 106, 137, 20);
		painelFundo.add(txVencimentoMat);
		txVencimentoMat.setColumns(10);

		JLabel lblPercDesc = new JLabel("Acr\u00E9scimo:");
		lblPercDesc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPercDesc.setBounds(10, 137, 107, 14);
		painelFundo.add(lblPercDesc);

		txPercDesc = new JTextField();
		txPercDesc.setBounds(10, 152, 137, 20);
		painelFundo.add(txPercDesc);
		txPercDesc.setColumns(10);
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(255, 255, 153));
				panel.setBounds(0, 0, 414, 37);
				painelFundo.add(panel);
				
						JLabel lblEnsinoTecnico = new JLabel("Controle Ensino T\u00E9cnico");
						lblEnsinoTecnico.setHorizontalAlignment(SwingConstants.TRAILING);
						panel.add(lblEnsinoTecnico);
						lblEnsinoTecnico.setVerticalAlignment(SwingConstants.TOP);
						lblEnsinoTecnico.setFont(new Font("Tahoma", Font.BOLD, 16));
						lblEnsinoTecnico.setForeground(new Color(0, 0, 0));
				
				JLabel lblPercAcre = new JLabel("Desconto:");
				lblPercAcre.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblPercAcre.setBounds(254, 137, 107, 14);
				painelFundo.add(lblPercAcre);
				
				txPercAcre = new JTextField();
				txPercAcre.setColumns(10);
				txPercAcre.setBounds(254, 152, 137, 20);
				painelFundo.add(txPercAcre);
				
				JLabel lblObs = new JLabel("Observa\u00E7\u00E3o:");
				lblObs.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblObs.setBounds(10, 183, 107, 14);
				painelFundo.add(lblObs);
				
				txObs = new JTextField();
				txObs.setColumns(10);
				txObs.setBounds(10, 198, 381, 28);
				painelFundo.add(txObs);
				
				JLabel lblCodigo = new JLabel("C\u00F3digo:");
				lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblCodigo.setBounds(10, 49, 107, 14);
				painelFundo.add(lblCodigo);
				
				txCodigo = new JTextField();
				txCodigo.setColumns(10);
				txCodigo.setBounds(10, 62, 137, 20);
				painelFundo.add(txCodigo);
	}
}