package com.techelevator;

import java.math.BigDecimal;

public class Drinks extends Item{
    public Drinks(String slot, String productName, BigDecimal price) {
        super(slot, productName, price);
    }

    @Override
    public String getSound() {
        return "Glug Glug, Yum!";
    }
}
