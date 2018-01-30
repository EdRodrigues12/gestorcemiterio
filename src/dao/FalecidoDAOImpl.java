package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Falecido;

public class FalecidoDAOImpl implements FalecidoDAO {

	
	public void adicionar(Falecido f) throws DAOException {
		String sql = "INSERT INTO falecido (cpf,  cpfDeclarante, codigoJazigo, rg, nome, sexo,"
				+ "naturalidade, nacionalidade, etnia, nascimento,"
				+ "profissao, estadoCivil, tituloEleitor, zona,"
				+ "secao, cep, endereco, numero, bairro, complemento,"
				+ "cidade, uf, foto, dataFalecimento, dataExumacao, horaFalecimento, horaExumacao, localFalecimento,"
				+ "cartorio, registroObito, crm, causaMorte, idade, dataSepultamento, horaSepultamento) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, f.getCpf());
			stmt.setString(2, f.getCpfDeclarante());
			stmt.setInt(3, f.getCodJazigo());
			stmt.setString(4, f.getRg());
			stmt.setString(5, f.getNome());
			stmt.setString(6, f.getSexo());
			stmt.setString(7, f.getNaturalidade());
			stmt.setString(8, f.getNacionalidade());
			stmt.setString(9, f.getEtnia());
			java.sql.Date sd = new java.sql.Date(f.getNascimento().getTime());
			stmt.setDate(10, sd);
			stmt.setString(11, f.getProfissao());
			stmt.setString(12, f.getEstCivil());
			stmt.setString(13, f.getTituloEleitor());
			stmt.setInt(14, f.getZona());
			stmt.setInt(15, f.getSecao());
			stmt.setString(16, f.getCep());
			stmt.setString(17, f.getEndereco());
			stmt.setInt(18, f.getNumero());
			stmt.setString(19, f.getBairro());
			stmt.setString(20, f.getComplemento());
			stmt.setString(21, f.getCidade());
			stmt.setString(22, f.getUf());
			stmt.setBytes(23, f.getFoto());
			java.sql.Date sdf = new java.sql.Date(f.getDtFalecimento().getTime());
			stmt.setDate(24, sdf);
			java.sql.Date dex = new java.sql.Date(f.getDtExumacao().getTime());
			stmt.setDate(25, dex);
			java.sql.Timestamp hf = new java.sql.Timestamp(f.getHrFalecimeneto().getTime());
			stmt.setTimestamp(26, hf);
			java.sql.Timestamp he = new java.sql.Timestamp(f.getHrExumacao().getTime());
			stmt.setTimestamp(27, he);
			stmt.setString(28, f.getLocal());
			stmt.setString(29, f.getCartorio());
			java.sql.Date pzre = new java.sql.Date(f.getDtRegistroObito().getTime());
			stmt.setDate(30, pzre);
			stmt.setString(31, f.getCrm());
			stmt.setString(32, f.getCausamorte());
            stmt.setInt(33, f.getIdade());
            java.sql.Date sds = new java.sql.Date(f.getDataSepultamento().getTime());
			stmt.setDate(34, sds);
			java.sql.Timestamp hes = new java.sql.Timestamp(f.getHoraSepultamento().getTime());
			stmt.setTimestamp(35, hes);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}

	}

	
	public void atualizar(Falecido f) throws DAOException {
		String sql = "UPDATE falecido SET cpfDeclarante = ?, codigoJazigo = ?, rg = ?, nome = ?, sexo = ?,"
				+ "naturalidade = ?, nacionalidade = ?, etnia = ?, nascimento = ?,"
				+ "profissao = ?, estadoCivil = ?, tituloEleitor = ?, zona = ?,"
				+ "secao = ?, cep = ?, endereco = ?, numero = ?, bairro = ?, complemento = ?,	"
				+ "cidade = ?, uf = ?,foto = ?, dataFalecimento = ?, dataExumacao = ?, horaFalecimento = ?,"
				+ "horaExumacao = ?, localFalecimento = ?,"
				+ "cartorio = ?, registroObito = ?, crm = ?, causaMorte = ?, idade = ?, dataSepultamento = ?, horaSepultamento = ? WHERE cpf = ? ";

		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			
			stmt.setString(1, f.getCpfDeclarante());
			stmt.setInt(2, f.getCodJazigo());
			stmt.setString(3, f.getRg());
			stmt.setString(4, f.getNome());
			stmt.setString(5, f.getSexo());
			stmt.setString(6, f.getNaturalidade());
			stmt.setString(7, f.getNacionalidade());
			stmt.setString(8, f.getEtnia());
			java.sql.Date sd = new java.sql.Date(f.getNascimento().getTime());
			stmt.setDate(9, sd);
			stmt.setString(10, f.getProfissao());
			stmt.setString(11, f.getEstCivil());
			stmt.setString(12, f.getTituloEleitor());
			stmt.setInt(13, f.getZona());
			stmt.setInt(14, f.getSecao());
			stmt.setString(15, f.getCep());
			stmt.setString(16, f.getEndereco());
			stmt.setInt(17, f.getNumero());
			stmt.setString(18, f.getBairro());
			stmt.setString(19, f.getComplemento());
			stmt.setString(20, f.getCidade());
			stmt.setString(21, f.getUf());
			stmt.setBytes(22, f.getFoto());
			java.sql.Date sdf = new java.sql.Date(f.getDtFalecimento().getTime());
			stmt.setDate(23, sdf);
			java.sql.Date dex = new java.sql.Date(f.getDtExumacao().getTime());
			stmt.setDate(24, dex);
			java.sql.Timestamp hf = new java.sql.Timestamp(f.getHrFalecimeneto().getTime());
			stmt.setTimestamp(25, hf);
			java.sql.Timestamp he = new java.sql.Timestamp(f.getHrExumacao().getTime());
			stmt.setTimestamp(26, he);
			stmt.setString(27, f.getLocal());
			stmt.setString(28, f.getCartorio());
			java.sql.Date pzre = new java.sql.Date(f.getDtRegistroObito().getTime());
			stmt.setDate(29, pzre);
			stmt.setString(30, f.getCrm());
			stmt.setString(31, f.getCausamorte());
			stmt.setInt(32, f.getIdade());
			java.sql.Date sds = new java.sql.Date(f.getDataSepultamento().getTime());
			stmt.setDate(33, sds);
			java.sql.Timestamp hes = new java.sql.Timestamp(f.getHoraSepultamento().getTime());
			stmt.setTimestamp(34, hes);
			stmt.setString(35, f.getCpf());
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
		String sql = "DELETE FROM falecido WHERE cpf = ?";
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

	
	public List<Falecido> pesquisar(String nome) throws DAOException {
		String sql = "SELECT * FROM falecido WHERE  nome like ? ";
		List<Falecido> falecidos = new ArrayList<Falecido>();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Falecido d = new Falecido();
				d.setCpf(rs.getString("cpf"));
				d.setCpfDeclarante(rs.getString("cpfDeclarante"));
				d.setCodJazigo(rs.getInt("codigoJazigo"));
				d.setRg(rs.getString("rg"));
				d.setNome(rs.getString("nome"));
				d.setSexo(rs.getString("sexo"));
				d.setNaturalidade(rs.getString("naturalidade"));
				d.setNacionalidade(rs.getString("nacionalidade"));
				d.setEtnia(rs.getString("etnia"));
				d.setNascimento(rs.getDate("nascimento"));
				d.setProfissao(rs.getString("profissao"));
				d.setEstCivil(rs.getString("estadoCivil"));
				d.setTituloEleitor(rs.getString("tituloEleitor"));
				d.setZona(rs.getInt("zona"));
				d.setSecao(rs.getInt("secao"));
				d.setCep(rs.getString("cep"));
				d.setEndereco(rs.getString("endereco"));
				d.setNumero(rs.getInt("numero"));
				d.setBairro(rs.getString("bairro"));
				d.setComplemento(rs.getString("complemento"));
				d.setCidade(rs.getString("cidade"));
				d.setUf(rs.getString("uf"));
				d.setFoto(rs.getBytes("foto"));	
				d.setDtFalecimento(rs.getDate("dataFalecimento"));
				d.setDtExumacao(rs.getDate("dataExumacao"));
				d.setHrFalecimeneto(rs.getTimestamp("horaFalecimento"));
				d.setHrExumacao(rs.getTimestamp("horaExumacao"));
				d.setLocal(rs.getString("localFalecimento"));
				d.setCartorio(rs.getString("cartorio"));
				d.setDtRegistroObito(rs.getDate("registroObito"));
				d.setCrm(rs.getString("crm"));
				d.setCausamorte(rs.getString("causaMorte"));
				d.setIdade(rs.getInt("idade"));
				d.setDataSepultamento(rs.getDate("dataSepultamento"));
				d.setHoraSepultamento(rs.getTimestamp("horaSepultamento"));
				falecidos.add(d);
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return falecidos;
	}

	
	public Falecido pesquisar1(String cpf) throws DAOException {
		String sql = "SELECT * FROM falecido WHERE cpf like ? ";
		Falecido d = new Falecido();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + cpf + "%");
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				d.setCpf(rs.getString("cpf"));
				d.setCpfDeclarante(rs.getString("cpfDeclarante"));
				d.setCodJazigo(rs.getInt("codigoJazigo"));
				d.setRg(rs.getString("rg"));
				d.setNome(rs.getString("nome"));
				d.setSexo(rs.getString("sexo"));
				d.setNaturalidade(rs.getString("naturalidade"));
				d.setNacionalidade(rs.getString("nacionalidade"));
				d.setEtnia(rs.getString("etnia"));
				d.setNascimento(rs.getDate("nascimento"));
				d.setProfissao(rs.getString("profissao"));
				d.setEstCivil(rs.getString("estadoCivil"));
				d.setTituloEleitor(rs.getString("tituloEleitor"));
				d.setZona(rs.getInt("zona"));
				d.setSecao(rs.getInt("secao"));
				d.setCep(rs.getString("cep"));
				d.setEndereco(rs.getString("endereco"));
				d.setNumero(rs.getInt("numero"));
				d.setBairro(rs.getString("bairro"));
				d.setComplemento(rs.getString("complemento"));
				d.setCidade(rs.getString("cidade"));
				d.setUf(rs.getString("uf"));
				d.setFoto(rs.getBytes("foto"));
				d.setDtFalecimento(rs.getDate("dataFalecimento"));
				d.setDtExumacao(rs.getDate("dataExumacao"));
				d.setHrFalecimeneto(rs.getTimestamp("horaFalecimento"));
				d.setHrExumacao(rs.getTimestamp("horaExumacao"));
				d.setLocal(rs.getString("localFalecimento"));
				d.setCartorio(rs.getString("cartorio"));
				d.setDtRegistroObito(rs.getDate("registroObito"));
				d.setCrm(rs.getString("crm"));
				d.setCausamorte(rs.getString("causaMorte"));
				d.setIdade(rs.getInt("idade"));
				d.setDataSepultamento(rs.getDate("dataSepultamento"));
				d.setHoraSepultamento(rs.getTimestamp("horaSepultamento"));
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
