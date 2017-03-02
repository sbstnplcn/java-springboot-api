package MyApi.controllers;

import MyApi.models.Car;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController

public class HomeController{
    @RequestMapping("/")

    public String countColor(){

        List<Car> cars = new ArrayList<>();
        cars.add(new Car().setId(1L).setName("Citroen").setColor("Blue"));
        cars.add(new Car().setId(2L).setName("Ferrari").setColor("Red"));
        cars.add(new Car().setId(2L).setName("VW").setColor("Red"));

        Set<String> numberOfColor = cars.stream()
                .filter(a-> a.getColor().startsWith(""))
                .map(Car::getColor)
                .collect(Collectors.toSet());

        Set<String> filterByNameAndColor = cars.stream()
                .filter(a-> a.getName().startsWith("C"))
                .filter(a-> a.getColor().startsWith("B"))
                .map(Car::getName)
                .collect(Collectors.toSet());

        return "There is " + numberOfColor.size() +" colors. " + filterByNameAndColor;

    }
}