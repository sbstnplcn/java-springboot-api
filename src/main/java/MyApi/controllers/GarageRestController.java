package MyApi.controllers;

import MyApi.models.Garage;
import MyApi.repositories.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/garage")
public class GarageRestController {

    @Autowired
    private GarageRepository garageRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Garage>> getAllGarage(){
        return new ResponseEntity<>((Collection<Garage>) garageRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Garage> getGarageById(@PathVariable Long id) {
        return new ResponseEntity<>(garageRepository.findOne(id),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"name"})
    public ResponseEntity<Collection<Garage>> findGarageByName(@RequestParam(value="name") String name) {
        return new ResponseEntity<>(garageRepository.findByName(name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addGarage(@RequestBody Garage input) {
        return new ResponseEntity<>(garageRepository.save(input), HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        garageRepository.delete(id);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateGarage(@PathVariable("id") Long id, @RequestBody Garage input) {
        Garage currentGarage = garageRepository.findOne(id);
        currentGarage.setName(input.getName());
        return new ResponseEntity<Garage>(garageRepository.save(currentGarage), HttpStatus.OK);
    }

}