package com.reto.serenity.falabella.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UiProductos {
    public static final Target CONTENEDOR_PADRE = Target.the("").locatedBy("//div[@class='jsx-200723616 search-results-4-grid grid-pod' or @class='jsx-200723616 search-results-list' or @class='jsx-1484439449 search-results-4-grid grid-pod']");
    public static final Target LINK_TITLE = Target.the("").locatedBy("//b[contains(@id,'testId-pod-displaySubTitle') and contains(text(),'{0}')]");
    public static final Target LBL_PRESIO = Target.the("").locatedBy("//span[@class='copy17 primary senary jsx-2835692965 bold      line-height-29']");
    public static final Target BTN_AGREGAR = Target.the("").located(By.id("add-to-cart-button"));
    public static final Target BTN_INCREMENTAR = Target.the("Boton incrementar").located(By.id("quantity-selector-increment-btn"));
    public static final Target BTN_MODAL_DIRECCION = Target.the("Boton cerrar alerta").located(By.id("testId-modal-close"));
    public static final Target CARRITO = Target.the("").located(By.id("testId-UserAction-basket"));
    public static final Target LBL_CARRITO = Target.the("").locatedBy("(//p[@data-testid='total-products-count'])[1]");
    public static final Target LBL_TOTAL_CARRITO = Target.the("").locatedBy("//p[@data-testid='total-amount-SUB_TOTAL']");
    public static final Target BTN_TALLA = Target.the("").locatedBy("(//button[@class='jsx-2923872838 size-button rebranded   '])[1]");
    public static final Target LBL_CANTIDAD = Target.the("").locatedBy("//div[@class=\"css-gj089s\" and //child::a[contains(text(),'{0}')]]//child::Input");
}
