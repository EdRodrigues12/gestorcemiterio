package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Dono;
import entidades.DonoJazigo;
import entidades.Jazigo;



public class DonoDAOImpl implements DonoDAO {

	@Override
	public void adicionar(Dono d) throws DAOException {
		String sql = "INSERT INTO dono (cpf, nome,codigoJazigo, cep, endereco, numeroD, "
				+  "complemento, bairro, cidade, uf, telefone  ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			
			stmt.setString(1, d.getCpf());
			stmt.setString(2, d.getNome());
			stmt.setInt(3, d.getCodJazigo());
			stmt.setString(4, d.getCep());
			stmt.setString(5, d.getEndereco());
			stmt.setInt(6, d.getnumeroD());
			stmt.setString(7, d.getComplemento());
			stmt.setString(8, d.getBairro());
			stmt.setString(9, d.getCidade());
			stmt.setString(10, d.getUf());
			stmt.setString(11, d.getTelefone());
			

			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}

	}

	@Override
	public void atualizar(Dono d) throws DAOException {
		String sql = "UPDATE dono SET cpf = ?,"
				+ " nome = ?,codigoJazigo = ?,cep = ?,endereco = ?,numeroD = ?,complemento = ?,bairro = ?,"
				+ "cidade = ?,uf = ?,telefone = ? WHERE id = ?";
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			
			stmt.setString(1, d.getCpf());
			stmt.setString(2, d.getNome());
			stmt.setInt(3, d.getCodJazigo());
			stmt.setString(4, d.getCep());
			stmt.setString(5, d.getEndereco());
			stmt.setInt(6, d.getnumeroD());
			stmt.setString(7, d.getComplemento());
			stmt.setString(8, d.getBairro());
			stmt.setString(9, d.getCidade());
			stmt.setString(10, d.getUf());
			stmt.setString(11, d.getTelefone());
			stmt.setInt(12, d.getId());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}

	}

	@Override
	public boolean deletar(String cpf) throws DAOException {
		boolean deletado = false;
		String sql = "DELETE FROM dono WHERE cpf = ?";

		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, cpf);
			stmt.execute();
			stmt.executeUpdate();
			// stmt.close();
			deletado = true;
			stmt.close(); 
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return deletado;
	}

	@Override
	public List<Dono> pesquisar(String dono) throws DAOException {
		String sql = "SELECT * FROM dono WHERE nome like ? ";
		List<Dono> donos = new ArrayList<Dono>();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + dono + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Dono d = new Dono();
				d.setId( rs.getInt("id") );
				d.setCpf(rs.getString("cpf"));
				d.setNome(rs.getString("nome"));
				d.setCodJazigo(rs.getInt("codigoJazigo"));
				d.setCep(rs.getString("cep"));
				d.setEndereco(rs.getString("endereco"));
				d.setnumeroD(rs.getInt("numeroD"));
				d.setComplemento(rs.getString("complemento"));
				d.setBairro(rs.getString("bairro"));
				d.setCidade(rs.getString("cidade"));
				d.setUf(rs.getString("uf"));
				d.setTelefone(rs.getString("telefone"));
							
				donos.add(d);
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return donos;
	}

	@Override
	public List<Dono> pesquisarDonoCpf(String cpf) throws DAOException {
		String sql = "SELECT * FROM dono WHERE cpf like ? ";
		List<Dono> donos = new ArrayList<Dono>();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + cpf + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Dono d = new Dono();
				d.setId( rs.getInt("id") );
				d.setCpf(rs.getString("cpf"));
				d.setNome(rs.getString("nome"));
				d.setCodJazigo(rs.getInt("codigoJazigo"));
				d.setCep(rs.getString("cep"));
				d.setEndereco(rs.getString("endereco"));
				d.setnumeroD(rs.getInt("numeroD"));
				d.setComplemento(rs.getString("complemento"));
				d.setBairro(rs.getString("bairro"));
				d.setCidade(rs.getString("cidade"));
				d.setUf(rs.getString("uf"));
				d.setTelefone(rs.getString("telefone"));
				donos.add(d);
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return donos;
	}

	@Override
	public boolean deletarJazigo(int codigo) throws DAOException {
		boolean deletado = false;
		String sql = "DELETE FROM dono WHERE codigoJazigo = ?";

		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, codigo);
			stmt.execute();
			stmt.executeUpdate();
			// stmt.close();
			deletado = true;
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return deletado;
	}

	@Override
	public List<DonoJazigo> pesquisarJazigo(int dono) throws DAOException {
		System.out.println(""+dono);
		String sql = "SELECT cpf,nome,codigo, rua, quadra, gaveta,numero "
				+ "FROM dono INNER JOIN jazigo on codigoJazigo = codigo where numero = ? ";

		List<DonoJazigo> donos = new ArrayList<DonoJazigo>();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + dono + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
//				Dono d = new Dono();
//				Jazigo j = new Jazigo();
//				
//				d.setCpf(rs.getString("cpf"));
//     			d.setNome(rs.getString("nome"));
//				d.setCodJazigo(rs.getInt("codigo"));
//				j.setRua(rs.getString("rua"));
//				j.setQuadra(rs.getString("quadra"));
//				j.setGaveta(rs.getInt("gaveta"));
//				j.setNumero(rs.getInt("numero"));
//				donos.addAll(dono, donos);
				
				
				DonoJazigo d = new DonoJazigo();
				
				d.setCpf(rs.getString("cpf"));
				d.setNome(rs.getString("nome"));
				d.setCodigo(rs.getInt("codigo"));
				d.setRua(rs.getString("rua"));
				d.setQuadra(rs.getString("quadra"));
				d.setGaveta(rs.getInt("gaveta"));
				d.setNumero(rs.getInt("numero"));
				donos.add(d);
				System.out.println(""+d.getCpf());
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return donos;
		
	}

	@Override
	public Dono pesquisar1(String cpf) throws DAOException {
		String sql = "SELECT * FROM dono WHERE cpf like ? ";
		Dono d = new Dono();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + cpf + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				d.setId( rs.getInt("id") );
				d.setCpf(rs.getString("cpf"));
				d.setNome(rs.getString("nome"));
				d.setCodJazigo(rs.getInt("codigoJazigo"));
				d.setCep(rs.getString("cep"));
				d.setEndereco(rs.getString("endereco"));
				d.setnumeroD(rs.getInt("numeroD"));
				d.setComplemento(rs.getString("complemento"));
				d.setBairro(rs.getString("bairro"));
				d.setCidade(rs.getString("cidade"));
				d.setUf(rs.getString("uf"));
				d.setTelefone(rs.getString("telefone"));
				
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
