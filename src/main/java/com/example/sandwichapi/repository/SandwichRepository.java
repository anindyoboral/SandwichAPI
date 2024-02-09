package com.example.sandwichapi.repository;

import com.example.sandwichapi.exception.SandwichNotFoundException;
import com.example.sandwichapi.model.Sandwich;

import java.util.List;

public interface SandwichRepository {
    List<Sandwich> findAllSandwiches();
    Sandwich findSandwichById(int id) throws SandwichNotFoundException;
    Sandwich findSandwichByName(String name) throws SandwichNotFoundException;
    List<Sandwich> findSandwichesByCategory(String category) ;
    void addSandwich(Sandwich sandwich);
    void updatePrice(Sandwich sandwich);
    void deleteSandwich(int id);

}
