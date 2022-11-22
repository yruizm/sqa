package co.com.yrm.qa.proyecto.tasks;


import co.com.yrm.qa.proyecto.models.FiltrarAlojamientoModel;
import co.com.yrm.qa.proyecto.models.FiltrarSeleccionModel;
import co.com.yrm.qa.proyecto.userinterfaces.FiltrarAlojamientoPage;
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

public class FiltrarAlojamiento implements Task {

    FiltrarAlojamientoModel filtrarAlojamientoModel = new FiltrarAlojamientoModel();

    public FiltrarAlojamiento(List<String> data) {
        filtrarAlojamientoModel.setDestinoHotel(data.get(0));
        filtrarAlojamientoModel.setFechaIda(data.get(1));
        filtrarAlojamientoModel.setFechaRegreso(data.get(2));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(PaginaPrincipal.CERRAR_INICIO_SESION),
                Click.on(PaginaPrincipal.ENTENDI_COOKIES));

        String[] fechaIda= filtrarAlojamientoModel.getFechaIda().split("-");
        String[] fechaRegreso= filtrarAlojamientoModel.getFechaRegreso().split("-");

        actor.wasAbleTo(
                Click.on(FiltrarAlojamientoPage.LNK_ALOJAMIENTO),
                Click.on(FiltrarAlojamientoPage.INPUT_DESTINO),
                SendKeys.of(filtrarAlojamientoModel.getDestinoHotel()).into(FiltrarAlojamientoPage.INPUT_DESTINO),
                Hit.the(Keys.TAB).into(FiltrarAlojamientoPage.INPUT_DESTINO),
                Click.on(FiltrarAlojamientoPage.VER_CALENDARIO_IDA)

        );



        actor.wasAbleTo(

                Click.on(FiltrarAlojamientoPage.FECHA_IDA.of(fechaIda[0]+"-"+fechaIda[1],fechaIda[2])),
                Click.on(FiltrarAlojamientoPage.FECHA_REGRESO.of(fechaRegreso[0]+"-"+fechaRegreso[1],fechaRegreso[2])),
                Click.on(FiltrarAlojamientoPage.BTN_BUSCAR)
        );
        lsListaTraza.add("RESERVAR ALOJAMIENTO");
        lsListaTraza.add("Destino. "+filtrarAlojamientoModel.getDestinoHotel());
        lsListaTraza.add("FechaIda. "+filtrarAlojamientoModel.getFechaIda());
        lsListaTraza.add("FechaRegreso. "+filtrarAlojamientoModel.getFechaRegreso());

    }

    public static FiltrarAlojamiento busqueda(List<String> data) {
        return Tasks.instrumented(FiltrarAlojamiento.class, data);
    }
}
