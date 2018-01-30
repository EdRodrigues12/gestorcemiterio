package model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import dao.DAOException;
import dao.JazigoDAO;
import dao.JazigoDAOImpl;
import entidades.Declarante;
import entidades.Jazigo;


@ManagedBean
@SessionScoped
public class JazigoMB {
	
		private JazigoDAO jazigoDao = new JazigoDAOImpl();
		private Jazigo jazigo = new Jazigo();
		private List<Jazigo> lista = new ArrayList<Jazigo>();
		private List<Jazigo> lista2 = new ArrayList<Jazigo>();
		
		public JazigoMB() throws DAOException{
			this.refresh();
			jazigos();
			jazigosTodos();
			
		}
	
		public String adicionar() throws DAOException {;
							
			try{
				jazigoDao.adicionar(jazigo);
				
				FacesContext context = FacesContext.getCurrentInstance();
		        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Adicionado com sucesso!", " "));
		   
				
		        jazigo = new Jazigo();
				}catch(DAOException e){
					e.printStackTrace();
				        FacesContext context = FacesContext.getCurrentInstance();
				        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao adicionar ", null));
				    	
				}
			return "";
		}

		public String pesquisar() throws DAOException {
			//jazigo = new Jazigo();
			int codigo = jazigo.getNumero();
			try{
				jazigo = jazigoDao.pesquisarUmJazigo(codigo);
				if (jazigo.getRua()== null ){
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Jazigo não cadastrado ", null));
				}
				}catch(DAOException e){
					e.printStackTrace();
			        FacesContext context = FacesContext.getCurrentInstance();
			        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao pesquisar ", null));
			    	
				}
			
			
			return "";
		}
		
		public void jazigos() throws DAOException {
			//jazigo = new Jazigo();
			//int codigo = jazigo.getNumero();
			//try{
				//jazigo = jazigoDao.pesquisarUmJazigo(codigo);
				//if (jazigo.getRua()== null ){
				//FacesContext context = FacesContext.getCurrentInstance();
				//context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Jazigo não cadastrado ", null));
				//}
				//}catch(DAOException e){
					//e.printStackTrace();
			       // FacesContext context = FacesContext.getCurrentInstance();
			       // context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao pesquisar ", null));
			    	
				//}
			lista = jazigoDao.pesquisar();
			this.refresh();
			
		}
		public void jazigosTodos() throws DAOException {
			
			lista2 = jazigoDao.pesquisarTodos();
			this.refresh();
			
		}
		public void refresh() {  
	        FacesContext context = FacesContext.getCurrentInstance();  
	        Application application = context.getApplication();  
	        ViewHandler viewHandler = application.getViewHandler();  
	        UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());  
	        context.setViewRoot(viewRoot);  
	        context.renderResponse();  
	    }

		public String atualizar() throws DAOException {
						
			try{
				jazigoDao.atualizar(jazigo);
				FacesContext context = FacesContext.getCurrentInstance();
		        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado com sucesso!", " "));
		        jazigo = new Jazigo();
				}catch(DAOException e){
					e.printStackTrace();
			        FacesContext context = FacesContext.getCurrentInstance();
			        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao atualizar ", null));
			    	
				}
			return "";
		}
		

		public String deletar() throws DAOException {
			
			
			try{
				jazigoDao.deletar(jazigo.getCodigo());
				jazigo = new Jazigo();
				
		        FacesContext context = FacesContext.getCurrentInstance();
		        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletado com Sucesso ", null));
		    	
				}catch(DAOException e){
					e.printStackTrace();
			        FacesContext context = FacesContext.getCurrentInstance();
			        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao deletar ", null));
			    	
				}
			return "";
		}

		
		public Jazigo getJazigo() {
			return jazigo;
		}

		public void setJazigo(Jazigo jazigo) {
			this.jazigo = jazigo;
		}

		public List<Jazigo> getLista() {
			return lista;
		}

		public void setLista(List<Jazigo> lista) {
			this.lista = lista;
		}

		public List<Jazigo> getLista2() {
			return lista2;
		}

		public void setLista2(List<Jazigo> lista2) {
			this.lista2 = lista2;
		}
		
		

}
