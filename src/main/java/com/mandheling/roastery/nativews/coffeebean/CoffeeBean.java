package com.mandheling.roastery.nativews.coffeebean;

import java.util.Objects;

public record CoffeeBean(
        Integer id,
        String name,
        String origin,
        String variety,
        String acidity
) {
    public CoffeeBean {
        Objects.requireNonNull(name, "name is required");
        Objects.requireNonNull(origin, "origin is required");
        Objects.requireNonNull(variety, "variety is required");
        Objects.requireNonNull(acidity, "acidity is required");
    }
}