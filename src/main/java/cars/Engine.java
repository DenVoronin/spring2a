package cars;

public class Engine {
    public enum type{
        Petrol,
        Diesel
    }
    type engineType;
   public Engine(type type){
       this.engineType = type;
   }

   //4b
String powerUp(){
       return "I am running on "+ this.engineType.toString();


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
