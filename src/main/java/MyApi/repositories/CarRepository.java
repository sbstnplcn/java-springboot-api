package MyApi.repositories;


import MyApi.models.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findByName(String name);
    List<Car> findByNameAndColor(String name, String color);
}