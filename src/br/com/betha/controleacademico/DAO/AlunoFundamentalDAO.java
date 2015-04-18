package br.com.betha.controleacademico.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.betha.controleacademico.modelo.AlunoFundamental;

public class AlunoFundamentalDAO {
	
	
	private static final String INSERT = "insert into ensino_fundamental (codigo, periodo, venc_matricula, percent_desc, percent_acresc, observacao) values (SEQ_ALUNO_FUNDAMENTAL.nextval, ?, ?, ?, ?, ?)";
	private static final String DELETE = "delete from ensino_fundamental where codigo = ?";
	private static final String UPDATE = "update ensino_fundamental set periodo = ?, venc_matricula = ?, percent_desc = ?, percent_acresc = ?, observacao = ? where codigo = ?";

	
	public boolean inserirAlunoFundamental(AlunoFundamental fundamental){
		Connection con = null;
		
		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(INSERT);
			
			pstm.setString(1, fundamental.getPeriodo());
			pstm.setString(2, fundamental.getVencMatricula());
			pstm.setDouble(3, fundamental.getPercentDesc());
			pstm.setDouble(4, fundamental.getPercentAcresc());
			pstm.setString(5, fundamental.getObservacao());
			pstm.execute();
			
			JOptionPane.showMessageDialog(null,"Controle inserido com sucesso!");
			return true;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível realizar a inserção");
			System.out.println(e.getMessage());
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println("Erro ao fechar a conexão");
			}
		}
		return false;
	}
	
	
	public boolean deleteAlunoFundamental(int codigo){		
		Connection con = null;
		
		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(DELETE);
			pstm.setInt(1, codigo);
			pstm.execute();
			
			JOptionPane.showMessageDialog(null, "Controle removido com sucesso!");
			return true;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível realizar a exclusão!");
			System.out.println(e.getMessage());
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println("Erro ao fechar a conexão");
			}
		}
		return false;
	}
	
	
	public boolean editarAlunoFundamental(AlunoFundamental fundamental) {
		
		Connection con = null;
		
		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(UPDATE);
			
			pstm.setString(1, fundamental.getPeriodo());
			pstm.setString(2, fundamental.getVencMatricula());
			pstm.setDouble(3, fundamental.getPercentDesc());
			pstm.setDouble(4, fundamental.getPercentAcresc());
			pstm.setString(5, fundamental.getObservacao());
			pstm.setInt(6, fundamental.getCodigo());
			pstm.execute();
			
			JOptionPane.showMessageDialog(null, "Controle alterado com sucesso!");
			return true;
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível realizar a atualização!");
			System.out.println(e.getMessage());
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println("Erro ao fechar a conexão");
			}
		}
		return false;
	}
	
	public void SemDados(){	
		JOptionPane.showMessageDialog(null, "Nenhum registro selecionado!");
	}

}
