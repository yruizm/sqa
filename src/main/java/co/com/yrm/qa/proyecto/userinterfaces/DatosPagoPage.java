package co.com.yrm.qa.proyecto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosPagoPage {


    private DatosPagoPage() {
    }


    public static final Target TXT_NUMERO_TC =
            Target.the("Numero TC")
                    .locatedBy("//input[contains(@placeholder,'Ingresa el número de tu tarjeta')]");

    public static final Target TXT_TITULAR_TC =
            Target.the("Titular TC")
                    .locatedBy("//input[contains(@placeholder,'Como figura en la tarjeta')]");

    public static final Target TXT_VENCIMIENTO_TC =
            Target.the("Vencimiento TC")
                    .located(By.xpath("//input[contains(@placeholder,'MM/AA')]"));

    public static final Target TXT_CODIGO_TC =
            Target.the("Codigo Seguro TC")
                    .located(By.xpath("//*[@id='formData.paymentData.cardPayments[0].card.securityCode']/div/input"));

    public static final Target TXT_IDENTIFICACION_TITULAR_TC =
            Target.the("Identificacion Titular TC")
                    .located(By.xpath("//input[contains(@placeholder,'Ej.: 15234765')]"));

    public static final Target RBD_CUOTA =
            Target.the("Email")
                    .located(By.xpath("//*[@id='checkout-content']/div[1]/div[2]/payment-component/div/div[1]/payment-method/div/payment-method-selector-container/prepaid-payment-container/div/div/direct-card-load/div/installment-selector/collapse/div/div[2]/div/payment-installment-items/div[1]/div/div[1]/span/label/i"));

    public static final Target ACEPTO_TERMINOS_CONDICIONES =
            Target.the("Confirmar Email")
                    .locatedBy("//input[@id='terms-checkbox']/following::i[1]");

    public static final Target RBD_TARJETA_CREDITO =
            Target.the("Tarjeta de Credito")
                    .locatedBy("//input[@id='payment-method-0']/following::i[1]");
}
