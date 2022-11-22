package co.com.yrm.qa.proyecto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FiltrarAlojamientoPage {

    private FiltrarAlojamientoPage() {
    }

    public static final Target LNK_ALOJAMIENTO = Target.the("Origen")
            .locatedBy("//a[contains(@title,'Alojamientos')]");

    public static final Target INPUT_DESTINO = Target.the("Destino")
            //.locatedBy("//input[contains(@placeholder,'Ingresa hacia dónde viajas')]");
            .locatedBy("//input[contains(@placeholder,'Ingresa una ciudad, alojamiento o punto de interés')]");

    public static final Target VER_CALENDARIO_IDA = Target.the("CALENDARIO IDA")
            //.locatedBy("//input[contains(@placeholder,'Ida')]");
            .locatedBy("//input[contains(@placeholder,'Entrada')]");
    public static final Target FECHA_IDA = Target.the("CALENDARIO IDA")
            .locatedBy("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[contains(@data-month,'{0}')]//child::div[@class='sbox5-monthgrid-datenumber-number' and contains(text(),'{1}')]");

    public static final Target FECHA_REGRESO = Target.the("CALENDARIO IDA")
            .locatedBy("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[contains(@data-month,'{0}')]//child::div[@class='sbox5-monthgrid-datenumber-number' and contains(text(),'{1}')]");

    public static final Target BTN_BUSCAR =
            Target.the("Boton de Buscar")
                    .located(By.xpath("//*[@id='searchbox-sbox-box-hotels']/div/div/div/div/div[3]/button/em"));

}
