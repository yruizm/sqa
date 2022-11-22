package co.com.yrm.qa.proyecto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosPaquetePage {


    private DatosPaquetePage() {
    }

    public static final Target TXT_NOMBRES_UNO =
            Target.the("Nombres")
                    .locatedBy("//div[contains(text(),'Adulto 1')]/following::input[contains(@placeholder,'Como figura en el documento de viaje')][1]");

    public static final Target TXT_APELLIDOS_UNO =
            Target.the("Apellidos")
                    .locatedBy("//div[contains(text(),'Adulto 1')]/following::input[contains(@placeholder,'Como figura en el documento de viaje')][2]");

    public static final Target TXT_IDENTIFICACION_UNO =
            Target.the("Identificacion")
                    .located(By.id("traveler-identification-number-0"));

    public static final Target CMB_DIA_NACIMIENTO_UNO =
            Target.the("Pais Residencia")
                    .located(By.id("traveler-birthday-day-0"));

    public static final Target CMB_MES_NACIMIENTO_UNO =
            Target.the("Pais Residencia")
                    .located(By.id("traveler-birthday-month-0"));

    public static final Target CMB_ANO_NACIMIENTO_UNO =
            Target.the("Pais Residencia")
                    .located(By.id("traveler-birthday-year-0"));

    public static final Target TXT_NOMBRES_DOS =
            Target.the("Nombres")
                    .locatedBy("//div[contains(text(),'Adulto 2')]/following::input[contains(@placeholder,'Como figura en el documento de viaje')][1]");

    public static final Target TXT_APELLIDOS_DOS =
            Target.the("Apellidos")
                    .locatedBy("//div[contains(text(),'Adulto 2')]/following::input[contains(@placeholder,'Como figura en el documento de viaje')][2]");

    public static final Target TXT_IDENTIFICACION_DOS =
            Target.the("Identificacion")
                    .located(By.id("traveler-identification-number-1"));


    public static final Target CMB_DIA_NACIMIENTO_DOS =
            Target.the("Pais Residencia")
                    .located(By.id("traveler-birthday-day-1"));

    public static final Target CMB_MES_NACIMIENTO_DOS =
            Target.the("Pais Residencia")
                    .located(By.id("traveler-birthday-month-1"));

    public static final Target CMB_ANO_NACIMIENTO_DOS =
            Target.the("Pais Residencia")
                    .located(By.id("traveler-birthday-year-1"));


    public static final Target RDB_GENERO_FEMENINO_UNO = Target.the("Seleccionar Ida")
            .locatedBy("//*[@class='group-items']/following::em[contains(text(),'Femenino')][1]");

    public static final Target RDB_GENERO_MASCULINO_DOS = Target.the("Seleccionar Ida")
            .locatedBy("//*[@class='group-items']//following::em[contains(text(),'Masculino')][2]");

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
