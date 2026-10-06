package ProyectoFinal2_B.ApiFinalBoss.modules.eventos.service;


import ProyectoFinal2_B.ApiFinalBoss.modules.eventos.dto.EventosDTO;
import ProyectoFinal2_B.ApiFinalBoss.modules.eventos.entity.EventosEntity;
import ProyectoFinal2_B.ApiFinalBoss.modules.eventos.repository.EventosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventosService {

    private EventosRepository repository;

    public EventosDTO nuevoCliente(EventosDTO dto){
        EventosEntity entity = convertirAEntity(dto);
        EventosEntity guardar = repository.save(entity);
        return convertirADTO(guardar);
    }

    private EventosDTO convertirADTO(EventosEntity guardar) {
        EventosDTO dto = new EventosDTO();

        return dto;
    }

    private EventosEntity convertirAEntity(EventosDTO dto) {
        EventosEntity e = new EventosEntity();
        return e;
    }
}
