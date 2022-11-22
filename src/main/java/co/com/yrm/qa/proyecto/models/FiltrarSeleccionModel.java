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
@JsonPropertyOrder({"idaVuelta","origen","destino","fechaIda","fechaRegreso"})

public class FiltrarSeleccionModel {
    private String idaVuelta;
    private String origen;
    private String destino;
    private String fechaIda;
    private String fechaRegreso;

}
