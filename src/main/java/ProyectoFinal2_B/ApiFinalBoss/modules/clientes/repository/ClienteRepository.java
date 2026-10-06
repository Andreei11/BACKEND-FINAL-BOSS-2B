package ProyectoFinal2_B.ApiFinalBoss.modules.clientes.repository;

import ProyectoFinal2_B.ApiFinalBoss.modules.clientes.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
