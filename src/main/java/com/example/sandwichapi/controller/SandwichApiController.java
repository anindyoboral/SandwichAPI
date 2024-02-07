package com.example.sandwichapi.controller;


import com.example.sandwichapi.model.Sandwich;
import com.example.sandwichapi.service.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
