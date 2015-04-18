package br.com.betha.controleacademico.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.betha.controleacademico.modelo.AlunoSuperior;

public class AlunoSuperiorDAO {
	
	private static final String INSERT = "insert into ensino_superior (codigo, periodo, vencMatricula, percentDesc, percentAcresc, Observacao) values (SEQ_ALUNO_SUPERIOR.nextval, ?, ?, ?, ?, ?)";
	private static final String DELETE = "delete from ensino_superior where codigo = ?";
	private static final String UPDATE = "update ensino_superior set periodo = ?, vencMatricula = ?, percentDesc = ?, percentAcresc = ?, Observacao = ? where codigo = ?";

	
	public boolean inserirAlunoSuperior(AlunoSuperior superior) {

		Connection con = null;
		
		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement("INSERT");
			
			

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
	
	
	public boolean deleteAlunoSuperior(AlunoSuperior superior) {
		
		Connection con = null;
		
		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement("DELETE");
			
			

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível realizar a exclusão");
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
	
	
	
	public boolean atualizaAlunoSuperior(AlunoSuperior superior) {
		
		Connection con = null;
		
		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement("UPDATE");
			
			

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível realizar a atualização");
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

}
