package com.api.cars.controller;

import com.api.cars.dto.CarDTO;
import com.api.cars.model.Car;
import com.api.cars.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/cars")
public class CarController {

    private final CarRepository repository;

    public CarController(CarRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void addCar(@RequestBody CarDTO req) {
        repository.save(new Car(req));

        System.out.println("Modelo: " + req.modelo());
        System.out.println("Fabricante: " + req.fabricante());
        System.out.println("Valor: " + req.valor());
    }

    @GetMapping
    public List<Car> listAll(){
        return repository.findAll();
    }
}
