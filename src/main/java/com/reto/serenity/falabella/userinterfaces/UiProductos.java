package com.reto.serenity.falabella.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UiProductos {
    public static final Target CONTENEDOR_PADRE = Target.the("").locatedBy("//div[@class='jsx-200723616 search-results-4-grid grid-pod' or @class='jsx-200723616 search-results-list']");
    public static final Target LINK_TITLE = Target.the("").locatedBy("//b[contains(@id,'testId-pod-displaySubTitle') and contains(text(),'{0}')]");
    public static final Target LBL_PRESIO = Target.the("").locatedBy("//span[contains(text(),'$')]");
    public static final Target BTN_AGREGAR = Target.the("").located(By.id("add-to-cart-button"));
    public static final Target BTN_INCREMENTAR = Target.the("Boton incrementar").located(By.id("quantity-selector-increment-btn"));
    public static final Target BTN_SEGUIR_COMPRANDO = Target.the("Boton seguir comprando").locatedBy("//button[text()='Seguir comprando']");
    public static final Target CARRITO = Target.the("").located(By.id("testId-UserAction-basket"));
}
