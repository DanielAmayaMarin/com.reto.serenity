package com.reto.serenity.falabella.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.Map;

import static com.reto.serenity.falabella.userinterfaces.UiProductos.LBL_CANTIDAD;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class VerificarCantidadUnitaria implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        List<Map<String, Object>> nuevaTabla = theActorInTheSpotlight().recall("tabladatos");
        for (Map<String, Object> datosCarrito : nuevaTabla) {
            List<String> nombres = (List<String>) datosCarrito.get("nombre");
            int cantidad = (int) datosCarrito.get("cantidad");
            int cantidadPagina = Integer.parseInt(LBL_CANTIDAD.of(nombres.get(0)).resolveFor(actor).getValue());
            System.out.println(cantidadPagina);
            System.out.println(nombres.get(0));
            System.out.println(cantidad);
        }
        return null;
    }

    public static VerificarCantidadUnitaria cantidad(){
        return new VerificarCantidadUnitaria();
    }
}
