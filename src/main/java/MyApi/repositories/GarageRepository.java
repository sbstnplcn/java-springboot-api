package MyApi.repositories;


import MyApi.models.Garage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GarageRepository extends CrudRepository<Garage, Long> {
    List<Garage> findByName(String name);
}