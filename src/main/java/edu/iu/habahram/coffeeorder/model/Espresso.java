package edu.iu.habahram.coffeeorder.model;

public class Espresso extends Beverage{
    public String getDescription() {
        return "Espresso";
    }
    @Override
    public float cost() {
        return 1.34F;
    }
}
