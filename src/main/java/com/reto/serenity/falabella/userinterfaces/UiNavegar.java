package com.reto.serenity.falabella.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class UiNavegar {
    public static final Target MENU_ITEM_PADRE = Target.the("MENU_ITEM_PADRE").locatedBy("(//*[@class='FirstLevelCategories-module_chevronRightIcon__3qHuv'])[{0}]");
    public static final Target ELEMENTOS = Target.the("MENU_ITEM_PADRE").locatedBy("//ul[@class='SecondLevelCategories-module_secondLevelCategory__3SPXi']//child::li");
    public static final Target ITEM = Target.the("Item menu").locatedBy("(//ul[@class='SecondLevelCategories-module_secondLevelCategory__3SPXi']//child::li//child::a)[{0}]");
}
