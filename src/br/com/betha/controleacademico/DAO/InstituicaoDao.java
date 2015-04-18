package br.com.betha.controleacademico.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import br.com.betha.controleacademico.modelo.Instituicao;

public class InstituicaoDao {
	
	private static final String INSERT = "INSERT INTO INSTITUICAO (CODIGO, NOME, ENDERECO, CNPJ, TELEFONE, COMPLEMENTO) VALUES (SEQ_INSTITUICAO.NEXTVAL, ?, ?, ?, ?, ?)";
	private static final String DELETE = "DELETE FROM INSTITUICAO WHERE CODIGO = ?";
	private static final String UPDATE = "UPDATE INSTITUICAO SET NOME = ?, ENDERECO = ?, CNPJ = ?, TELEFONE = ?, COMPLEMENTO = ? WHERE CODIGO = ?";
	private static final String SELECT = "SELECT * FROM INSTITUICAO";
	private static final String SELECT_ID = "SELECT * FROM INSTITUICAO WHERE CODIGO = ?";
	private static final String SELECT_NOME = "SELECT * FROM INSTITUICAO WHERE NOME = like '% ? %'";
	
	
	public boolean inserirInstituicao(Instituicao instituicao) {
		Connection con = null;

		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(INSERT);
				
			pstm.setString(1, instituicao.getNome());
			pstm.setString(2, instituicao.getEndereco());
			pstm.setString(3, instituicao.getCnpj());
			pstm.setString(4, instituicao.getTelefone());
			pstm.setString(5, instituicao.getComplemento());

			pstm.execute();
			
			JOptionPane.showMessageDialog(null,"Instituição inserida com sucesso");
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Não foi possível realizar a inserção");
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
	
	public boolean removerInstituicao(int codigo) {
		Connection con = null;

		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(DELETE);
			pstm.setInt(1, codigo);
			pstm.execute();
			
			JOptionPane.showMessageDialog(null, "Instituição removida com sucesso");
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
	
	public boolean editarInstituicao(Instituicao instituicao) {
		Connection con = null;

		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(UPDATE);
			
			pstm.setString(1, instituicao.getNome());
			pstm.setString(2, instituicao.getEndereco());
			pstm.setString(3, instituicao.getCnpj());
			pstm.setString(4, instituicao.getTelefone());
			pstm.setString(5, instituicao.getComplemento());
			pstm.setInt(6, instituicao.getCodigo());
			
			pstm.execute();
			
			JOptionPane.showMessageDialog(null, "Instituição Alterada com sucesso");
			return true;
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível realizar a alteração");
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
	
	
	public List<Instituicao> listarInstituicao() {
		Connection con = null;
		List<Instituicao> Instituicoes = new ArrayList<>();

		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(SELECT);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Instituicao inst = new Instituicao();
				inst.setCodigo(rs.getInt("codigo"));
				inst.setNome(rs.getString("nome"));
				inst.setEndereco(rs.getString("endereco"));
				inst.setCnpj(rs.getString("cnpj"));
				inst.setTelefone(rs.getString("telefone"));
				inst.setComplemento(rs.getString("complemento"));
				Instituicoes.add(inst);
			}
			return Instituicoes;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível listar as instituições");
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

	public Instituicao listarCodigo(int codigo) {
		Connection con = null;
		Instituicao inst = new Instituicao();

		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(SELECT_ID);
			pstm.setInt(1, codigo);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				inst.setCodigo(rs.getInt("codigo"));
				inst.setNome(rs.getString("nome"));
				inst.setEndereco(rs.getString("endereco"));
				inst.setCnpj(rs.getString("cnpj"));
				inst.setTelefone(rs.getString("telefone"));
				inst.setComplemento(rs.getString("complemento"));
			}
			return inst;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível encontrar a instituição");
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
	
	public List<Instituicao> listarInstituicaoNome(String nome) {
		Connection con = null;
		List<Instituicao> Instituicoes = new ArrayList<>();

		try {
			con = Conexao.setConexao();
			PreparedStatement pstm = con.prepareStatement(SELECT_NOME);
			pstm.setString(1, nome);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				Instituicao inst = new Instituicao();
				inst.setCodigo(rs.getInt("codigo"));
				inst.setNome(rs.getString("nome"));
				inst.setEndereco(rs.getString("endereco"));
				inst.setCnpj(rs.getString("cnpj"));
				inst.setTelefone(rs.getString("telefone"));
				inst.setComplemento(rs.getString("complemento"));
				Instituicoes.add(inst);
			}
			return Instituicoes;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível listar a instituição");
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
