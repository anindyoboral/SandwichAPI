package com.example.sandwichapi.service;

import com.example.sandwichapi.exception.SandwichNotFoundException;
import com.example.sandwichapi.model.Sandwich;
import com.example.sandwichapi.repository.SandwichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbisSandwichService implements  SandwichService{

    @Autowired
    SandwichRepository sandwichRepository;

    @Override
    public List<Sandwich> findAllSandwiches() {
        return sandwichRepository.findAllSandwiches();
    }

    @Override
    public Sandwich findSandwichById(int id) throws SandwichNotFoundException {
        return sandwichRepository.findSandwichById(id);
    }

    @Override
    public Sandwich findSandwichByName(String name) throws SandwichNotFoundException {
        return sandwichRepository.findSandwichByName(name);
    }

    @Override
    public List<Sandwich> findSandwichesByCategory(String category) {
        return sandwichRepository.findSandwichesByCategory(category);
    }

    @Override
    public void addSandwich(Sandwich sandwich) {
         sandwichRepository.addSandwich(sandwich);
    }

    @Override
    public void updatePrice(Sandwich sandwich) {
        sandwichRepository.updatePrice(sandwich);
    }

    @Override
    public void deleteSandwich(int id) {
        sandwichRepository.deleteSandwich(id);
    }
}
