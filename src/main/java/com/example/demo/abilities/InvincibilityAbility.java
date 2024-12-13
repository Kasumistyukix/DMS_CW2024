package com.example.demo.abilities;

import com.example.demo.player.UserPlane;

/**
 * {@code InvincibilityAbility} is an implementation of the {@link Ability} interface
 * that grants invincibility to the player-controlled plane for a limited duration.
 * The ability has a cooldown period before it can be activated again.
 */
public class InvincibilityAbility implements Ability {

    /**
     * The duration of the invincibility effect in milliseconds.
     * This defines how long the user is invincible once the ability is activated.
     */
    private static final long DURATION = 3_000; // 3 seconds duration

    /**
     * The cooldown duration in milliseconds after the ability is used.
     * Once the invincibility effect ends, this cooldown period must pass before it can be activated again.
     */
    private static final long COOLDOWN = 10_000; // 10 seconds cooldown

    /**
     * The time at which the ability was activated.
     * This is used to track how long the invincibility effect has been active.
     */
    private long startTime;

    /**
     * The time at which the cooldown period started.
     * This is used to track how long the cooldown has been ongoing after the invincibility effect ends.
     */
    private long cooldownStartTime;

    /**
     * Indicates whether the invincibility ability is currently active.
     * If true, the user is invincible and cannot take damage.
     */
    private boolean active;

    /**
     * Indicates whether the invincibility ability is currently on cooldown.
     * If true, the ability cannot be used until the cooldown period ends.
     */
    private boolean onCooldown;

    /**
     * The user plane that this ability is associated with.
     * This object allows the ability to modify the user plane's state, such as invincibility.
     */
    private UserPlane userplane;

    /**
     * Initializes the InvincibilityAbility with default values for active status, cooldown, and start time.
     */
    public InvincibilityAbility() {
        startTime = 0;
        cooldownStartTime = 0;
        active = false;
        onCooldown = false;
    }

    /**
     * Activates the invincibility ability for the given {@link UserPlane}.
     * The plane becomes invincible for a limited duration.
     *
     * @param plane The {@link UserPlane} on which the ability is activated.
     */
    public void activate(UserPlane plane) {
        if (!active) {
            active = true;
            startTime = System.currentTimeMillis();
            cooldownStartTime = startTime;
            userplane = plane;
            userplane.setInvincible(true); // Make plane invincible
            onCooldown = true; // Start cooldown
        }
    }

    /**
     * Checks whether the invincibility ability is currently active.
     *
     * @return {@code true} if the ability is active, {@code false} otherwise.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Checks whether the invincibility ability is on cooldown.
     *
     * @return {@code true} if the ability is on cooldown, {@code false} otherwise.
     */
    public boolean isOnCooldown() {
        return onCooldown;
    }

    /**
     * Updates the state of the invincibility ability. Deactivates the ability when
     * the duration expires and starts the cooldown. Resets the cooldown when the
     * cooldown time ends.
     *
     * @param currentTime The current time, in milliseconds, used to
     *                    track the ability's duration and cooldown.
     */
    @Override
    public void update(long currentTime) {
        // Deactivate ability when duration ends
        if (active && currentTime - startTime >= DURATION) {
            active = false;
            userplane.setInvincible(false); // Remove invincibility
        }

        // Reset cooldown when cooldown time ends
        if (onCooldown && currentTime - startTime>= COOLDOWN) {
            onCooldown = false;
        }
    }
}
