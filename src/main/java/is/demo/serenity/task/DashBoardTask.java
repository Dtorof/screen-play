package is.demo.serenity.task;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static is.demo.serenity.userInterface.DashBoardUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
public class DashBoardTask implements Task  {

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                Click.on(BTN_PRODUCTO)
        );

    }

    public static Performable SeccionDeProductos(){
        return  instrumented(DashBoardTask.class);
    }

}