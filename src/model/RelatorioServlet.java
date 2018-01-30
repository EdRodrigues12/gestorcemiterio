package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.pdf.codec.Base64.InputStream;

import dao.DBResourceManager;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * Servlet implementation class RelatorioServlet
 */
@ManagedBean
@WebServlet("/relatorio")
public class RelatorioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RelatorioServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		try {
			geraRelatorio(request,response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	protected void geraRelatorio(HttpServletRequest request, HttpServletResponse response
			)throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String erro = "";
		
		String empresa = request.getParameter("empresa");
		//InputStream jasper = (InputStream) this.getClass().getResourceAsStream("WEB-INF/reports/jazigoPorRua.jasper");
		
		String jasper = "WEB-INF/reports/jazigoPorRua.jasper";
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("empresa", empresa);
		byte[]bytes = null;
		ServletContext contexto = getServletContext();
		
		try {
			
			JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile
			(contexto.getRealPath(jasper));
			
			bytes = JasperRunManager.runReportToPdf(relatorio, param, new DBResourceManager().getCon());
		} catch (JRException e) {
		
			e.printStackTrace();
		}finally{
			if(bytes != null){
				response.setContentType("application/pdf");
				response.setContentLength(bytes.length);
				ServletOutputStream sos = response.getOutputStream();
				sos.write(bytes);
				sos.flush();
				sos.close();
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("jazigoPorRua.xhtml");
				request.setAttribute("erro", erro);
		
				
			}
		}
		
	}

}
