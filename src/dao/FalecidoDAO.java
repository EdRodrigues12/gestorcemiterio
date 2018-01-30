package dao;

import java.util.List;

import entidades.Falecido;

public interface FalecidoDAO {
	public void adicionar(Falecido f) throws DAOException;

	public void atualizar(Falecido f) throws DAOException;

	public boolean deletar(String CPF_falecido) throws DAOException;

	public List<Falecido> pesquisar(String nome) throws DAOException;
	
	public Falecido pesquisar1(String CPF) throws DAOException;


}
