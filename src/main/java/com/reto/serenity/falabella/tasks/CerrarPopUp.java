package com.reto.serenity.falabella.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.reto.serenity.falabella.userinterfaces.UiPopUp.BOTON_NO;
import static com.reto.serenity.falabella.userinterfaces.UiPopUp.CONTENEDOR_PADRE;

public class CerrarPopUp implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebElement root = driver.findElement(By.cssSelector(CONTENEDOR_PADRE()));
        SearchContext shadowRootTwo = root.getShadowRoot();
        WebElement nestedText = shadowRootTwo.findElement(By.cssSelector(BOTON_NO()));
        nestedText.click();
    }

    public static CerrarPopUp enLaPantalla(){
        return Instrumented.instanceOf(CerrarPopUp.class).withProperties();
    }
}
