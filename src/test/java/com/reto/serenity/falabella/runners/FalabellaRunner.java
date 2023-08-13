package com.reto.serenity.falabella.runners;



import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features/seleccionar_articulos.feature",
        tags = "@smokTestAgregaProduto",
        glue = {"com.reto.serenity.falabella.stepdefinitions","com.reto.serenity.falabella.conf"},
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"},
        publish = true
)
public class FalabellaRunner {
    public FalabellaRunner(){}
}
