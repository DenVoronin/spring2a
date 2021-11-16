package cars.repository;

import cars.entity.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface EngineRepository extends JpaRepository<Engine, Integer> {
    @Query("select b from Engine b where b.name = :name")
    Engine findByName(@Param("name") String name);

    @Query("select b from Engine b where b.id = :id")
    Engine findById(@Param("id") int id);
}
