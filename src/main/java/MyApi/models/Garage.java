package MyApi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Garage(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    //for JPA
    public Garage() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Garage setName(String name) {
        this.name = name;
        return this;
    }
}