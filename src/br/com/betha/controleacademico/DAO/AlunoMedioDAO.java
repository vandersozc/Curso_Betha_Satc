package br.com.betha.controleacademico.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.betha.controleacademico.modelo.AlunoMedio;

public class AlunoMedioDAO {
	
	private static final String INSERT = "insert into ensino_medio (codigo, periodo, venc_matricula, percent_desc, percent_acresc, observacao) values (SEQ_ALUNO_MEDIO.nextval, ?, ?, ?, ?, ?)";
	private static final String DELETE = "delete from ensino_medio where codigo = ?";
	private static final String UPDATE = "update ensino_medio set periodo = ?, venc_matricula = ?, percent_desc = ?, percent_acresc = ?, observacao = ? where codigo = ?";
	private static final String SELECT = "select * from ensino_medio";
	
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
			JOptionPane.showMessageDialog(null, "Não foi possível realizar a inserção!");
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
	
	public List<AlunoMedio> listarAlunoMedio() {

		Connection con = null;
		List<AlunoMedio> medio = new ArrayList<>();

		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(SELECT);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				AlunoMedio al = new AlunoMedio();
				
				al.setCodigo(rs.getInt("codigo"));
				al.setPeriodo(rs.getString("periodo"));
				al.setVencMatricula(rs.getString("venc_matricula"));
				al.setPercentDesc(Double.parseDouble(rs.getString("percent_desc")));
				al.setPercentAcresc(Double.parseDouble(rs.getString("percent_acresc")));
				medio.add(al);
			}
			return medio;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível listar os controles!");
			System.out.println(e.getMessage());
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println("Erro ao fechar a conexão");
			}
		}
		return null;
	}
	
	
	public void SemDados(){	
		JOptionPane.showMessageDialog(null, "Nenhum registro selecionado!");
	}
	
}
