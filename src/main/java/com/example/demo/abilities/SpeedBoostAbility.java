package com.example.demo.abilities;

import com.example.demo.player.UserPlane;

/**
 * Represents a Speed Boost ability that enhances the user's movement speed for a limited duration.
 * This ability includes cooldown management and activation logic.
 */
public class SpeedBoostAbility implements Ability{

    /**
     * The multiplier for the user's speed when the ability is active.
     * During the boost, the speed of the user will be multiplied by this value.
     */
    private static final int SPEED_MULTIPLIER = 4;

    /**
     * The duration of the boost in frames.
     * This defines how long the speed boost lasts before it deactivates.
     */
    private static final int DURATION_FRAMES = 100;

    /**
     * The cooldown duration in frames after the ability is used.
     * Once the ability is deactivated, this cooldown period must pass before it can be used again.
     */
    private static final int COOLDOWN_FRAMES = 250;

    /**
     * The number of frames the boost has been active.
     * This is incremented during the activation period and used to determine when to deactivate the boost.
     */
    private int framesActive;

    /**
     * The number of frames remaining in the cooldown period.
     * This value is decremented as time passes after the ability is deactivated.
     */
    private int framesCooldown;

    /**
     * Indicates whether the speed boost is currently active.
     * If true, the user is experiencing a speed boost; if false, the boost is not active.
     */
    private boolean isActive;

    /**
     * Indicates whether the ability is in its cooldown period.
     * If true, the ability cannot be used until the cooldown expires.
     */
    private boolean onCooldown;

    /**
     * The user plane that this ability is associated with.
     * This object allows the ability to modify the user plane's state, such as speed.
     */
    private UserPlane userPlane;

    /**
     * Initializes the SpeedBoostAbility with default values for the active and cooldown frames.
     */
    public SpeedBoostAbility() {
        framesActive = 0;
        framesCooldown = 0;
        isActive = false;
        onCooldown = false;
    }

    /**
     * Activates the speed boost ability for the given {@link UserPlane}.
     * The plane's speed is multiplied by a defined speed multiplier for the duration.
     *
     * @param plane The {@link UserPlane} on which the ability is activated.
     */
    @Override
    public void activate(UserPlane plane) {
        if (!onCooldown) {
            userPlane = plane;
            isActive = true;
            framesActive = 0; // Reset active frame counter when activated
            userPlane.setSpeed(userPlane.getSpeed() * SPEED_MULTIPLIER); // Apply speed boost
        }
    }

    /**
     * Updates the state of the ability, controlling its active duration and cooldown period based on frames.
     *
     * @param currentTime The current time, typically in milliseconds, used to track the ability's duration and cooldown.
     */
    @Override
    public void update(long currentTime) {
        if (isActive) {
            framesActive++; // Increment frame counter while active

            // Deactivate the ability when the duration ends
            if (framesActive >= DURATION_FRAMES) {
                isActive = false;
                onCooldown = true;
                userPlane.setSpeed(userPlane.getSpeed() / SPEED_MULTIPLIER); // Reset speed
            }
        }

        if (onCooldown) {
            framesCooldown++; // Increment frame counter for cooldown

            // Once cooldown is finished, reset and allow reactivation
            if (framesCooldown >= COOLDOWN_FRAMES) {
                onCooldown = false;
                framesCooldown = 0;
            }
        }
    }

    /**
     * Checks whether the ability is currently active.
     *
     * @return {@code true} if the ability is active, {@code false} otherwise.
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Checks whether the ability is on cooldown.
     *
     * @return {@code true} if the ability is on cooldown, {@code false} otherwise.
     */
    public boolean isOnCooldown() {
        return onCooldown;
    }
}
