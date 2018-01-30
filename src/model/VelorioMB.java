package model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;


import dao.DAOException;
import dao.VelorioDAO;
import dao.VelorioDAOImpl;
import entidades.Velorio;

@ManagedBean
@ViewScoped
public class VelorioMB implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Velorio velorio = new Velorio();;
	private ScheduleModel eventModel;
	private List<Velorio> lista = new ArrayList<Velorio>();
	private VelorioDAO dao = new VelorioDAOImpl();
	
	@PostConstruct
	public void inicializar(){
		velorio = new Velorio();
		eventModel = new DefaultScheduleModel();
		
		
			try {
				lista = dao.pesquisarTudo();
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO","Erro no Banco"));
			}
			
			for(Velorio vel : lista){
				DefaultScheduleEvent evt = new DefaultScheduleEvent();
				evt.setEndDate(vel.getDiaFim());
				evt.setStartDate(vel.getDia());
				//evt.setStartDate(vel.getHoraInicio());
				//evt.setEndDate(vel.getHoraFim());
				evt.setData(vel.getId());
				evt.setTitle(vel.getNomeFalecido());
				//evt.setTitle(vel.getNomeDeclarante());
				evt.setDescription(vel.getCpfFalecido());
				//evt.setDescription(vel.getCpfDeclarante());
				evt.setAllDay(true);
				evt.setEditable(true);
				
				Date data = new Date(System.currentTimeMillis());
				if(vel.isStatus() == true || vel.getDiaFim().before(data) ){
					evt.setStyleClass("#006600");
				}else if(vel.isStatus() == false || vel.getDiaFim().after(data) ){
					evt.setStyleClass("emp2");
				}
				
				eventModel.addEvent(evt);
				
			}
			
		
		
	}
	
	public void selecionarEvento(SelectEvent selectEvent){
		
		ScheduleEvent evt = (ScheduleEvent) selectEvent.getObject();
		
		for(Velorio vel : lista){
			if(vel.getId() == (Long) evt.getData()){
				velorio =  vel;
				break;
				
			}
		}
	}
	
	public void novoEvento(SelectEvent selectEvent){
		ScheduleEvent evt = new DefaultScheduleEvent("",(Date)selectEvent.getObject(),(Date)selectEvent.getObject());
	    velorio = new Velorio();
	    velorio.setDia(new java.sql.Date(evt.getStartDate().getTime()));
	    velorio.setDiaFim(new java.sql.Date(evt.getEndDate().getTime()));
		
	}
	
	public String adicionar() throws DAOException {;
	dao.adicionar(velorio);
	System.out.println(velorio.getNomeFalecido());
	velorio = new Velorio();
	inicializar();
	return "";
}
	
	public void salvar(){
			
		if(velorio.getId() == null){
			if(velorio.getDia().getTime() <= velorio.getDiaFim().getTime()){
				dao = new VelorioDAOImpl();
				try {
					dao.adicionar(velorio);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES,"Adicionado com sucesso"));
					inicializar();
				} catch (DAOException e) {
//					FacesContext context = FacesContext.getCurrentInstance();
//			        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar no banco ", null));
			    	
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO","Erro ao salvar no banco"));
					
				}
				velorio = new Velorio();
			}else{
//				FacesContext context = FacesContext.getCurrentInstance();
//		        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data Fim menor que Data início ", null));
		    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO","Data Fim menor que Data início"));
//		    	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", null);
//		         
//		        context.addMessage(null, message);;
		}
			
		}else{
			try {
				dao.atualizar(velorio);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES,"Atualizado com sucesso"));
				inicializar();
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO","Erro ao atualizar"));
				
			}
			velorio = new Velorio();
		}
	}
	
	public void eventMove(ScheduleEntryMoveEvent evtMove ){
		for(Velorio vel : lista){
			if(vel.getId() == (Long) evtMove.getScheduleEvent().getData()){
				velorio = vel;
				try {
					dao.atualizar(velorio);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES,"Atualizado com sucesso"));
					inicializar();
				} catch (DAOException e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO","Erro ao salvar"));
					
				}
				break;
				
			}
		}
		
	}
	
	public void eventResize(ScheduleEntryResizeEvent evtMove ){
		for(Velorio vel : lista){
			if(vel.getId() == (Long) evtMove.getScheduleEvent().getData()&& velorio.getDia().getTime() <= velorio.getDiaFim().getTime()){
				velorio = vel;
				try {
					dao.atualizar(velorio);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES,"Atualizado com sucesso"));
					inicializar();
				} catch (DAOException e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO","Erro ao salvar"));
					
				}
				break;
				
			}
		}
		
	}
	
	
	public Velorio getVelorio() {
		return velorio;
	}
	public void setVelorio(Velorio velorio) {
		this.velorio = velorio;
	}
	public ScheduleModel getEventModel() {
		return eventModel;
	}
	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}
	public List<Velorio> getLista() {
		return lista;
	}
	public void setLista(List<Velorio> lista) {
		this.lista = lista;
	}
	public VelorioDAO getDao() {
		return dao;
	}
	public void setDao(VelorioDAO dao) {
		this.dao = dao;
	}
	
	

	   

}
