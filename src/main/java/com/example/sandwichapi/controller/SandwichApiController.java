package com.example.sandwichapi.controller;


import com.example.sandwichapi.exception.ApiError;
import com.example.sandwichapi.exception.SandwichNotFoundException;
import com.example.sandwichapi.model.Sandwich;
import com.example.sandwichapi.service.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> returnSandwichById(@PathVariable("id") int id){

        try {
            Sandwich s = sandwichService.findSandwichById(id);
            return new ResponseEntity<Object>(s, HttpStatus.OK);
        }catch (SandwichNotFoundException e){
            HttpStatus status = HttpStatus.NOT_FOUND;
            ApiError err = new ApiError("person not found", status.value(), e.getMessage());
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("content-type", MediaType.APPLICATION_PROBLEM_JSON_VALUE);
            return new ResponseEntity<Object>(err, responseHeaders, status);
        }

    }

    @GetMapping("/sandwichname/{name}")
    public ResponseEntity<Object> returnSandwichByName(@PathVariable("name") String name){
        //return  sandwichService.findSandwichByName(name);
        try {
            Sandwich s = sandwichService.findSandwichByName(name);
            return new ResponseEntity<Object>(s, HttpStatus.OK);
        }catch (SandwichNotFoundException e){
            HttpStatus status = HttpStatus.NOT_FOUND;
            ApiError err = new ApiError("Sandwich not found", status.value(), e.getMessage());
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("content-type", MediaType.APPLICATION_PROBLEM_JSON_VALUE);
            return new ResponseEntity<Object>(err, responseHeaders, status);
        }
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
    public void deleteSandwich(@PathVariable int id)  {
        sandwichService.deleteSandwich(id);
    }

}
