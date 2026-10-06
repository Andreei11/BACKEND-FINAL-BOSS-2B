package ProyectoFinal2_B.ApiFinalBoss.modules.eventos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "EVENTOS")
public class EventosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private Long idEvento;


    @Column(name = "id_cliente")
    private Long idCliente;


    @Column(name = "id_salon")
    private Long idSalon;

    @Column(name = "nombre_evento")
    private String nombreEvento;

    @Column(name = "fecha_evento")
    private LocalDate fechaEvento;

    @Column(name = "cantidad_personas")
    private int cantidadPersonas;

    @Column(name = "cantidad_horas")
    private int cantidadHoras;

    @Column(name = "estado")
    private String estado;

    @Column(name = "total_pago")
    private int totalPago;
}
