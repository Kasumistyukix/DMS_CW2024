package com.example.demo.abilities;

import com.example.demo.actor.FighterPlane;
import com.example.demo.player.UserPlane;

/**
 * The {@code Ability} interface defines the structure for special abilities
 * that can be used by the player-controlled plane ({@link UserPlane}) in the game.
 * It provides methods to activate abilities, check their status, and handle cooldowns and updates.
 */
public interface Ability {

    /**
     * Activates the ability for the player-controlled plane.
     *
     * @param plane The {@link UserPlane} on which the ability is activated.
     */
    void activate(UserPlane plane);

    /**
     * Checks whether the ability is currently active.
     *
     * @return {@code true} if the ability is active, {@code false} otherwise.
     */
    boolean isActive();

    /**
     * Checks whether the ability is on cooldown.
     *
     * @return {@code true} if the ability is on cooldown, {@code false} otherwise.
     */
    boolean isOnCooldown();

    /**
     * Updates the state of the ability, such as tracking its duration or cooldown.
     *
     * @param currentTime The current time, typically in milliseconds, used to
     *                    calculate ability state changes.
     */
    void update(long currentTime);
}


