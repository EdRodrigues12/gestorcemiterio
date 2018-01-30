package model;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class Listener implements PhaseListener {
	private static final long serialVersionUID = 3549101153061073955L;
	
	@Override
	public void afterPhase(PhaseEvent e) {
		System.out.println("After Phase sendo executado para a Fase : " + e.getPhaseId());	
		FacesContext fc = FacesContext.getCurrentInstance();
		String nomePagina = fc.getViewRoot().getViewId();
		String nomePagina2 = fc.getViewRoot().getViewId();
		System.out.println( "Pagina acessada : " + nomePagina);
		
         
		if (! "/Login.xhtml".equals( nomePagina )) {
			Application app = fc.getApplication();
			LoginMB login = app.evaluateExpressionGet(
					fc, "#{loginMB}", LoginMB.class);
			if (login.isLogado()) { 
				System.out.println("Usuario logado pode prosseguir");
			} else { 
				System.out.println("Usuario não logado direcionando para a pagina ./Login.xhtml");
				NavigationHandler nav = app.getNavigationHandler();
				nav.handleNavigation(fc, "", "Login?faces-redirect=true");
				fc.renderResponse();
			}
		}
        
		if("/adicionarUsuario.xhtml".equals( nomePagina)){
			Application app = fc.getApplication();
			LoginMB login = app.evaluateExpressionGet(
					fc, "#{loginMB}", LoginMB.class);
			if (login.isPerm() && login.isLogado()) { 
				System.out.println("Usuario pode prosseguir");
//			NavigationHandler nav = app.getNavigationHandler();
//			nav.handleNavigation(fc, "", "adicionarUsuario?faces-redirect=true");
//			fc.renderResponse();
			System.out.println("teste");
			}
		else{
			System.out.println("Usuario não direcionando para a pagina ./adicionarUsuario.xhtml");
			NavigationHandler nav = app.getNavigationHandler();
			nav.handleNavigation(fc, "", "index?faces-redirect=true");
			fc.renderResponse();
		}
	 }
		
		else if("/atualizarUsuario.xhtml".equals( nomePagina)){
			Application app = fc.getApplication();
			LoginMB login = app.evaluateExpressionGet(
					fc, "#{loginMB}", LoginMB.class);
			if (login.isPerm()&& login.isLogado() ) { 
				System.out.println("Usuario pode prosseguir");
//			NavigationHandler nav = app.getNavigationHandler();
//			nav.handleNavigation(fc, "", "atualizarUsuario?faces-redirect=true");
//			fc.renderResponse();
			System.out.println("teste no Phase");
			}
		else{
			System.out.println("Usuario não direcionando para a pagina ./adicionarUsuario.xhtml");
			NavigationHandler nav = app.getNavigationHandler();
			nav.handleNavigation(fc, "", "index?faces-redirect=true");
			fc.renderResponse();
		}
	 }
		
		else if("/deletarUsuario.xhtml".equals( nomePagina)){
			Application app = fc.getApplication();
			LoginMB login = app.evaluateExpressionGet(
					fc, "#{loginMB}", LoginMB.class);
			if (login.isPerm()&& login.isLogado()) { 
				System.out.println("Usuario pode prosseguir");
//			NavigationHandler nav = app.getNavigationHandler();
//			nav.handleNavigation(fc, "", "deletarUsuario?faces-redirect=true");
//			fc.renderResponse();
			System.out.println("teste no phase");
			}
		else{
			System.out.println("Usuario não direcionando para a pagina ./adicionarUsuario.xhtml");
			NavigationHandler nav = app.getNavigationHandler();
			nav.handleNavigation(fc, "", "index?faces-redirect=true");
			fc.renderResponse();
		}
	 }
		
		//Colaborador
		
		else if("/adicionarColaborador.xhtml".equals( nomePagina)){
			Application app = fc.getApplication();
			LoginMB login = app.evaluateExpressionGet(
					fc, "#{loginMB}", LoginMB.class);
			if (login.isPerm()&& login.isLogado() ) { 
				System.out.println("Usuario pode prosseguir");
//			NavigationHandler nav = app.getNavigationHandler();
//			nav.handleNavigation(fc, "", "adicionarColaborador?faces-redirect=true");
//			fc.renderResponse();
			System.out.println("teste");
			}
		else{
			System.out.println("Usuario não direcionando para a pagina ./adicionarUsuario.xhtml");
			NavigationHandler nav = app.getNavigationHandler();
			nav.handleNavigation(fc, "", "index?faces-redirect=true");
			fc.renderResponse();
		}
	 }
		
		else if("/atualizarColaborador.xhtml".equals( nomePagina)){
			Application app = fc.getApplication();
			LoginMB login = app.evaluateExpressionGet(
					fc, "#{loginMB}", LoginMB.class);
			if (login.isPerm()&& login.isLogado() ) { 
				System.out.println("Usuario pode prosseguir");
//			NavigationHandler nav = app.getNavigationHandler();
//			nav.handleNavigation(fc, "", "atualizarColaborador?faces-redirect=true");
//			fc.renderResponse();
			System.out.println("teste");
			}
		else{
			System.out.println("Usuario não direcionando para a pagina ./adicionarUsuario.xhtml");
			NavigationHandler nav = app.getNavigationHandler();
			nav.handleNavigation(fc, "", "index?faces-redirect=true");
			fc.renderResponse();
		}
	 }
		
		else if("/deletarColaborador.xhtml".equals( nomePagina)){
			Application app = fc.getApplication();
			LoginMB login = app.evaluateExpressionGet(
					fc, "#{loginMB}", LoginMB.class);
			if (login.isPerm()&& login.isLogado() ) { 
				System.out.println("Usuario pode prosseguir");
//			NavigationHandler nav = app.getNavigationHandler();
//			nav.handleNavigation(fc, "", "deletarColaborador?faces-redirect=true");
//			fc.renderResponse();
			System.out.println("teste");
			}
		else{
			System.out.println("Usuario não direcionando para a pagina ./adicionarUsuario.xhtml");
			NavigationHandler nav = app.getNavigationHandler();
			nav.handleNavigation(fc, "", "index?faces-redirect=true");
			fc.renderResponse();
		}
	 }
		
		//Declarante
		
		if("/adicionarDeclarante.xhtml".equals( nomePagina)){
			Application app = fc.getApplication();
			LoginMB login = app.evaluateExpressionGet(
					fc, "#{loginMB}", LoginMB.class);
			if (login.isPerm()&& login.isLogado() ) { 
				System.out.println("Usuario pode prosseguir");
//			NavigationHandler nav = app.getNavigationHandler();
//			nav.handleNavigation(fc, "", "adicionarDeclarante?faces-redirect=true");
//			fc.renderResponse();
			System.out.println("teste");
			}
		else{
			System.out.println("Usuario não direcionando para a pagina ./adicionarUsuario.xhtml");
			NavigationHandler nav = app.getNavigationHandler();
			nav.handleNavigation(fc, "", "index?faces-redirect=true");
			fc.renderResponse();
		}
	 }
		
		if("/atualizarDeclarante.xhtml".equals( nomePagina)){
			Application app = fc.getApplication();
			LoginMB login = app.evaluateExpressionGet(
					fc, "#{loginMB}", LoginMB.class);
			if (login.isPerm()&& login.isLogado() ) { 
				System.out.println("Usuario pode prosseguir");
//			NavigationHandler nav = app.getNavigationHandler();
//			nav.handleNavigation(fc, "", "atualizarDeclarante?faces-redirect=true");
//			fc.renderResponse();
			System.out.println("teste");
			}
		else{
			System.out.println("Usuario não direcionando para a pagina ./adicionarUsuario.xhtml");
			NavigationHandler nav = app.getNavigationHandler();
			nav.handleNavigation(fc, "", "index?faces-redirect=true");
			fc.renderResponse();
		}
	 }
		
		if("/deletarDeclarante.xhtml".equals( nomePagina)){
			Application app = fc.getApplication();
			LoginMB login = app.evaluateExpressionGet(
					fc, "#{loginMB}", LoginMB.class);
			if (login.isPerm()&& login.isLogado() ) { 
				System.out.println("Usuario pode prosseguir");
//			NavigationHandler nav = app.getNavigationHandler();
//			nav.handleNavigation(fc, "", "deletarDeclarante?faces-redirect=true");
//			fc.renderResponse();
			System.out.println("teste");
			}
		else{
			System.out.println("Usuario não direcionando para a pagina ./adicionarUsuario.xhtml");
			NavigationHandler nav = app.getNavigationHandler();
			nav.handleNavigation(fc, "", "index?faces-redirect=true");
			fc.renderResponse();
		}
	 }
		
		//Falecimento
		
		if("/adicionarFalecido.xhtml".equals( nomePagina)){
			Application app = fc.getApplication();
			LoginMB login = app.evaluateExpressionGet(
					fc, "#{loginMB}", LoginMB.class);
			if (login.isPerm()&& login.isLogado() ) { 
				System.out.println("Usuario pode prosseguir");
//			NavigationHandler nav = app.getNavigationHandler();
//			nav.handleNavigation(fc, "", "adicionarFalecido?faces-redirect=true");
//			fc.renderResponse();
			System.out.println("teste");
			}
		else{
			System.out.println("Usuario não direcionando para a pagina ./adicionarUsuario.xhtml");
			NavigationHandler nav = app.getNavigationHandler();
			nav.handleNavigation(fc, "", "index?faces-redirect=true");
			fc.renderResponse();
		}
	 }
		
		if("/atualizarFalecido.xhtml".equals( nomePagina)){
			Application app = fc.getApplication();
			LoginMB login = app.evaluateExpressionGet(
					fc, "#{loginMB}", LoginMB.class);
			if (login.isPerm()&& login.isLogado() ) { 
				System.out.println("Usuario pode prosseguir");
//			NavigationHandler nav = app.getNavigationHandler();
//			nav.handleNavigation(fc, "", "atualizarFalecido?faces-redirect=true");
//			fc.renderResponse();
			System.out.println("teste");
			}
		else{
			System.out.println("Usuario não direcionando para a pagina ./adicionarUsuario.xhtml");
			NavigationHandler nav = app.getNavigationHandler();
			nav.handleNavigation(fc, "", "index?faces-redirect=true");
			fc.renderResponse();
		}
	 }
		
		if("/deletarFalecido.xhtml".equals( nomePagina)){
			Application app = fc.getApplication();
			LoginMB login = app.evaluateExpressionGet(
					fc, "#{loginMB}", LoginMB.class);
			if (login.isPerm()&& login.isLogado() ) { 
				System.out.println("Usuario pode prosseguir");
//			NavigationHandler nav = app.getNavigationHandler();
//			nav.handleNavigation(fc, "", "deletarFalecido?faces-redirect=true");
//			fc.renderResponse();
			System.out.println("teste");
			}
		else{
			System.out.println("Usuario não direcionando para a pagina ./adicionarUsuario.xhtml");
			NavigationHandler nav = app.getNavigationHandler();
			nav.handleNavigation(fc, "", "index?faces-redirect=true");
			fc.renderResponse();
		}
	 }
		
		//Jazigo
		
		if("/adicionarJazigo.xhtml".equals( nomePagina)){
			Application app = fc.getApplication();
			LoginMB login = app.evaluateExpressionGet(
					fc, "#{loginMB}", LoginMB.class);
			if (login.isPerm()&& login.isLogado() ) { 
				System.out.println("Usuario pode prosseguir");
//			NavigationHandler nav = app.getNavigationHandler();
//			nav.handleNavigation(fc, "", "adicionarJazigo?faces-redirect=true");
//			fc.renderResponse();
			System.out.println("teste");
			}
		else{
			System.out.println("Usuario não direcionando para a pagina ./adicionarUsuario.xhtml");
			NavigationHandler nav = app.getNavigationHandler();
			nav.handleNavigation(fc, "", "index?faces-redirect=true");
			fc.renderResponse();
		}
	 }
		
		if("/atualizarJazigo.xhtml".equals( nomePagina)){
			Application app = fc.getApplication();
			LoginMB login = app.evaluateExpressionGet(
					fc, "#{loginMB}", LoginMB.class);
			if (login.isPerm()&& login.isLogado() ) { 
				System.out.println("Usuario pode prosseguir");
//			NavigationHandler nav = app.getNavigationHandler();
//			nav.handleNavigation(fc, "", "atualizarJazigo?faces-redirect=true");
//			fc.renderResponse();
			System.out.println("teste");
			}
		else{
			System.out.println("Usuario não direcionando para a pagina ./adicionarUsuario.xhtml");
			NavigationHandler nav = app.getNavigationHandler();
			nav.handleNavigation(fc, "", "index?faces-redirect=true");
			fc.renderResponse();
		}
	 }
		
		if("/deletarJazigo.xhtml".equals( nomePagina)){
			Application app = fc.getApplication();
			LoginMB login = app.evaluateExpressionGet(
					fc, "#{loginMB}", LoginMB.class);
			if (login.isPerm()&& login.isLogado() ) { 
				System.out.println("Usuario pode prosseguir");
//			NavigationHandler nav = app.getNavigationHandler();
//			nav.handleNavigation(fc, "", "deletarJazigo?faces-redirect=true");
//			fc.renderResponse();
			System.out.println("teste");
			}
		else{
			System.out.println("Usuario não direcionando para a pagina ./adicionarUsuario.xhtml");
			NavigationHandler nav = app.getNavigationHandler();
			nav.handleNavigation(fc, "", "index?faces-redirect=true");
			fc.renderResponse();
		}
	 }
		
		//Velorio
		
		if("/adicionarVelorio.xhtml".equals( nomePagina)){
			Application app = fc.getApplication();
			LoginMB login = app.evaluateExpressionGet(
					fc, "#{loginMB}", LoginMB.class);
			if (login.isPerm()&& login.isLogado() ) { 
				System.out.println("Usuario pode prosseguir");
//			NavigationHandler nav = app.getNavigationHandler();
//			nav.handleNavigation(fc, "", "adicionarVelorio?faces-redirect=true");
//			fc.renderResponse();
			System.out.println("teste");
			}
		else{
			System.out.println("Usuario não direcionando para a pagina ./adicionarUsuario.xhtml");
			NavigationHandler nav = app.getNavigationHandler();
			nav.handleNavigation(fc, "", "index?faces-redirect=true");
			fc.renderResponse();
		}
	 }
		
		//Dono
		
		if("/adicionarDono.xhtml".equals( nomePagina)){
			Application app = fc.getApplication();
			LoginMB login = app.evaluateExpressionGet(
					fc, "#{loginMB}", LoginMB.class);
			if (login.isPerm()&& login.isLogado() ) { 
				System.out.println("Usuario pode prosseguir");
//			NavigationHandler nav = app.getNavigationHandler();
//			nav.handleNavigation(fc, "", "adicionarDono?faces-redirect=true");
//			fc.renderResponse();
			System.out.println("teste");
			}
		else{
			System.out.println("Usuario não direcionando para a pagina ./adicionarUsuario.xhtml");
			NavigationHandler nav = app.getNavigationHandler();
			nav.handleNavigation(fc, "", "index?faces-redirect=true");
			fc.renderResponse();
		}
	 }
		
		if("/atualizarDono.xhtml".equals( nomePagina)){
			Application app = fc.getApplication();
			LoginMB login = app.evaluateExpressionGet(
					fc, "#{loginMB}", LoginMB.class);
			if (login.isPerm()&& login.isLogado() ) { 
				System.out.println("Usuario pode prosseguir");
//			NavigationHandler nav = app.getNavigationHandler();
//			nav.handleNavigation(fc, "", "atualizarDono?faces-redirect=true");
//			fc.renderResponse();
			System.out.println("teste");
			}
		else{
			System.out.println("Usuario não direcionando para a pagina ./adicionarUsuario.xhtml");
			NavigationHandler nav = app.getNavigationHandler();
			nav.handleNavigation(fc, "", "index?faces-redirect=true");
			fc.renderResponse();
		}
	 }
		
		if("/deletarDono.xhtml".equals( nomePagina)){
			Application app = fc.getApplication();
			LoginMB login = app.evaluateExpressionGet(
					fc, "#{loginMB}", LoginMB.class);
			if (login.isPerm()&& login.isLogado() ) { 
				System.out.println("Usuario pode prosseguir");
//			NavigationHandler nav = app.getNavigationHandler();
//			nav.handleNavigation(fc, "", "deletarDono?faces-redirect=true");
//			fc.renderResponse();
			System.out.println("teste");
			}
		else{
			System.out.println("Usuario não direcionando para a pagina ./adicionarUsuario.xhtml");
			NavigationHandler nav = app.getNavigationHandler();
			nav.handleNavigation(fc, "", "index?faces-redirect=true");
			fc.renderResponse();
		}
	 }
										
	}

	@Override
	public void beforePhase(PhaseEvent e) {
	}
	
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
	

}
