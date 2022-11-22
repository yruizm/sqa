package co.com.yrm.qa.proyecto.questions;


import co.com.yrm.qa.proyecto.userinterfaces.ResultadosPage;
import co.com.yrm.qa.proyecto.utils.Utils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Collection;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import static co.com.yrm.qa.proyecto.utils.Utils.lsListaTraza;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarAlojamiento implements Question<Boolean> {

    int intPresupuesto;

    public SeleccionarAlojamiento(int intPresupuesto) {
        this.intPresupuesto = intPresupuesto;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        Collection<String> caprturarPrecios = actor.asksFor(Text.ofEach(ResultadosPage.RECORRER_PRECIOS_ALOJAMIENTO));

        System.out.println(Collections.max(caprturarPrecios)); // 5
        System.out.println(Collections.min(caprturarPrecios)); // 1
        String strPrecioBajo1=Collections.min(caprturarPrecios);
        String strPrecioBajo=Collections.min(caprturarPrecios).replace(".","");

        if (Integer.parseInt(strPrecioBajo)<intPresupuesto){
            System.out.println("Precio Bajo");
            actor.attemptsTo(
                    Click.on(ResultadosPage.BTN_VER_DETALLE.of(strPrecioBajo1)),
                    Switch.toNewWindow(),
                    Click.on(ResultadosPage.BTN_RESERVAR_AHORA)
            );

                if (ResultadosPage.BTN_SIGUIENTE.resolveFor(actor).isPresent()) {
                    actor.attemptsTo(Click.on(ResultadosPage.BTN_SIGUIENTE));
                }
            lsListaTraza.add("Compra de Alojamiento Precio: $" +strPrecioBajo);
            Logger.getAnonymousLogger().log(Level.INFO, "true");
            return true;
        }else {
            System.out.println("Precio Superior a Presupuesto");
            Logger.getAnonymousLogger().log(Level.INFO, "false");

            lsListaTraza.add("Reserva de Alojamiento Precio, encontrado: $" +strPrecioBajo+ " Superior al Presupuesto $"+intPresupuesto);
            lsListaTraza.add("Proceso Fallido");
            lsListaTraza.add("");
            Utils.crearArchivoTraza("Reserva de Alojamiento Fallida");
            return false;
        }
    }

    public static SeleccionarAlojamiento enPaginaPrincipal(int intPresupuesto){
        return new SeleccionarAlojamiento(intPresupuesto);
    }
}
