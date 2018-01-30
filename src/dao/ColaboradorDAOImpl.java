package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Colaborador;

public class ColaboradorDAOImpl implements ColaboradorDAO {

	@Override
	public void adicionar(Colaborador c)throws DAOException {
		try {
			String sql = "INSERT INTO COLABORADOR(nome, servico, email, telefone) VALUES (?, ?, ?, ?)";
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getServico());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getTelefone());
			stmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Colaborador c)throws DAOException {
		try {
			String sql = "UPDATE COLABORADOR SET nome = ?, servico = ?, email = ?, telefone = ? "
					+ "WHERE id = ?";
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getServico());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getTelefone());
			stmt.setInt(5, c.getId());
			stmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Colaborador> pesquisarPorNome(String nome)throws DAOException {
		List<Colaborador> colaboradores = new ArrayList<Colaborador>();
		try {
			String sql = "SELECT * FROM COLABORADOR WHERE nome LIKE ?";
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%"+nome+"%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Colaborador c = new Colaborador();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setServico(rs.getString("servico"));
				c.setEmail(rs.getString("email"));
				c.setTelefone(rs.getString("telefone"));
				colaboradores.add(c);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return colaboradores;
	}
	
	@Override
	public List<Colaborador> pesquisarPorServico(String servico)throws DAOException {
		List<Colaborador> colaboradores = new ArrayList<Colaborador>();
		try {
			String sql = "SELECT * FROM COLABORADOR WHERE servico LIKE ?";
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%"+servico+"%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Colaborador c = new Colaborador();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setServico(rs.getString("servico"));
				c.setEmail(rs.getString("email"));
				c.setTelefone(rs.getString("telefone"));
				colaboradores.add(c);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return colaboradores;
	}

	@Override
	public void remover(int id)throws DAOException {
		try {
			String sql = "DELETE FROM COLABORADOR WHERE id = ?";
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
