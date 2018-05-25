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

	@When("^El usuario selecciona (.*), (.*), (.*), (.*), (.*), (.*), (.*) y da clic en buscar$")
	public void el_usuario_selecciona_Medellín_Cartagena_y_da_clic_en_buscar
		(String origen, String destino, String viajeros, String anio_mes_inicio, String dia_inicio, String anio_mes_fin, String dia_fin) throws InterruptedException {
	    	buscarTiquetes.escogerVuelo(origen,destino,viajeros,anio_mes_inicio,dia_inicio,anio_mes_fin,dia_fin);
	}
	
	@Then("^el usuario ve la lista de vuelos disponibles$")
	public void el_usuario_ve_la_lista_de_vuelos_disponibles() throws Exception {
	    buscarTiquetes.consultar();
	}

	@Then("^se almacena en un archivo de Excel los siete vuelos mas baratos y se marca en verde el precio más económico$")
	public void se_almacena_en_un_archivo_de_Excel_los_siete_vuelos_mas_baratos_y_se_marca_en_verde_el_precio_más_económico() throws Exception {
	    buscarTiquetes.GuardarExcel();
	}
	
}
