package ProyectoFinal2_B.ApiFinalBoss.modules.clientes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClienteDTO {

    private Long idCliente;

    @NotBlank(message = "falta el nombre")
    private String nombre;

    @NotBlank(message = "falta el apellido")
    private String apellido;

    @NotBlank(message = "falta el telefono")
    private String telefono;

    @Email
    @NotBlank(message = "falta el email")
    private String email;

    @NotBlank(message = "falta la direccion")
    private String direccion;
}
