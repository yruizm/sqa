package co.com.yrm.qa.proyecto.stepdefinitions;


import co.com.yrm.qa.proyecto.tasks.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ReservasDespegarStepDefinitions {


	@Dado("el ingreso al sitio web {string}")
	public void elIngresoAlSitioWeb(String strUrl) {
		OnStage.setTheStage(new OnlineCast());
		OnStage.theActorCalled("Actor").attemptsTo(
				Open.theWebSite(strUrl)
		);
	}

	@Entonces("diligencio la informacion del pago")
	public void diligencioLaInformacionDelPago(DataTable datosPago) {
		theActorInTheSpotlight().wasAbleTo(DatosPago.ingresarDatos(datosPago.transpose().asList(String.class)));
	}

}
