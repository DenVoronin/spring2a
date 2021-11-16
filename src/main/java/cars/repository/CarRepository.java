package cars.repository;

import cars.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface CarRepository extends JpaRepository<Car, Integer> {
    @Query("select b from Car b where b.modelName = :name")
   Car findByName(@Param("name") String name);

    @Query("select b from Car b where b.id = :id")
    Car findById(@Param("id") int id);
}
