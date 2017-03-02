package MyApi;

import MyApi.models.Car;
import MyApi.models.Garage;
import MyApi.repositories.CarRepository;
import MyApi.repositories.GarageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner initializeDb(CarRepository repository, GarageRepository garageRepository){
        return (args) -> {
            repository.deleteAll();
            repository.save(new Car(1L,"Citroen", "Blue"));
            repository.save(new Car(2L,"Ferrari", "Red"));
            repository.save(new Car(3L,"Renault", "Grey"));
            repository.save(new Car(4L,"Peugeot", "White"));
            repository.save(new Car(5L,"VW", "Blue"));
            garageRepository.deleteAll();
            garageRepository.save(new Garage(1L,"Toulouse"));
            garageRepository.save(new Garage(2L,"Bordeaux"));
            garageRepository.save(new Garage(3L,"Paris"));
        };
    }
}