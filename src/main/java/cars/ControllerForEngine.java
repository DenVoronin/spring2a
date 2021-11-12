package cars;

import cars.Engine;
import cars.services.DAOForEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class ControllerForEngine {
    private DAOForEngine daoForEngine;

    @Autowired
    public ControllerForEngine(DAOForEngine daoForEngine  )
    {


        this.daoForEngine = daoForEngine;
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

        DAOForEngine.newEngine(engine);
        return "index";
    }
    @PostMapping ("/editEngine")
    public String editEngine(@RequestParam String id, @RequestParam String name,
                             @RequestParam String engineType)
    {
        Engine engine = new Engine(name,engineType);
        engine.id=Integer.parseInt(id);
        System.out.println(engine.toString());

        DAOForEngine.update(engine);
        return "index";
    }
    @RequestMapping(value="/edit/engine/{id}", method = RequestMethod.GET)
    public String editEngine(@PathVariable("id") String id, Model model) {

        Engine engine = DAOForEngine.findEngineById(Integer.parseInt(id));
        model.addAttribute("engine", engine);
        return "editEngine";
    }
    @RequestMapping(value="/delete/engine/{id}", method = RequestMethod.GET)
    public String deleteEngine(@PathVariable("id") String id) {

        DAOForEngine.delete(DAOForEngine.findEngineById(Integer.parseInt(id)));

        return "index";
    }
}
