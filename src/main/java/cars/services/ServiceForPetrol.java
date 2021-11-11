package cars.services;

import cars.Engine;
import org.springframework.stereotype.Service;

//4a
@Service
public class ServiceForPetrol {
    //3
    Engine createEnginePetrol(){
        return new Engine(Engine.type.Petrol);
    }
}
