package co.com.yrm.qa.proyecto.tasks;


import co.com.yrm.qa.proyecto.models.DatosPasajeroModel;
import co.com.yrm.qa.proyecto.userinterfaces.DatosPaquetePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.SendKeys;
import java.util.List;

public class DatosPasajeroPaquete implements Task {

    DatosPasajeroModel datosPasajeroModel = new DatosPasajeroModel();

    public DatosPasajeroPaquete(List<String> data) {

        datosPasajeroModel.setNombres(data.get(0));
        datosPasajeroModel.setApellidos(data.get(1));
        datosPasajeroModel.setNumeroDocumento(data.get(2));
        datosPasajeroModel.setFechaNacimiento(data.get(3));
        datosPasajeroModel.setGenero(data.get(4));

        datosPasajeroModel.setNombresDos(data.get(5));
        datosPasajeroModel.setApellidosDos(data.get(6));
        datosPasajeroModel.setNumeroDocumentoDos(data.get(7));
        datosPasajeroModel.setFechaNacimientoDos(data.get(8));
        datosPasajeroModel.setGeneroDos(data.get(9));

        datosPasajeroModel.setEmail(data.get(10));
        datosPasajeroModel.setTelefono(data.get(11));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String[] fechaUno= datosPasajeroModel.getFechaNacimiento().split("-");
        String[] fechaDos= datosPasajeroModel.getFechaNacimientoDos().split("-");
        actor.attemptsTo(
                SendKeys.of(datosPasajeroModel.getNombres()).into(DatosPaquetePage.TXT_NOMBRES_UNO),
                SendKeys.of(datosPasajeroModel.getApellidos()).into(DatosPaquetePage.TXT_APELLIDOS_UNO),
                SendKeys.of(datosPasajeroModel.getNumeroDocumento()).into(DatosPaquetePage.TXT_IDENTIFICACION_UNO),

                SelectFromOptions.byValue(fechaUno[0]).from(DatosPaquetePage.CMB_DIA_NACIMIENTO_UNO),
                SelectFromOptions.byValue(fechaUno[1]).from(DatosPaquetePage.CMB_MES_NACIMIENTO_UNO),
                SelectFromOptions.byValue(fechaUno[2]).from(DatosPaquetePage.CMB_ANO_NACIMIENTO_UNO),
                Click.on(DatosPaquetePage.RDB_GENERO_FEMENINO_UNO),

                SendKeys.of(datosPasajeroModel.getNombresDos()).into(DatosPaquetePage.TXT_NOMBRES_DOS),
                SendKeys.of(datosPasajeroModel.getApellidosDos()).into(DatosPaquetePage.TXT_APELLIDOS_DOS),
                SendKeys.of(datosPasajeroModel.getNumeroDocumentoDos()).into(DatosPaquetePage.TXT_IDENTIFICACION_DOS),
                SelectFromOptions.byValue(fechaDos[0]).from(DatosPaquetePage.CMB_DIA_NACIMIENTO_DOS),
                SelectFromOptions.byValue(fechaDos[1]).from(DatosPaquetePage.CMB_MES_NACIMIENTO_DOS),
                SelectFromOptions.byValue(fechaDos[2]).from(DatosPaquetePage.CMB_ANO_NACIMIENTO_DOS),
                Click.on(DatosPaquetePage.RDB_GENERO_MASCULINO_DOS),


                SendKeys.of(datosPasajeroModel.getEmail()).into(DatosPaquetePage.TXT_EMAIL),
                SendKeys.of(datosPasajeroModel.getEmail()).into(DatosPaquetePage.TXT_CONFIRMAR_EMAIL),
                SendKeys.of("0").into(DatosPaquetePage.TXT_AREA_TELEFONO),
                SendKeys.of(datosPasajeroModel.getTelefono()).into(DatosPaquetePage.TXT_TELEFONO)

        );


    }

    public static DatosPasajeroPaquete ingresarDatos(List<String> data) {
        return Tasks.instrumented(DatosPasajeroPaquete.class, data);
    }
}
