package ProyectoFinal2_B.ApiFinalBoss.modules.clientes.controller;

import ProyectoFinal2_B.ApiFinalBoss.modules.clientes.dto.ClienteDTO;
import ProyectoFinal2_B.ApiFinalBoss.modules.clientes.service.ClienteService;
import ProyectoFinal2_B.ApiFinalBoss.reponse.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("api/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PutMapping("actualizar/id")
    public ResponseEntity<ApiResponse<ClienteDTO>> actualizar(@PathVariable @Valid @RequestBody Long id, ClienteDTO dto){
        try {
            ClienteDTO dato = service.actualizar(dto, id);
            if(dato == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>(false,"no se actualizo"));
            }
            return ResponseEntity.ok(new ApiResponse<>(true,"si se actualizaron los datos"));
        }
        catch (Exception e){
            log.error("error al actualizar los datos del cliente", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false,"error no se actualizar"));
        }
    }

    @DeleteMapping("eliminar/id")
    public ResponseEntity<ApiResponse<Void>> eliminar(@PathVariable Long id){
        try {
            if(service.eliminarCliente(id)){
                return ResponseEntity.ok(new ApiResponse<>(true,"se elimino correctamente"));
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(true,"se elimino el cliente"));
        }
        catch (Exception e){
            log.error("error al eliminar al cliente", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false,"error no se elimino"));
        }
    }

    @PostMapping("/agregar")
    public ResponseEntity<ApiResponse<ClienteDTO>> agregar(@Valid @RequestBody ClienteDTO json){
        try {
            ClienteDTO dto = service.nuevoCliente(json);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse<>(true,"creado exitosamente" , json));
        }
        catch (Exception e){
            log.error("error al crear al cliente", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false,"error no se creo"));
        }
    }

    @GetMapping("/ver")
    public ResponseEntity<ApiResponse<List<ClienteDTO>>> listar(){
        try {
            List<ClienteDTO> list = service.obtenerTodos();
            return ResponseEntity.ok(new ApiResponse<>(true,"datos encontrados",list));
        }
        catch (Exception e){
            log.error("error al encontrar los datos", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false,"datos no encontrados"));
        }
    }
}
