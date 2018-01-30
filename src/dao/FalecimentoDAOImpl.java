package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Falecimento;

public class FalecimentoDAOImpl implements FalecimentoDAO {

	
	public void adicionar(Falecimento f) throws DAOException {
		String sql = "INSERT INTO falecimento (cpfFalecido, dataFalecimento, dataExumacao, horaFalecimento, horaExumacao, localFalecimento,"
				+ "cartorio, registroObito, crm, causaMorte) VALUES (?, ?, ?, ?,  ?, ?, ?, ?, ?, ?) ";
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, f.getCpfFalecido());
			java.sql.Date sd = new java.sql.Date(f.getDtFalecimento().getTime());
			stmt.setDate(2, sd);
			java.sql.Date dex = new java.sql.Date(f.getDtExumacao().getTime());
			stmt.setDate(3, dex);
			java.sql.Timestamp hf = new java.sql.Timestamp(f.getHrFalecimeneto().getTime());
			stmt.setTimestamp(4, hf);
			java.sql.Timestamp he = new java.sql.Timestamp(f.getHrExumacao().getTime());
			stmt.setTimestamp(5, he);
			stmt.setString(6, f.getLocal());
			stmt.setString(7, f.getCartorio());
			java.sql.Date pzre = new java.sql.Date(f.getDtRegistroObito().getTime());
			stmt.setDate(8, pzre);
			stmt.setString(9, f.getCrm());
			stmt.setString(10, f.getCausamorte());

			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}

	}

	
	public void atualizar(Falecimento f) throws DAOException {
		String sql = "UPDATE falecimento SET dataFalecimento = ?, dataExumacao = ?, horaFalecimento = ?,"
				+ "horaExumacao = ?, localFalecimento = ?,"
				+ "cartorio = ?, registroObito = ?, crm = ?, causaMorte = ? WHERE cpfFalecido = ? ";
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			java.sql.Date sd = new java.sql.Date(f.getDtFalecimento().getTime());
			stmt.setDate(1, sd);
			java.sql.Date dex = new java.sql.Date(f.getDtExumacao().getTime());
			stmt.setDate(2, dex);
			java.sql.Timestamp hf = new java.sql.Timestamp(f.getHrFalecimeneto().getTime());
			stmt.setTimestamp(3, hf);
			java.sql.Timestamp he = new java.sql.Timestamp(f.getHrExumacao().getTime());
			stmt.setTimestamp(4, he);
			stmt.setString(5, f.getLocal());
			stmt.setString(6, f.getCartorio());
			java.sql.Date pzre = new java.sql.Date(f.getDtRegistroObito().getTime());
			stmt.setDate(7, pzre);
			stmt.setString(8, f.getCrm());
			stmt.setString(9, f.getCausamorte());
			stmt.setString(10, f.getCpfFalecido());

			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}

	}

	
	public boolean deletar(String cpfFalecido) throws DAOException {
		boolean deletado = false;
		String sql = "DELETE FROM falecimento WHERE cpfFalecido = ?";
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, cpfFalecido);
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

	
	public List<Falecimento> pesquisar(String cpfFalecido) throws DAOException {
		String sql = "SELECT * FROM falecimento WHERE cpfFalecido like ?";
		List<Falecimento> falecimentos = new ArrayList<Falecimento>();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + cpfFalecido + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Falecimento f = new Falecimento();
				f.setCpfFalecido(rs.getString("cpfFalecido"));
				f.setDtFalecimento(rs.getDate("dataFalecimento"));
				f.setDtExumacao(rs.getDate("dataExumacao"));
				f.setHrFalecimeneto(rs.getDate("horaFalecimento"));
				f.setHrExumacao(rs.getDate("horaExumacao"));
				f.setLocal(rs.getString("localFalecimento"));
				f.setCartorio(rs.getString("cartorio"));
				f.setDtRegistroObito(rs.getDate("registroObito"));
				f.setCrm(rs.getString("crm"));
				f.setCausamorte(rs.getString("causaMorte"));

				falecimentos.add(f);
				
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return falecimentos;

	}
	public Falecimento pesquisar1(String nomeFalecido) throws DAOException {
		String sql = "SELECT * FROM falecimento WHERE cpfFalecido like ?";
		Falecimento f = new Falecimento();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + nomeFalecido + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				f.setCpfFalecido(rs.getString("cpfFalecido"));
				f.setDtFalecimento(rs.getDate("dataFalecimento"));
				f.setDtExumacao(rs.getDate("dataExumacao"));
				f.setHrFalecimeneto(rs.getDate("horaFalecimento"));
				f.setHrExumacao(rs.getDate("horaExumacao"));
				f.setLocal(rs.getString("localFalecimento"));
				f.setCartorio(rs.getString("cartorio"));
				f.setDtRegistroObito(rs.getDate("registroObito"));
				f.setCrm(rs.getString("crm"));
				f.setCausamorte(rs.getString("causaMorte"));

				
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return f;

	}
}
