package com.reto.serenity.falabella.tasks;

import com.reto.serenity.falabella.interactions.EsperaExplicita;
import com.reto.serenity.falabella.interactions.SeleccionarCantidad;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.ScrollToTarget;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.*;
import static com.reto.serenity.falabella.userinterfaces.UiProductos.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SeleccionarProducto implements Task {

    private int cantidad;

    public SeleccionarProducto(int cantidad){
        this.cantidad = cantidad;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Map<String, Object>> tabla = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            WebElement elemento = CONTENEDOR_PADRE.resolveFor(actor);
            List<WebElement> productElements = elemento.findElements(By.xpath("//b[contains(@id,'testId-pod-displaySubTitle')]"));
            int item = (int)(Math.random()*productElements.size()+1);
            WebElement randomProduct = productElements.get(item);
            int cant = (int)(Math.random()*10+1);
            Map<String, Object> datosCarrito = new HashMap<>();
            datosCarrito.put("nombre", Arrays.asList(randomProduct.getText()));
            actor.attemptsTo(
                    new ScrollToTarget(LINK_TITLE.of(randomProduct.getText())),
                    WaitUntil.the(LINK_TITLE.of(randomProduct.getText()), isClickable()).forNoMoreThan(60).seconds(),
                    Click.on(LINK_TITLE.of(randomProduct.getText()))
            );
            datosCarrito.put("cantidad", cant);
            actor.attemptsTo(WaitUntil.the(LBL_PRESIO,  isClickable()).forNoMoreThan(60).seconds());
            datosCarrito.put("precio", LBL_PRESIO.resolveFor(actor).getText().replace("$", "").trim());
            actor.attemptsTo(
                    SeleccionarCantidad.seleccionar(cant),
                    Check.whether(BTN_TALLA.resolveFor(actor).isClickable()).andIfSo(Click.on(BTN_TALLA)),
                    WaitUntil.the(BTN_AGREGAR,  isClickable()).forNoMoreThan(60).seconds(),
                    Click.on(BTN_AGREGAR),
                    EsperaExplicita.empleada(6000)
            );
            tabla.add(datosCarrito);
            BrowseTheWeb.as(actor).getDriver().navigate().back();
        }
        actor.remember("tabladatos", tabla);
        actor.attemptsTo(
                new ScrollToTarget(CARRITO),
                Click.on(CARRITO),
                EsperaExplicita.empleada(6000));

    }

    public static SeleccionarProducto producto(int cantidad){
        return Tasks.instrumented(SeleccionarProducto.class, cantidad);
    }

}
