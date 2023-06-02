package is.demo.serenity.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class InicioDeSesionUI {
    public static final Target BTN_INGRESAR= Target.the("Boton de ingreso")
            .locatedBy("//button[@id='LoginPanel0_LoginButton']");

    public static final Target TXT_USUARIO= Target.the("nombre de usuario")
            .locatedBy("//input[@id='LoginPanel0_Username']");

    public static final Target TXT_CLAVE= Target.the("Clave de usuario")
            .locatedBy("//input[@id='LoginPanel0_Password']");
}
