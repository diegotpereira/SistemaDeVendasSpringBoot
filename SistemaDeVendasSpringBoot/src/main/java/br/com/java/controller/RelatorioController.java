package br.com.java.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.java.service.impl.ClienteReportService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
@RequestMapping("/relatorios")
public class RelatorioController {
	
	@Autowired
	private ClienteReportService service;
	
	@GetMapping("/report")
	public String generateReport() {
		
		return service.generateReport();
	}
	
//	@Autowired
//	private DataSource dataSource;
	
//	@GetMapping("/index")
//	public String relatorio() {
//		
//		return "/relatorios/index";
//	}
//	
//	@PostMapping
//	public void imprimir(@RequestParam Map<String, Object> parametros, HttpServletResponse response) throws JRException, SQLException, IOException{
//		
//		parametros = parametros == null ? parametros = new HashMap<>() : parametros;
//		
//		// Pega o arquivo .jasper localizado na pasta resources
//		InputStream jasperStream = this.getClass().getResourceAsStream("/relatorios/clientes.jasper");
//		
//		// Cria o objeto JasperReport com o Stream do arquivo jasper da pasta resource.
//		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
//		
//		// Passa para o JasperPrint o relatório, os parâmetros e a fonte dos dados, 
//		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperStream, parametros, dataSource.getConnection());
//		
//		// Configura a reposta para o tipo PDF
//		response.setContentType("application/pdf");
//		
//		// Define que o arquivo pode ser visualizado no navegador e também nome final do arquivo
//		// para fazer download do relatório troque 'inline' por 'attachment'
//		response.setHeader("Content-Disposition", "inline; filename = ClienteService.pdf");
//		
//		// Faz a exportação do relatório para o HttpServletResponse
//		final OutputStream outStream = response.getOutputStream();
//		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
//	}
}
