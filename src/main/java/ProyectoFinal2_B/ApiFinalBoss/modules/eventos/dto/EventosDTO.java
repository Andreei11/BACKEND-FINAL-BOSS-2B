package ProyectoFinal2_B.ApiFinalBoss.modules.eventos.dto;

import ProyectoFinal2_B.ApiFinalBoss.modules.clientes.entity.ClienteEntity;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EventosDTO {

    private Long idEvento;

    private ClienteEntity idCliente;

    private Long idSalon;

    @NotBlank
    private String nombreEvento;

    @FutureOrPresent
    private LocalDate fechaEvento;

    @PositiveOrZero
    private int cantidadPersonas;

    @PositiveOrZero
    private int cantidadHoras;

    @NotBlank
    private String estado;

    @PositiveOrZero
    private int totalPago;
}
