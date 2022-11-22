package co.com.yrm.qa.proyecto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosPasajeroPage {


    private DatosPasajeroPage() {
    }


    public static final Target TXT_NOMBRES =
            Target.the("Nombres")
                    .locatedBy("//label[contains(text(),'Nombres')]/following::input[contains(@placeholder,'Como figura en el documento de viaje')][1]");

    public static final Target TXT_APELLIDOS =
            Target.the("Apellidos")
                    .locatedBy("//label[contains(text(),'Nombres')]/following::input[contains(@placeholder,'Como figura en el documento de viaje')][2]");

    public static final Target CMB_PAIS_RESIDENCIA =
            Target.the("Pais Residencia")
                    .located(By.id("traveler-nationality-0"));

    public static final Target CMB_TIPO_DOCUMENTO =
            Target.the("Pais Residencia")
                    .located(By.id("traveler-identification-type-0"));

    public static final Target TXT_IDENTIFICACION =
            Target.the("Identificacion")
                    .located(By.id("traveler-identification-number-0"));

    public static final Target TXT_EMAIL =
            Target.the("Email")
                    .located(By.id("formData.contactData.mainEmailAddress"));

    public static final Target TXT_CONFIRMAR_EMAIL =
            Target.the("Confirmar Email")
                    .located(By.id("formData.contactData.repeatMainEmailAddress"));

    public static final Target TXT_AREA_TELEFONO =
            Target.the("Area de Telefono")
                    .located(By.id("formData.contactData.phones[0].areaCode"));

    public static final Target TXT_TELEFONO =
            Target.the("Telefono")
                    .located(By.id("formData.contactData.phones[0].number"));

}
