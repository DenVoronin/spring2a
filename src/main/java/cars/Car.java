package cars;




import javax.persistence.*;


@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int id;
    public String manufacturedName;
    public String engine;
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
        return engine;
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


    Car (String modelName, String manufacturedName, String engine, String wheel, String transmission, String gear){
        this.engine=engine;
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

        return String.join(" ", manufacturedName, modelName, engine,wheel, gear, transmission );
    }
}
