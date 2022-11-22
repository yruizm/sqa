package co.com.yrm.qa.proyecto.tasks;


import co.com.yrm.qa.proyecto.models.FiltrarSeleccionModel;
import co.com.yrm.qa.proyecto.userinterfaces.FiltrarPage;
import co.com.yrm.qa.proyecto.userinterfaces.PaginaPrincipal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;
import java.util.List;

import static co.com.yrm.qa.proyecto.utils.Utils.lsListaTraza;

public class FiltrarSeleccion implements Task {

    FiltrarSeleccionModel filtrarSeleccionModel = new FiltrarSeleccionModel();

    public FiltrarSeleccion(List<String> data) {
        filtrarSeleccionModel.setIdaVuelta(data.get(0));
        filtrarSeleccionModel.setOrigen(data.get(1));
        filtrarSeleccionModel.setDestino(data.get(2));
        filtrarSeleccionModel.setFechaIda(data.get(3));
        filtrarSeleccionModel.setFechaRegreso(data.get(4));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String[] fechaIda= filtrarSeleccionModel.getFechaIda().split("-");
        String[] fechaRegreso= filtrarSeleccionModel.getFechaRegreso().split("-");


        actor.attemptsTo(Click.on(PaginaPrincipal.CERRAR_INICIO_SESION),
                Click.on(PaginaPrincipal.ENTENDI_COOKIES));

        if (filtrarSeleccionModel.getIdaVuelta().equals("NO")){
            actor.wasAbleTo(Click.on(FiltrarPage.RDB_IDA));
        }
        actor.wasAbleTo(
                Click.on(FiltrarPage.INPUT_DESTINO),
                SendKeys.of(filtrarSeleccionModel.getDestino()).into(FiltrarPage.INPUT_DESTINO)

        );

        actor.wasAbleTo(
                Hit.the(Keys.TAB).into(FiltrarPage.INPUT_DESTINO),
                Click.on(FiltrarPage.VER_CALENDARIO_IDA)

        );


        actor.wasAbleTo(

                Click.on(FiltrarPage.FECHA_IDA.of(fechaIda[0]+"-"+fechaIda[1],fechaIda[2]))
        );

        if (filtrarSeleccionModel.getIdaVuelta().equals("SI")){
            actor.wasAbleTo(Click.on(FiltrarPage.FECHA_REGRESO.of(fechaRegreso[0]+"-"+fechaRegreso[1],fechaRegreso[2])));
        }

        actor.wasAbleTo(
                Click.on(FiltrarPage.BTN_BUSCAR)
        );

        lsListaTraza.add("RESERVAR VUELO");
        lsListaTraza.add("Ida y Vuelta. "+filtrarSeleccionModel.getIdaVuelta());
        lsListaTraza.add("Destino. "+filtrarSeleccionModel.getDestino());
        lsListaTraza.add("FechaIda. "+filtrarSeleccionModel.getFechaIda());
        lsListaTraza.add("FechaRegreso. "+filtrarSeleccionModel.getFechaRegreso());

    }

    public static FiltrarSeleccion filtros(List<String> data) {
        return Tasks.instrumented(FiltrarSeleccion.class, data);
    }
}
