package co.com.yrm.qa.proyecto.interactions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.DriverTask;
import org.openqa.selenium.WebDriver;

public class Close {

    private Close(){}

    public static Performable browser() {
        return new DriverTask(WebDriver::quit);
    }
}
