package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	@Override
	public void adicionar(Usuario usu) throws DAOExceptionLG {
		String sql = "INSERT INTO usuario (id, nivel, nome, nascimento, senha) VALUES (?, ?, ?, ?, ?)";
		try {
			
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, usu.getId());
			stmt.setString(2, usu.getNivel());
			stmt.setString(3, usu.getNome());
			java.sql.Date sd = new java.sql.Date(usu.getNascimento().getTime());
			stmt.setDate(4, sd);
			stmt.setString(5, usu.getSenha());
			
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException | ClassNotFoundException e) {
			throw new DAOExceptionLG(e);
		}

	}

	@Override
	public void atualizar(Usuario usu) throws DAOExceptionLG {
		String sql = "UPDATE usuario SET nivel = ?, nome = ?, nascimento = ?," + "senha = ?  WHERE id = ?";
		try {
			
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, usu.getNivel());
			stmt.setString(2, usu.getNome());
			java.sql.Date sd = new java.sql.Date(usu.getNascimento().getTime());
			stmt.setDate(3, sd);
			stmt.setString(4, usu.getSenha());
			stmt.setString(5, usu.getId());
			
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException | ClassNotFoundException e) {
			throw new DAOExceptionLG(e);
		} 

	}

	@Override
	public void excluir(String id) throws DAOExceptionLG {
		String sql = "DELETE FROM usuario WHERE id = ?";
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, id);			
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOExceptionLG(e);
		} catch (ClassNotFoundException e) {
			throw new DAOExceptionLG(e);
		}
	}

	@Override
	public Usuario pesquisar(String id) throws DAOExceptionLG {
		String sql = "SELECT * FROM usuario WHERE id like ? ";
		Usuario usu = new Usuario();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%"+id+"%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				usu.setNivel(rs.getString("nivel"));
				usu.setNome(rs.getString("nome"));
				usu.setNascimento(rs.getDate("nascimento"));
				usu.setSenha(rs.getString("senha"));
				usu.setId(rs.getString("id"));
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOExceptionLG(e);
		} catch (ClassNotFoundException e) {
			throw new DAOExceptionLG(e);
		}
		return usu;
	}
	

	@Override
	public boolean verificar(String id) throws DAOExceptionLG {
		String sql = "SELECT senha FROM usuario WHERE id like ? ";
		Usuario usu = new Usuario();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				usu.setSenha(rs.getString("senha"));
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOExceptionLG(e);
		} catch (ClassNotFoundException e) {
			throw new DAOExceptionLG(e);
		}
		if(usu.getSenha().isEmpty()){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public String password(String id) throws DAOExceptionLG {
			String sql = "SELECT senha FROM usuario WHERE id like ? ";
			Usuario usu = new Usuario();
			try {
				Connection con = DBResourceManager.getInstance().getCon();
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, id);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					usu.setSenha(rs.getString("senha"));
				}
				stmt.close();
			} catch (SQLException e) {
				throw new DAOExceptionLG(e);
			} catch (ClassNotFoundException e) {
				throw new DAOExceptionLG(e);
			}
			return usu.getSenha();
	}

	@Override
	public String verNivel(String id) throws DAOExceptionLG {
		String sql = "SELECT nivel FROM usuario WHERE id like ? ";
		Usuario usu = new Usuario();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				usu.setNivel(rs.getString("nivel"));
			}
			System.out.println(usu.getNivel());
			stmt.close();
		} catch (SQLException e) {
			throw new DAOExceptionLG(e);
		} catch (ClassNotFoundException e) {
			throw new DAOExceptionLG(e);
		}
		return usu.getNivel();
		
	}

	@Override
	public String user(String id) throws DAOExceptionLG {
		String sql = "SELECT id FROM usuario WHERE id like ? ";
		Usuario usu = new Usuario();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				usu.setId(rs.getString("id"));
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOExceptionLG(e);
		} catch (ClassNotFoundException e) {
			throw new DAOExceptionLG(e);
		}
		return usu.getId();
	}
		
}


