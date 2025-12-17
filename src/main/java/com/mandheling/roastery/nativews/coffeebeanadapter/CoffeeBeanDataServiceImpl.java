package com.mandheling.roastery.nativews.coffeebeanadapter;

import com.mandheling.roastery.nativews.coffeebean.CoffeeBean;
import com.mandheling.roastery.nativews.coffeebean.CoffeeBeanDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CoffeeBeanDataServiceImpl implements CoffeeBeanDataService {
    private final JdbcTemplate jdbc;

    @Override
    public List<CoffeeBean> findAll() {
        var sql = "select * from coffee_bean";
        return jdbc.query(sql, new CoffeeBeanRowMapper());
    }

    @Override
    public void add(CoffeeBean coffeeBean) {
        var sql = "insert into coffee_bean (name, origin, variety, acidity) values (?, ?, ?, ?)";
        jdbc.update(sql, coffeeBean.name(), coffeeBean.origin(), coffeeBean.variety(), coffeeBean.acidity());
    }

    private static class CoffeeBeanRowMapper implements RowMapper<CoffeeBean> {
        @Override
        public CoffeeBean mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new CoffeeBean(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("origin"),
                    rs.getString("variety"),
                    rs.getString("acidity"));
        }
    }
}