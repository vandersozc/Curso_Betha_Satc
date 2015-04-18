package br.com.betha.controleacademico.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.betha.controleacademico.modelo.AlunoMedio;

public class AlunoMedioDAO {
	
	private static final String INSERT = "insert into ensino_medio (codigo, periodo, venc_matricula, percent_desc, percent_acresc, observacao) values (SEQ_ALUNO_MEDIO.nextval, ?, ?, ?, ?, ?)";
	private static final String DELETE = "delete from ensino_medio where codigo = ?";
	private static final String UPDATE = "update ensino_medio set periodo = ?, venc_matricula = ?, percent_desc = ?, percent_acresc = ?, observacao = ? where codigo = ?";
	
	
	public boolean inserirAlunoMedio(AlunoMedio medio){
		Connection con = null;
		
		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(INSERT);
			
			pstm.setString(1, medio.getPeriodo());
			pstm.setString(2, medio.getVencMatricula());
			pstm.setDouble(3, medio.getPercentDesc());
			pstm.setDouble(4, medio.getPercentAcresc());
			pstm.setString(5, medio.getObservacao());
			pstm.execute();
			
			JOptionPane.showMessageDialog(null,"Controle inserido com sucesso!");
			return true;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel realizar a inser��o!");
			System.out.println(e.getMessage());
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println("Erro ao fechar a conex�o");
			}
		}
		return false;
	}
	
	
	public boolean deleteAlunoMedio(int codigo){
		Connection con = null;
		
		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(DELETE);
			pstm.setInt(1, codigo);
			pstm.execute();
			
			JOptionPane.showMessageDialog(null, "Controle removido com sucesso!");
			return true;
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel realizar a exclus�o!");
			System.out.println(e.getMessage());
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println("Erro ao fechar a conex�o");
			}
		}
		return false;
	}
	
	
	public boolean editarAlunoMedio(AlunoMedio medio) {
		Connection con = null;
		
		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(UPDATE);
			
			pstm.setString(1, medio.getPeriodo());
			pstm.setString(2, medio.getVencMatricula());
			pstm.setDouble(3, medio.getPercentDesc());
			pstm.setDouble(4, medio.getPercentAcresc());
			pstm.setString(5, medio.getObservacao());
			pstm.setInt(6, medio.getCodigo());
			pstm.execute();
			
			JOptionPane.showMessageDialog(null, "Controle alterado com sucesso!");
			return true;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel realizar a atualiza��o!");
			System.out.println(e.getMessage());
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println("Erro ao fechar a conex�o");
			}
		}
		return false;
	}
	
	public void SemDados(){	
		JOptionPane.showMessageDialog(null, "Nenhum registro selecionado!");
	}
	
}
