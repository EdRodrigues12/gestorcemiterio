package model;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.record.formula.functions.T;

import com.lowagie.text.pdf.codec.Base64.InputStream;
import com.mysql.jdbc.Connection;


import dao.DBResourceManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class Relatorio {

	private HttpServletResponse response;
	private FacesContext context;
	private ByteArrayOutputStream baos;
	private InputStream stream;
	String rua;
	
	
	public Relatorio() {
		this.context = FacesContext.getCurrentInstance();
		this.response = (HttpServletResponse) this.context.getExternalContext().getResponse();
	}
	
	
	public void getRelatorio(){
		String stream = ("WEB-INF/reports/jazigoPorRua.jasper");
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("rua", rua);
		baos = new ByteArrayOutputStream();
		try{
			
			JasperReport jasper = (JasperReport) JRLoader.loadObjectFromFile(stream);
			JasperPrint print = JasperFillManager.fillReport(jasper, param, new DBResourceManager().getCon());
			
			JasperExportManager.exportReportToPdfStream(print, baos);
			
			//response.reset();
			
			response.setContentType("application/pdf");
			
			response.setContentLength(baos.size());
			
			//response.setHeader("Content-disposition","inline; filename=relatorio.pdf");
			
			response.getOutputStream().write(baos.toByteArray());
			
			response.getOutputStream().flush();
			
			response.getOutputStream().close();
			
			context.responseComplete();
			//ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			//JRBeanCollectionDataSource datasrc = new JRBeanCollectionDataSource(lista);
			
			
			
			//para usar JavaBeanDataSource define 'datasrc' como datasource
			
			
			//closeConnection();
			
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro ao gerar o relatorio!"));
		}
		
	}
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}
}
