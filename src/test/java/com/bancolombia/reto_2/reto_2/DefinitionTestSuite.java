package com.bancolombia.reto_2.reto_2;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/despegar/buscar_tiquetes.feature")
public class DefinitionTestSuite {}
