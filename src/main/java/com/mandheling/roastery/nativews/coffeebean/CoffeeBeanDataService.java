package com.mandheling.roastery.nativews.coffeebean;

import java.util.List;

public interface CoffeeBeanDataService {
    List<CoffeeBean> findAll();
    void add(CoffeeBean coffeeBean);
}