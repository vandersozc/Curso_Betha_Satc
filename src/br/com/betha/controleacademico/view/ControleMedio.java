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

import br.com.betha.controleacademico.DAO.AlunoMedioDAO;
import br.com.betha.controleacademico.modelo.AlunoMedio;

public class ControleMedio extends JFrame {

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

	public ControleMedio() {
		setResizable(false);
		setTitle("Controle Ensino Médio");
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
		panelInferior.setBackground(new Color(204, 204, 255));
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
								AlunoMedioDAO dao = new AlunoMedioDAO();
								
								if (!txCodigo.getText().equals("")) {
									int codigo = Integer.parseInt(txCodigo.getText());
									dao.deleteAlunoMedio(codigo);
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
								
								AlunoMedio am = new AlunoMedio();   
								
								am.setPeriodo(txPeriodo.getText());
								am.setVencMatricula(txVencimentoMat.getText());
								am.setPercentDesc(Double.parseDouble(txPercDesc.getText()));
								am.setPercentAcresc(Double.parseDouble(txPercAcre.getText()));
								am.setObservacao(txObs.getText());
								
								AlunoMedioDAO dao = new AlunoMedioDAO();
								
								if (!txCodigo.getText().equals("")) {
									am.setCodigo(Integer.parseInt(txCodigo.getText()));
									dao.editarAlunoMedio(am);
								} else {
									dao.inserirAlunoMedio(am);
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
				panel.setBackground(new Color(204, 204, 255));
				panel.setBounds(0, 0, 414, 37);
				painelFundo.add(panel);
				
						JLabel lblEnsinoMedio = new JLabel("Controle Ensino M\u00E9dio");
						panel.add(lblEnsinoMedio);
						lblEnsinoMedio.setVerticalAlignment(SwingConstants.TOP);
						lblEnsinoMedio.setFont(new Font("Tahoma", Font.BOLD, 16));
						lblEnsinoMedio.setForeground(new Color(0, 0, 0));
				
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