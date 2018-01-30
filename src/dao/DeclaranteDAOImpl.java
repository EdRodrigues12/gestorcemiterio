package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Declarante;

public class DeclaranteDAOImpl implements DeclaranteDAO {

	
	public void adicionar(Declarante d) throws DAOException {
		String sql = "INSERT INTO declarante (cpf, nascimento, rg, nome, sexo, cep,"
				+ "endereco, numero, complemento, bairro, cidade, uf,"
				+ "profissao, parentesco, telefone,"
				+ "celular, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, d.getCpf());
			java.sql.Date sd = new java.sql.Date(d.getNascimento().getTime());
			stmt.setDate(2, sd);
			stmt.setString(3, d.getRg());
			stmt.setString(4, d.getNome());
			stmt.setString(5, d.getSexo());
			stmt.setString(6, d.getCep());
			stmt.setString(7, d.getEndereco());
			stmt.setInt(8, d.getNumero());
			stmt.setString(9, d.getComplemento());
			stmt.setString(10, d.getBairro());
			stmt.setString(11, d.getCidade());
			stmt.setString(12, d.getUf());
			stmt.setString(13, d.getProfissao());
			stmt.setString(14, d.getParentesco());
			stmt.setString(15, d.getTelefone());
			stmt.setString(16, d.getCelular());
			stmt.setString(17, d.getEmail());

			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}

	}

	
	public void atualizar(Declarante d) throws DAOException {
		String sql = "UPDATE declarante SET nascimento = ?, rg = ?, nome = ?, sexo = ?,"
				+ "cep = ?,"
				+ "endereco = ?, numero = ?, complemento = ?, bairro = ?,"
				+ "cidade = ?, uf = ?,"
				+ "profissao = ?, parentesco = ?, telefone = ?,"
				+ "celular = ?, email = ?  WHERE cpf = ?";
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			java.sql.Date sd = new java.sql.Date(d.getNascimento().getTime());
			stmt.setDate(1, sd);
			stmt.setString(2, d.getRg());
			stmt.setString(3, d.getNome());
			stmt.setString(4, d.getSexo());
			stmt.setString(5, d.getCep());
			stmt.setString(6, d.getEndereco());
			stmt.setInt(7, d.getNumero());
			stmt.setString(8, d.getComplemento());
			stmt.setString(9, d.getBairro());
			stmt.setString(10, d.getCidade());
			stmt.setString(11, d.getUf());
			stmt.setString(12, d.getProfissao());
			stmt.setString(13, d.getParentesco());
			stmt.setString(14, d.getTelefone());
			stmt.setString(15, d.getCelular());
			stmt.setString(16, d.getEmail());
			stmt.setString(17, d.getCpf());

			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}

	}

	
	public boolean deletar(String cpf) throws DAOException {
		boolean deletado = false;
		String sql = "DELETE FROM declarante WHERE cpf = ?";
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.execute();
			// stmt.close();
			stmt.executeUpdate();
			deletado = true;
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}

		return deletado;

	}

	
	public List<Declarante> pesquisar(String cpf) throws DAOException {
		String sql = "SELECT * FROM declarante WHERE cpf like ? ";
		List<Declarante> declarantes = new ArrayList<Declarante>();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + cpf + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Declarante d = new Declarante();
				d.setCpf(rs.getString("cpf"));
				d.setNascimento(rs.getDate("nascimento"));
				d.setRg(rs.getString("rg"));
				d.setNome(rs.getString("nome"));
				d.setSexo(rs.getString("sexo"));
				d.setCep(rs.getString("cep"));
				d.setEndereco(rs.getString("endereco"));
				d.setNumero(rs.getInt("numero"));
				d.setComplemento(rs.getString("complemento"));
				d.setBairro(rs.getString("bairro"));
				d.setCidade(rs.getString("cidade"));
				d.setUf(rs.getString("uf"));
				d.setProfissao(rs.getString("profissao"));
				d.setParentesco(rs.getString("parentesco"));
				d.setTelefone(rs.getString("telefone"));
				d.setCelular(rs.getString("celular"));
				d.setEmail(rs.getString("email"));
				declarantes.add(d);
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return declarantes;
	}

	
	public Declarante pesquisar1(String cpf) throws DAOException {
		String sql = "SELECT * FROM declarante WHERE cpf like ? ";
		Declarante d = new Declarante();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + cpf + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				d.setCpf(rs.getString("cpf"));
				d.setNascimento(rs.getDate("nascimento"));
				d.setRg(rs.getString("rg"));
				d.setNome(rs.getString("nome"));
				d.setSexo(rs.getString("sexo"));
				d.setCep(rs.getString("cep"));
				d.setEndereco(rs.getString("endereco"));
				d.setNumero(rs.getInt("numero"));
				d.setComplemento(rs.getString("complemento"));
				d.setBairro(rs.getString("bairro"));
				d.setCidade(rs.getString("cidade"));
				d.setUf(rs.getString("uf"));
				d.setProfissao(rs.getString("profissao"));
				d.setParentesco(rs.getString("parentesco"));
				d.setTelefone(rs.getString("telefone"));
				d.setCelular(rs.getString("celular"));
				d.setEmail(rs.getString("email"));
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return d;
	}

}
