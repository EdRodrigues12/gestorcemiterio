package model;

import java.util.ArrayList;
import java.util.List;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import dao.DAOExceptionLG;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entidades.Usuario;



@ManagedBean
@SessionScoped
public class LoginMB1 {
	
	private UsuarioDAO usuarioDao = new UsuarioDAOImpl();
	private Usuario user = new Usuario();
	private List<Usuario> lista = new ArrayList<Usuario>();
	private String id;
	private String senha;
	private boolean logado = false;
	private boolean perm = false;


	
	   public String doLogout() {
		      HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		      sessao.invalidate();
		      return "Login?faces-redirect=true";
	   }
	
	public String logar() throws DAOExceptionLG{
		String pagina = "login";
		//user = usuarioDao.pesquisar(id);
		//try{
			if(usuarioDao.password(id) == null){
				logado = false;
				FacesContext fc = FacesContext.getCurrentInstance();
				FacesMessage msg =  new FacesMessage("Usuáio inválido","Usuário  "
						+ "inválido, tente novamentte");
				fc.addMessage("formBody:txtUsuario", msg);
			}
		  							 		
		//}
		//catch(DAOExceptionLG e){
			else if(usuarioDao.verificar(id)== true && 
					usuarioDao.password(id).equals(senha)&& usuarioDao.verNivel(id).equals("Administrador")){
					//if(usuarioDao.verNivel(user.getId()).equals("Administrador")){
			pagina = "index?faces-redirect=true";
			logado = true;
			}
			else if(usuarioDao.verificar(id)== true && 
					usuarioDao.password(id).equals(senha)&& ! usuarioDao.verNivel(id).equals("Administrador")){
				System.out.println(user.getNivel());
				pagina = "index?faces-redirect=true";
				logado = true;
			}
													
				else if(usuarioDao.verificar(id)== true && usuarioDao.password(id)!= senha){
				logado = false;
				FacesContext fc = FacesContext.getCurrentInstance();
				FacesMessage msg = new FacesMessage("Senha inválida","Senha  "
						+ "inválida, tente novamentte");
				fc.addMessage("formBody:txtSenha", msg);
				}
				else{
					logado = false;
					FacesContext fc = FacesContext.getCurrentInstance();
					FacesMessage msg = new FacesMessage("Usuário ou Senha inválida","Usuário ou Senha inválida, tente novamente");
					fc.addMessage("formBody:txtSenha, formBody:txtUsuario", msg);
				}
			//}
		
			
		
		return pagina;
	}
	
	public String nivelAddA() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuAdmin";
		if(usuarioDao.verNivel(id).equals("Administrador")){
			perm = true;
			pagina = "adicionarUsuario?faces-redirect=true";
			//return "adicionarUsuario.xhtml";
			System.out.println("teste phase");
			//
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	public String nivelAttA() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuAdmin";
		if(usuarioDao.verNivel(id).equals("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			pagina = "atualizarUsuario?faces-redirect=true";
			System.out.println("teste");
			//
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	public String nivelDelA() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuAdmin";
		if(usuarioDao.verNivel(id).equals("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			System.out.println("teste");
			pagina = "deletarUsuario?faces-redirect=true";
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	
	public String nivelPesqA() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuAdmin";
		if(usuarioDao.verNivel(id).equals("Administrador") || usuarioDao.verNivel(id)!=("Administrador")){
			//return "adicionarUsuario.xhtml";
			System.out.println("teste");
			pagina = "pesquisarUsuario?faces-redirect=true";
			perm = true;
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	
	public String nivelAddC() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuCola";
		if(usuarioDao.verNivel(id).equals("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			System.out.println("teste");
			pagina = "adicionarColaborador?faces-redirect=true";
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	public String nivelAttC() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuCola";
		if(usuarioDao.verNivel(id).equals("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			System.out.println("teste");
			pagina = "atualizarColaborador?faces-redirect=true";
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	public String nivelDelC() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuCola";
		if(usuarioDao.verNivel(id).equals("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			System.out.println("teste");
			pagina = "deletarColaborador?faces-redirect=true";
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	
	public String nivelPesqC() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuCola";
		if(usuarioDao.verNivel(id).equals("Administrador") || usuarioDao.verNivel(id)!=("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			System.out.println("teste");
			pagina = "pesquisarColaborador?faces-redirect=true";
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	public String nivelAddD() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuDecla";
		if(usuarioDao.verNivel(id).equals("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			System.out.println("teste");
			pagina = "adicionarDeclarante?faces-redirect=true";
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	public String nivelAttD() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuDecla";
		if(usuarioDao.verNivel(id).equals("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			System.out.println("teste");
			pagina = "atualizarDeclarante?faces-redirect=true";
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	public String nivelDelD() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuDecla";
		if(usuarioDao.verNivel(id).equals("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			System.out.println("teste");
			pagina = "deletarDeclarante?faces-redirect=true";
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	
	public String nivelPesqD() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuDecla";
		if(usuarioDao.verNivel(id).equals("Administrador") || usuarioDao.verNivel(id)!=("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			System.out.println("teste");
			pagina = "pesquisarDeclarante?faces-redirect=true";
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	public String nivelAddF() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuFal";
		if(usuarioDao.verNivel(id).equals("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			System.out.println("teste");
			pagina = "adicionarFalecido?faces-redirect=true";
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	public String nivelAttF() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuFal";
		if(usuarioDao.verNivel(id).equals("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			System.out.println("teste");
			pagina = "atualizarFalecido?faces-redirect=true";
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	public String nivelDelF() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuFal";
		if(usuarioDao.verNivel(id).equals("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			System.out.println("teste");
			pagina = "deletarFalecido?faces-redirect=true";
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	
	public String nivelPesqF() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuFal";
		if(usuarioDao.verNivel(id).equals("Administrador") || usuarioDao.verNivel(id)!=("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			System.out.println("teste");
			pagina = "pesquisarFalecido?faces-redirect=true";
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	public String nivelAddJ() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuJaz";
		if(usuarioDao.verNivel(id).equals("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			System.out.println("teste");
			pagina = "adicionarJazigo?faces-redirect=true";
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	public String nivelAttJ() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuJaz";
		if(usuarioDao.verNivel(id).equals("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			System.out.println("teste");
			pagina = "atualizarJazigo?faces-redirect=true";
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	public String nivelDelJ() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuJaz";
		if(usuarioDao.verNivel(id).equals("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			System.out.println("teste");
			pagina = "deletarJazigo?faces-redirect=true";
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	
	public String nivelPesqJ() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuJaz";
		if(usuarioDao.verNivel(id).equals("Administrador") || usuarioDao.verNivel(id)!=("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			System.out.println("teste");
			pagina = "pesquisarJazigo?faces-redirect=true";
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	public String nivelAddDn() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuJaz";
		if(usuarioDao.verNivel(id).equals("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			System.out.println("teste");
			pagina = "adicionarDono?faces-redirect=true";
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	public String nivelAttDn() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuJaz";
		if(usuarioDao.verNivel(id).equals("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			System.out.println("teste");
			pagina = "atualizarDono?faces-redirect=true";
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	public String nivelDelDn() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuJaz";
		if(usuarioDao.verNivel(id).equals("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			System.out.println("teste");
			pagina = "deletarDono?faces-redirect=true";
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	
	public String nivelPesqDn() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuJaz";
		if(usuarioDao.verNivel(id).equals("Administrador") || usuarioDao.verNivel(id)!=("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			System.out.println("teste");
			pagina = "pesquisarDono?faces-redirect=true";
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}
	public String nivelAddV() throws DAOExceptionLG{
		System.out.println(id);
		String pagina = "menuVelo";
		if(usuarioDao.verNivel(id).equals("Administrador")){
			//return "adicionarUsuario.xhtml";
			perm = true;
			System.out.println("teste");
			pagina = "adicionarVelorio?faces-redirect=true";
			
		}
		else{
			perm = false;
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não possui permissão", " "));
      
		}
		
		return pagina;
		
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public List<Usuario> getLista() {
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isLogado() {
		return logado;
	}
	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public boolean isPerm() {
		return perm;
	}

	public void setPerm(boolean perm) {
		this.perm = perm;
	}
	

}
