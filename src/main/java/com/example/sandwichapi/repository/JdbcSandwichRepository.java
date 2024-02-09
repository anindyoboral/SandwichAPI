package com.example.sandwichapi.repository;

import com.example.sandwichapi.exception.SandwichNotFoundException;
import com.example.sandwichapi.model.Sandwich;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



@Component
public class JdbcSandwichRepository implements  SandwichRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<Sandwich> findAllSandwiches() {
        return (List<Sandwich>) jdbcTemplate.query("select * from  sandwiches ",new SandwichMapper());
    }

    @Override
    public Sandwich findSandwichById(int id) throws SandwichNotFoundException {
        return jdbcTemplate.queryForObject("select * from  sandwiches where id=?",new JdbcSandwichRepository.SandwichMapper(),id);
    }

    @Override
    public Sandwich findSandwichByName(String name) throws SandwichNotFoundException{
        return jdbcTemplate.queryForObject("select * from  sandwiches where name=?",new JdbcSandwichRepository.SandwichMapper(),name);
    }

    @Override
    public List<Sandwich> findSandwichesByCategory(String category) {
        return  jdbcTemplate.query("select * from  sandwiches where category=?",new SandwichMapper(),category);
    }

    @Override
    public void addSandwich(Sandwich sandwich) {

        jdbcTemplate.update("insert into  sandwiches(id,name,description,category,baseprice)\n" +
                "values(?,?,?,?,?)" , sandwich.getId(),sandwich.getName(),sandwich.getDescription(),sandwich.getCategory(),sandwich.getBasePrice());

    }

    @Override
    public void updatePrice(Sandwich sandwich) {
        jdbcTemplate.update("update sandwiches set baseprice=? where name=?",sandwich.getBasePrice(),sandwich.getName());
    }

    @Override
    public void deleteSandwich(int id) {
        jdbcTemplate.update("delete from sandwiches where id=?",id);
    }

    private static final class SandwichMapper implements RowMapper<Sandwich> {
        public Sandwich mapRow(ResultSet rs, int rowNum) throws SQLException {
            Sandwich sandwich = new Sandwich();
            sandwich.setCategory(rs.getString("CATEGORY"));
            sandwich.setBasePrice(rs.getDouble("BASEPRICE"));
            sandwich.setId(rs.getInt("ID"));
            sandwich.setDescription(rs.getString("DESCRIPTION"));
            sandwich.setName(rs.getString("NAME"));

            return sandwich;
        }
    }
}
