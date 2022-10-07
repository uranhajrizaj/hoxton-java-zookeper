package com.project.zookeper;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Controller {
    
    @Autowired
    ZooAnimalRepository zooAnimalRepository;
    
    @GetMapping("/animals")
    public List<ZooAnimal> getAllAnimals(){
    return zooAnimalRepository.findAll();
    }

    @GetMapping("/animals/{id}")
    public ZooAnimal getSingleAnimal(@PathVariable Integer id) {
        ZooAnimal animal = zooAnimalRepository.findById(id).get();
        return animal;
    }

    @PostMapping("/animals")
    public ZooAnimal createAnimal(@RequestBody ZooAnimal newanimal){
        ZooAnimal animal= zooAnimalRepository.save(newanimal);
        return animal;
    }

    @DeleteMapping("/animals/{id}")
    public String deleteAnimal(@PathVariable Integer id) {
        zooAnimalRepository.deleteById(id);
        return "Animal deleted succesfuly";
    }

    @PatchMapping("/animals/{id}")
    public ZooAnimal updateAnimal(@RequestBody ZooAnimal animal, @PathVariable int id) {
        animal.id=id;
        return zooAnimalRepository.save(animal);
    }
    
}

interface ZooAnimalRepository extends JpaRepository<ZooAnimal, Integer>{}
