package co.com.yrm.qa.proyecto.stepdefinitions;


import co.com.yrm.qa.proyecto.questions.SeleccionarAlojamiento;
import co.com.yrm.qa.proyecto.tasks.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ReservaAlojamientoStepDefinitions {

	@Cuando("filtro los datos del Alojamiento")
	public void filtroLosDatosDelVuelo(DataTable dataFiltros) {
		theActorInTheSpotlight().wasAbleTo(FiltrarAlojamiento.busqueda(dataFiltros.transpose().asList(String.class)));
	}


	@Cuando("seleccione alojamiento dentro del rango {int}")
	public void seleccioneAlojamientoDentroDelRango(Integer intPresupuesto) {
		theActorInTheSpotlight().should(seeThat(SeleccionarAlojamiento.enPaginaPrincipal(intPresupuesto)));
	}


	@Cuando("diligencio los datos personales alojamiento")
	public void diligencioLosDatosPersonales(DataTable dataFormulario) {
		theActorInTheSpotlight().wasAbleTo(DatosAlojamiento.ingresarDatos(dataFormulario.transpose().asList(String.class)));
	}


}
