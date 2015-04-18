package br.com.betha.controleacademico.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.betha.controleacademico.DAO.AlunoFundamentalDAO;
import br.com.betha.controleacademico.DAO.AlunoMedioDAO;
import br.com.betha.controleacademico.DAO.AlunoSuperiorDAO;
import br.com.betha.controleacademico.DAO.AlunoTecnicoDAO;
import br.com.betha.controleacademico.modelo.AlunoFundamental;
import br.com.betha.controleacademico.modelo.AlunoMedio;
import br.com.betha.controleacademico.modelo.AlunoSuperior;
import br.com.betha.controleacademico.modelo.AlunoTecnico;

public class ListaControles extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tabela;

	public ListaControles() {
		setResizable(false);
		setTitle("Lista de Controles");
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
		
		criaTabela();
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(0, 56, 709, 318);
		painelFundo.add(scrollPane);
		
				JLabel lblCadastroDeLivros = new JLabel("Lista dos Controles");
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
		modelo.addColumn("Período");
		modelo.addColumn("Venc. Matrícula");
		modelo.addColumn("Percentual Desc.");
		modelo.addColumn("Percentual Acresc.");
		carregarTabela();
	
	}

	private void carregarTabela() {
		
		AlunoFundamentalDAO daoFund =  new AlunoFundamentalDAO();
		for (AlunoFundamental fund : daoFund.listarAlunoFundamental()) {
			modelo.addRow(new Object[]{fund.getCodigo(),
									   fund.getPeriodo(),
									   fund.getVencMatricula(),
									   fund.getPercentDesc(),
									   fund.getPercentAcresc()});
			
		}
		
		AlunoMedioDAO daoMedio =  new AlunoMedioDAO();
		for (AlunoMedio al : daoMedio.listarAlunoMedio()) {
			modelo.addRow(new Object[]{al.getCodigo(),
									   al.getPeriodo(),
									   al.getVencMatricula(),
									   al.getPercentDesc(),
									   al.getPercentAcresc()});
			
		}
		
		AlunoTecnicoDAO daoTec =  new AlunoTecnicoDAO();
		for (AlunoTecnico tec : daoTec.listarAlunoTecnico()) {
			modelo.addRow(new Object[]{tec.getCodigo(),
									   tec.getPeriodo(),
									   tec.getVencMatricula(),
									   tec.getPercentDesc(),
									   tec.getPercentAcresc()});
			
		}
		
		AlunoSuperiorDAO daoSup =  new AlunoSuperiorDAO();
		for (AlunoSuperior sup : daoSup.listarAlunoSuperior()) {
			modelo.addRow(new Object[]{sup.getCodigo(),
									   sup.getPeriodo(),
									   sup.getVencMatricula(),
									   sup.getPercentDesc(),
									   sup.getPercentAcresc()});
		}
		
	}
}
