package com.bancolombia.reto_2.reto_2.steps;

import static org.junit.Assert.assertEquals;

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
	public void escogerVuelo(String origen, String destino, String viajeros, String fecha_inicio, String fecha_fin) throws InterruptedException {
		home.getDriver().manage().window().maximize();
		home.ingresarVuelo(origen,destino,viajeros,fecha_inicio,fecha_fin);
	}
	
	@Step
	public void consultar() {
		assertEquals("Datos de búsqueda no válidos","Despegar.com . Resultados de Vuelos", consultar.traerTitulo());
		//consultar.tatat(); //otor metodo
	}
	
	@Test
	public void pruebaExcel() throws Exception {
		//Ruta del Excel

		/*
		String ruta = "C:\\Users\\sergarci\\Documents\\Listado_Vuelos.xlsx";
		String rutaSalida = "C:\\Users\\sergarci\\Documents\\Listado_Vuelos2.xlsx";
//		System.out.print("Prueba");
	    ExcelHtas.AbrirExcel(ruta, "Hoja1");
	    String var = ExcelHtas.TraerValorCelda(0,0);
	    System.out.println("Valor celda 0,0: "+ var);
		ExcelHtas.PonerValorCelda(rutaSalida,"Hola", 6, 6);
		var = ExcelHtas.TraerValorCelda(6,6);
	    System.out.println("Valor celda 6,6: "+ var);
	    */
		String [] vector = new String [10];
		vector[0]= "Siiiii";
		vector[1]= "Hola 1xx";
		ExcelHtas.escribirExcel(vector);
	    
	}

}
