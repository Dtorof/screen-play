package is.demo.serenity.questions;
/*
 * @(#) YoutubeValidacionQuestion.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import is.demo.serenity.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


import static is.demo.serenity.userInterface.ProductosUI.*;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class ProductoValidacionQuestion implements Question<Boolean> {




    @Override
    public Boolean answeredBy(Actor actor) {
        String producto="";
        try {
            ArrayList<Map<String, String>> datosExcel = Excel.leerDatosDeHojaDeExcel("datos/data.xlsx", "Producto");
            producto = datosExcel.get(0).get("Nombre");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        String textVideo = LISTA_PRODUCTOS.resolveFor(actor).getText();




        return producto.equals(textVideo);
    }

    public static Question validacionProducto(){
        return new ProductoValidacionQuestion();
    }
}
