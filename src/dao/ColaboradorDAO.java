package dao;

import java.util.List;

import entidades.Colaborador;

public interface ColaboradorDAO {
	public void adicionar(Colaborador c)throws DAOException;
	public void atualizar(Colaborador c)throws DAOException;
	public List<Colaborador> pesquisarPorNome(String nome)throws DAOException;
	public List<Colaborador> pesquisarPorServico(String servico)throws DAOException;
	public void remover(int id)throws DAOException;
}
