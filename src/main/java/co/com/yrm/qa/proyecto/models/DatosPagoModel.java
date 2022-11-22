package co.com.yrm.qa.proyecto.models;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"numeroTC","titularTC","vencimientoTC","codigoTC","documentoTitularTC"})

public class DatosPagoModel {
    private String numeroTC;
    private String titularTC;
    private String vencimientoTC;
    private String codigoTC;
    private String documentoTitularTC;
}
