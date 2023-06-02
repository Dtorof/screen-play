package is.demo.serenity.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class ProductosUI {
    public static final Target BTN_NUEVO_PRODUCTO= Target.the("Boton de registro de producto")
            .locatedBy("//span[@class='button-inner' and contains(text(), 'New Product')]");

    public static final Target TXT_NOMBRE_PRODUCTO= Target.the("nombre del producto")
            .locatedBy(" //input[@type='text' and contains(@class, 'editor') and contains(@class, 's-Serenity-StringEditor') and contains(@class, 's-StringEditor') and contains(@class, 'required') and @id='Serenity_Demo_Northwind_ProductDialog9_ProductName' and @name='ProductName' and @maxlength='40']");

    public static final Target TXT_STOCK= Target.the("stock del producto")
            .locatedBy("//*[@id='Serenity_Demo_Northwind_ProductDialog9_UnitsInStock']");


    public static final Target TXT_UNIDADES_EN_PEDIDO = Target.the("unidades en el pedido")

            .locatedBy("//input[@id='Serenity_Demo_Northwind_ProductDialog9_UnitsOnOrder']");

    public static final Target TXT_NIVEL_ORDEN = Target.the("nivel de orden")

            .locatedBy("//input[@id='Serenity_Demo_Northwind_ProductDialog9_ReorderLevel']");

    public static final Target BTN_GUARDAR= Target.the("Boton de guardar nuevo producto")
            .locatedBy("//span[@class='button-inner']/i[@class='fa fa-check-circle text-purple']");


    public static final Target LISTA_PRODUCTOS = Target.the("Lista de productos")
            .locatedBy("//div[@class='slick-cell l1 r1']/a[@data-item-type=\"Demo.Northwind.Product\" and position()=1]");

    public static final Target TXT_BUSCAR = Target.the("buscar producto")

            .locatedBy("//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']");



}
