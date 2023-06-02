package is.demo.serenity.stepDefinitions;

import is.demo.serenity.questions.ProductoValidacionQuestion;
import is.demo.serenity.task.DashBoardTask;
import is.demo.serenity.task.InicioDeSesionTask;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import is.demo.serenity.task.ProductosTask;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import java.io.IOException;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class RegistrarproductoStepDefinitions {

    @Before
    public void setStage(){
        setTheStage(new OnlineCast());
    }

    @Dado("que el usuario ha iniciado sesion y que el usuario hace clic en Product Types")
    public void queElUsuarioHaIniciadoSesionYQueElUsuarioHaceClicEnProductTypes() throws IOException{
        theActorCalled("Usuario").wasAbleTo(

                InicioDeSesionTask.InicioDeSesionTask(),
                DashBoardTask.SeccionDeProductos()
        );
    }
    @Cuando("el usuario da clic en el boton New Product y agerga el nombre juntco con los campos obligatorios y guarde el producto")
    public void elUsuarioDaClicEnElBotonNewProductYAgergaElNombreJuntcoConLosCamposObligatoriosYGuardeElProducto() {
        theActorCalled("Usuario").wasAbleTo(

                ProductosTask.BotonNuevoProductos()
        );
    }


    @Entonces("el usuario puede visualizar el nombre del nuevo producto en la tabla de productos.")
    public void elUsuarioPuedeVisualizarElNombreDelNuevoProductoEnLaTablaDeProductos() {
        theActorInTheSpotlight().should(
                seeThat(
                        "Se visualiza el titulo del producto",
                        ProductoValidacionQuestion.validacionProducto(),
                        Matchers.equalTo(true)
                )
        );
    }

}
