package ProyectoFinal2_B.ApiFinalBoss.modules.eventos.repository;

import ProyectoFinal2_B.ApiFinalBoss.modules.eventos.entity.EventosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventosRepository extends JpaRepository<EventosEntity, Long> {

}
