package co.com.yrm.qa.proyecto.tasks;


import co.com.yrm.qa.proyecto.models.FiltrarSeleccionModel;
import co.com.yrm.qa.proyecto.userinterfaces.FiltrarPaquetePage;
import co.com.yrm.qa.proyecto.userinterfaces.PaginaPrincipal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actions.Switch;
import org.openqa.selenium.Keys;
import java.util.List;

import static co.com.yrm.qa.proyecto.utils.Utils.lsListaTraza;

public class FiltrarPaquete implements Task {

    FiltrarSeleccionModel filtrarSeleccionModel = new FiltrarSeleccionModel();

    public FiltrarPaquete(List<String> data) {
        filtrarSeleccionModel.setOrigen(data.get(0));
        filtrarSeleccionModel.setDestino(data.get(1));
        filtrarSeleccionModel.setFechaIda(data.get(2));
        filtrarSeleccionModel.setFechaRegreso(data.get(3));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String[] fechaIda= filtrarSeleccionModel.getFechaIda().split("-");
        String[] fechaRegreso= filtrarSeleccionModel.getFechaRegreso().split("-");

        actor.attemptsTo(Click.on(PaginaPrincipal.CERRAR_INICIO_SESION),
                Click.on(PaginaPrincipal.ENTENDI_COOKIES));


        actor.wasAbleTo(
                Click.on(FiltrarPaquetePage.LNK_PAQUETE),
                Switch.toDefaultContext(),
                Click.on(FiltrarPaquetePage.INPUT_DESTINO),
                SendKeys.of(filtrarSeleccionModel.getDestino()).into(FiltrarPaquetePage.INPUT_DESTINO),
                Hit.the(Keys.TAB).into(FiltrarPaquetePage.INPUT_DESTINO),
                Click.on(FiltrarPaquetePage.VER_CALENDARIO_IDA)

        );


        actor.wasAbleTo(
                Click.on(FiltrarPaquetePage.FECHA_IDA.of(fechaIda[0]+"-"+fechaIda[1],fechaIda[2])),
                Click.on(FiltrarPaquetePage.FECHA_REGRESO.of(fechaRegreso[0]+"-"+fechaRegreso[1],fechaRegreso[2])),
                Click.on(FiltrarPaquetePage.BTN_BUSCAR)
        );

        lsListaTraza.add("RESERVAR PAQUETE");
        lsListaTraza.add("Destino. "+filtrarSeleccionModel.getDestino());
        lsListaTraza.add("FechaIda. "+filtrarSeleccionModel.getFechaIda());
        lsListaTraza.add("FechaRegreso. "+filtrarSeleccionModel.getFechaRegreso());

    }

    public static FiltrarPaquete busqueda(List<String> data) {
        return Tasks.instrumented(FiltrarPaquete.class, data);
    }
}
