package com.mandheling.roastery.nativews.coffeebeanresource;

import com.mandheling.roastery.nativews.coffeebean.CoffeeBean;
import com.mandheling.roastery.nativews.coffeebean.CoffeeBeanDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "beans", version = "1")
@RequiredArgsConstructor
public class CoffeeBeanController {
    private final CoffeeBeanDataService coffeeBeanDataService;

    @GetMapping
    public ResponseEntity<Object> showCoffeeBeans() {
        var beans = coffeeBeanDataService.findAll();
        return ResponseEntity.ok(beans);
    }

    @PostMapping
    public ResponseEntity<Object> addCoffeeBean(@RequestBody CoffeeBean coffeeBean) {
        coffeeBeanDataService.add(coffeeBean);
        return ResponseEntity.ok("Coffee bean successfully added.");
    }
}