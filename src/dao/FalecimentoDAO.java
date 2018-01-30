package dao;

import java.util.List;

import entidades.Falecimento;

public interface FalecimentoDAO {
	public void adicionar(Falecimento f) throws DAOException;

	public void atualizar(Falecimento f) throws DAOException;

	public boolean deletar(String cpf_falecimento) throws DAOException;

	public List<Falecimento> pesquisar(String nome_falecimento) throws DAOException;
	
	public Falecimento pesquisar1(String cpf_falecimento) throws DAOException;

}
