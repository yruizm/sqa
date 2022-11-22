package co.com.yrm.qa.proyecto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FiltrarPaquetePage {

    private FiltrarPaquetePage() {
    }

    

    public static final Target LNK_PAQUETE = Target.the("Origen")
            .locatedBy("//a[contains(@title,'Paquetes')]");

    public static final Target INPUT_DESTINO = Target.the("Destino")
            //.locatedBy("//input[contains(@placeholder,'Ingresa hacia dónde viajas')]");
            .locatedBy("//*[@id='searchbox-sbox-box-packages']/div/div/div/div/div[3]/div[1]/div/div[2]/div/div/input");

    public static final Target VER_CALENDARIO_IDA = Target.the("CALENDARIO IDA")
            //.locatedBy("//input[contains(@placeholder,'Ida')]");
            .locatedBy("//*[@id='searchbox-sbox-box-packages']/div/div/div/div/div[3]/div[2]/div[1]/div[1]/div/div/div/div/input");
    public static final Target FECHA_IDA = Target.the("CALENDARIO IDA")
            .locatedBy("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[contains(@data-month,'{0}')]//child::div[@class='sbox5-monthgrid-datenumber-number' and contains(text(),'{1}')]");


    public static final Target VER_CALENDARIO_REGRESO = Target.the("CALENDARIO_REGRESO")
            .locatedBy("//input[contains(@placeholder,'Vuelta')]");

    public static final Target FECHA_REGRESO = Target.the("CALENDARIO IDA")
            .locatedBy("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[contains(@data-month,'{0}')]//child::div[@class='sbox5-monthgrid-datenumber-number' and contains(text(),'{1}')]");

    public static final Target BTN_BUSCAR =
            Target.the("Boton de Buscar")
                    .located(By.xpath("//*[@id='searchbox-sbox-box-packages']/div/div/div/div/div[3]/div[4]/button/em"));



}
