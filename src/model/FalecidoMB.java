package model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import dao.DAOException;
import dao.DeclaranteDAO;
import dao.DeclaranteDAOImpl;
import dao.FalecidoDAO;
import dao.FalecidoDAOImpl;
import dao.JazigoDAO;
import dao.JazigoDAOImpl;
import entidades.Declarante;
import entidades.Falecido;
import entidades.Jazigo;


@ManagedBean
@SessionScoped
public class FalecidoMB {

	private HtmlInputText nomeText = new HtmlInputText();
	private FalecidoDAO falecidoDao = new FalecidoDAOImpl();
	private Falecido falecido = new Falecido();
	private List<Falecido> lista = new ArrayList<Falecido>();
	private JazigoDAO jazigoDao = new JazigoDAOImpl();
	private Jazigo jazigo = new Jazigo();
	private List<Jazigo> list = new ArrayList<Jazigo>();
	
	private DeclaranteDAO declaranteDao = new DeclaranteDAOImpl();
	private Declarante declarante = new Declarante();
	
	private StreamedContent imagem;
	private ManipularImagem mai = new ManipularImagem();
	private Date dtExumacao;
	private String dono;
	private String cep = null;
	 
    private String tipoendereco;
    private String endereco;
    private String uf;
    private String cidade;
    private String bairro;
	private int nAno;
	

	public String buscaCEP(){
		System.out.println(cep);
		WebServiceCep webServiceCep = WebServiceCep.searchCep(getCep());
      
        if (webServiceCep.wasSuccessful()) {
        	//setTipoendereco(webServiceCep.getTipoendereco());
//            setEndereco(webServiceCep.getLogradouroFull());
//            setUf(webServiceCep.getUf());
//            setCidade(webServiceCep.getCidade());
//            setBairro(webServiceCep.getBairro());
        	
        	falecido.setEndereco(webServiceCep.getLogradouroFull());
        	falecido.setUf(webServiceCep.getUf());
        	falecido.setCidade(webServiceCep.getCidade());
        	falecido.setBairro(webServiceCep.getBairro());
            falecido.setCep(cep);
           // System.out.println(cep);
            System.out.println(falecido.getEndereco());
            

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cep Encontrado!", " "));
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cep Não Encontrado ", null));
        }
		return "";
		
		
	}
	

	public String adicionar() throws DAOException {
		String cpf = falecido.getCpfDeclarante();
		declarante = declaranteDao.pesquisar1(cpf);
		try{
		//falecido = new Falecido();
			if(falecido.getCpfDeclarante().equals(declarante.getCpf())){
		falecidoDao.adicionar(falecido);
		
		imagem = new DefaultStreamedContent();
		falecido = new Falecido();
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Adicionado com sucesso!", " "));
			}else{
				FacesContext context = FacesContext.getCurrentInstance();
		        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF Declarante não cadastrado ", null));
		    	
			}
		}catch(DAOException e){
			e.printStackTrace();
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao adicionar ", null));
	    	
	}
		return "";
	}

	public String pesquisar() throws DAOException {
		//falecido = new Falecido();
		String codigo = falecido.getCpf();
		
		try{
			falecido = falecidoDao.pesquisar1(codigo);
			 if(falecido.getCpf()== null ){
			    FacesContext context = FacesContext.getCurrentInstance();
		        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro, CPF não cadastrado", " "));
			    }
		else if(falecido.getFoto()!= null){
		//int num = falecido.getCodJazigo();
		//jazigo = new Jazigo();
	   // jazigo = jazigoDao.pesquisarUmJazigo(num);
	//	falecido = new Falecido();
		
		imagem = new DefaultStreamedContent();
		falecido.setFoto(falecido.getFoto());
	    imagem = new DefaultStreamedContent(new ByteArrayInputStream(falecido.getFoto()));
		cep = falecido.getCep();
		}
			else if(falecido.getFoto()== null ){
			falecido.setFoto(null);
			falecido = falecidoDao.pesquisar1(codigo);
		}
		
		else{
		
		}
			
			   
		}catch(DAOException e){
			e.printStackTrace();
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao pesquisar ", null));
	    	
		}
		
		return "";
	}
	public String pesquisarPorNome() throws DAOException{
		//falecido = new Falecido();
		try{
		imagem = new DefaultStreamedContent();
		setLista(falecidoDao.pesquisar(falecido.getNome()));
		cep = falecido.getCep();
		if(lista.isEmpty()){
		//falecido = new Falecido();
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO, nome não cadastrado", " "));
		}
		}catch(DAOException e){
			e.printStackTrace();
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao pesquisar ", null));
	    	
		}
//		falecido.setFoto(falecido.getFoto());
//	    imagem = new DefaultStreamedContent(new ByteArrayInputStream(falecido.getFoto()));
		//falecido = new Falecido();
		return "";
	}
	
	public String ver(Falecido f)throws DAOException { 
		if(falecido.getFoto() != null){
		falecido = f;
		imagem = new DefaultStreamedContent();
		falecido.setFoto(falecido.getFoto());
	    imagem = new DefaultStreamedContent(new ByteArrayInputStream(falecido.getFoto()));
	    cep = falecido.getCep();}
	    else if(falecido.getFoto()== null){
	    	falecido.setFoto(null);
			falecido = f;
			cep = falecido.getCep();
		}
		else{
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao pesquisar ", null));
	    	
		}
		// falecido = new Falecido();
	    
		System.out.println("Botao Editar do taxista " + f.getNome() + " foi pressionado");
		return "";
	}

	public String atualizar() throws DAOException {
		System.out.println(" teste");
		String cpf = falecido.getCpfDeclarante();
		declarante = declaranteDao.pesquisar1(cpf);
		try{
		//falecido = new Falecido();
			if(falecido.getCpfDeclarante().equals(declarante.getCpf())){
		//falecido = new Falecido();
		
		falecidoDao.atualizar(falecido);
		System.out.println(falecido.getNome());
		falecido.setCep(cep);
		falecido = new Falecido();
		imagem = new DefaultStreamedContent();
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado com sucesso!", " "));
			}else{
				FacesContext context = FacesContext.getCurrentInstance();
		        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF Declarante não cadastrado ", null));
		    	
			}
		}catch(DAOException e){
			e.printStackTrace();
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao atualizar ", null));
		}
		return "";
	}

	public String deletar() throws DAOException {
		//falecido = new Falecido();
		try{
		System.out.println(" teste");
		falecidoDao.deletar(falecido.getCpf());
		falecido = new Falecido();
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado com sucesso!", " "));
   
		}catch(DAOException e){
			e.printStackTrace();
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao deletar ", null));
	    	
		}
		return "";

	}
	
	public String carregaJazigos() throws DAOException{
		System.out.println(" teste");
		//int codigo = falecido.getCodJazigo();
		//int txtNumero = (int) nomeText.getValue();
		//setList(jazigoDao.pesquisarDono(dono));
		return "";
		
	}
	public void calculaIdade(){
		Date hoje = new Date();    
	      Calendar cal = Calendar.getInstance();    
	          
	      cal.setTime(hoje);    
	      int day1 = cal.get(Calendar.DAY_OF_YEAR);    
	      int ano1 = cal.get(Calendar.YEAR);    
	          
	      cal.setTime(falecido.getNascimento());    
	      int day2 = cal.get(Calendar.DAY_OF_YEAR);    
	      int ano2 = cal.get(Calendar.YEAR);    
	          
	      nAno = ano1 - ano2;    
	         
	      if(day1 < day2)    
	         nAno--; //Ainda não completou aniversario esse ano.  
	      System.out.println(nAno);
	       falecido.setIdade(nAno);      
	      //return nAno;    
	     
	   }    
		
	
	public void calcularExumacao(/*int idade*/)throws DAOException{
		System.out.println(" teste");
		
		int idade = falecido.getIdade();
		  
		 if(idade > 6){
			int dias = 62;
	        Date date = new Date();
	        Calendar c = Calendar.getInstance();
	        c.setTime(date);
	        System.out.println(c.getTime());
	        c.add(Calendar.DAY_OF_YEAR, dias);
	        System.out.println(" teste"+c.getTime());
			//falecido.setDtExumacao(c) ;
			
		}else{
			System.out.println(" teste");
		}
		
		//return "";
	}
	 
	
	public void handleFileUpload(FileUploadEvent event) {
		 try {
		 imagem = new DefaultStreamedContent(event.getFile().getInputstream());
		 byte[] foto = event.getFile().getContents();
		 
		// mai.setImagemDimensao(foto., 180, 210);
		 this.falecido.setFoto(foto);
		 } catch (IOException ex) {
		 Logger.getLogger(FalecidoMB.class.getName()).log(Level.SEVERE, null, ex);
		 }
		 UploadedFile uploadedFile = event.getFile();
		 String fileNameUploaded = uploadedFile.getFileName(); 
         long fileSizeUploaded = uploadedFile.getSize(); 
         
         String infoAboutFile = "<br/> Arquivo recebido: <b>" +fileNameUploaded              		+"</b><br/>"+
             "Tamanho do Arquivo: <b>"+fileSizeUploaded+"</b>";
         FacesContext facesContext = FacesContext.getCurrentInstance();
         facesContext.addMessage(null, new FacesMessage("Sucesso", 			                                                                       infoAboutFile));

		 }
	
	public void buscaFoto() {
		 
		 falecido.setFoto(falecido.getFoto());
		 imagem = new DefaultStreamedContent(new ByteArrayInputStream(falecido.getFoto()));
		 }
	
	public void limpaImagem() {
		 this.imagem = new DefaultStreamedContent();
		 }
	
	
	public Falecido getFalecido() {
		return falecido;
	}

	public void setFalecido(Falecido falecido) {
		this.falecido = falecido;
	}

	public List<Falecido> getLista() {
		return lista;
	}

	public void setLista(List<Falecido> lista) {
		this.lista = lista;
	}

	public Jazigo getJazigo() {
		return jazigo;
	}

	public void setJazigo(Jazigo jazigo) {
		this.jazigo = jazigo;
	}

	public List<Jazigo> getList() {
		return list;
	}

	public void setList(List<Jazigo> list) {
		this.list = list;
	}

	public StreamedContent getImagem() {
		return imagem;
	}

	public void setImagem(StreamedContent imagem) {
		this.imagem = imagem;
	}

	public HtmlInputText getNomeText() {
		return nomeText;
	}

	public void setNomeText(HtmlInputText nomeText) {
		this.nomeText = nomeText;
	}

	public Date getDtExumacao() {
		return dtExumacao;
	}

	public void setDtExumacao(Date dtExumacao) {
		this.dtExumacao = dtExumacao;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}


	public int getnAno() {
		return nAno;
	}


	public void setnAno(int nAno) {
		this.nAno = nAno;
	}

}
