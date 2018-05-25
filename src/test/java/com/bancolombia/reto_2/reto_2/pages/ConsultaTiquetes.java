package com.bancolombia.reto_2.reto_2.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.findby.By;

public class ConsultaTiquetes extends PageObject {
	
	public String traerTitulo(){
		return getDriver().getTitle();	
		
	}

	// Devuelve en un vector los 10 tiquetes más baratos de la consulta 
	public String[] masBaratos () {
		String[] tiquete = new String[11];

		for (int i=0 ; i < 11; i++) {
			try {
				tiquete[i] = getDriver().findElement(By.xpath("//*[@id=\"clusters\"]/span[" + (i+1) +"]/span/cluster/div/div/span/fare/span/span/div[1]/item-fare/p/span/flights-price/span/flights-price-element/span/span/em/span[2]")).getText();
				System.out.println("Tiquete: " + i + " Valor: " + tiquete[i]);
			}catch(Exception e) {
			}
		}

		return tiquete;
		
	}
	
}
