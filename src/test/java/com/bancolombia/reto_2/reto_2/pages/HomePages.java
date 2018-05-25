package com.bancolombia.reto_2.reto_2.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.findby.By;

public class HomePages extends PageObject {
	public String[] tiquetes = new String[11];
	
	
	
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

	@FindBy(xpath = "//div[@class=\"sbox-places-dates-distri-button-container\"]//div[contains(@class,\"hotel-passengers-input\")]")
	private WebElement pasajerosTxt;
	
	@FindBy(xpath = "//div[3]/div/div[1]/div[2]/div/div[1]/div/div[1]//a[contains (@class,\"right\")]")
	private WebElement unoMas;
	
	@FindBy(xpath = "//div[@class=\"sbox-places-dates-distri-button-container\"]/div[4]//a")
	private WebElement buscar;

	@FindBy(xpath = "//div[@class=\"geo-autocomplete geo-show-autocomplete\"]//li[@data-index=\"1\"]/a")
	private List<WebElement> listaCiudad;
	
	@FindBy(xpath = "//div[@class=\"ac-group-container\"]/ul[@class=\"ac-group-items\"]/li[@class=\"item -active\"]/span")
	private List<WebElement> listaCiudad2;
	
	@FindBy(xpath = "//div[@class=\"geo-autocomplete geo-show-autocomplete\"]//li[@data-index=\"1\"]/a")
	private List<WebElement> listaDestino;
	
//	@FindBy(xpath = "//div[@class = \"_dpmg2--months\"]/div[contains(@class,\"month-active\") and @data-month=\"2018-06\"]/div[@class=\"_dpmg2--dates\"]/span[text()=\"1\"]")
//	private WebElement diaInicio;
	
//	@FindBy(xpath = "//div[@class = \"_dpmg2--months\"]/div[contains(@class,\"month-active\") and @data-month=\"2018-06\"]/div[@class=\"_dpmg2--dates\"]/span[text()=\"30\"]")
//	private WebElement diaFin;
	
	@FindBy(xpath = "//div[@class=\"_dpmg2--controlsWrapper\"]//div[@class=\"_dpmg2--controls-next\"]")
	private WebElement mesProx;
		
	@FindBy(xpath = "//div[@data-month = \"2018-09\"]//span[@class=\"_dpmg2--date _dpmg2--available _dpmg2--nights-tooltip _dpmg2--days--modifier\"][30]")
	private WebElement fechaFin;
	
	public void ingresarVuelo(String origen, String destino, String viajeros, String anio_mes_inicio, String dia_inicio, String anio_mes_fin, String dia_fin)
			throws InterruptedException, IOException {	
	
		try {
			cerrar.click();
		} catch (Exception e) {
		}
		Thread.sleep(3000);
		vuelo.click();
		Thread.sleep(2000);
		
// Ciudad origen	
		origenTxt.clear();
		origenTxt.sendKeys(origen);
		Thread.sleep(2000);
		try {
			listaCiudad.get(0).click();
		} catch (Exception e) {
			listaCiudad2.get(0).click();
		}
		Thread.sleep(2000);
		
// Ciudad destino
		destinoTxt.clear();
		destinoTxt.sendKeys(destino);
		Thread.sleep(2000);
		try {
			listaCiudad.get(0).click();
		} catch (Exception e) {
			listaCiudad2.get(0).click();
		}
		
// Fecha inicial
		inicioTxt.click();
		Thread.sleep(500);
		if (seleccionarFecha(anio_mes_inicio))
		{
			dia(anio_mes_inicio,dia_inicio).click();
		};
//		Thread.sleep(3000);

// Fecha final
//		finTxt.click();
		Thread.sleep(500);
		if (seleccionarFecha(anio_mes_fin))
		{
			dia(anio_mes_fin,dia_fin).click();
		};
		Thread.sleep(1000);
		
//Pasajeros
		pasajerosTxt.click();
		unoMas.click();


//Búsqueda de tiquetes con los parámetros ingresados
		buscar.click();
		Thread.sleep(8000);
		
//Consulta de tiquetes
//		tiquetes = masBaratos();
//		ExcelHtas.escribirExcel(tiquetes);
		
// Guardar en Excel
		
		
	}
	
// Seleccionar en el calendario el mes de la fecha inicio y de la fecha fin de la consulta
public  boolean seleccionarFecha (String anioMes) throws InterruptedException {
	Thread.sleep(1000);
	for (int i=1 ; i <= 12; i++) {
//		System.out.println("Contador: " + i);
		try {
			getDriver().findElement(By.xpath("//div[@class = \"_dpmg2--months\"]/div[contains(@class,\"month-active\") and @data-month=\""+anioMes+"\"]")).isEnabled();
			return true;
		}catch(Exception e) {
			mesProx.click();
		}
	}
	return false;
 	
}

// Elemento web para clic en el diaInicio y en el diaFin
public  WebElement dia(String anioMes, String dia) throws InterruptedException {
	WebElement miXpath;
			miXpath = getDriver().findElement(By.xpath("//div[@class = \"_dpmg2--months\"]/div[contains(@class,\"month-active\") and @data-month=\""+anioMes+"\"]/div[@class=\"_dpmg2--dates\"]/span[text()=\""+dia+"\"]"));
			return miXpath;	
}

/*
//Elemento web para diaFin
public  WebElement diaFin(String anioMes, String dia) throws InterruptedException {
	WebElement miXpath;
			miXpath = getDriver().findElement(By.xpath("//div[@class = \"_dpmg2--months\"]/div[contains(@class,\"month-active\") and @data-month=\"2018-06\"]/div[@class=\"_dpmg2--dates\"]/span[text()=\"30\"]"));
			return miXpath;	
}

//@FindBy(xpath = "//div[@class = \"_dpmg2--months\"]/div[contains(@class,\"month-active\") and @data-month=\"2018-06\"]/div[@class=\"_dpmg2--dates\"]/span[text()=\"30\"]")
//private WebElement diaFin;
*/

// Devuelve en un vector los 10 tiquetes más baratos de la consulta 
public String[] masBaratos () {
	String[] tiquete = new String[11];

	for (int i=1 ; i <= 11; i++) {
		try {
			tiquete[i] = getDriver().findElement(By.xpath("//*[@id=\"clusters\"]/span[" + i +"]/span/cluster/div/div/span/fare/span/span/div[1]/item-fare/p/span/flights-price/span/flights-price-element/span/span/em/span[2]")).getText();
			System.out.println("Tiquete: " + i + " Valor: " + tiquete[i]);
		}catch(Exception e) {
		}
	}

	return tiquete;
	
}


}
