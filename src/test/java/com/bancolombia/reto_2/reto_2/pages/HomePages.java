package com.bancolombia.reto_2.reto_2.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.findby.By;

public class HomePages extends PageObject {

	@FindBy(xpath = "//div[@class=\"nevo-header-navigation\"]//span[text()=\"Vuelos\"]")
	private WebElement vuelo;
	@FindBy(xpath = "//span[@class=\"as-login-close as-login-icon-close-circled\"]")
	private WebElement cerrar;

	@FindBy(xpath = "//div[@class=\"sbox-places-dates-distri-button-container\"]//input[contains(@class,\"origin\") and not(contains(@class,\"segment\"))]")
	private WebElement origenTxt;

	@FindBy(xpath = "//div[@class=\"sbox-places-dates-distri-button-container\"]//input[contains(@class,\"destination\") and not(contains(@class,\"segment\"))]")
	private WebElement destinoTxt;

	@FindBy(xpath = "//div[@class=\"sbox-places-dates-distri-button-container\"]//input[contains(@class,\"disable-start-date\")]")
	private WebElement inicioTxt;

	@FindBy(xpath = "//div[@class=\"sbox-places-dates-distri-button-container\"]//input[contains(@class,\"disable-end-date\")]")
	private WebElement finTxt;

	@FindBy(xpath = "//div[@class=\"sbox-places-dates-distri-button-container\"]//input[contains(@class,\"disable-passengers\")]")
	private WebElement pasajerosTxt;

	@FindBy(xpath = "//div[@class=\"sbox-places-dates-distri-button-container\"]//input[contains(@class,\"disable-passengers\")]")
	private WebElement buscar;

	@FindBy(xpath = "//div[@class=\"geo-autocomplete geo-show-autocomplete\"]//li[@data-index=\"1\"]/a")
	private List<WebElement> listaOrigen;

	@FindBy(xpath = "//div[@class=\"geo-autocomplete geo-show-autocomplete\"]//li[@data-index=\"1\"]/a")
	private List<WebElement> listaDestino;
	
//	@FindBy(xpath = "//div[@data-month = \"2018-09\"]//span[@class=\"_dpmg2--date _dpmg2--available _dpmg2--nights-tooltip _dpmg2--days--modifier\"][1]")
//	@FindBy(xpath = "//div[@data-month = \"2018-09\"]//span[@class=\"_dpmg2--date _dpmg2--available _dpmg2--days--modifier\"][1]")
//	@FindBy(xpath = "//div[@data-month = \"2018-09\"]//span[@class=\"_dpmg2--date _dpmg2--available _dpmg2--days--modifier _dpmg2--nights-tooltip _dpmg2--date-range\"][1]")
	@FindBy(xpath = "//div[@data-month = \"2018-09\"]//span[@class=\"//div[@data-month = \"2018-09\"]//span[@class=\"_dpmg2--date _dpmg2--available _dpmg2--days--modifier _dpmg2--range-start _dpmg2--nights-tooltip\"]")
		
	private WebElement fechaInicio;
	
	@FindBy(xpath = "//div[@class=\"_dpmg2--controlsWrapper\"]//div[@class=\"_dpmg2--controls-next\"]")
	private WebElement mesProx;
		
	@FindBy(xpath = "//div[@data-month = \"2018-09\"]//span[@class=\"_dpmg2--date _dpmg2--available _dpmg2--nights-tooltip _dpmg2--days--modifier\"][30]")
	private WebElement fechaFin;
	
	public void ingresarVuelo(String origen, String destino, String viajeros, String fecha_inicio, String fecha_fin)
			throws InterruptedException {

		
		
		try {
			cerrar.click();
		} catch (Exception e) {
		}
		Thread.sleep(3000);
		vuelo.click();
		Thread.sleep(2000);
		origenTxt.clear();
		origenTxt.sendKeys(origen);
		Thread.sleep(2000);
		listaOrigen.get(0).click();
		Thread.sleep(2000);
		
//		System.out.println("Cantidad de ciudades: " + listaOrigen.size());
//		System.out.println("Primera: " + listaOrigen.get(0));
//		System.out.println("Segunda: " + listaOrigen.get(1));

		destinoTxt.clear();
		destinoTxt.sendKeys(destino);
		Thread.sleep(2000);
		listaOrigen.get(0).click();
		
		inicioTxt.click();
		Thread.sleep(2000);
	
		seleccionarFecha("2018-12");
		
		Thread.sleep(2000);
		
//		fechaInicio.isEnabled();
	
		fechaInicio.click();
		
		Thread.sleep(2000);
//		finTxt.click();
		
		
//		buscar.click();
		Thread.sleep(5000);
	}
	
	
public  boolean seleccionarFecha (String anioMes) throws InterruptedException {
//	Thread.sleep(1000);
	for (int i=1 ; i <= 12; i++) {
		System.out.println("Contador: " + i);
		try {
			getDriver().findElement(By.xpath("//div[@class = \"_dpmg2--months\"]/div[contains(@class,\"month-active\") and @data-month=\""+anioMes+"\"]")).isEnabled();
			return true;
		}catch(Exception e) {
			mesProx.click();
		}
	}
	return false;
 	
}


}
