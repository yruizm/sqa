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
@JsonPropertyOrder({"destinoHotel","fechaIda","fechaRegreso"})

public class FiltrarAlojamientoModel {
    private String destinoHotel;
    private String fechaIda;
    private String fechaRegreso;

}
