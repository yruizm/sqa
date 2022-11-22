package co.com.yrm.qa.proyecto.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ResultadosPage extends PageObject{

    public static final Target SPAN_VUELOS =
            Target.the("seleccionar opcion CC").located(By.xpath("//div[@class='sbox-mobile-body sbox-bind-disable-date']//span[@class='sbox-title sbox-3-h4' and contains(text(),'Vuelos baratos')]"));

    public static final Target RECORRER_PRECIOS =
            Target.the("Seleccion de combobox tipo documento")
                    .located(By.xpath("//*[@classes='fare-price']//span[@class='amount price-amount']"));

    public static final Target RECORRER_PRECIOS_ALOJAMIENTO =
            Target.the("Seleccion de combobox tipo documento")
                    .located(By.xpath("//*[@class='price-info-wrapper -eva-3-mt-xsm']/span[2]"));

    public static final Target BTN_COMPRAR =
            Target.the("Boton de confirmar el codigo OTP ingresado")
                    .locatedBy("//*[@classes='fare-price']//span[@class='amount price-amount' and contains(text(),'{0}')]/following::buy-button[1]/a");
    public static final Target BTN_VER_DETALLE =
            Target.the("Boton de confirmar el codigo OTP ingresado")
                    .locatedBy("//*[@class='price-info-wrapper -eva-3-mt-xsm']//span[contains(text(),'{0}')]/following::button[1]/em");

    public static final Target BTN_SIGUIENTE_PAQUETE =
            Target.the("Boton de confirmar el codigo OTP ingresado")
                    .locatedBy("//span[@class='accommodation-name -eva-3-ellipsis' and contains(text(), '{0}')]/following::em[@class='btn-text'][1]");

    public static final Target BTN_SIGUIENTE_HOTEL =
            Target.the("Boton de confirmar el codigo OTP ingresado")
                    .locatedBy("//button[@class='eva-3-btn -md -primary -eva-3-fwidth']/em");

    public static final Target DIV_H3_VENTANA_COMPRA =
            Target.the("Boton de confirmar el codigo OTP ingresado")
                    .located(By.xpath("//*[@class='eva-3-h3 -eva-3-tc -eva-3-tc-gray-0 -eva-3-pb-sm']"));

    public static final Target BTN_CONTINUAR_COMPRA =
            Target.the("Boton de confirmar el codigo OTP ingresado")
                    .located(By.xpath("//*[@class='eva-3-btn pricebox-sticky-button -lg -primary']"));

    public static final Target BTN_RESERVAR_AHORA =
            Target.the("txt de numero de documento")
                    .located(By.xpath("//button[@class='eva-3-btn -md -secondary -eva-3-fwidth']/em"));

    public static final Target BTN_SIGUIENTE =
            Target.the("txt de contrasena")
                    .located(By.xpath("//button[@class='eva-3-btn -lg pricebox-sticky-button -secondary']/em"));

    public static final Target LBL_HOTEL =
        Target.the("Txt para agregar codigo OTP")
            .locatedBy("//span[@class='accommodation-name -eva-3-ellipsis' and contains(text(), '{0}')]");

    public static final Target RECORRER_PRECIOS_PAQUETE =
            Target.the("Seleccion de combobox tipo documento")
                    .locatedBy("//span[@class='accommodation-name -eva-3-ellipsis' and contains(text(), '{0}')]/following::span[@class='tertiary-price'][1]");

}
