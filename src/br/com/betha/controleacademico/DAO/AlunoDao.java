package br.com.betha.controleacademico.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.betha.controleacademico.modelo.Aluno;

public class AlunoDao {
	
	private static final String INSERT = "insert into Aluno (codigo, nome, cpf, matricula, telefone, email, endereco) values (SEQ_ALUNO.nextval, ?, ?, ?, ?, ?, ?)";
	private static final String DELETE = "delete from aluno where codigo = ?";
	private static final String UPDATE = "update aluno set nome = ?, cpf = ?, matricula = ?, telefone = ?, email = ?, endereco = ? where codigo = ?";
	private static final String LIST = "select * from aluno";
	private static final String LIST_ID = "select * from aluno where codigo = ?";
	
	public boolean inserirALuno(Aluno aluno) {
		Connection con = null;

		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(INSERT);
				
			pstm.setString(1, aluno.getNome());
			pstm.setInt(2, aluno.getCpf());
			pstm.setInt(3, aluno.getMatricula());
			pstm.setString(4, aluno.getTelefone());
			pstm.setString(5, aluno.getEmail());
			pstm.setString(6, aluno.getEndereco());
			pstm.execute();
			
			JOptionPane.showMessageDialog(null,"Aluno inserido com sucesso!");
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Não foi possível realizar a inserção!");
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
	
	public boolean removerAluno(int codigo) {
		Connection con = null;

		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(DELETE);
			pstm.setInt(1, codigo);
			pstm.execute();
			
			JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!");
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
	
	public boolean editarAluno(Aluno aluno) {
		Connection con = null;

		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(UPDATE);
			
			pstm.setString(1, aluno.getNome());
			pstm.setInt(2, aluno.getCpf());
			pstm.setInt(3, aluno.getMatricula());
			pstm.setString(4, aluno.getTelefone());
			pstm.setString(5, aluno.getEmail());
			pstm.setString(6, aluno.getEndereco());
			pstm.setString(7, aluno.getNivelEnsino());
			pstm.setInt(8, aluno.getCodigo());
			pstm.execute();
			
			JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso!");
			return true;
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível realizar a alteração!");
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
	
	public List<Aluno> listarAluno() {

		Connection con = null;
		List<Aluno> alunos = new ArrayList<>();

		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(LIST);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				Aluno al = new Aluno();
				al.setCodigo(rs.getInt("codigo"));
				al.setNome(rs.getString("nome"));
				al.setCpf(rs.getInt("cpf"));
				al.setEndereco(rs.getString("matricula"));
				al.setEndereco(rs.getString("telefone"));
				al.setEmail(rs.getString("email"));
				al.setTelefone(rs.getString("endereco"));
				alunos.add(al);
			}
			return alunos;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível listar os alunos!");
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

	public Aluno listarCodigo(int codigo) {
		Connection con = null;
		Aluno al = new Aluno();

		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(LIST_ID);
			pstm.setInt(1, codigo);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				al.setCodigo(rs.getInt("codigo"));
				al.setNome(rs.getString("nome"));
				al.setCpf(rs.getInt("cpf"));
				al.setEndereco(rs.getString("matricula"));
				al.setEndereco(rs.getString("telefone"));
				al.setEmail(rs.getString("email"));
				al.setTelefone(rs.getString("endereco"));
				
			}
			return al;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível encontrar a aluno!");
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
	
}
