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
@JsonPropertyOrder({"nombres","apellidos","paisResidencia","tipoDocumento","numeroDocumento","email","telefono"})

public class DatosPasajeroModel {
    private String nombres;
    private String apellidos;
    private String paisResidencia;
    private String tipoDocumento;
    private String numeroDocumento;
    private String fechaNacimiento;
    private String genero;
    private String email;
    private String telefono;
    private String nombresDos;
    private String apellidosDos;
    private String numeroDocumentoDos;
    private String fechaNacimientoDos;
    private String generoDos;

}
