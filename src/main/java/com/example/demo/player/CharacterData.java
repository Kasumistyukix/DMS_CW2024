package com.example.demo.player;

public class characterHandler {
    private String name;
    private int health;
    private double speed;
    private Ability ability;

    public CharacterData(String name, int health, double speed, Ability ability) {
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.ability = ability;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public double getSpeed() {
        return speed;
    }

    public Ability getAbility() {
        return ability;
    }

}
