package co.com.yrm.qa.proyecto.stepdefinitions;


import co.com.yrm.qa.proyecto.questions.VerificarPresupuesto;
import co.com.yrm.qa.proyecto.tasks.DatosPasajeros;
import co.com.yrm.qa.proyecto.tasks.FiltrarSeleccion;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ReservaVueloStepDefinitions {


	@Cuando("filtro los datos del vuelo")
	public void filtroLosDatosDelVuelo(DataTable dataFiltros) {
		theActorInTheSpotlight().wasAbleTo(FiltrarSeleccion.filtros(dataFiltros.transpose().asList(String.class)));
	}

	@Cuando("seleccione Tiquetes dentro del rango {int}")
	public void seleccioneTiquetesDentroDelRango(Integer intPresupuesto) {
		theActorInTheSpotlight().should(seeThat(VerificarPresupuesto.enPaginaPrincipal(intPresupuesto)));
	}

	@Cuando("diligencio los datos personales")
	public void diligencioLosDatosPersonales(DataTable dataFormulario) {
		theActorInTheSpotlight().wasAbleTo(DatosPasajeros.ingresarDatos(dataFormulario.transpose().asList(String.class)));
	}


}
