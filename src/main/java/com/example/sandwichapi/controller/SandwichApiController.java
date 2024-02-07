package com.example.sandwichapi.controller;


import com.example.sandwichapi.model.Sandwich;
import com.example.sandwichapi.service.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SandwichApiController {

    @Autowired
    SandwichService sandwichService;

    @GetMapping("/all")
    public List<Sandwich> returnAllSandwiches(){
        System.out.println("in all sandwiches");

        return  sandwichService.findAllSandwiches();
    }

    @GetMapping("/sandwichid/{id}")
    public Sandwich returnSandwichById(@PathVariable("id") int id){
        return  sandwichService.findSandwichById(id);
    }

    @GetMapping("/sandwichname/{name}")
    public Sandwich returnSandwichByName(@PathVariable("name") String name){
        return  sandwichService.findSandwichByName(name);
    }

    @GetMapping("/sandwichcategory/{name}")
    public List<Sandwich> returnSandwichByCategory(@PathVariable("name") String category){
        return sandwichService.findSandwichesByCategory(category);
    }


    @PostMapping("/sandwich/add")
    public void addSandwich(@RequestBody Sandwich sandwich){
         sandwichService.addSandwich(sandwich);
    }

    @PostMapping("/sandwich/updateprice")
    public void updatePrice(@RequestBody Sandwich sandwich){
        sandwichService.updatePrice(sandwich);
    }

    @DeleteMapping(path = "/sandwich/delete/{id}")
    public void deletePerson(@PathVariable int id)  {
        sandwichService.deleteSandwich(id);
    }

}
