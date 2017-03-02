package MyApi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String color;

    public Car() {}

    public Car(Long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Car setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Car setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public Car setColor(String color) {
        this.color = color;
        return this;
    }

    public String getColor() {
        return color;
    }
}