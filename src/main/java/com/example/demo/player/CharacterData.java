package com.example.demo.player;

import com.example.demo.abilities.Ability;

/**
 * Represents data related to a character in the game.
 * This class stores information about the character's name, health, speed, and special ability.
 */
public class CharacterData {

    /**
     * The name of the character.
     */
    private String name;

    /**
     * The health value of the character, representing how much damage it can take before being destroyed.
     */
    private int health;

    /**
     * The speed of the character, determining how fast it moves.
     */
    private double speed;

    /**
     * The ability that the character possesses, such as invincibility or speed boost.
     */
    private Ability ability;


    /**
     * Constructs a new CharacterData object with the specified attributes.
     *
     * @param name The name of the character.
     * @param health The health points of the character.
     * @param speed The speed of the character.
     * @param ability The special ability assigned to the character.
     */
    public CharacterData(String name, int health, double speed, Ability ability) {
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.ability = ability;
    }

    /**
     * Retrieves the name of the character.
     *
     * @return The name of the character.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the health of the character.
     *
     * @return The health points of the character.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Retrieves the speed of the character.
     *
     * @return The speed of the character.
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Retrieves the ability associated with the character.
     *
     * @return The Ability object representing the character's special ability.
     */
    public Ability getAbility() {
        return ability;
    }
}
