package dao;

import java.util.List;

import entidades.Declarante;

public interface DeclaranteDAO {
	public void adicionar(Declarante d) throws DAOException;

	public void atualizar(Declarante d) throws DAOException;

	public boolean deletar(String cpf) throws DAOException;

	public List<Declarante> pesquisar(String cpf) throws DAOException;
	
	public Declarante pesquisar1(String cpf) throws DAOException;

}
