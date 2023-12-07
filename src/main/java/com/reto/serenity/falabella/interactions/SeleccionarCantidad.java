package com.reto.serenity.falabella.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.reto.serenity.falabella.userinterfaces.UiProductos.*;

public class SeleccionarCantidad implements Interaction {

    private int cantidad;

    public SeleccionarCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

            if (cantidad != 0) {
                if (cantidad != 1) {
                    for (int j = 1; j < cantidad; j++) {
                        actor.attemptsTo(
                                WaitUntil.the(BTN_INCREMENTAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                                Click.on(BTN_INCREMENTAR)
                        );
                    }
                }
            }
    }


    public static SeleccionarCantidad seleccionar(int cantidad) {
        return Instrumented.instanceOf(SeleccionarCantidad.class).withProperties(cantidad);
    }
}
