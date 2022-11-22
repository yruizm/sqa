package co.com.yrm.qa.proyecto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FiltrarPage {

    private FiltrarPage() {
    }
    
    public static final Target RDB_IDA = Target.the("Seleccionar Ida")
    .locatedBy("//*[@id='searchbox-sbox-box-flights']/div/div/div/div[2]/div/div[2]/span/label/i");


    public static final Target INPUT_DESTINO = Target.the("Destino")
            .locatedBy("//input[contains(@placeholder,'Ingresa hacia')]");

    public static final Target VER_CALENDARIO_IDA = Target.the("CALENDARIO IDA")
            .locatedBy("//input[contains(@placeholder,'Ida')]");

    public static final Target FECHA_IDA = Target.the("CALENDARIO IDA")
            .locatedBy("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[contains(@data-month,'{0}')]//child::div[@class='sbox5-monthgrid-datenumber-number' and contains(text(),'{1}')]");

    public static final Target FECHA_REGRESO = Target.the("CALENDARIO IDA")
            .locatedBy("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[contains(@data-month,'{0}')]//child::div[@class='sbox5-monthgrid-datenumber-number' and contains(text(),'{1}')]");

    public static final Target BTN_BUSCAR =
            Target.the("Boton de Buscar")
                    .located(By.xpath("//button[@type='button']/em[contains(text(),'Buscar')]"));


}
