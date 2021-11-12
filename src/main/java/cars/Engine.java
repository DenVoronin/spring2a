package cars;

import javax.persistence.*;

@Entity
@Table(name = "engines")
public class Engine {
    public enum type{
        Petrol,
        Diesel
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String engineType;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEngineType() {
        return engineType;
    }

    public Engine(String name,String type){

        this.name = name;
        this.engineType = type;
   }
    public Engine(){}
   //4b
String powerUp(){
       return "I am running on "+ this.engineType.toString();


}

    public String toString() {

        return String.join(" ", name, engineType);
    }
   //4c
  public static Boolean isFuelAcceptable(String s){
      for (type c : type.values()) {
          if (c.name().equals(s)) {
              return true;
          }
      }

      return false;
  }
}
