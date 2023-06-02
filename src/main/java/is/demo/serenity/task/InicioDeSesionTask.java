package is.demo.serenity.task;


import is.demo.serenity.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static is.demo.serenity.userInterface.InicioDeSesionUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
public class InicioDeSesionTask implements Task {
    private static ArrayList<Map<String, String>> url = new ArrayList<>();
    private static ArrayList<Map<String, String>> datosExcel= new ArrayList<>();
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            url = Excel.leerDatosDeHojaDeExcel("datos/data.xlsx", "Url");
            datosExcel = Excel.leerDatosDeHojaDeExcel("datos/data.xlsx", "Credenciales");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        actor.attemptsTo(
                Open.url(url.get(0).get("Url")),
                Clear.field(TXT_USUARIO),
                Enter.theValue(datosExcel.get(0).get("Usuario")).into(TXT_USUARIO),
                Clear.field(TXT_CLAVE),
                Enter.theValue(datosExcel.get(0).get("Clave")).into(TXT_CLAVE),
                Click.on(BTN_INGRESAR)
        );

    }

    public static Performable InicioDeSesionTask(){
        return  instrumented(InicioDeSesionTask.class);
    }

}
