package com.bancolombia.reto_2.reto_2.definitions;

import com.bancolombia.reto_2.reto_2.steps.BuscarTiquetesSteps;

import cucumber.api.PendingException; 
import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Steps;

public class BuscarTiquetesDefinitions {

	@Steps
	BuscarTiquetesSteps buscarTiquetes;
	
	@Given("^El usuario se encuentra en la (.*)$")
	public void el_usuario_se_encuentra_en_la_pagina(String pagina) throws Exception {
	   buscarTiquetes.AbrirNavegador(pagina);
	}


	@When("^El usuario selecciona (.*), (.*), (.*), (.*), (.*) y da clic en buscar$")
	public void el_usuario_selecciona_Medellín_Cartagena_y_da_clic_en_buscar(String origen, String destino, String viajeros, String fecha_inicio, String fecha_fin) throws InterruptedException {
	    	buscarTiquetes.escogerVuelo(origen,destino,viajeros,fecha_inicio,fecha_fin);
	}

	@Then("^el usuario ve la lista de vuelos disponibles$")
	public void el_usuario_ve_la_lista_de_vuelos_disponibles() throws Exception {
	    buscarTiquetes.consular();
	}

	@Then("^se genera un archivo Excel con los (\\d+) vuelos mas baratos y se marca en verde el precio mas economico$")
	public void se_genera_un_archivo_Excel_con_los_vuelos_mas_baratos_y_se_marca_en_verde_el_precio_mas_economico(int arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
