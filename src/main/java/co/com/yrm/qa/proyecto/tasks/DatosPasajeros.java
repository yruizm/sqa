package co.com.yrm.qa.proyecto.tasks;


import co.com.yrm.qa.proyecto.models.DatosPasajeroModel;
import co.com.yrm.qa.proyecto.models.FiltrarSeleccionModel;
import co.com.yrm.qa.proyecto.userinterfaces.DatosPasajeroPage;
import co.com.yrm.qa.proyecto.userinterfaces.FiltrarPage;
import co.com.yrm.qa.proyecto.userinterfaces.PaginaPrincipal;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;

import java.util.List;

import static co.com.yrm.qa.proyecto.utils.Utils.lsListaTraza;

public class DatosPasajeros implements Task {

    DatosPasajeroModel datosPasajeroModel = new DatosPasajeroModel();

    public DatosPasajeros(List<String> data) {
        datosPasajeroModel.setNombres(data.get(0));
        datosPasajeroModel.setApellidos(data.get(1));
        datosPasajeroModel.setPaisResidencia(data.get(2));
        datosPasajeroModel.setTipoDocumento(data.get(3));
        datosPasajeroModel.setNumeroDocumento(data.get(4));
        datosPasajeroModel.setEmail(data.get(5));
        datosPasajeroModel.setTelefono(data.get(6));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                SendKeys.of(datosPasajeroModel.getNombres()).into(DatosPasajeroPage.TXT_NOMBRES),
                SendKeys.of(datosPasajeroModel.getApellidos()).into(DatosPasajeroPage.TXT_APELLIDOS),
                SelectFromOptions.byVisibleText(datosPasajeroModel.getPaisResidencia()).from(DatosPasajeroPage.CMB_PAIS_RESIDENCIA),
                SelectFromOptions.byValue("LOCAL").from(DatosPasajeroPage.CMB_TIPO_DOCUMENTO),
                SendKeys.of(datosPasajeroModel.getNumeroDocumento()).into(DatosPasajeroPage.TXT_IDENTIFICACION),
                SendKeys.of(datosPasajeroModel.getEmail()).into(DatosPasajeroPage.TXT_EMAIL),
                SendKeys.of(datosPasajeroModel.getEmail()).into(DatosPasajeroPage.TXT_CONFIRMAR_EMAIL),
                SendKeys.of("0").into(DatosPasajeroPage.TXT_AREA_TELEFONO),
                SendKeys.of(datosPasajeroModel.getTelefono()).into(DatosPasajeroPage.TXT_TELEFONO)

        );

    }

    public static DatosPasajeros ingresarDatos(List<String> data) {
        return Tasks.instrumented(DatosPasajeros.class, data);
    }
}
