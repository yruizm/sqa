package co.com.yrm.qa.proyecto.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaPrincipal extends PageObject{

    public static final Target CERRAR_INICIO_SESION =
            Target.the("Seleccion de combobox tipo documento")
                    .located(By.xpath("/html/body/nav/div[4]/div[1]/i"));
    public static final Target ENTENDI_COOKIES =
            Target.the("seleccionar opcion CC").located(By.xpath("//*[@id='lgpd-banner']/div/a[2]"));


}
