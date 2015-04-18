package br.com.betha.controleacademico.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.betha.controleacademico.modelo.AlunoSuperior;

public class AlunoSuperiorDAO {
	
	private static final String INSERT = "insert into ensino_superior (codigo, periodo, venc_matricula, percent_desc, percent_acresc, observacao) values (SEQ_ALUNO_SUPERIOR.nextval, ?, ?, ?, ?, ?)";
	private static final String DELETE = "delete from ensino_superior where codigo = ?";
	private static final String UPDATE = "update ensino_superior set periodo = ?, venc_matricula = ?, percent_desc = ?, percent_acresc = ?, observacao = ? where codigo = ?";
	private static final String SELECT = "select * from ensino_superior";
	
	public boolean inserirAlunoSuperior(AlunoSuperior superior) {
		Connection con = null;
		
		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(INSERT);
			
			pstm.setString(1, superior.getPeriodo());
			pstm.setString(2, superior.getVencMatricula());
			pstm.setDouble(3, superior.getPercentDesc());
			pstm.setDouble(4, superior.getPercentAcresc());
			pstm.setString(5, superior.getObservacao());
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
	
	
	public boolean deleteAlunoSuperior(int codigo) {
		Connection con = null;
		
		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(DELETE);
			pstm.setInt(1, codigo);
			pstm.execute();
			
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
	
	
	public boolean editarAlunoSuperior(AlunoSuperior superior) {	
		Connection con = null;
		
		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(UPDATE);
			
			pstm.setString(1, superior.getPeriodo());
			pstm.setString(2, superior.getVencMatricula());
			pstm.setDouble(3, superior.getPercentDesc());
			pstm.setDouble(4, superior.getPercentAcresc());
			pstm.setString(5, superior.getObservacao());
			pstm.setInt(6, superior.getCodigo());
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
	
	public List<AlunoSuperior> listarAlunoSuperior() {

		Connection con = null;
		List<AlunoSuperior> superior = new ArrayList<>();

		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(SELECT);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				AlunoSuperior sup = new AlunoSuperior();
				
				sup.setCodigo(rs.getInt("codigo"));
				sup.setPeriodo(rs.getString("periodo"));
				sup.setVencMatricula(rs.getString("venc_matricula"));
				sup.setPercentDesc(Double.parseDouble(rs.getString("percent_desc")));
				sup.setPercentAcresc(Double.parseDouble(rs.getString("percent_acresc")));
				superior.add(sup);
			}
			return superior;
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
