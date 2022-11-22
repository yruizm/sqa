package co.com.yrm.qa.proyecto.questions;


import co.com.yrm.qa.proyecto.tasks.DatosAlojamiento;
import co.com.yrm.qa.proyecto.userinterfaces.ResultadosPage;
import co.com.yrm.qa.proyecto.utils.Utils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static co.com.yrm.qa.proyecto.utils.Utils.lsListaTraza;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarPaquete implements Question<Boolean> {

    int intPresupuesto;
    String hotel;
    public static int intPresupuestoRestate;

    public SeleccionarPaquete(List<String> data) {
        intPresupuesto=Integer.parseInt(data.get(0));
        hotel=data.get(1);

    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(ResultadosPage.LBL_HOTEL.of(hotel), isVisible()).forNoMoreThan(20).seconds()
        );


        if (ResultadosPage.LBL_HOTEL.of(hotel).resolveFor(actor).isPresent()) {
            System.out.println("Se encontro Hotel");
            lsListaTraza.add("Compra de Paquete, Hotel  encontrado o Diponible: " +hotel);

            String strPrecioPaquete = actor. asksFor(Text.of(ResultadosPage.RECORRER_PRECIOS_PAQUETE.of(hotel)));

            System.out.println(strPrecioPaquete);
            String strPrecioBajo=strPrecioPaquete.replace(".","").replace(" ","").replace( "$","");
            System.out.println(strPrecioBajo);
            if (Integer.parseInt(strPrecioBajo)<intPresupuesto){
                intPresupuestoRestate=intPresupuesto-Integer.parseInt(strPrecioBajo);
                actor.attemptsTo(
                        Click.on(ResultadosPage.BTN_SIGUIENTE_PAQUETE.of(hotel)),
                        Switch.toNewWindow(),
                        Click.on(ResultadosPage.BTN_SIGUIENTE_HOTEL)
                );
                Logger.getAnonymousLogger().log(Level.INFO, "true");
                lsListaTraza.add("Compra de Tiquetes Alojamiento Precio: $" +strPrecioBajo);
                return true;
            }else {
                System.out.println("Precio Superior al Presupuesto");
                Logger.getAnonymousLogger().log(Level.INFO, "false");
                lsListaTraza.add("Compra de Paquete, Precio Hotel encontrado: $" +strPrecioBajo+ " Superior al Presupuesto $"+intPresupuesto);
                lsListaTraza.add("Proceso Fallido");
                lsListaTraza.add("");
                Utils.crearArchivoTraza("Compra de Paquete Fallida");
                return false;
            }
        }else {
            System.out.println("No se encontro Hotel");
            Logger.getAnonymousLogger().log(Level.INFO, "false");
            lsListaTraza.add("Compra de Paquete, Hotel No encontrado o no Diponible: " +hotel);
            lsListaTraza.add("Proceso Fallido");
            lsListaTraza.add("");
            Utils.crearArchivoTraza("Compra de Paquete Fallida");
            return false;
        }

    }

    public static SeleccionarPaquete enPaginaPrincipal(List<String> data){
        return new SeleccionarPaquete(data);
    }

}
