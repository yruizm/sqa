package co.com.yrm.qa.proyecto.questions;


import co.com.yrm.qa.proyecto.userinterfaces.ResultadosPage;
import co.com.yrm.qa.proyecto.utils.Utils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Collection;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import static co.com.yrm.qa.proyecto.utils.Utils.lsListaTraza;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerificarPresupuesto implements Question<Boolean> {

    int intPresupuesto;

    public VerificarPresupuesto(int intPresupuesto) {
        this.intPresupuesto = intPresupuesto;
    }

    @Override
    public Boolean answeredBy(Actor actor) {


        Collection<String> caprturarPrecios = actor.asksFor(Text.ofEach(ResultadosPage.RECORRER_PRECIOS));

        System.out.println(Collections.min(caprturarPrecios));
        String strPrecioBajo1=Collections.min(caprturarPrecios);
        String strPrecioBajo=Collections.min(caprturarPrecios).replace(".","");

        if (Integer.parseInt(strPrecioBajo)<intPresupuesto){
            System.out.println("Precio Bajo Tiquetes");
            actor.attemptsTo(
                    Click.on(ResultadosPage.BTN_COMPRAR.of(strPrecioBajo1)),
                    WaitUntil.the(ResultadosPage.DIV_H3_VENTANA_COMPRA, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(ResultadosPage.BTN_CONTINUAR_COMPRA)
            );
            if (ResultadosPage.BTN_SIGUIENTE.resolveFor(actor).isPresent()) {
                actor.attemptsTo(Click.on(ResultadosPage.BTN_SIGUIENTE));
            }
            Logger.getAnonymousLogger().log(Level.INFO, "true");
            lsListaTraza.add("Compra de Tiquetes Precio: $" +strPrecioBajo);
            return true;
        }else {
            System.out.println("Precio Superior a Presupuesto Tiquetes");
            Logger.getAnonymousLogger().log(Level.INFO, "false");
            lsListaTraza.add("Compra de Tiquetes Precio, encontrado: $" +strPrecioBajo+ " Superior al Presupuesto $"+intPresupuesto);
            lsListaTraza.add("Proceso Fallido");
            lsListaTraza.add("");
            Utils.crearArchivoTraza("Compra de Tiquetes Fallida");
            return false;
        }
    }

    public static VerificarPresupuesto enPaginaPrincipal(int intPresupuesto){
        return new VerificarPresupuesto(intPresupuesto);
    }
}
