package dao;

import java.util.List;

import entidades.Dono;
import entidades.DonoJazigo;


public interface DonoDAO {
	
	public void adicionar(Dono d) throws DAOException;

	public void atualizar(Dono d) throws DAOException;

	public boolean deletar(String cpf) throws DAOException;

	public List<Dono> pesquisar(String dono) throws DAOException;
	
	public List<Dono> pesquisarDonoCpf(String cpf) throws DAOException;
	
	public boolean deletarJazigo(int codigo) throws DAOException;
	
	public List<DonoJazigo> pesquisarJazigo(int num) throws DAOException;
	
	public Dono pesquisar1(String nome) throws DAOException;

	

}
