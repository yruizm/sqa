package co.com.yrm.qa.proyecto.tasks;


import co.com.yrm.qa.proyecto.models.DatosPagoModel;
import co.com.yrm.qa.proyecto.userinterfaces.DatosPagoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import java.util.List;
import static co.com.yrm.qa.proyecto.utils.Utils.crearArchivoTraza;
import static co.com.yrm.qa.proyecto.utils.Utils.lsListaTraza;

public class DatosPago implements Task {

    DatosPagoModel datosPagoModel = new DatosPagoModel();

    public DatosPago(List<String> data) {
        datosPagoModel.setNumeroTC(data.get(0));
        datosPagoModel.setTitularTC(data.get(1));
        datosPagoModel.setVencimientoTC(data.get(2));
        datosPagoModel.setCodigoTC(data.get(3));
        datosPagoModel.setDocumentoTitularTC(data.get(4));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.wasAbleTo(
                Click.on(DatosPagoPage.RBD_TARJETA_CREDITO),
                Enter.keyValues(datosPagoModel.getNumeroTC()).into(DatosPagoPage.TXT_NUMERO_TC),
                Enter.keyValues(datosPagoModel.getTitularTC()).into(DatosPagoPage.TXT_TITULAR_TC),
                Enter.keyValues(datosPagoModel.getVencimientoTC()).into(DatosPagoPage.TXT_VENCIMIENTO_TC),
                SendKeys.of(datosPagoModel.getCodigoTC()).into(DatosPagoPage.TXT_CODIGO_TC),
                SendKeys.of(datosPagoModel.getDocumentoTitularTC()).into(DatosPagoPage.TXT_IDENTIFICACION_TITULAR_TC),
                Click.on(DatosPagoPage.RBD_CUOTA),
                Click.on(DatosPagoPage.ACEPTO_TERMINOS_CONDICIONES)
        );

        lsListaTraza.add("Datos del Pago");
        lsListaTraza.add("Tarjeta Credito. "+ datosPagoModel.getNumeroTC());
        lsListaTraza.add("Titular. " + datosPagoModel.getTitularTC());
        lsListaTraza.add("Identificación Titular."+datosPagoModel.getDocumentoTitularTC());

        crearArchivoTraza("Compra Despegar");

    }

    public static DatosPago ingresarDatos(List<String> data) {
        return Tasks.instrumented(DatosPago.class, data);
    }
}
