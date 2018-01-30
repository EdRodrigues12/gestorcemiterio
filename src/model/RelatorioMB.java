package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dao.DAOException;
import dao.DBResourceManager;
import dao.JazigoDAO;
import dao.JazigoDAOImpl;
import entidades.Jazigo;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


@ManagedBean
@SessionScoped
public class RelatorioMB {
	
	private JazigoDAO jazigoDao = new JazigoDAOImpl();
	private Jazigo jazigo = new Jazigo();
	private List<Jazigo> lista = new ArrayList<Jazigo>();
	String rua;
	String causaMorte;
	String mes;
	String dia;


	

	public String pesquisar() throws DAOException {
		setLista(jazigoDao.pesquisarRua(jazigo.getRua()));
		return "";
	}
	
	public String gera() throws DAOException, JRException{

		
		return "";
	}
	
		
	public void geraJazigo() throws ServletException, IOException, ClassNotFoundException, SQLException{
//			FacesContext facesContext = FacesContext.getCurrentInstance();
//	        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
//	        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
//	        String erro = "";
//		
//		String jasper = "WEB-INF/reports/jazigoPorRua.jasper";
//		HashMap<String, Object> param = new HashMap<String, Object>();
//		param.put("rua",this.rua);
//		byte[]bytes = null;
//		ServletContext contexto = (ServletContext)facesContext.getExternalContext().getContext();;
//		
//		try {
//			JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile
//			(contexto.getRealPath(jasper));
//			bytes = JasperRunManager.runReportToPdf(relatorio, param, new DBResourceManager().getCon());
//		} catch (JRException e) {
//		
//			e.printStackTrace();
//		}finally{
//			if(bytes != null){
//				response.setContentType("application/pdf");
//				response.setContentLength(bytes.length);
//				ServletOutputStream sos = response.getOutputStream();
//				sos.write(bytes);
//				sos.flush();
//				sos.close();
//			}else{
//				RequestDispatcher rd = request.getRequestDispatcher("jazigoPorRua.xhtml");
//				((ServletContext) rd).setAttribute("erro", erro);
//				
//			}
//		}
		 ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	        ServletContext context = (ServletContext) externalContext.getContext();
	        String arquivo = "/WEB-INF/reports/jazigoPorRua.jasper";
	        OutputStream servletOutputStream = null;
	        FacesContext contexte = FacesContext.getCurrentInstance();
	        HttpServletResponse response = (HttpServletResponse) contexte.getExternalContext().getResponse();
	        HashMap<String, Object> param = new HashMap<String, Object>();
	        param.put("rua",this.rua);
			byte[]bytes = null;
			
			
        	try {
        		JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile
        			(context.getRealPath(arquivo));
				bytes = JasperRunManager.runReportToPdf(relatorio, param, new DBResourceManager().getCon());
			} catch (JRException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
	        try {
	        	response.setContentType("application/pdf");
	        	response.setContentLength(bytes.length);
	        	servletOutputStream = response.getOutputStream();	        	          
		        servletOutputStream.write(bytes);
	            servletOutputStream.flush();
	            servletOutputStream.close();
	            contexte.renderResponse();
	            contexte.responseComplete();
	            System.out.println("Sem erro");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
		
	}
	
	public void geraCausaFalecimento() throws IOException, ClassNotFoundException, SQLException{
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        ServletContext context = (ServletContext) externalContext.getContext();
        String arquivo = context.getRealPath("/WEB-INF/reports/causaFalecimento.jasper");
        OutputStream servletOutputStream = null;
        FacesContext contexte = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) contexte.getExternalContext().getResponse();
        HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("causaMorte",this.causaMorte);
        try {
			JasperRunManager.runReportToPdfStream(new FileInputStream(new File(arquivo)),response.getOutputStream(), param, new DBResourceManager().getCon());
		} catch (JRException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
            
		try {
            response.setContentType("application/pdf");
            contexte.responseComplete();
            servletOutputStream = response.getOutputStream();
            servletOutputStream.flush();
            servletOutputStream.close();
            contexte.renderResponse();
            contexte.responseComplete();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
//		try{
//            FacesContext context = FacesContext.getCurrentInstance();    
//            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();    
//            String caminhoRelatorio = servletContext.getRealPath("relatorios/folhaPonto.jasper");    
//            System.out.println("caminhoRelatorio :"+caminhoRelatorio);
//            HashMap<String, Object> param = new HashMap<String, Object>();
//            param.put("causaMorte",this.causaMorte);
//            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();    
//            response.setContentType("application/pdf");    
//            response.addHeader("Content-disposition", "attachment; filename=\"FolhaPonto.pdf\"");    
//            JasperPrint impressao = JasperFillManager.fillReport(caminhoRelatorio, param, new DBResourceManager().getCon());    
//            System.out.println("impressao :"+impressao);
//            JasperExportManager.exportReportToPdfStream(impressao, response.getOutputStream());                        
//            context.getApplication().getStateManager().saveView(context);    
//            context.renderResponse();
//            context.responseComplete();                                                            
//        }catch(Exception e){
//        }
		
	}
	public void geraExumacaoMes() throws IOException, ClassNotFoundException, SQLException{
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        ServletContext context = (ServletContext) externalContext.getContext();
        String arquivo = context.getRealPath("WEB-INF/reports/DataExumacao.jasper");
        OutputStream servletOutputStream = null;
        FacesContext contexte = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) contexte.getExternalContext().getResponse();
        HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("mes",this.mes);
        try {
            servletOutputStream = response.getOutputStream();
            JasperRunManager.runReportToPdfStream(new FileInputStream(new File(arquivo)),response.getOutputStream(), param, new DBResourceManager().getCon());
            response.setContentType("application/pdf");
            servletOutputStream.flush();
            servletOutputStream.close();
            contexte.renderResponse();
            contexte.responseComplete();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	public void geraFalecidoMes() throws IOException, ClassNotFoundException, SQLException{
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        ServletContext context = (ServletContext) externalContext.getContext();
        String arquivo = context.getRealPath("WEB-INF/reports/falecidoPorMes.jasper");
        OutputStream servletOutputStream = null;
        FacesContext contexte = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) contexte.getExternalContext().getResponse();
        HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("mes",this.mes);
        try {
            servletOutputStream = response.getOutputStream();
            JasperRunManager.runReportToPdfStream(new FileInputStream(new File(arquivo)),response.getOutputStream(), param, new DBResourceManager().getCon());
            response.setContentType("application/pdf");
            servletOutputStream.flush();
            servletOutputStream.close();
            contexte.renderResponse();
            contexte.responseComplete();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	public void geraVelorioDia() throws IOException, ClassNotFoundException, SQLException{
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        ServletContext context = (ServletContext) externalContext.getContext();
        String arquivo = context.getRealPath("WEB-INF/reports/velorioDia.jasper");
        OutputStream servletOutputStream = null;
        FacesContext contexte = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) contexte.getExternalContext().getResponse();
        HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("dia",this.dia);
        try {
            servletOutputStream = response.getOutputStream();
            JasperRunManager.runReportToPdfStream(new FileInputStream(new File(arquivo)),response.getOutputStream(), param, new DBResourceManager().getCon());
            response.setContentType("application/pdf");
            servletOutputStream.flush();
            servletOutputStream.close();
            contexte.renderResponse();
            contexte.responseComplete();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
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
	
	public String getCausaMorte() {
		return causaMorte;
	}

	public void setCausaMorte(String causaMorte) {
		this.causaMorte = causaMorte;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}
	
}
