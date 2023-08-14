package com.reto.serenity.falabella.stepdefinitions;

import com.reto.serenity.falabella.questions.VerificarCantidad;
import com.reto.serenity.falabella.questions.VerificoSubTotal;
import com.reto.serenity.falabella.tasks.AbrirPagina;
import com.reto.serenity.falabella.tasks.CerrarPopUp;
import com.reto.serenity.falabella.tasks.Navegar;
import com.reto.serenity.falabella.tasks.SeleccionarProducto;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SeleccionarArticuloStepdefinition {

    @Given("Que {string} navego en la página de Falabella")
    public void queNavegoEnLaPáginaDeFalabella(String actor) {
        theActorCalled(actor).wasAbleTo(
                AbrirPagina.urlWeb(),
                CerrarPopUp.enLaPantalla()
        );
    }
    @When("Navega aleatoriamente por el menú")
    public void navegaAleatoriamentePorElMenú() {
        theActorInTheSpotlight().attemptsTo(
                Navegar.menu()
        );
    }
    @When("Selecciona los {int} productos aleatorios")
    public void seleccionaLosProductosAleatorios(Integer cantidad) {

        theActorInTheSpotlight().attemptsTo(
                SeleccionarProducto.producto(cantidad)
        );

    }
    @Then("Debería ver la cantidad de productos en el carrito de compras")
    public void deberíaVerLaCantidadDeProductosEnElCarritoDeCompras() {
        theActorInTheSpotlight().should(seeThat(
                VerificarCantidad.validar()
        ));
    }
    @Then("Debería ver el subtotal de los productos")
    public void deberíaVerElSubtotalDeLosProductos() {
        theActorInTheSpotlight().should(seeThat(
                VerificoSubTotal.subTotal()
        ));
    }
    @Then("Debería ver la cantidad por cada producto")
    public void deberíaVerLaCantidadPorCadaProducto() {

    }
}
