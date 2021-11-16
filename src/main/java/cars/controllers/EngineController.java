package cars.controllers;

import cars.entity.Engine;
import cars.services.impl.CarServiceImpl;
import cars.services.impl.EngineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Component
@org.springframework.stereotype.Controller

public class EngineController {
    private CarServiceImpl carServiceImpl;
    private EngineServiceImpl engineServiceImpl;
    @Autowired
    public EngineController(CarServiceImpl carServiceImpl, EngineServiceImpl engineServiceImpl)
    {
        this.engineServiceImpl = engineServiceImpl;
        this.carServiceImpl = carServiceImpl;
    }

    @RequestMapping(value = {"/createEngine"} , method = RequestMethod.GET)
    public String createOpen(@ModelAttribute Engine engine)  {


        return "createEngine";

    }
    @PostMapping("/createEngine")
    public String createEngine(@RequestParam String name,
                               @RequestParam String engineType)
    {
        Engine engine = new Engine(name,engineType);
        System.out.println(engine.toString());

        engineServiceImpl.newEngine(engine);
        return "index";
    }
    @PostMapping ("/editEngine")
    public String editEngine(@RequestParam String id, @RequestParam String name,
                             @RequestParam String engineType)
    {
        Engine engine = new Engine(name,engineType);
        engine.id=Integer.parseInt(id);
        System.out.println(engine.toString());

        engineServiceImpl.editEngine(engine);
        return "index";
    }
    @RequestMapping(value="/edit/engine/{id}", method = RequestMethod.GET)
    public String editEngine(@PathVariable("id") String id, Model model) {

        Engine engine = engineServiceImpl.getById(Integer.parseInt(id));
        model.addAttribute("engine", engine);
        return "editEngine";
    }
    @RequestMapping(value="/delete/engine/{id}", method = RequestMethod.GET)
    public String deleteEngine(@PathVariable("id") String id) {

        engineServiceImpl.delete((Integer.parseInt(id)));

        return "index";
    }
}
