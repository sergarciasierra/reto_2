package com.bancolombia.reto_2.reto_2.steps;

import org.fluentlenium.core.annotation.Page;

import com.bancolombia.reto_2.reto_2.pages.HomePages;

import net.thucydides.core.annotations.Step;

public class BuscarTiquetesSteps {
	
	@Page
	HomePages home;
	
	@Step 
	public void AbrirNavegador(String pagina) {
		home.openUrl(pagina);
	}
	
	@Step
	public void escogerVuelo(String origen, String destino, String viajeros, String fecha_inicio, String fecha_fin) throws InterruptedException {
		home.getDriver().manage().window().maximize();
		home.ingresarVuelo(origen,destino,viajeros,fecha_inicio,fecha_fin);
	}

}
