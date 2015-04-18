package br.com.betha.controleacademico.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.betha.controleacademico.modelo.AlunoTecnico;

public class AlunoTecnicoDAO {
	
	private static final String INSERT = "insert into ensino_tecnico (codigo, periodo, vencMatricula, percentDesc, percentAcresc, Observacao) values (SEQ_ALUNO_TECNICO.nextval, ?, ?, ?, ?, ?)";
	private static final String DELETE = "delete from ensino_tecnico where codigo = ?";
	private static final String UPDATE = "update ensino_tecnico set periodo = ?, vencMatricula = ?, percentDesc = ?, percentAcresc = ?, Observacao = ? where codigo = ?";

	public boolean inserirAlunoTecnico(AlunoTecnico tecnico) {
		
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
	
	
	public boolean deleteAlunoTecnico(AlunoTecnico tecnico) {
		
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
	
	
	
	public boolean atualizaAlunoTecnico(AlunoTecnico tecnico) {
		
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
