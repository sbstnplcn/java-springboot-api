package MyApi.controllers;

import MyApi.models.Car;
import MyApi.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/cars")
public class CarRestController {

    @Autowired
    private CarRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Car>> getAllCars(){
        return new ResponseEntity<>((Collection<Car>) repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"name"})
    public ResponseEntity<Collection<Car>> findCarByName(@RequestParam(value="name") String name) {
        return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"name", "color"})
    public ResponseEntity<Collection<Car>> findCarByNameAndColor(@RequestParam(value="name") String name, @RequestParam(value="color") String color) {
        return new ResponseEntity<>(repository.findByNameAndColor(name, color), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addCar(@RequestBody Car input) {
        return new ResponseEntity<>(repository.save(input), HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCar(@PathVariable("id") Long id, @RequestBody Car input) {
        Car currentCar = repository.findOne(id);
        currentCar.setName(input.getName());
        currentCar.setColor(input.getColor());
        return new ResponseEntity<Car>(repository.save(currentCar), HttpStatus.OK);
    }

    //DELETE
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public HttpStatus delete(@PathVariable Long id) {
        repository.delete(id);
        return HttpStatus.OK;
    }

}