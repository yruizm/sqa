package co.com.yrm.qa.proyecto.tasks;


import co.com.yrm.qa.proyecto.models.DatosPasajeroModel;
import co.com.yrm.qa.proyecto.userinterfaces.DatosPasajeroPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SendKeys;
import java.util.List;

public class DatosAlojamiento implements Task {

    DatosPasajeroModel datosPasajeroModel = new DatosPasajeroModel();

    public DatosAlojamiento(List<String> data) {
        datosPasajeroModel.setNombres(data.get(0));
        datosPasajeroModel.setApellidos(data.get(1));
        datosPasajeroModel.setEmail(data.get(2));
        datosPasajeroModel.setTelefono(data.get(3));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                SendKeys.of(datosPasajeroModel.getNombres()).into(DatosPasajeroPage.TXT_NOMBRES),
                SendKeys.of(datosPasajeroModel.getApellidos()).into(DatosPasajeroPage.TXT_APELLIDOS),
                SendKeys.of(datosPasajeroModel.getEmail()).into(DatosPasajeroPage.TXT_EMAIL),
                SendKeys.of(datosPasajeroModel.getEmail()).into(DatosPasajeroPage.TXT_CONFIRMAR_EMAIL),
                SendKeys.of("0").into(DatosPasajeroPage.TXT_AREA_TELEFONO),
                SendKeys.of(datosPasajeroModel.getTelefono()).into(DatosPasajeroPage.TXT_TELEFONO)

        );

    }

    public static DatosAlojamiento ingresarDatos(List<String> data) {
        return Tasks.instrumented(DatosAlojamiento.class, data);
    }
}
