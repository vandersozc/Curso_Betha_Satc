package br.com.betha.controleacademico.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.betha.controleacademico.modelo.AlunoTecnico;

public class AlunoTecnicoDAO {
	
	private static final String INSERT = "insert into ensino_tecnico (codigo, periodo, venc_matricula, percent_desc, percent_acresc, observacao) values (SEQ_ALUNO_TECNICO.nextval, ?, ?, ?, ?, ?)";
	private static final String DELETE = "delete from ensino_tecnico where codigo = ?";
	private static final String UPDATE = "update ensino_tecnico set periodo = ?, venc_matricula = ?, percent_desc = ?, percent_acresc = ?, observacao = ? where codigo = ?";
	private static final String SELECT = "select * from ensino_tecnico";
	
	public boolean inserirAlunoTecnico(AlunoTecnico tecnico) {
		Connection con = null;
		
		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(INSERT);
			
			pstm.setString(1, tecnico.getPeriodo());
			pstm.setString(2, tecnico.getVencMatricula());
			pstm.setDouble(3, tecnico.getPercentDesc());
			pstm.setDouble(4, tecnico.getPercentAcresc());
			pstm.setString(5, tecnico.getObservacao());
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
	
	
	public boolean deleteAlunoTecnico(int codigo) {
		Connection con = null;
		
		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(DELETE);
			pstm.setInt(1, codigo);
			pstm.execute();
			
			JOptionPane.showMessageDialog(null, "Controle removido com sucesso!");
			return true;

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
	
	
	public boolean editarAlunoTecnico(AlunoTecnico tecnico) {
		Connection con = null;
		
		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(UPDATE);
			
			pstm.setString(1, tecnico.getPeriodo());
			pstm.setString(2, tecnico.getVencMatricula());
			pstm.setDouble(3, tecnico.getPercentDesc());
			pstm.setDouble(4, tecnico.getPercentAcresc());
			pstm.setString(5, tecnico.getObservacao());
			pstm.setInt(6, tecnico.getCodigo());
			pstm.execute();
			
			JOptionPane.showMessageDialog(null, "Controle alterado com sucesso!");
			return true;
			
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
	
	
	public List<AlunoTecnico> listarAlunoTecnico() {

		Connection con = null;
		List<AlunoTecnico> tecnico = new ArrayList<>();

		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(SELECT);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				AlunoTecnico tec = new AlunoTecnico();
				
				tec.setCodigo(rs.getInt("codigo"));
				tec.setPeriodo(rs.getString("periodo"));
				tec.setVencMatricula(rs.getString("venc_matricula"));
				tec.setPercentDesc(Double.parseDouble(rs.getString("percent_desc")));
				tec.setPercentAcresc(Double.parseDouble(rs.getString("percent_acresc")));
				tecnico.add(tec);
			}
			return tecnico;
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
