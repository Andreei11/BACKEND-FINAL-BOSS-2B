package ProyectoFinal2_B.ApiFinalBoss.modules.clientes.service;

import ProyectoFinal2_B.ApiFinalBoss.modules.clientes.dto.ClienteDTO;
import ProyectoFinal2_B.ApiFinalBoss.modules.clientes.entity.ClienteEntity;
import ProyectoFinal2_B.ApiFinalBoss.modules.clientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private ClienteRepository repo;

    public ClienteDTO nuevoCliente(ClienteDTO dto){
        ClienteEntity entity = convertirAEntity(dto);
        ClienteEntity guardar = repo.save(entity);
        return convertirADTO(guardar);
    }

    public ClienteDTO actualizar(ClienteDTO dto, Long id){
        Optional<ClienteEntity> opt = repo.findById(id);
        if(opt.isEmpty()){
            return null;
        }
        ClienteEntity entity = opt.get();
        return convertirADTO(repo.save(entity));
    }

    public boolean eliminarCliente(Long id){
        if(!repo.existsById(id)){
            return false;
        }
        repo.deleteById(id);
        return true;
    }

    public ClienteDTO obtenerPorId(Long id){
        Optional<ClienteEntity> opt = repo.findById(id);
        return opt.isPresent() ? convertirADTO(opt.get()):null;
    }

    public List<ClienteDTO> obtenerTodos(){
        List<ClienteDTO> lista = new ArrayList<>();
        for(ClienteEntity e: repo.findAll()){
            lista.add(convertirADTO(e));
        }
        return lista;
    }

    private ClienteDTO convertirADTO(ClienteEntity guardar) {
        ClienteDTO dto = new ClienteDTO();
        dto.setIdCliente(guardar.getIdCliente());
        dto.setNombre(guardar.getNombre());
        dto.setApellido(guardar.getApellido());
        dto.setTelefono(guardar.getTelefono());
        dto.setEmail(guardar.getEmail());
        dto.setDireccion(guardar.getDireccion());

        return dto;
    }

    private ClienteEntity convertirAEntity(ClienteDTO dto) {
        ClienteEntity e = new ClienteEntity();
        e.setNombre(dto.getNombre());
        e.setApellido(dto.getApellido());
        e.setTelefono(dto.getTelefono());
        e.setEmail(dto.getEmail());
        e.setDireccion(dto.getDireccion());

        return e;
    }
}
