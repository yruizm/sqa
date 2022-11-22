package co.com.yrm.qa.proyecto.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/reservas_despegar.feature",
        tags = "@ReservaAlojamiento",
        glue = "co.com.yrm.qa.proyecto.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerSuite {

}
