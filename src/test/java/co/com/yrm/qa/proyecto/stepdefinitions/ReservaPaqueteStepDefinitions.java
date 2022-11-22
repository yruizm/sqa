package co.com.yrm.qa.proyecto.stepdefinitions;


import co.com.yrm.qa.proyecto.questions.SeleccionarPaquete;
import co.com.yrm.qa.proyecto.questions.VerificarPresupuesto;
import co.com.yrm.qa.proyecto.tasks.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ReservaPaqueteStepDefinitions {

	@Cuando("filtro los datos del paquete")
	public void filtroLosDatosDelVuelo(DataTable dataFiltros) {
		theActorInTheSpotlight().wasAbleTo(FiltrarPaquete.busqueda(dataFiltros.transpose().asList(String.class)));
	}

	@Cuando("selecciono paquete dentro del rango con hotel")
	public void seleccioneAlojamientoDentroDelRangoa(DataTable dataFormulario) {
		theActorInTheSpotlight().should(seeThat(SeleccionarPaquete.enPaginaPrincipal(dataFormulario.transpose().asList(String.class))));
		theActorInTheSpotlight().should(seeThat(VerificarPresupuesto.enPaginaPrincipal(SeleccionarPaquete.intPresupuestoRestate)));
	}


	@Cuando("diligencio los datos personales paquete")
	public void diligencioLosDatosPersonales(DataTable dataFormulario) {
		theActorInTheSpotlight().wasAbleTo(DatosPasajeroPaquete.ingresarDatos(dataFormulario.transpose().asList(String.class)));
	}


}
