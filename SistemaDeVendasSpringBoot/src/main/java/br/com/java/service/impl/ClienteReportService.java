package br.com.java.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.dao.impl.ReportRepository;
import br.com.java.model.Cliente;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ClienteReportService {
	
	@Autowired
	private ReportRepository reportRepository;
	
	public String generateReport() {
		
		try {
			List<Cliente> clientes = reportRepository.findAll();
			
			String reportPath = "br/com/java/relatorio/";
			
			// Compile o relatório Jasper de .jrxml para .japser
			JasperReport jasperReport = JasperCompileManager
					.compileReport(reportPath + "clientes.jrxml");
			
			// Obtenha sua fonte de dados
			JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(clientes);
			
			// Adiciona Paramêtros
			Map<String, Object> parameters = new HashMap<>();

			parameters.put("createdBy", "Websparrow.org");
			
			// Preenche o relatório
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrBeanCollectionDataSource);
			
			// Exporta o relatório para um arquivo PDF
			JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "C:/Users/T.I/Documents/RelatoriosJasper/relatorios/clientes.pdf");
			
			System.out.println("Realizado");
			
			return "Report successfully generated @path= " + reportPath;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Error--> verifique o log do console";
		}
	}
}
