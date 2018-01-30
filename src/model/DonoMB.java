package model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.DAOException;
import dao.DonoDAO;
import dao.DonoDAOImpl;
import entidades.Dono;
import entidades.DonoJazigo;
import entidades.Jazigo;

@ManagedBean
@SessionScoped
public class DonoMB {

	private DonoDAO donoDao = new DonoDAOImpl();
	private Dono dono = new Dono();
	private Jazigo jazigo = new Jazigo();
	private DonoJazigo dj = new DonoJazigo();
	private List<Dono> lista = new ArrayList<Dono>();
	private List<DonoJazigo> list = new ArrayList<DonoJazigo>();
    private String nome;
    private int num;
    private String cep = null;
    
    public String buscaCEP(){
		System.out.println(cep);
		WebServiceCep webServiceCep = WebServiceCep.searchCep(getCep());
      
        if (webServiceCep.wasSuccessful()) {
//        	setTipoendereco(webServiceCep.getTipoendereco());
//            setEndereco(webServiceCep.getLogradouroFull());
//            setUf(webServiceCep.getUf());
//            setCidade(webServiceCep.getCidade());
//            setBairro(webServiceCep.getBairro());
        	
        	dono.setEndereco(webServiceCep.getLogradouroFull());
        	dono.setUf(webServiceCep.getUf());
        	dono.setCidade(webServiceCep.getCidade());
        	dono.setBairro(webServiceCep.getBairro());
            dono.setCep(cep);
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
		//String cpf = dono.getCpf();
		
	
		//if(dono.getCodJazigo()!= donoDao.pesquisar1(cpf).getCodJazigo()){
		try{
		donoDao.adicionar(dono);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Adicionado com sucesso!", " "));
   
		dono = new Dono();
		}catch(DAOException e){
			FacesContext context = FacesContext.getCurrentInstance();
		        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao adicionar ", null));
		    	
		}
		//else{
			//FacesContext context = FacesContext.getCurrentInstance();
	       // context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao adicionar, dono já adicionado ", null));
	    	
		//}
		return "";
	}
	
	public String pesquisarCPF() throws DAOException {
		//declarante = new Declarante();
		
		String cpf = dono.getCpf();
		try{
		dono = donoDao.pesquisar1(cpf);
		cep = dono.getCep();
		}
		catch(DAOException e){
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao pesquisar ", null));
	    	
		}
		//declarante = new Declarante();
		return "";
	}
	
	public String pesquisarDono() throws DAOException {
		
		try{
			setLista(donoDao.pesquisar(dono.getNome()));
			cep = dono.getCep();
			}
			catch(DAOException e){
				FacesContext context = FacesContext.getCurrentInstance();
		        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao pesquisar ", null));
		    	
			}
		
		System.out.println(dj.getNome());
		//dono = new Dono();
		return "";
	}

	public String pesquisar() throws DAOException {
		setList(donoDao.pesquisarJazigo(num));
		System.out.println(dono.getNome());
		dj.setNome(dono.getNome());
		dj.setCodigo(jazigo.getCodigo());
		System.out.println(dj.getNome());
		//dono = new Dono();
		return "";
	}
	
	public String pesquisarCpf() throws DAOException {
		
//		System.out.println(dono.getNome());
//		dono = new Dono();
		try{
			setLista(donoDao.pesquisarDonoCpf(dono.getCpf()));
			cep = dono.getCep();
			}
			catch(DAOException e){
				FacesContext context = FacesContext.getCurrentInstance();
		        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao pesquisar ", null));
		    	
			}
		return "";
	}

	public String atualizar() throws DAOException {
		try{
			donoDao.atualizar(dono);
			dono.setCep(cep);
			FacesContext context = FacesContext.getCurrentInstance();
	       	context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado com sucesso!", " "));
	   		dono = new Dono();
			}catch(DAOException e){
				FacesContext context = FacesContext.getCurrentInstance();
			        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao atualizar ", null));
			    	
			}
		
		
		return "";
	}

	public String deletar(Dono d) throws DAOException {
		try{
			dono = d;
			donoDao.deletar(d.getCpf());
			dono = new Dono();
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletado com sucesso!", " "));
	   		
			}catch(DAOException e){
				FacesContext context = FacesContext.getCurrentInstance();
			        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao deletar ", null));
			    	
			}
		
		
		return "";

	}
	public String deletarJazigo(Dono d) throws DAOException {
		try{
			dono = d;
			donoDao.deletarJazigo(d.getCodJazigo());
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Jazigo deletado com sucesso!", " "));
	   		
			}catch(DAOException e){
				FacesContext context = FacesContext.getCurrentInstance();
			        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao deletar ", null));
			    	
			}
		
		return "";

	}

	public Dono getDono() {
		return dono;
	}

	public void setDono(Dono dono) {
		this.dono = dono;
	}

	public List<Dono> getLista() {
		return lista;
	}

	public void setLista(List<Dono> lista) {
		this.lista = lista;
	}

	public List<DonoJazigo> getList() {
		return list;
	}

	public void setList(List<DonoJazigo> list) {
		this.list = list;
	}

	public DonoJazigo getDj() {
		return dj;
	}

	public void setDj(DonoJazigo dj) {
		this.dj = dj;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public DonoDAO getDonoDao() {
		return donoDao;
	}

	public void setDonoDao(DonoDAO donoDao) {
		this.donoDao = donoDao;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Jazigo getJazigo() {
		return jazigo;
	}

	public void setJazigo(Jazigo jazigo) {
		this.jazigo = jazigo;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}
	
}
