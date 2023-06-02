package is.demo.serenity.userInterface;

import net.serenitybdd.screenplay.targets.Target;
public class DashBoardUI {

    public static final Target BTN_PRODUCTO= Target.the("Boton de producto")
            .locatedBy(" //a[@href='/Northwind/Product' and @class='card-footer']");


}
