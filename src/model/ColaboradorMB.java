package model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.ColaboradorDAO;
import dao.ColaboradorDAOImpl;
import dao.DAOException;
import entidades.Colaborador;

@ManagedBean
@SessionScoped
public class ColaboradorMB {

	private Colaborador colaborador = new Colaborador();
	private List<Colaborador> colaboradores = new ArrayList<Colaborador>();
	private ColaboradorDAO dao = new ColaboradorDAOImpl();
	
	
	public String adicionar()throws DAOException{
		try{
		dao.adicionar(colaborador);
		colaborador = new Colaborador();
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Adicionado com sucesso!", " "));
   		}catch(DAOException e){
			e.printStackTrace();
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao adicionar ", null));
	    	
	}
		return "";
	}
	public String atualizar()throws DAOException{
		try{
		dao.atualizar(colaborador);
		colaborador = new Colaborador();
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado com sucesso!", " "));
   		
		}catch(DAOException e){
			e.printStackTrace();
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao atualizar ", null));
	    	
		}
		return "";
	}
	public String pesquisarPorNome()throws DAOException{
		try{
		setColaboradores(dao.pesquisarPorNome(colaborador.getNome()));
		colaborador = new Colaborador();
		//colaborador = colaboradores.get(0);
		if(colaboradores.isEmpty()){
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro, colaborador não cadastrado ", " "));
		}
		}catch(DAOException e){
			e.printStackTrace();
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao pesquisar ", null));
		}	
		return "";
	}
	public String pesquisarPorServico()throws DAOException{
		try{
		setColaboradores(dao.pesquisarPorServico(colaborador.getServico()));
		colaborador = new Colaborador();
		//colaborador = colaboradores.get(0);
		if(colaboradores.isEmpty()){
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro, Não existe colaborador para o serviço ", " "));
			}
		}catch(DAOException e){
			e.printStackTrace();
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao pesquisar ", null));
		}	
		return "";
	}
	public String remover(Colaborador c)throws DAOException{
		try{
		colaborador = c;
		dao.remover(c.getId());
		colaborador = new Colaborador();
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletado com Sucesso!", " "));
   		
		}catch(DAOException e){
			e.printStackTrace();
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao deletar ", null));
		}	
		return "";
	}
	
	public String editar(Colaborador c) { 
		colaborador = c;
		System.out.println("Botao Editar do Col " + c.getNome() + " foi pressionado");
		//colaborador = new Colaborador();
		return "";
	}
	
	public Colaborador getColaborador() {
		return colaborador;
	}
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}
	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}
}
