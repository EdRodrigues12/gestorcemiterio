package dao;

import entidades.Usuario;

public interface UsuarioDAO {

	public void adicionar(Usuario usu)throws DAOExceptionLG;
	public void atualizar(Usuario usu)throws DAOExceptionLG;
	public void excluir(String id)throws DAOExceptionLG;
	public Usuario pesquisar(String id)throws DAOExceptionLG;
	public boolean verificar(String id)throws DAOExceptionLG;
	public String password(String id) throws DAOExceptionLG;
	public String user(String id) throws DAOExceptionLG;
	public String verNivel(String id) throws DAOExceptionLG;
	
}
