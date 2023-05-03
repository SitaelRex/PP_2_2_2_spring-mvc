package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.model.CarService;
import web.model.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService service;
    @Autowired
    public CarController(CarService service) {
        this.service = service;
        service.saveCar(new Car());
        service.saveCar(new Car("buggatti veyron superspot", 6_900_000, 42));
        service.saveCar(new Car("moskvich", 110000, 11));
        service.saveCar(new Car("tesla model x", 100000, 6));
        service.saveCar(new Car());
    }
    @GetMapping(value = "")
    public String printCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        List<Car> loadedCars = service.getCarList(count != null ? count : -1);
        model.addAttribute("cars", loadedCars);
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Table Of Cars");
        model.addAttribute("messages", messages);
        return "cars";
    }
}
