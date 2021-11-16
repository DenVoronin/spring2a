package cars.controllers;

import cars.entity.Car;
import cars.entity.Engine;
import cars.services.impl.CarServiceImpl;
import cars.services.impl.EngineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Component

@org.springframework.stereotype.Controller

public class CarController {


    private CarServiceImpl carServiceimpl;
    private EngineServiceImpl engineServiceImpl;

    @Autowired
    public CarController(CarServiceImpl carServiceimpl, EngineServiceImpl engineServiceImpl  )
    {

        this.carServiceimpl = carServiceimpl;
        this.engineServiceImpl = engineServiceImpl;
    }



    @RequestMapping(value = {"/create"} , method = RequestMethod.GET)
    public String createOpen(@ModelAttribute Car car, Model modelE)  {

        ArrayList<Engine> engines = new ArrayList<>(engineServiceImpl.getAll());
        engines.stream().forEach(e -> System.out.println(e.toString()));
        modelE.addAttribute("engines", engines);
        return "create";

    }

    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") String id,Model model,Model modelE) {
        ArrayList<Engine> engines = new ArrayList<>(engineServiceImpl.getAll());
        engines.stream().forEach(e -> System.out.println(e.toString()));
        modelE.addAttribute("engines", engines);
        Car car = carServiceimpl.getById(Integer.parseInt(id));
        model.addAttribute("car", car);
        return "edit";
    }

    @PostMapping ("/create")
    public String update(@RequestParam String id,@RequestParam String modelName,@RequestParam String manufacturedName,
                         @RequestParam int engine,@RequestParam String wheel,
                         @RequestParam String transmission,@RequestParam String gear) {
        Car car = new Car(modelName, manufacturedName, engineServiceImpl.getById(engine), wheel, transmission, gear);
         car.id=Integer.parseInt(id);
      //  System.out.println(car.toString());
        carServiceimpl.editCar(car);
        return "index";
    }

        @PostMapping ("/")
        public String create(@RequestParam String modelName,@RequestParam String manufacturedName,
            @RequestParam int engine,@RequestParam String wheel,
            @RequestParam String transmission,@RequestParam String gear)
        {
            Car car = new Car(modelName,manufacturedName,engineServiceImpl.getById(engine),wheel,transmission,gear);

            System.out.println(car.toString());
            carServiceimpl.newCar(car);
            return "create";
    }



    @RequestMapping(value = { "/index" , "/"}, method = RequestMethod.GET)
    public String index(Model model, Model modelE){

        ArrayList<Car> cars = new ArrayList<>(carServiceimpl.getAll());
        cars.stream().forEach(e -> System.out.println(e.toString()));
        model.addAttribute("cars", cars);
        ArrayList<Engine> engines = new ArrayList<>(engineServiceImpl.getAll());
        engines.stream().forEach(e -> System.out.println(e.toString()));
        model.addAttribute("engines", engines);
      return "index";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteFilm(@PathVariable("id") String id) {
        carServiceimpl.getById(Integer.parseInt(id)).engine=null;
        carServiceimpl.delete(Integer.parseInt(id));

        return "index";
    }


   // @GetMapping(value = "/fuel/check/")
   // public ResponseEntity<List<Car>> checkFuel(@RequestParam String type) throws Exception {
       // try {
      //      if (Engine.powerUp(type) == false) { throw new Exception(); }
      //  } catch (Exception ex) {
      //      throw new Exception("This type of engine is incorrect");
     //   }
  //  }
    }

