package br.com.betha.controleacademico.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.betha.controleacademico.modelo.AlunoMedio;

public class AlunoMedioDAO {
	
	
	private static final String INSERT = "insert into ensino_medio (codigo, periodo, vencMatricula, percentDesc, percentAcresc, Observacao) values (SEQ_ALUNO_MEDIO.nextval, ?, ?, ?, ?, ?)";
	private static final String DELETE = "delete from ensino_medio where codigo = ?";
	private static final String UPDATE = "update ensino_medio set periodo = ?, vencMatricula = ?, percentDesc = ?, percentAcresc = ?, Observacao = ? where codigo = ?";
	
	
	public boolean inserirAlunoMedio(AlunoMedio medio){

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
	
	
	public boolean deleteAlunoMedio(AlunoMedio medio){
		
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
	
	
	
	public boolean atualizaAlunoMedio(AlunoMedio medio) {
		
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
