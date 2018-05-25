package com.bancolombia.reto_2.reto_2.steps;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

import com.bancolombia.reto_2.reto_2.pages.ConsultaTiquetes;
import com.bancolombia.reto_2.reto_2.pages.HomePages;
import com.bancolombia.reto_2.utilidades.*;

import net.thucydides.core.annotations.Step;

public class BuscarTiquetesSteps {
	
	@Page
	HomePages home;
	ConsultaTiquetes consultar;
	
	@Step 
	public void AbrirNavegador(String pagina) {
		home.openUrl(pagina);
	}
	
	@Step
	public void escogerVuelo(String origen, String destino, String viajeros, String anio_mes_inicio, String dia_inicio, String anio_mes_fin, String dia_fin) throws InterruptedException, IOException {
		home.getDriver().manage().window().maximize();
		home.ingresarVuelo(origen,destino,viajeros,anio_mes_inicio,dia_inicio,anio_mes_fin,dia_fin);
	}
	
	@Step
	public void consultar() {
		assertEquals("Datos de búsqueda no válidos","Despegar.com . Resultados de Vuelos", consultar.traerTitulo());
	}
		
	@Step
	public void GuardarExcel() throws Exception {
		ExcelHtas.escribirExcel(home.masBaratos());
	    
	}

}
