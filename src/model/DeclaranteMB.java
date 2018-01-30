package model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.DAOException;
import dao.DeclaranteDAO;
import dao.DeclaranteDAOImpl;
import entidades.Declarante;
@ManagedBean
@SessionScoped
public class DeclaranteMB {
	
	private DeclaranteDAO declaranteDao = new DeclaranteDAOImpl();
	private Declarante declarante = new Declarante();
	private List<Declarante> lista = new ArrayList<Declarante>();
	private String cep = null;
	 
    private String tipoendereco;
    private String endereco;
    private String uf;
    private String cidade;
    private String bairro;
	
	

	public String buscaCEP(){
		System.out.println(cep);
		WebServiceCep webServiceCep = WebServiceCep.searchCep(getCep());
      
        if (webServiceCep.wasSuccessful()) {
//        	setTipoendereco(webServiceCep.getTipoendereco());
//            setEndereco(webServiceCep.getLogradouroFull());
//            setUf(webServiceCep.getUf());
//            setCidade(webServiceCep.getCidade());
//            setBairro(webServiceCep.getBairro());
        	
        	declarante.setEndereco(webServiceCep.getLogradouroFull());
        	declarante.setUf(webServiceCep.getUf());
        	declarante.setCidade(webServiceCep.getCidade());
        	declarante.setBairro(webServiceCep.getBairro());
            declarante.setCep(cep);
//            System.out.println(cep);
//            System.out.println(declarante.getEndereco());
//            System.out.println(declarante);

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cep Encontrado!", " "));
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cep Não Encontrado ", null));
        }
		
		
		return "";
		
		
	}

	public String adicionar() throws DAOException {
		
		//declarante = new Declarante();
//		declarante.setCep(getCep());
//		declarante.setBairro(getBairro());
//    	declarante.setendereco(getendereco());
//    	declarante.setCidade(getCidade());
//    	declarante.setUf(getuf());
		try{
		declaranteDao.adicionar(declarante);
		
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Adicionado com sucesso!", " "));
   
		
		System.out.println(declarante);
//		declarante.setCep(cep);
//    	declarante.setBairro(bairro);
//    	declarante.setendereco(endereco);
//    	declarante.setCidade(cidade);
//    	declarante.setUf(uf);
		declarante = new Declarante();
		}catch(DAOException e){
			e.printStackTrace();
		        FacesContext context = FacesContext.getCurrentInstance();
		        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao adicionar ", null));
		    	
		}
		return "";
	}

	public String pesquisar() throws DAOException {
		//declarante = new Declarante();
		String codigo = declarante.getCpf();
		try{
		declarante = declaranteDao.pesquisar1(codigo);
		System.out.println(declarante.getCpf());
		cep = declarante.getCep();
		if (declarante.getCpf()==null){
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF não cadastrado ", null));
		}
		}catch(DAOException e){
			e.printStackTrace();
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao pesquisar ", null));
	    	
		}

		//declarante = new Declarante();
		return "";
	}

	public String atualizar() throws DAOException {
		//declarante = new Declarante();
		try{
		declaranteDao.atualizar(declarante);
		declarante.setCep(cep);
		declarante = new Declarante();
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado com sucesso!", " "));
   
		}catch(DAOException e){
			e.printStackTrace();
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao atualizar ", null));
	    	
		}
		return "";
	}

	public String deletar() throws DAOException {
		try{
		declaranteDao.deletar(declarante.getCpf());
		declarante = new Declarante();
		
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletado com Sucesso ", null));
    	
		}catch(DAOException e){
			e.printStackTrace();
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao deletar ", null));
	    	
		}
		return "";

	}

	public Declarante getDeclarante() {
		return declarante;
	}

	public void setDeclarante(Declarante declarante) {
		this.declarante = declarante;
	}

	public List<Declarante> getLista() {
		return lista;
	}

	public void setLista(List<Declarante> lista) {
		this.lista = lista;
	}

	public DeclaranteDAO getDeclaranteDao() {
		return declaranteDao;
	}

	public void setDeclaranteDao(DeclaranteDAO declaranteDao) {
		this.declaranteDao = declaranteDao;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTipoendereco() {
		return tipoendereco;
	}

	public void setTipoendereco(String tipoendereco) {
		this.tipoendereco = tipoendereco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	
	
}
