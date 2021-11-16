package cars.entity;




import cars.repository.EngineRepository;
import cars.services.impl.EngineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;


@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int id;
    @Basic
    @Column(name = "manufactured_name")
    public String manufacturedName;
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "engine")
    public Engine engine;
    @Basic
    @Column(name = "model_name")
    public String modelName;
    public String wheel;
    public String transmission;
    public String gear; //?

    public String getWheel() {
        return wheel;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getManufacturedName() {
        return manufacturedName;
    }

    public String getEngine() {
        return
            "<strong> Name: </strong>"
            +engine.name
            + "<br>"
                    + "<strong> Type: </strong>"
            +engine.engineType;
    }

    public String getGear() {
        return gear;
    }

    public void setManufacturerName(String manufacturedName) {
        this.manufacturedName = manufacturedName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car(){}


    public Car(String modelName, String manufacturedName, Engine engine, String wheel, String transmission, String gear){


        this.engine= engine;
        this.manufacturedName=manufacturedName;
        this.modelName=modelName;
        this.gear=gear;
        this.wheel=wheel;
        this.transmission=transmission;
    }

    public int getId() {
        return id;
    }

    public String getManufacturerName() {
        return manufacturedName;
    }

    public String getModelName() {
        return modelName;
    }

    public String toString() {

        return String.join(" ", manufacturedName, modelName, engine.toString(),wheel, gear, transmission );
    }
}
