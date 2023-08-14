package com.reto.serenity.falabella.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import java.util.List;
import java.util.Map;
import static com.reto.serenity.falabella.userinterfaces.UiProductos.LBL_CARRITO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class VerificarCantidad implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        boolean resultado = false;
        int totalCantidad = 0;
        List<Map<String, Object>> nuevaTabla = theActorInTheSpotlight().recall("tabladatos");
        for (Map<String, Object> datosCarrito : nuevaTabla) {
            int cantidad = (int) datosCarrito.get("cantidad");
            totalCantidad += cantidad;
        }
        int cantidad = Integer.parseInt(LBL_CARRITO.resolveFor(actor).getText().replace("Carro (", "").replace(" productos)","").replace("(","").trim());

        resultado = cantidad == totalCantidad;
        if (!resultado){
            throw new AssertionError("La cantidad de productos en el carrito no es igual a la seleccionada\n" +
                    "Cantidad en el carrito: " + cantidad + "\n" +
                    "Cantidad seleccionada: " + totalCantidad);
        }

        return resultado;

    }

    public static VerificarCantidad validar(){
        return new VerificarCantidad();
    }
}
