package com.reto.serenity.falabella.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.reto.serenity.falabella.userinterfaces.UiNavegar.*;
import static com.reto.serenity.falabella.userinterfaces.UiPaginaFalabella.BTN_MENU;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class Navegar implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        int numero = (int)(Math.random()*20+1);
        actor.attemptsTo(
                WaitUntil.the(BTN_MENU,  isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_MENU),
                Click.on(MENU_ITEM_PADRE.of(String.valueOf(numero)))
        );
        WebElement elemento = ELEMENTOS.resolveFor(actor);
        List<WebElement> productElements = elemento.findElements(By.xpath("//a[@target=\"_self\" and contains(@href,'https://www.falabella.com.co/falabella-co/category')]"));
        int item = (int)(Math.random()*productElements.size()+1);
        actor.attemptsTo(
                Click.on(ITEM.of(String.valueOf(item)))
        );
    }

    public static Navegar menu(){
        return Tasks.instrumented(Navegar.class);
    }
}
