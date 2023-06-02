package is.demo.serenity.task;

import is.demo.serenity.interactions.ScrollAlObjetivo;
import is.demo.serenity.utils.EscrituraExcel;
import is.demo.serenity.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static is.demo.serenity.userInterface.ProductosUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ProductosTask  implements Task {

    private static ArrayList<Map<String, String>> datosExcel= new ArrayList<>();
    private static String rutaExcel = "datos/data.xlsx";

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            datosExcel = Excel.leerDatosDeHojaDeExcel("datos/data.xlsx", "Producto");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        EscrituraExcel.escrituraExcel(rutaExcel, "Agregados", datosExcel.get(0).get("Nombre"), 0);
        EscrituraExcel.escrituraExcel(rutaExcel, "Agregados", datosExcel.get(0).get("Stock"), 1);
        EscrituraExcel.escrituraExcel(rutaExcel, "Agregados", datosExcel.get(0).get("Unidades"), 2);
        EscrituraExcel.escrituraExcel(rutaExcel, "Agregados", datosExcel.get(0).get("Nivel"), 3);

        actor.attemptsTo(
                Click.on(BTN_NUEVO_PRODUCTO),
                Enter.theValue(datosExcel.get(0).get("Nombre")).into(TXT_NOMBRE_PRODUCTO),
                Clear.field(TXT_STOCK),
                Enter.theValue(datosExcel.get(0).get("Stock")).into(TXT_STOCK),
                Clear.field(TXT_UNIDADES_EN_PEDIDO),
                Enter.theValue(datosExcel.get(0).get("Unidades")).into(TXT_UNIDADES_EN_PEDIDO),
                Clear.field(TXT_NIVEL_ORDEN ),
                Enter.theValue(datosExcel.get(0).get("Nivel")).into(TXT_NIVEL_ORDEN ),
                ScrollAlObjetivo.of(BTN_GUARDAR),
                Click.on(BTN_GUARDAR),
                Click.on(TXT_BUSCAR),
                Enter.theValue(datosExcel.get(0).get("Nombre")).into(TXT_BUSCAR)
                        .thenHit(Keys.ENTER)


        );


        actor.attemptsTo(
                Click.on(TXT_BUSCAR),
                Enter.theValue(datosExcel.get(0).get("Nombre")).into(TXT_BUSCAR)
                        .thenHit(Keys.ENTER)
        );

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static Performable BotonNuevoProductos(){
        return  instrumented(ProductosTask.class);
    }
}
