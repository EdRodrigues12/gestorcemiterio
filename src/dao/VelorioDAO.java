package dao;

import java.util.Date;
import java.util.List;

import entidades.Velorio;

public interface VelorioDAO {
	public void adicionar(Velorio v) throws DAOException;

	public void atualizar(Velorio v) throws DAOException;

	//public boolean deletar() throws DAOException;

	public List<Velorio> pesquisarD(Date dia) throws DAOException;
	
	public List<Velorio> pesquisarS(int sala) throws DAOException;
	
	public List<Velorio> pesquisarH(Date hora) throws DAOException;
	
	public List<Velorio> pesquisarTudo() throws DAOException;
	
	public Velorio pesquisar1(String cpfFalecido) throws DAOException;
	
	public Velorio pesquisarDec(String cpfDeclarante) throws DAOException;
}
