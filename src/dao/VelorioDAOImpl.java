package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.Velorio;

public class VelorioDAOImpl implements VelorioDAO {

	@Override
	public void adicionar(Velorio v) throws DAOException {
		String sql = "INSERT INTO velorio (cpfFalecido,nomeFalecido, cpfDeclarante, nomeDeclarante, sala, dia, diaFim, horaInicio, horafim, statu) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			
			stmt.setString(1, v.getCpfFalecido());
			stmt.setString(2, v.getNomeFalecido());
			stmt.setString(3, v.getCpfDeclarante());
			stmt.setString(4, v.getNomeDeclarante());
			stmt.setInt(5, v.getSala());				
			java.sql.Date dex = new java.sql.Date(v.getDia().getTime());
			stmt.setDate(6, dex);
			java.sql.Date dexf = new java.sql.Date(v.getDiaFim().getTime());
			stmt.setDate(7, dexf);
			java.sql.Timestamp hf = new java.sql.Timestamp(v.getHoraInicio().getTime());
			stmt.setTimestamp(8, hf);
			java.sql.Timestamp hff = new java.sql.Timestamp(v.getHoraFim().getTime());
			stmt.setTimestamp(9, hff);
			stmt.setBoolean(10, v.isStatus());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}

	}

	@Override
	public void atualizar(Velorio v) throws DAOException {
		String sql = "UPDATE velorio SET cpfFalecido =?,nomeFalecido =?, cpfDeclarante =?, nomeDeclarante =?, sala =?, dia =?, diaFim =?, horaInicio =?, horaFim =?"
				+ ", statu =? WHERE id = ? ";
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			
			stmt.setString(1, v.getCpfFalecido());
			stmt.setString(2, v.getNomeFalecido());
			stmt.setString(3, v.getCpfDeclarante());
			stmt.setString(4, v.getNomeDeclarante());
			stmt.setInt(5, v.getSala());				
			java.sql.Date dex = new java.sql.Date(v.getDia().getTime());
			stmt.setDate(6, dex);
			java.sql.Date dexf = new java.sql.Date(v.getDiaFim().getTime());
			stmt.setDate(7, dexf);
			java.sql.Timestamp hf = new java.sql.Timestamp(v.getHoraInicio().getTime());
			stmt.setTimestamp(8, hf);
			java.sql.Timestamp hff = new java.sql.Timestamp(v.getHoraFim().getTime());
			stmt.setTimestamp(9, hff);
			stmt.setBoolean(10, v.isStatus());
			stmt.setLong(11, v.getId());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}

	}

	@Override
	public List<Velorio> pesquisarD(Date dia) throws DAOException {
		String sql = "SELECT * FROM velorio WHERE dia like ? ";
		List<Velorio> velorios = new ArrayList<Velorio>();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + dia + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Velorio v = new Velorio();
				v.setCpfFalecido(rs.getString("cpfFalecido"));
				v.setCpfDeclarante(rs.getString("cpfDeclarante"));
				v.setNomeDeclarante(rs.getString("nomeDeclarante"));
				v.setNomeFalecido(rs.getString("nomeFalecido"));
				v.setDia(rs.getDate("dia"));
				v.setDiaFim(rs.getDate("diaFim"));
				v.setHoraInicio(rs.getDate("horaInicio"));
				v.setHoraFim(rs.getDate("horaFim"));
				v.setSala(rs.getInt("sala"));
				velorios.add(v);
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return velorios;
	}
	
	@Override
	public List<Velorio> pesquisarTudo() throws DAOException {
		String sql = "SELECT * FROM velorio ";
		List<Velorio> velorios = new ArrayList<Velorio>();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Velorio v = new Velorio();
				v.setId(rs.getLong("id"));
				v.setCpfFalecido(rs.getString("cpfFalecido"));
				v.setCpfDeclarante(rs.getString("cpfDeclarante"));
				v.setNomeDeclarante(rs.getString("nomeDeclarante"));
				v.setNomeFalecido(rs.getString("nomeFalecido"));
				v.setDia(rs.getDate("dia"));
				v.setDiaFim(rs.getDate("diaFim"));
				v.setHoraInicio(rs.getTimestamp("horaInicio"));
				v.setHoraFim(rs.getTimestamp("horaFim"));
				v.setSala(rs.getInt("sala"));
				v.setStatus(rs.getBoolean("statu"));
				velorios.add(v);
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return velorios;
	}

	@Override
	public List<Velorio> pesquisarS(int sala) throws DAOException {
		String sql = "SELECT * FROM velorio WHERE sala like ? ";
		List<Velorio> velorios = new ArrayList<Velorio>();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + sala + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Velorio v = new Velorio();
				v.setCpfFalecido(rs.getString("cpfFalecido"));
				v.setCpfDeclarante(rs.getString("cpfDeclarante"));
				v.setNomeDeclarante(rs.getString("nomeDeclarante"));
				v.setNomeFalecido(rs.getString("nomeFalecido"));
				v.setDia(rs.getDate("dia"));
				v.setDiaFim(rs.getDate("diaFim"));
				v.setHoraInicio(rs.getDate("horaInicio"));
				v.setHoraFim(rs.getDate("horaFim"));
				v.setSala(rs.getInt("sala"));
				velorios.add(v);
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return velorios;
	}

	@Override
	public List<Velorio> pesquisarH(Date hora) throws DAOException {
		String sql = "SELECT * FROM velorio WHERE horainicio like ? ";
		List<Velorio> velorios = new ArrayList<Velorio>();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + hora + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Velorio v = new Velorio();
				v.setCpfFalecido(rs.getString("cpfFalecido"));
				v.setCpfDeclarante(rs.getString("cpfDeclarante"));
				v.setNomeDeclarante(rs.getString("nomeDeclarante"));
				v.setNomeFalecido(rs.getString("nomeFalecido"));
				v.setDia(rs.getDate("dia"));
				v.setDiaFim(rs.getDate("diaFim"));
				v.setHoraInicio(rs.getDate("horaInicio"));
				v.setHoraFim(rs.getDate("horaFim"));
				v.setSala(rs.getInt("sala"));
				velorios.add(v);
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return velorios;
	}

	@Override
	public Velorio pesquisar1(String cpfFalecido) throws DAOException {
		Velorio v = new Velorio();
		String sql = "SELECT * FROM velorio WHERE cpfFalecido like ? ";

		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + cpfFalecido + "%");
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				v.setCpfFalecido(rs.getString("cpfFalecido"));
				v.setCpfDeclarante(rs.getString("cpfDeclarante"));
				v.setNomeDeclarante(rs.getString("nomeDeclarante"));
				v.setNomeFalecido(rs.getString("nomeFalecido"));
				v.setDia(rs.getDate("dia"));
				v.setDiaFim(rs.getDate("diaFim"));
				v.setHoraInicio(rs.getDate("horaInicio"));
				v.setHoraFim(rs.getDate("horaFim"));
				v.setSala(rs.getInt("sala"));
				

			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return v;
	}

	@Override
	public Velorio pesquisarDec(String cpfDeclarante) throws DAOException {
		Velorio v = new Velorio();
		String sql = "SELECT * FROM velorio WHERE cpfDeclarante like ? ";

		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + cpfDeclarante + "%");
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				v.setCpfFalecido(rs.getString("cpfFalecido"));
				v.setCpfDeclarante(rs.getString("cpfDeclarante"));
				v.setNomeDeclarante(rs.getString("nomeDeclarante"));
				v.setNomeFalecido(rs.getString("nomeFalecido"));
				v.setDia(rs.getDate("dia"));
				v.setDiaFim(rs.getDate("diaFim"));
				v.setHoraInicio(rs.getDate("horaInicio"));
				v.setHoraFim(rs.getDate("horaFim"));
				v.setSala(rs.getInt("sala"));
				

			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return v;
	}

	

}
