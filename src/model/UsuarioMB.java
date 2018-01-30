package model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.DAOExceptionLG;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entidades.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioMB {
	
	private UsuarioDAO usuarioDao = new UsuarioDAOImpl();
	private Usuario user = new Usuario();
	private List<Usuario> lista = new ArrayList<Usuario>();
	
	public String adicionar() throws DAOExceptionLG {;
    try{
	usuarioDao.adicionar(user);
	user = new Usuario();
    FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Adicionado com sucesso!", " "));
		}catch(DAOExceptionLG e){
		e.printStackTrace();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao adicionar ", null));
    	
}
	return "";
}

public String pesquisar() throws DAOExceptionLG {
	try{
	String codigo = user.getId();
	user = new Usuario();
	user = usuarioDao.pesquisar(codigo);
	if(user.getId()== null){
	FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro, usuário não cadastrado ", " "));
	}
	}catch(DAOExceptionLG e){
		e.printStackTrace();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao pesquisar ", null));
    	
}
	return "";
}

public String atualizar() throws DAOExceptionLG {
	try{
	usuarioDao.atualizar(user);
	FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado com sucesso!", " "));
		
	}catch(DAOExceptionLG e){
		e.printStackTrace();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao atualizar ", null));
    	
}
	return "";
}

public String deletar() throws DAOExceptionLG {
	try{
	usuarioDao.excluir(user.getId());
	FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletado com sucesso", " "));
		
	}catch(DAOExceptionLG e){
		e.printStackTrace();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao deletar ", null));
    	
}
	return "";

}

}
