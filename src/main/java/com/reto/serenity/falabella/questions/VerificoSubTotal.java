package com.reto.serenity.falabella.questions;

import com.reto.serenity.falabella.interactions.EsperaExplicita;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import static com.reto.serenity.falabella.userinterfaces.UiProductos.LBL_CARRITO;
import static com.reto.serenity.falabella.userinterfaces.UiProductos.LBL_TOTAL_CARRITO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class VerificoSubTotal implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(EsperaExplicita.empleada(10000));
        DecimalFormat decimalFormat = new DecimalFormat("###.000");
        DecimalFormat Format = new DecimalFormat("###,###.000");
        boolean resultado = false;
        double totalGeneral = 0.0;
        List<Map<String, Object>> nuevaTabla = theActorInTheSpotlight().recall("tabladatos");
        for (Map<String, Object> datosCarrito : nuevaTabla) {
            int cantidad = (int) datosCarrito.get("cantidad");
            double precio = Double.parseDouble((String) datosCarrito.get("precio"));
            double totalPorItem = precio * cantidad;
            //double numeroFormateado = Double.parseDouble(decimalFormat.format(totalPorItem));
            totalGeneral += totalPorItem;
        }

        String total = LBL_TOTAL_CARRITO.resolveFor(actor).getText().replace("$ ", "").replace(".", "").trim();
        String totalGeneralString = String.valueOf(Format.format(totalGeneral)).replace(".", "").replace(",", "");

        resultado = total.contains(totalGeneralString);

        if (!resultado) {
            throw new AssertionError("La cantidad de productos en el carrito no es igual a la seleccionada\n" +
                    "Cantidad en el carrito: " + total + "\n" +
                    "Cantidad seleccionada: " + totalGeneralString);
        }
        return resultado;
    }

    public static VerificoSubTotal subTotal() {
        return new VerificoSubTotal();
    }
}
