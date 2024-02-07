package com.example.sandwichapi;

import com.example.sandwichapi.repository.SandwichRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SandwichApiApplicationTests {


    @Autowired
    SandwichRepository sandwichRepository;
    @Test
    void contextLoads() {
    }

    @Test
    public void sandwich1isPoulet()  {
        String name = sandwichRepository.findSandwichById(1).getName();
        assertEquals("poulet",name);
    }

}
