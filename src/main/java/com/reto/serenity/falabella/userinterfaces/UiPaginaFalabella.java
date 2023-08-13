package com.reto.serenity.falabella.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.falabella.com.co/falabella-co")
public class UiPaginaFalabella extends PageObject {
    public static final Target BTN_MENU = Target.the("Boton hamburgesa").located(By.id("testId-HamburgerBtn-toggle"));
}
